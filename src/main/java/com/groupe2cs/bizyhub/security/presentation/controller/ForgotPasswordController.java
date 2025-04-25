package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.dto.ForgotPasswordRequestDto;
import com.groupe2cs.bizyhub.security.application.dto.ResetPasswordDto;
import com.groupe2cs.bizyhub.security.application.service.PasswordResetService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Auth", description = "Reset password endpoints")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Slf4j
public class ForgotPasswordController {

	private final PasswordResetService service;

	@PostMapping("/forgot-password")
	public ResponseEntity<String> forgot(@RequestBody ForgotPasswordRequestDto dto) {
		log.info("forgot-password: {}", dto.getUsername());
		String token = service.createToken(dto.getUsername());
		log.info("Token: {}", token);
		return ResponseEntity.ok("Token will be sent to your email.");
	}

	@PostMapping("/reset-password")
	public ResponseEntity<String> reset(@RequestBody ResetPasswordDto dto) {
		boolean success = service.resetPassword(dto.getToken(), dto.getNewPassword());
		return success
				? ResponseEntity.ok("Password updated")
				: ResponseEntity.badRequest().body("Invalid or expired token");
	}
}
