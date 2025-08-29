package com.groupe2cs.bizyhub.security.application.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthResponseDto implements Serializable {
	private Integer code;
	private String message;
	private String username;
	private String token;
	private Instant expirationAt;
	private String tenant;
	private String id;

}

