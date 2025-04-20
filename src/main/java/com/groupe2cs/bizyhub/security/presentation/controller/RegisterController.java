package com.groupe2cs.bizyhub.security.presentation.controller;
	import com.groupe2cs.bizyhub.security.application.dto.*;
	import com.groupe2cs.bizyhub.security.application.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Auth", description = "Endpoints registration ")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class RegisterController {

private final RegisterUser registerUser;

@PostMapping("/register")
public ResponseEntity<AuthResponseDto> register(@RequestBody AuthRequestDto request) {
	try {
	return ResponseEntity.ok(registerUser.handle(request));
	} catch (Exception e) {
	return ResponseEntity.status(HttpStatus.BAD_REQUEST)
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
