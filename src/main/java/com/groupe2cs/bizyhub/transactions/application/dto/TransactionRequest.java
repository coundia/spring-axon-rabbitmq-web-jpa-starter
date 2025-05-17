package com.groupe2cs.bizyhub.transactions.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "TransactionRequest", description = "Request payload for Transaction operations")
public class TransactionRequest implements Serializable {

	@Schema(description = "", example = "29ba32ff-0ea5-494a-ad47-6057b3bc715a")
	private String name;

	@Schema(description = "", example = "2464.04")
	private Double amount;

	@Schema(description = "", example = "fe851934-a5aa-4ff1-a444-7af0f6fdf1bd")
	private String details;

	@Schema(description = "", example = "false")
	private Boolean isActive;

	@Schema(description = "", example = "06d63c01-6849-46f2-b676-da66d20830e1")
	private String account;

	@Schema(description = "", example = "19a554ae-6b01-46ee-9ce8-3aa32e8fec58")
	private String category;

	@Schema(description = "", example = "ae0a2177-93b3-40c0-92dc-9027a64e1b19")
	private String typeTransactionRaw;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant dateTransaction;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "7c842c95-6f98-4661-bcf2-5f0e046865ba")
	private String reference;


}
