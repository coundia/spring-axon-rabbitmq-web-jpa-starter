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
	private String remoteId;
	@Schema(description = "", example = "")
	private String localId;
	@Schema(description = "", example = "")
	private String code;
	@Schema(description = "", example = "")
	private String description;
	@Schema(description = "", example = "")
	private Double amount;
	@Schema(description = "", example = "")
	private String typeEntry;
	@Schema(description = "", example = "")
	private java.time.Instant dateTransaction;
	@Schema(description = "", example = "")
	private String status;
	@Schema(description = "", example = "")
	private String entityName;
	@Schema(description = "", example = "")
	private String entityId;
	@Schema(description = "", example = "")
	private String account;
	@Schema(description = "", example = "")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "")
	private String category;
	@Schema(description = "", example = "")
	private String company;
	@Schema(description = "", example = "")
	private String customer;
	@Schema(description = "", example = "")
	private String debt;
	@Schema(description = "", example = "")
	private String createdBy;
	@Schema(description = "", example = "")
	private String tenant;

}
