package com.groupe2cs.bizyhub.companies.presentation.controller;

import com.groupe2cs.bizyhub.companies.application.dto.*;
import com.groupe2cs.bizyhub.companies.application.usecase.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;
import com.groupe2cs.bizyhub.companies.infrastructure.repository.*;
import com.groupe2cs.bizyhub.companies.infrastructure.entity.*;
import com.groupe2cs.bizyhub.companies.application.mapper.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/public/queries/companies")
@Tag(name = "Company Queries", description = "Endpoints public for listing paginated companies")
public class CompanyPublicController {

     private final CurrentTenantIdentifierResolver currentTenantIdentifierResolver;
    private final CompanyRepository repository;

    @GetMapping
    @Operation(summary = "List paginated companies", description = "Returns a paginated list of companies based on page and limit parameters")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list of companies", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CompanyPagedResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    public CompanyPagedResponse list(
            @Parameter(description = "Page number (zero-based index)", example = "0") @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Number of items per page", example = "10") @RequestParam(defaultValue = "10") int limit
    ) {
        String tenantId = currentTenantIdentifierResolver.resolveCurrentTenantIdentifier();
        Page<Company> paged = repository.findPublicByTenantId(tenantId, PageRequest.of(page, limit));
        List<CompanyResponse> content = paged.getContent().stream().map(CompanyMapper::toResponse).toList();
        return CompanyPagedResponse.from(paged, content);
    }
}
