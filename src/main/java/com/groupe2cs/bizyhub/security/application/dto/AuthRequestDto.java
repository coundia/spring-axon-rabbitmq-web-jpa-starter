package com.groupe2cs.bizyhub.security.application.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequestDto implements Serializable {
private String username;
private String password;
}
