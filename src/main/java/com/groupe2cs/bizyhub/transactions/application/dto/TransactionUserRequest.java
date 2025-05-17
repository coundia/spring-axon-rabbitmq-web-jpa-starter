package com.groupe2cs.bizyhub.transactions.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "TransactionUserRequest", description = "Request payload for TransactionUser operations")
public class TransactionUserRequest implements Serializable {

	@Schema(description = "", example = "966f0a69-8937-4da1-ace6-694349d6cac8")
	private String name;

	@Schema(description = "", example = "4cffb5a1-37ac-4d88-97f6-c2ceb695fef4")
	private String transaction;

	@Schema(description = "", example = "4cd5024e-85dd-42ca-a9f3-cf2dfdf3a8f7")
	private String user;

	@Schema(description = "", example = "a58f8abe-4499-4451-83b8-37407a0a902e")
	private String username;

	@Schema(description = "", example = "7148a59d-5ce0-4baa-99c1-2f6bb78f355f")
	private String details;

	@Schema(description = "", example = "false")
	private Boolean isActive;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "efdfc052-e1cd-42db-bf10-d300f279c3d2")
	private String reference;


}
