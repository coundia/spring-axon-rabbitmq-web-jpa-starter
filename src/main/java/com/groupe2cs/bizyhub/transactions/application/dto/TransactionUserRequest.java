package com.groupe2cs.bizyhub.transactions.application.dto;

import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
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
@Schema(name = "TransactionUserRequest", description = "Request payload for TransactionUser operations")
public class TransactionUserRequest implements Serializable {

	@Schema(description = "", example = "15e3e5a5-a8e5-40c2-b66d-5a6763bec1fe")
	private String name;

	@Schema(description = "", example = "193108a2-8961-4873-be93-8e6c7cb5389e")
	private String transaction;

	@Schema(description = "", example = "76c9b175-76cb-4e84-acd8-d4c80aa0e06d")
	private String user;

	@Schema(description = "", example = "113f052e-4624-4345-b0df-ba07f502ffc1")
	private String username;

	@Schema(description = "", example = "946d84bd-0ee5-417c-b780-1ce2e105cedd")
	private String details;

	@Schema(description = "", example = "true")
	private Boolean isActive;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "96940e60-4628-462f-ba67-bf4424f39e0e")
	private String reference;


}
