package com.terraway.service;

import com.terraway.dao.entity.RoleEntity;
import com.terraway.dao.entity.UserEntity;
import com.terraway.dao.repository.RoleRepository;
import com.terraway.dao.repository.UserRepository;
import com.terraway.mapper.UserMapper;
import com.terraway.model.dto.criteria.UserCriteriaRequest;
import com.terraway.model.dto.request.UserUpdateRequest;
import com.terraway.model.dto.response.UserResponse;
import com.terraway.model.exception.ActiveException;
import com.terraway.model.exception.AlreadyExistsException;
import com.terraway.model.exception.NotActiveException;
import com.terraway.model.exception.NotFoundException;
import com.terraway.service.specification.UserSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final AmazonS3Service amazonS3Service;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserResponse getUser(Long id) {
        UserEntity entity = userRepository.findById(id).orElseThrow(() ->
                new NotFoundException("USER_NOT_FOUND"));
        return UserMapper.INSTANCE.entityToResponse(entity);
    }

    public UserResponse getMyProfile(){
        String email = getCurrentEmail();
        UserEntity entity = userRepository.findByEmail(email).orElseThrow(() ->
                new NotFoundException("USER_NOT_FOUND"));
        return UserMapper.INSTANCE.entityToResponse(entity);
    }

    public List<UserResponse> getAllUsers(Pageable pageable, UserCriteriaRequest criteriaRequest){
        Specification<UserEntity> specification = UserSpecification.getUserByCriteria(criteriaRequest);
        Page<UserEntity> entities = userRepository.findAll(specification, pageable);
        return UserMapper.INSTANCE.entitiesToResponses(entities);
    }

    @Transactional
    public UserResponse update(UserUpdateRequest request, MultipartFile image) {
        String email = getCurrentEmail();
        UserEntity entity = userRepository.findByEmail(email).orElseThrow(() ->
                new NotFoundException("USER_NOT_FOUND"));
        if(!request.getEmail().equals(entity.getEmail())) {
            if(userRepository.existsByEmail(request.getEmail())) {
                throw new AlreadyExistsException("EMAIL_ALREADY_EXISTS");
            }
        }
        entity.setPhotoUrl(amazonS3Service.uploadFile(image));
        UserMapper.INSTANCE.mapRequestToEntity(entity,request);
        userRepository.save(entity);
        return UserMapper.INSTANCE.entityToResponse(entity);
    }

    public void activateUser(Long id){
        UserEntity entity = userRepository.findById(id).orElseThrow(() ->
                new NotFoundException("USER_NOT_FOUND"));
        if(entity.getStatus()){
            throw new ActiveException("USER_ALREADY_ACTIVE");
        }
        entity.setStatus(true);
        userRepository.save(entity);
    }

    public void deactivateUser(Long id){
        UserEntity entity = userRepository.findById(id).orElseThrow(() ->
                new NotFoundException("USER_NOT_FOUND"));
        if(!entity.getStatus()){
            throw new NotActiveException("USER_NOT_ACTIVE");
        }
        entity.setStatus(false);
        userRepository.save(entity);
    }

    public void setRole(Long userId, Long roleId){
        UserEntity user = userRepository.findById(userId).orElseThrow(() ->
                new NotFoundException("USER_NOT_FOUND"));
        RoleEntity role = roleRepository.findById(roleId).orElseThrow(() ->
                new NotFoundException("ROLE_NOT_FOUND"));
        user.setRoles(List.of(role));
        userRepository.save(user);
    }

    public String getCurrentEmail(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        } else {
            return principal.toString();
        }
    }
}