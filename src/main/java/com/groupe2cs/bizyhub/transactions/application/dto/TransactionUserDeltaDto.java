package com.groupe2cs.bizyhub.transactions.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "TransactionUserDeltaDto", description = "Delta DTO for transactionUser changes")
public class TransactionUserDeltaDto implements Serializable {

	@Schema(description = "Identifier of the transactionUser", example = "uuid")
	private String id;

	@Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
	private String type = "CREATE";

	@Schema(description = "", example = "5f172491-2498-4db7-b6cd-da31fc16cf06")
	private String name;
	@Schema(description = "", example = "37ef9cfc-c388-4eef-bec9-96d5980eb28b")
	private String transaction;
	@Schema(description = "", example = "5e34364f-a50e-4bb9-9f07-5bcab21d2fdc")
	private String user;
	@Schema(description = "", example = "de44fe11-5cb2-426a-ab12-d57d93bd7499")
	private String username;
	@Schema(description = "", example = "2e4d14a5-00a9-4b4f-ad13-cc2d17a36c2c")
	private String details;
	@Schema(description = "", example = "true")
	private Boolean isActive;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;
	@Schema(description = "", example = "0889958a-5aab-41b8-bea9-abe4a0982337")
	private String reference;

}
