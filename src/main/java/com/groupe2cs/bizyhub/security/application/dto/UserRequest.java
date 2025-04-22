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

	@Schema(description = "", example = "22540407-ea23-4cf5-bc34-062ebc06a7f6")
	private String username;

	@Schema(description = "", example = "170689ba-a4a2-4fe7-964f-e8c94ea38a5e")
	private String password;


}
