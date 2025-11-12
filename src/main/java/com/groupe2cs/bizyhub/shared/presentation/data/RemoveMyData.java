package com.groupe2cs.bizyhub.shared.presentation.data;


import com.groupe2cs.bizyhub.security.application.dto.AuthResponseDto;
import com.groupe2cs.bizyhub.security.application.dto.VerificationCodeRequest;
import com.groupe2cs.bizyhub.security.application.dto.VerificationCodeResponse;
import com.groupe2cs.bizyhub.security.application.service.JwtService;
import com.groupe2cs.bizyhub.security.application.service.RegisterUser;
import com.groupe2cs.bizyhub.security.application.service.UserPrincipal;
import com.groupe2cs.bizyhub.security.application.usecase.VerificationCodeCreateApplicationService;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.entity.VerificationCode;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.security.infrastructure.repository.VerificationCodeRepository;
import com.groupe2cs.bizyhub.shared.application.CodeGenerator;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.UUID;

@RestController
@RequestMapping("/api/auth")
@Slf4j
@RequiredArgsConstructor
public class RemoveMyData {
	private static final String STATUS_NEW = "NEW";
	private static final String STATUS_USED = "USED";

	private final VerificationCodeCreateApplicationService applicationService;
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final CurrentTenantIdentifierResolver currentTenantIdentifierResolver;
	private final VerificationCodeRepository verificationCodeRepository;


	@PostMapping("/remove-my-data")
	public ResponseEntity<AuthResponseDto> checkCode(@Valid @RequestBody VerificationCodeRequest request) {
		try {
			String tenantId = currentTenantIdentifierResolver.resolveCurrentTenantIdentifier();
			String username = request.getUsername();
			String code = request.getCode();
			VerificationCode
					v =
					verificationCodeRepository.findTopByTenantIdAndUsernameAndCodeAndStatusAndExpirationAfter(
							tenantId, username, code, STATUS_NEW, Instant.now()
					).orElse(null);
			if (v == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			v.setStatus(STATUS_USED);
			verificationCodeRepository.save(v);
			MetaRequest metaRequest = MetaRequest.builder().tenantId(tenantId).build();
			User user = userRepository.findFirstByUsernameAndTenantId(username, tenantId).orElseGet(() -> {
				User
						u =
						User.builder().id(UUID.randomUUID().toString()).username(username)
								.password(passwordEncoder.encode(code)).tenant(new Tenant(tenantId)).build();

				u.setEnabled(false);
				u.setIsBan(true);
				u.setIsPremium(false);
				u.setMessage("DELETED");
				u.setUserRoles(null);

				return userRepository.save(u);
			});
			UserPrincipal userPrincipal = new UserPrincipal(user);
			Authentication
					authentication =
					new UsernamePasswordAuthenticationToken(userPrincipal, null, userPrincipal.getAuthorities());
			String token = jwtService.generateToken(authentication, metaRequest);

			//reset password
			_changePassword(username, tenantId, UUID.randomUUID().toString());

			return ResponseEntity.status(HttpStatus.CREATED).body(
					AuthResponseDto.builder().code(1).token(token).tenant(tenantId).username(username)
							.message("Login successful").build()
			);
		} catch (Exception ex) {
			log.error("check-code failed: {}", ex.getMessage());
			return ResponseEntity.status(500).build();
		}
	}

	private User _changePassword(String username, String tenantId, String newPassword) {
		return userRepository.findFirstByUsernameAndTenantId(username, tenantId).orElseGet(() -> {
			User
					u =
					User.builder().id(UUID.randomUUID().toString()).username(username)
							.password(passwordEncoder.encode(newPassword)).tenant(new Tenant(tenantId)).build();
			return userRepository.save(u);
		});
	}
}
