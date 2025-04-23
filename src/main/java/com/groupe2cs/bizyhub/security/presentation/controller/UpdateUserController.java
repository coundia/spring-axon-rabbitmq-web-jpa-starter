package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.application.usecase.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.application.mapper.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import lombok.AllArgsConstructor;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;

@PreAuthorize("@userGate.canEdit(authentication, #id)")
@RestController
@RequestMapping("/api/v1/commands/user")
@Tag(name = "User commands", description = "Endpoints for managing users")
@Slf4j
public class UpdateUserController {

private final UserUpdateApplicationService applicationService;

public UpdateUserController(UserUpdateApplicationService  applicationService) {
this.applicationService = applicationService;
}

@Operation(summary = "Update a new user")
@ApiResponses(value = {
@ApiResponse(responseCode = "200", description = "User Updated",
content = @Content(mediaType = "application/json",
schema = @Schema(implementation = UserResponse.class))),
@ApiResponse(responseCode = "500", description = "Internal server error",
content = @Content)
})
@PutMapping(value="{id}",  consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<UserResponse> updateUser(@Valid @PathVariable String id, @RequestBody UserRequest request) { {
	try {

	UserResponse response = applicationService.updateUser(UserId.create(id), request);

	return ResponseEntity.ok(response);

	} catch (Exception ex) {
	log.error("Failed to Update user: {}", ex.getMessage(), ex);
	return ResponseEntity.internalServerError().build();
	}
	}
}
}
