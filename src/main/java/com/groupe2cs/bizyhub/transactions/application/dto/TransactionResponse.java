package com.groupe2cs.bizyhub.transactions.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "TransactionResponse", description = "Response payload for Transaction")
public class TransactionResponse implements Serializable {

	@Schema(description = "", example = "")
	private String id;
	@Schema(description = "", example = "")
	private Double amount;
	@Schema(description = "", example = "")
	private java.time.Instant dateOperation;
	@Schema(description = "", example = "")
	private String description;
	@Schema(description = "", example = "")
	private String reference;
	@Schema(description = "", example = "")
	private Boolean isRecurring;
	@Schema(description = "", example = "")
	private Boolean isExcluToRapport;
	@Schema(description = "", example = "")
	private String status;
	@Schema(description = "", example = "")
	private String balance;
	@Schema(description = "", example = "")
	private String category;
	@Schema(description = "", example = "")
	private java.time.Instant updatedAt;
	@Schema(description = "", example = "")
	private java.time.Instant createdAt;

}
