package com.gihanz.controllers;

import com.gihanz.dtos.JwtResponse;
import com.gihanz.dtos.LoginDTO;
import com.gihanz.services.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginDTO login){
        JwtResponse jwt = authService.login(login);
        return ResponseEntity.ok(jwt);
    }

}
