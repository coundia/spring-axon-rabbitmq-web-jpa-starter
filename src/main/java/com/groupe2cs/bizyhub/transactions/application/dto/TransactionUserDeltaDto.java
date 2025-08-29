package com.groupe2cs.bizyhub.transactions.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Schema(name = "TransactionUserDeltaDto", description = "Delta DTO for transactionUser changes")
public class TransactionUserDeltaDto implements Serializable {

	@Schema(description = "Identifier of the transactionUser", example = "uuid")
	private String id;

	@Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
	private String type = "CREATE";

	@Schema(description = "", example = "a23549c3-7695-4b8c-91e1-6782a2a6afeb")
	private String name;
	@Schema(description = "", example = "b908ec4e-5abb-4f05-95fe-dc4e43c5fa1d")
	private String remoteId;
	@Schema(description = "", example = "100928ad-efdd-4f62-842d-7d76e0ba6ab3")
	private String localId;
	@Schema(description = "", example = "87865206-a7d5-4f8a-ae38-7dec6e90d70d")
	private String transaction;
	@Schema(description = "", example = "f6b12093-7b31-407d-8b91-3d2bdb2af0bc")
	private String user;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "201782a0-6858-4eb4-b439-dff609ccd4b5")
	private String username;
	@Schema(description = "", example = "784b1a4e-f782-4816-b7ac-daab3a936903")
	private String details;
	@Schema(description = "", example = "true")
	private Boolean isActive;

}
