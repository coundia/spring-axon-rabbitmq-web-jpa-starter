package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.application.query.*;
import com.groupe2cs.bizyhub.security.application.mapper.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.application.usecase.*;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf;
import static org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;


@PreAuthorize("@verificationCodeGate.canList(authentication)")
@RestController
@RequestMapping("/api/v1/queries/verificationCodes")
@Tag(name = "VerificationCode Queries", description = "Endpoints for querying verificationCodes by expiration")
@Slf4j
public class FindByExpirationVerificationCodeController {

private final VerificationCodeReadApplicationService applicationService;

public FindByExpirationVerificationCodeController(VerificationCodeReadApplicationService  applicationService) {
	this.applicationService = applicationService;
}

@GetMapping("/expiration")
@Operation(
summary = "Find verificationCode by expiration",
description = "Returns a list of verificationCodes that match the given expiration"
)
@ApiResponses(value = {
@ApiResponse(responseCode = "200", description = "Query successful",
content = @Content(mediaType = "application/json", schema = @Schema(implementation = VerificationCodeResponse.class))),
@ApiResponse(responseCode = "400", description = "Invalid parameter", content = @Content),
@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
})

public ResponseEntity<List<VerificationCodeResponse>> findByExpiration(
	@AuthenticationPrincipal Jwt jwt,
	@Parameter(description = "Value of the expiration to filter by", required = true)
	@RequestParam java.time.Instant expiration
	) {
	try {

	MetaRequest metaRequest = MetaRequest.builder()
		.userId(RequestContext.getUserId(jwt))		.tenantId(RequestContext.getTenantId(jwt))
	.build();
	metaRequest.setIsAdmin(RequestContext.isAdmin(jwt));

	var future = applicationService.findByVerificationCodeExpiration(VerificationCodeExpiration
	.create(expiration) , metaRequest);

	return ResponseEntity.ok(future);
	} catch (Exception e) {
	log.error("Failed to find verificationCode by expiration: {}", e.getMessage(), e);
	return ResponseEntity.internalServerError().build();
	}
	}
}