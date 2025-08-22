package com.groupe2cs.bizyhub.security.presentation.controller;

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
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static org.springframework.amqp.core.QueueBuilder.LeaderLocator.random;


@RestController
@RequestMapping("/api/auth")
@Tag(name = "Auth", description = "Endpoints for authentication")
@Slf4j
@RequiredArgsConstructor
public class AddVerificationCodeController {

	private final VerificationCodeCreateApplicationService applicationService;
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final RegisterUser registerUser;
	private final CurrentTenantIdentifierResolver currentTenantIdentifierResolver;
	private final VerificationCodeRepository verificationCodeRepository;

	@PostMapping("/request-code")
	public ResponseEntity<VerificationCodeResponse> requestCode(@Valid @RequestBody VerificationCodeRequest request) {
		try {
			MetaRequest metaRequest = MetaRequest.builder().build();
			String username = request.getUsername();
			String tenantId = currentTenantIdentifierResolver.resolveCurrentTenantIdentifier();
			String code = generate(6);
			request.setCode(code);

			metaRequest.setTenantId(tenantId);

			User user = userRepository.findByUsernameAndTenantId(
					username,
					tenantId
			).stream().findFirst().orElse(null);

			if (user == null) {
				user = User.builder()
						.id(UUID.randomUUID().toString())
						.username(request.getUsername())
						.password(passwordEncoder.encode(request.getCode()))
						.tenant(new Tenant(tenantId))
						.build();
				log.info("Create new user: {}", user.getUsername());
				userRepository.save(user);
			}
			metaRequest.setUserId(user.getId());

			VerificationCodeResponse response = applicationService.createVerificationCode(
					request,
					metaRequest
			);

			response.setCode(" ***** ");

			log.info("Generated verification code for user {}: {}",tenantId, username, code);

			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		} catch (Exception ex) {
			//e.printStackTrace();
			log.error("Failed to create verificationCode: {}", ex.getMessage());
			return ResponseEntity.status(500).build();
		}
	}


	@PostMapping("/check-code")
	public ResponseEntity<AuthResponseDto> checkCode(@Valid @RequestBody VerificationCodeRequest request) {
		try {
			MetaRequest metaRequest = MetaRequest.builder().build();
			String username = request.getUsername();
			String tenantId = currentTenantIdentifierResolver.resolveCurrentTenantIdentifier();
			String code = request.getCode();

			VerificationCode verificationCode = verificationCodeRepository.findFirstByCodeAndUsername(
					code,
					username
			);

			if (verificationCode == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}

			metaRequest.setTenantId(tenantId);


			User user = userRepository.findByUsernameAndTenantId(
					username,
					tenantId
			).stream().findFirst().orElse(null);

			if (user == null) {
				user = User.builder()
						.id(UUID.randomUUID().toString())
						.username(request.getUsername())
						.password(passwordEncoder.encode(request.getCode()))
						.tenant(new Tenant(tenantId))
						.build();
				log.info("Create new user: {}", user.getUsername());
				userRepository.save(user);
			}

			UserPrincipal userPrincipal = new UserPrincipal(user);

			Authentication authentication = new UsernamePasswordAuthenticationToken(
					userPrincipal,
					null,
					userPrincipal.getAuthorities()
			);

			String token = jwtService.generateToken(authentication, metaRequest);

 			return ResponseEntity.status(HttpStatus.CREATED).body(
					AuthResponseDto.builder()
							.code(1)
							.token(token)
							.tenant(tenantId)
							.username(username)
 							.message("Login successful")
							.build()
			);
		} catch (Exception ex) {
			//e.printStackTrace();
			log.error("Failed to create verificationCode: {}", ex.getMessage());
			return ResponseEntity.status(500).build();
		}
	}

	private String generate(int length) {
		if (length <= 0) throw new IllegalArgumentException("length must be > 0");
		char[] digits = new char[length];
		java.util.concurrent.ThreadLocalRandom r = java.util.concurrent.ThreadLocalRandom.current();
		for (int i = 0; i < length; i++) digits[i] = (char) ('0' + r.nextInt(10));
		return new String(digits);
	}


}
