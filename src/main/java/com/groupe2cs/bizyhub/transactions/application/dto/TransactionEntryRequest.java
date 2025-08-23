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
@Schema(name = "TransactionEntryRequest", description = "Request payload for TransactionEntry operations")
public class TransactionEntryRequest implements Serializable {

	@Schema(description = "", example = "3c3383f2-4922-4352-92c3-ad9ec0b12722")
	private String remoteId;
	@Schema(description = "", example = "d47772c1-1f2e-47cd-9cff-37022d5c436c")
	private String code;
	@Schema(description = "", example = "a3996516-f9e6-4738-9053-b98dee9e1fda")
	private String description;
	@Schema(description = "", example = "6585.36")
	private Double amount;
	@Schema(description = "", example = "678bbcb9-9de3-41c5-a3bc-23f3afa554aa")
	private String typeEntry;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant dateTransaction;
	@Schema(description = "", example = "6dac172e-be11-43e3-9c19-711559ad88b4")
	private String status;
	@Schema(description = "", example = "9ac5c709-7ad6-4815-b5a5-087d323352d2")
	private String entityName;
	@Schema(description = "", example = "5f5e6925-160c-40fe-b509-46b0f95fae19")
	private String entityId;
	@Schema(description = "", example = "cf193aae-a39f-46ee-ac85-2ac16d4b969c")
	private String account;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "0f27a75a-f46f-411c-ab3d-4bbb0c845ae4")
	private String category;
	@Schema(description = "", example = "32122264-fafd-47ca-bf24-5c766d3277f6")
	private String company;
	@Schema(description = "", example = "4d4e77ea-c550-4738-b3c7-446e2dfe106f")
	private String customer;
	@Schema(description = "", example = "3e346b4d-c707-424b-b335-03e60ef90988")
	private String debt;

}
