package com.groupe2cs.bizyhub.security.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequestDto implements Serializable {
	private String username;
	private String password;
}
