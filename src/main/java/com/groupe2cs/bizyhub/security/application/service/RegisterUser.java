package com.groupe2cs.bizyhub.security.application.service;

import com.groupe2cs.bizyhub.security.application.dto.AuthRequestDto;
import com.groupe2cs.bizyhub.security.application.dto.AuthResponseDto;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterUser {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;

	public AuthResponseDto handle(AuthRequestDto request) {
		if (userRepository.findByUsername(request.getUsername()).isPresent()) {
			throw new IllegalArgumentException("Username already exists");
		}

		User user = User.builder()
				.id(java.util.UUID.randomUUID().toString())
				.username(request.getUsername())
				.password(passwordEncoder.encode(request.getPassword()))
				.build();

		userRepository.save(user);

		String token = jwtService.generateToken(new UserPrincipal(user));
		return AuthResponseDto
				.builder()
				.token(token)
				.username(user.getUsername())
				.code(1)
				.message("Login successful")
				.build();
	}
}
