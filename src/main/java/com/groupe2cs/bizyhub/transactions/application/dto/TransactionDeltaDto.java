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

	@Schema(description = "", example = "52a02023-7798-48cf-aab0-a11e213faff9")
	private String reference;
	@Schema(description = "", example = "3134.21")
	private Double amount;

}
