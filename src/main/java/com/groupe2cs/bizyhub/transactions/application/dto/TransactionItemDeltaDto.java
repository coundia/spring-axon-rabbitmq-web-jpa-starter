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
@Schema(name = "TransactionItemDeltaDto", description = "Delta DTO for transactionItem changes")
public class TransactionItemDeltaDto implements Serializable {

	@Schema(description = "Identifier of the transactionItem", example = "uuid")
	private String id;

	@Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
	private String type = "CREATE";

	@Schema(description = "", example = "36423e8b-c775-4eef-ab2f-722becf598fe")
	private String transaction;
	@Schema(description = "", example = "c10da60f-f6d0-4172-9a70-1e87138d1fe2")
	private String product;
	@Schema(description = "", example = "599b120c-b4df-40a0-9305-61bc248108b9")
	private String label;
	@Schema(description = "", example = "65")
	private Integer quantity;
	@Schema(description = "", example = "01fdbfc3-310f-4335-938d-8d6b0c0f7513")
	private String unit;
	@Schema(description = "", example = "67ff8581-c03f-4202-9e74-62fbf53755cd")
	private String account;
	@Schema(description = "", example = "9275a98f-edac-45aa-a172-6d805dc9c6c7")
	private String remoteId;
	@Schema(description = "", example = "b11ecca0-ab87-417a-8f1f-e1010eab19ae")
	private String localId;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "8054.97")
	private Double unitPrice;
	@Schema(description = "", example = "8976.19")
	private Double total;
	@Schema(description = "", example = "52beadd9-6b75-4163-b85d-7abd3cef3b35")
	private String notes;

}
