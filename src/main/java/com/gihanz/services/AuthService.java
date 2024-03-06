package com.gihanz.services;

import com.gihanz.dtos.JwtResponse;
import com.gihanz.dtos.LoginDTO;
import com.gihanz.utils.JwtService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@ToString
public class AuthService {

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;
    public JwtResponse login(LoginDTO login){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
        if(authentication.isAuthenticated()){
            return JwtResponse.builder()
                    .token(jwtService.generateToken(login.getUsername())).build();
        } else {
            throw new UsernameNotFoundException("invalid user request..!!");
        }
    }
}
