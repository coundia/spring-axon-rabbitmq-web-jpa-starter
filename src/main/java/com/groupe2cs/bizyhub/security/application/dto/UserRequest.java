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

	@Schema(description = "", example = "92559d30-88c3-4c3b-9fec-74a0f7e40697")
	private String username;

	@Schema(description = "", example = "36d07c13-a181-44df-8b80-245a80c1a539")
	private String password;


}
