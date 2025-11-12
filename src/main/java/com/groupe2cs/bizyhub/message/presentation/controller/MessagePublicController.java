package com.groupe2cs.bizyhub.message.presentation.controller;

import com.groupe2cs.bizyhub.message.application.dto.*;
import com.groupe2cs.bizyhub.message.application.usecase.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;
import com.groupe2cs.bizyhub.message.infrastructure.repository.*;
import com.groupe2cs.bizyhub.message.infrastructure.entity.*;
import com.groupe2cs.bizyhub.message.application.mapper.*;

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
@RequestMapping("/api/public/queries/messages")
@Tag(name = "Message Queries", description = "Endpoints public for listing paginated messages")
public class MessagePublicController {

     private final CurrentTenantIdentifierResolver currentTenantIdentifierResolver;
    private final MessageRepository repository;

    @GetMapping
    @Operation(summary = "List paginated messages", description = "Returns a paginated list of messages based on page and limit parameters")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list of messages", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MessagePagedResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    public MessagePagedResponse list(
            @Parameter(description = "Page number (zero-based index)", example = "0") @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Number of items per page", example = "10") @RequestParam(defaultValue = "10") int limit
    ) {
        String tenantId = currentTenantIdentifierResolver.resolveCurrentTenantIdentifier();
        Page<Message> paged = repository.findPublicByTenantId(tenantId, PageRequest.of(page, limit));
        List<MessageResponse> content = paged.getContent().stream().map(MessageMapper::toResponse).toList();
        return MessagePagedResponse.from(paged, content);
    }
}
