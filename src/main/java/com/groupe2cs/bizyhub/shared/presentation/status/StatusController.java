package com.groupe2cs.bizyhub.shared.presentation.status;

	import com.groupe2cs.bizyhub.shared.application.ApiResponseDto;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Tag(name = "Status", description = "Endpoints for checking API status")
public class StatusController {

    @Value("${message:Api}")
    private String message;

    @Operation(summary = "Get public API status")
    @GetMapping("/status")
    public ApiResponseDto getStatusOpen() {
        log.info("Accessing public status endpoint");
        return ApiResponseDto.builder()
                .code(1)
                .message("I am " + message + " unSecure.")
                .build();
    }

    @Operation(summary = "Get fallback API status")
    @GetMapping("/status/fallback")
    public ApiResponseDto getStatusFallBack() {
        log.info("Accessing fallback status endpoint");
        return ApiResponseDto.builder()
                .code(1)
                .message("I am " + message + " fallback.")
                .build();
    }

    @Operation(summary = "Get admin API status")
    @GetMapping("/admin/status")
    public ApiResponseDto getStatusAdmin() {
        log.info("Accessing admin status endpoint");
        return ApiResponseDto.builder()
                .code(1)
                .message("I am " + message + " in Admin.")
                .build();
    }

    @Operation(summary = "Get logged-in user API status")
    @GetMapping("/status/logged-in")
    public ApiResponseDto getStatusForLogged(@AuthenticationPrincipal Jwt jwt) {
        log.info("Accessing logged-in status endpoint for user: {}", jwt.getSubject());
        return ApiResponseDto.builder()
                .code(1)
                .message("I am " + message + " in logged.")
                .build();
    }

}
