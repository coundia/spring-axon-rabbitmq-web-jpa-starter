package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.service.UserPrincipal;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.application.ApiResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

import java.util.Map;

@Slf4j
@Tag(name = "Auth", description = "Users infos")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthMe {

private final UserDetailsService userDetailsService;

@GetMapping("/me")
@Operation(summary = "Get current authenticated user", description = "Returns username from token")
@ApiResponses(value = {
@ApiResponse(responseCode = "200", description = "User info", content = @Content(schema = @Schema(implementation = ApiResponseDto.class))),
@ApiResponse(responseCode = "401", description = "Unauthorized")
})
public ResponseEntity<ApiResponseDto> me(@AuthenticationPrincipal Jwt jwt) {

	if(jwt == null) {
	log.warn("Auth/me JWT is null");
	return ResponseEntity.status(401).body(ApiResponseDto.error("Unauthorized"));
	}


	log.info("Auth/me User claims: {}", jwt.getClaims());
	String username = jwt.getSubject();

	 MetaRequest metaRequest = new MetaRequest();

	 Boolean isAdmin = RequestContext.isAdmin(jwt);

	UserPrincipal userPrincipal = (UserPrincipal) userDetailsService.loadUserByUsername(username);


	Map<String, Object> data = new HashMap<>();
	data.put("id", userPrincipal.getId());
	data.put("username", userPrincipal.getUsername());

	data.put("firstName", userPrincipal.getFirstName());
	data.put("lastName", userPrincipal.getLastName());
	data.put("email", userPrincipal.getEmail());
	data.put("telephone", userPrincipal.getTelephone());


	data.put("tenantId", userPrincipal.getTenantId());
	data.put("createdBy", userPrincipal.getCreatedBy());
	data.put("limitPerDay", userPrincipal.getLimitPerDay());
	data.put("isPremium", userPrincipal.isPremium());
	data.put("isAdmin", isAdmin);

	data.put("isEnabled", userPrincipal.isEnabled());
	data.put("isBan", userPrincipal.isBan());
	data.put("message", userPrincipal.getMessage());

	data.put("authorities", userPrincipal.getAuthorities());
	data.put("roles", userPrincipal.getRoles());

	return ResponseEntity.ok(ApiResponseDto.ok(data));


	}
}

