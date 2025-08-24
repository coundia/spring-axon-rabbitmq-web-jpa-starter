package com.groupe2cs.bizyhub.transactions.application.dto;

import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.*;
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
@Schema(name = "TransactionEntryResponse", description = "Response payload for TransactionEntry")
public class TransactionEntryResponse implements Serializable {

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
