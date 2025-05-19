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

	@Schema(description = "", example = "f26c4b7d-6f5c-4dbb-b7d7-5214ce5713bf")
	private String username;

	@Schema(description = "", example = "39ed9ce6-0db2-46cf-840f-8a3ec51195e5")
	private String password;

	@Schema(description = "", example = "44b3a90c-9e0a-4c4e-b434-b56f7506968e")
	private String firstName;

	@Schema(description = "", example = "6703bf3c-d9cd-4e1e-9ce2-7ca2fe9e4a91")
	private String lastName;

	@Schema(description = "", example = "0bdb2c99-08fe-42a6-9196-f069f09c737c")
	private String email;

	@Schema(description = "", example = "1e760104-88d2-4d97-9b2d-2da0fd5851cf")
	private String telephone;

	@Schema(description = "", example = "32")
	private Integer limitPerDay;

	@Schema(description = "", example = "false")
	private Boolean isPremium;

	@Schema(description = "", example = "false")
	private Boolean enabled;

	@Schema(description = "", example = "false")
	private Boolean isBan;

	@Schema(description = "", example = "35c7d32f-6f56-43ad-b06f-fc9fb9e40d5a")
	private String message;


}
