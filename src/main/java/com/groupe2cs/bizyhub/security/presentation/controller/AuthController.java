package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.application.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Auth", description = "Endpoints login ")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
private final AuthenticationManager authenticationManager;
private final UserDetailsService userDetailsService;
private final JwtService jwtService;
@PostMapping("/login")
public ResponseEntity<AuthResponseDto> authenticate(@RequestBody AuthRequestDto request) {
	try {
	authenticationManager.authenticate(
	new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
	);
	UserDetails user = userDetailsService.loadUserByUsername(request.getUsername());
	String token = jwtService.generateToken(user);
	return ResponseEntity.ok(
	AuthResponseDto
	.builder()
	.token(token)
	.username(user.getUsername())
	.code(1)
	.message("Login successful")
	.build()
	);
	} catch (Exception e) {
	return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
	.body(
	AuthResponseDto
	.builder()
	.token(null)
	.code(0)
	.message(e.getMessage())
	.build()
	);
	}
	}
	}
