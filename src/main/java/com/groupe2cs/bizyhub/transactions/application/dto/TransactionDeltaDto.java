package com.groupe2cs.bizyhub.transactions.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "TransactionDeltaDto", description = "Delta DTO for transaction changes")
public class TransactionDeltaDto implements Serializable {

	@Schema(description = "Identifier of the transaction", example = "uuid")
	private String id;

	@Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
	private String type = "CREATE";

	@Schema(description = "", example = "8540.45")
	private Double amount;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant dateOperation;
	@Schema(description = "", example = "b8661847-506c-41cc-af0e-c1a39f082371")
	private String description;
	@Schema(description = "", example = "193acd34-5896-41a5-92f9-020d4c2e2d59")
	private String reference;
	@Schema(description = "", example = "false")
	private Boolean isRecurring;
	@Schema(description = "", example = "false")
	private Boolean isExcluToRapport;
	@Schema(description = "", example = "f6cb3dd7-3d7f-4d07-b6a6-6fabbd66a958")
	private String status;
	@Schema(description = "", example = "67e7273b-30d6-48c6-974c-e2f34c8257a2")
	private String balance;
	@Schema(description = "", example = "44081c5c-4dca-4b03-bb79-7c7fdcae1c11")
	private String category;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant createdAt;

}
