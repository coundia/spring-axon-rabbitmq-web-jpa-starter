package com.groupe2cs.bizyhub.security.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "UserRequest", description = "Request payload for User operations")
public class UserRequest implements Serializable {

	@Schema(description = "", example = "4c83f1ec-266a-403b-b1bb-e6f7bbc87b19")
	private String username;

	@Schema(description = "", example = "dad3cdae-b967-42e8-ace5-7e5c85f3a5d1")
	private String password;


}
