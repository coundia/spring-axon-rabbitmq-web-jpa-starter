package com.groupe2cs.bizyhub.security.application.dto;

import lombok.AllArgsConstructor;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthResponseDto implements Serializable {
	private Integer code;
	private String message;
	private String username;
	private String token;

}
