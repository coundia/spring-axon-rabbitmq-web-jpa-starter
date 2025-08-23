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

	@Schema(description = "", example = "b120acd0-b028-403a-bef7-0527196b5eb3")
	private String username;
	@Schema(description = "", example = "ed162309-f29b-47f4-8e40-0c6749281a2d")
	private String password;
	@Schema(description = "", example = "288ec3f1-3908-4e85-b38b-4086a1759062")
	private String firstName;
	@Schema(description = "", example = "0b78762e-0ed3-413b-be6d-6ba8903c0284")
	private String lastName;
	@Schema(description = "", example = "c31a474d-4a0e-48f6-b54c-1a22e3b18418")
	private String email;
	@Schema(description = "", example = "7b857659-7c28-492a-a970-d92dfd72d836")
	private String telephone;
	@Schema(description = "", example = "90")
	private Integer limitPerDay;
	@Schema(description = "", example = "false")
	private Boolean isPremium;
	@Schema(description = "", example = "true")
	private Boolean enabled;
	@Schema(description = "", example = "true")
	private Boolean isBan;
	@Schema(description = "", example = "51f9293e-8b2a-410a-820a-2d42b3b0e8e1")
	private String message;

}
