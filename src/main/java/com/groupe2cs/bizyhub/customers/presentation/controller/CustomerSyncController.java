package com.groupe2cs.bizyhub.customers.presentation.controller;

	import com.groupe2cs.bizyhub.shared.application.dto.*;
	import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;
	import com.groupe2cs.bizyhub.shared.application.*;
	import com.groupe2cs.bizyhub.customers.application.dto.*;
	import com.groupe2cs.bizyhub.customers.application.usecase.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/v1/commands/customer/sync")
@Tag(name = "Customer commands", description = "Endpoint to synchronize customers")
@Slf4j
@RequiredArgsConstructor
public class CustomerSyncController {

		private final CustomerSyncApplicationService applicationService;

		@PostMapping
		@Operation(
		summary = "Sync customers",
		description = "Initiates synchronization of customer deltas without blocking the client"
		)
		@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Sync initiated",
		content = @Content(schema = @Schema(implementation = ApiResponseDto.class))),
		@ApiResponse(responseCode = "500", description = "Internal server error",
		content = @Content(schema = @Schema()))
		})
		public ResponseEntity<ApiResponseDto> syncCustomer(
	@AuthenticationPrincipal Jwt jwt,
	@Valid @RequestBody CustomerSyncRequest request) {
			try {

			log.info("d ***** payload *****");
				log.info(request.getDeltas().toString());

			MetaRequest metaRequest = MetaRequest.builder()
				.userId(RequestContext.getUserId(jwt))				.tenantId(RequestContext.getTenantId(jwt))
			.build();

			metaRequest.setIsAdmin(RequestContext.isAdmin(jwt));

			applicationService.syncCustomer(
					request,
					metaRequest
				);
			return ResponseEntity.ok(ApiResponseDto.builder()
				.code(1)
				.message("Sync in progress")
				.build()
			);
			} catch (Exception ex) {

			log.error("Failed to initiate sync of customers: {}", ex.getMessage());

			return ResponseEntity.status(500)
				.body(ApiResponseDto.builder()
				.code(0)
				.message(ex.getMessage())
				.build()
			);
		}
	}
}
