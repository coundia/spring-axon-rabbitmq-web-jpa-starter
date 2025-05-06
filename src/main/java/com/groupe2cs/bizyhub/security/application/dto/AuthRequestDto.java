package com.groupe2cs.bizyhub.security.application.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequestDto implements Serializable {

	@Schema(description = "User ", example = "admin")
	private String username;

	@Schema(description = "Password", example = "admin")
	private String password;
}
