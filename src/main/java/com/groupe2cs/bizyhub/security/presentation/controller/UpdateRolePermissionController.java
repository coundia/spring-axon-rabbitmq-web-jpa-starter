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

@RestController
@RequestMapping("/api/v1/commands/rolepermission")
@Tag(name = "RolePermission commands", description = "Endpoints for managing rolepermissions")
@Slf4j
public class UpdateRolePermissionController {

private final RolePermissionUpdateApplicationService applicationService;

public UpdateRolePermissionController(RolePermissionUpdateApplicationService  applicationService) {
this.applicationService = applicationService;
}

@Operation(summary = "Update a new rolepermission")
@ApiResponses(value = {
@ApiResponse(responseCode = "200", description = "RolePermission Updated",
content = @Content(mediaType = "application/json",
schema = @Schema(implementation = RolePermissionResponse.class))),
@ApiResponse(responseCode = "500", description = "Internal server error",
content = @Content)
})
@PutMapping(value="{id}",  consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<RolePermissionResponse> updateRolePermission(@PathVariable String id, @RequestBody RolePermissionRequest request) { {
	try {

	RolePermissionResponse response = applicationService.updateRolePermission(RolePermissionId.create(id), request);

	return ResponseEntity.ok(response);

	} catch (Exception ex) {
	log.error("Failed to Update rolepermission: {}", ex.getMessage(), ex);
	return ResponseEntity.internalServerError().build();
	}
	}
}
}
