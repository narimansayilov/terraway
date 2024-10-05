package com.terraway.controller;

import com.terraway.model.dto.request.ResetPassword;
import com.terraway.model.dto.request.UserLoginRequest;
import com.terraway.model.dto.request.UserRegisterRequest;
import com.terraway.model.dto.request.VerificationRequest;
import com.terraway.model.dto.response.JwtResponse;
import com.terraway.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/terraway/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody @Valid UserRegisterRequest request) {
        authService.register(request);
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody @Valid UserLoginRequest request) {
        return authService.login(request);
    }

    @PostMapping("/verify")
    public void verifyAccount(@RequestBody @Valid VerificationRequest request){
        authService.verifyAccount(request);
    }

    @PostMapping("/resend-verification-code")
    public void resendVerificationCode(@RequestParam("email") String email){
        authService.resendVerificationCode(email);
    }

    @PostMapping("/update-password")
    public void updatePassword(@RequestParam("email") String email){
        authService.updatePassword(email);
    }

    @PostMapping("/reset-password")
    public void resetPassword(@RequestParam("token") String token,
                              @RequestBody ResetPassword resetPassword){
        authService.resetPassword(token, resetPassword);
    }
}
