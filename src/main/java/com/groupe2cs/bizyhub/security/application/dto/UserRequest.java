package com.groupe2cs.bizyhub.security.application.dto;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import java.util.UUID;
import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "UserRequest", description = "Request payload for User operations")
public class UserRequest implements Serializable {

	@Schema(description = "", example = "e7c79025-3f48-4779-abb1-5e74d4fedd3a")
	private String username;
	@Schema(description = "", example = "c8daa6a5-c7c7-4133-b4db-3feb26a77064")
	private String password;
	@Schema(description = "", example = "1c15e189-6c65-4fce-a8ed-686f86076fba")
	private String firstName;
	@Schema(description = "", example = "310d1392-0d1c-434e-87d0-aa02158ef16f")
	private String lastName;
	@Schema(description = "", example = "db899dfc-92e1-43d3-acce-b15634276d77")
	private String email;
	@Schema(description = "", example = "b7211f35-6b7a-4ab5-aa7c-575680911a1a")
	private String telephone;
	@Schema(description = "", example = "56")
	private Integer limitPerDay;
	@Schema(description = "", example = "true")
	private Boolean isPremium;
	@Schema(description = "", example = "true")
	private Boolean enabled;
	@Schema(description = "", example = "true")
	private Boolean isBan;
	@Schema(description = "", example = "661a17c4-4c60-4ae8-b29b-a661c3612f25")
	private String message;

}
