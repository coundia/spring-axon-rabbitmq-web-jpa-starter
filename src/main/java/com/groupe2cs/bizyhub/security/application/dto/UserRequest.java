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

	@Schema(description = "", example = "57a5c788-e82c-46a3-9f96-2c199a262015")
	private String username;
	@Schema(description = "", example = "1778c520-d3d9-4cad-9ed7-0601a2076f9b")
	private String password;
	@Schema(description = "", example = "d5bea5d6-3336-499a-81cf-1583e6964b19")
	private String firstName;
	@Schema(description = "", example = "7c92febc-4043-4271-9792-bd2569d3b47a")
	private String lastName;
	@Schema(description = "", example = "56b94197-0815-4450-81c8-09e329396814")
	private String email;
	@Schema(description = "", example = "93ac156f-f67c-48a6-ba23-ff620b300d90")
	private String telephone;
	@Schema(description = "", example = "75")
	private Integer limitPerDay;
	@Schema(description = "", example = "false")
	private Boolean isPremium;
	@Schema(description = "", example = "false")
	private Boolean enabled;
	@Schema(description = "", example = "false")
	private Boolean isBan;
	@Schema(description = "", example = "b7d6ac93-a821-4b0b-96de-ceb47d958b78")
	private String message;

}
