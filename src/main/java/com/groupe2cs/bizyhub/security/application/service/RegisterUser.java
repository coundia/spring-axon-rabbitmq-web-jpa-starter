package com.groupe2cs.bizyhub.security.application.service;

import com.groupe2cs.bizyhub.security.application.dto.AuthRequestDto;
import com.groupe2cs.bizyhub.security.application.dto.AuthResponseDto;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
.id(UUID.randomUUID().toString())
.username(request.getUsername())
.password(passwordEncoder.encode(request.getPassword()))
.build();

userRepository.save(user);

Authentication authentication = new UsernamePasswordAuthenticationToken(
user.getUsername(),
null,
List.of(new SimpleGrantedAuthority("ROLE_USER"))
);

String token = jwtService.generateToken(authentication);

return AuthResponseDto.builder()
.token(token)
.username(user.getUsername())
.code(1)
.expirationAt(jwtService.extractExpiration(token))
.message("Login successful")
.build();
}
}


