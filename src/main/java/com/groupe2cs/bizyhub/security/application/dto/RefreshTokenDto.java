package com.groupe2cs.bizyhub.security.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RefreshTokenDto implements Serializable {

	@Schema(description = "refreshToken ", example = "38058cb7-4dde-446e-908e-3c887052a4c1")
	private String refreshToken;
}
