package com.groupe2cs.bizyhub.security.application.service;
	import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
	import com.groupe2cs.bizyhub.security.infrastructure.repository.*;
	import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
	import com.groupe2cs.bizyhub.security.application.dto.*;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class RegisterUser {

private final UserRepository userRepository;
private final PasswordEncoder passwordEncoder;
private final JwtService jwtService;

public AuthResponseDto handle(AuthRequestDto request,String tenantId) {
if (userRepository.findByUsername(request.getUsername()).isPresent()) {
	throw new IllegalArgumentException("Username already exists");
}

CustomUser user = CustomUser.builder()
.id(UUID.randomUUID().toString())
.username(request.getUsername())
.password(passwordEncoder.encode(request.getPassword()))
.tenant(new Tenant(tenantId))
.build();

log.info("Registering user: {}", user.getUsername());
userRepository.save(user);

UserPrincipal userPrincipal = new UserPrincipal(user);

Authentication authentication = new UsernamePasswordAuthenticationToken(
	userPrincipal,
	null,
	userPrincipal.getAuthorities()
);

String token = jwtService.generateToken(authentication);

return AuthResponseDto.builder()
.token(token)
.username(user.getUsername())
.code(1)
.expirationAt(jwtService.extractExpiration(token))
.message("Registration successful")
.tenant(tenantId)
.build();
}
}


