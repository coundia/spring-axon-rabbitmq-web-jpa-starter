package com.groupe2cs.bizyhub.settings.presentation.controller;

import com.groupe2cs.bizyhub.settings.application.dto.*;
import com.groupe2cs.bizyhub.settings.application.usecase.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/public/queries/settings")
@Tag(name = "Setting Queries", description = "Endpoints public for listing paginated settings")
public class SettingPublicController {

    private final SettingReadApplicationService applicationService;

    private final CurrentTenantIdentifierResolver currentTenantIdentifierResolver;

    @GetMapping
    @Operation(
    summary = "List paginated settings",
    description = "Returns a paginated list of settings based on page and limit parameters"
    )
    @ApiResponses(value = {
    @ApiResponse(
    responseCode = "200",
    description = "Successfully retrieved list of settings",
    content = @Content(mediaType = "application/json", schema = @Schema(implementation = SettingPagedResponse.class))
    ),
    @ApiResponse(
    responseCode = "500",
    description = "Internal server error",
    content = @Content
    )
    })
    public SettingPagedResponse list(
        @Parameter(description = "Page number (zero-based index)", example = "0")
        @RequestParam(defaultValue = "0") int page,

        @Parameter(description = "Number of items per page", example = "10")
        @RequestParam(defaultValue = "10") int limit
        ) {

            MetaRequest metaRequest = new MetaRequest();
                metaRequest.setTenantId(currentTenantIdentifierResolver.resolveCurrentTenantIdentifier());
                metaRequest.setIsAdmin(true);

            return applicationService.findAll(page,limit, metaRequest);
         }
}
