package com.forohub.api.controller;

import com.forohub.api.infra.security.JWTData;
import com.forohub.api.infra.security.TokenService;
import com.forohub.api.model.User;
import com.forohub.api.record.user.UserAuthenticationData;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity authenticateUser(@RequestBody @Valid UserAuthenticationData userAuthenticationData) {
        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(userAuthenticationData.username(), userAuthenticationData.password());
        Authentication authenticationUser = authenticationManager.authenticate(authenticationToken);
        String jwt = tokenService.generateToken((User) authenticationUser.getPrincipal());
        return ResponseEntity.ok(new JWTData(jwt));
    }
}
