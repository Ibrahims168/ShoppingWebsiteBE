package com.shoppingWebsite.service;

import com.shoppingWebsite.security.CustomUserDetailsService;
import com.shoppingWebsite.security.model.AuthenticationRequest;
import com.shoppingWebsite.security.model.AuthenticationResponse;
import com.shoppingWebsite.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private CustomUserDetailsService myUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse createAuthenticationToken(AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (Exception exception){
            throw new Exception("Incorrect Username Or Password");
        }

        UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        return new AuthenticationResponse( jwtUtil.generateToken(userDetails));
    }
}



