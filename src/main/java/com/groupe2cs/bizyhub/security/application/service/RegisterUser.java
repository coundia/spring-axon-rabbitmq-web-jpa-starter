package com.groupe2cs.bizyhub.security.application.service;

import com.groupe2cs.bizyhub.security.application.dto.AuthRequestDto;
import com.groupe2cs.bizyhub.security.application.dto.AuthResponseDto;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class RegisterUser {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;

	public AuthResponseDto handle(AuthRequestDto request, MetaRequest metaRequest) {

		String tenantId = metaRequest.getTenantId();
		if (tenantId == null) {
			throw new IllegalArgumentException("Tenant ID is required - when multi-tenant");
		}

		if (userRepository.findByUsernameAndTenantId(request.getUsername(), tenantId).stream()
				.findFirst().isPresent()) {
			log.error("User with username {} already exists in tenant {}", request.getUsername(), tenantId);
			throw new IllegalArgumentException("Username “admin” already exists in tenant");
		}

		User user = User.builder()
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

		String token = jwtService.generateToken(authentication, metaRequest);

		return AuthResponseDto.builder()
				.token(token)
				.username(user.getUsername())
				.id(user.getId())
				.code(1)
				.expirationAt(jwtService.extractExpiration(token))
				.message("Registration successful")
				.tenant(tenantId)
				.build();
	}
}


