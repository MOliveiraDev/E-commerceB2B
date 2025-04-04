package com.springboot.E_commerceB2B.Controller;

import com.nimbusds.openid.connect.sdk.AuthenticationRequest;
import com.springboot.E_commerceB2B.Entities.AuthenticationEntity;
import com.springboot.E_commerceB2B.Entities.AuthenticationResponse;
import com.springboot.E_commerceB2B.Entities.RefreshTokens;
import com.springboot.E_commerceB2B.Service.RefreshTokenService;
import com.springboot.E_commerceB2B.Util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private RefreshTokenService refreshTokenService;

    // Adicionar os Métodos de autenticação e geração de token

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationEntity authenticationEntity) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationEntity.getUsername(),
                            authenticationEntity.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final RefreshTokens refreshToken = refreshTokenService.createRefreshToken(authenticationEntity.getUsername());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationEntity.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails.getUsername());

        return ResponseEntity.ok(new AuthenticationResponse(jwt, refreshToken.getToken(), authenticationEntity.getEmail()));
    }

    // Método para fazer o Refresh Token

    @PostMapping("/refresh-token")
    public String refreshToken(@RequestBody String token) {
        RefreshTokens refreshToken = refreshTokenService.findByToken(token);
        if (refreshToken == null) {
            throw new RuntimeException("Invalid refresh token");
        }

        refreshTokenService.verifyExpiration(refreshToken);
        final UserDetails userDetails = userDetailsService.loadUserByUsername(refreshToken.getUsername());

        return jwtUtil.generateToken(userDetails.getUsername());
    }

    //End map do deslogar
    @PostMapping("/logout")
    public String logout(@RequestBody String token) {
        RefreshTokens refreshToken = refreshTokenService.findByToken(token);
        if (refreshToken == null) {
            throw new RuntimeException("Invalid refresh token");
        }

        refreshTokenService.deleteByToken(token);
        return "Logout successful";
    }


}
