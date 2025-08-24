package com.groupe2cs.bizyhub.transactions.application.dto;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import lombok.ToString;
import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Schema(name = "TransactionEntryDeltaDto", description = "Delta DTO for transactionEntry changes")
public class TransactionEntryDeltaDto implements Serializable {

    @Schema(description = "Identifier of the transactionEntry", example = "uuid")
    private String id;

    @Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
    private String type = "CREATE";

		@Schema(description = "", example = "bb0bef49-5e96-4b9d-bc0f-fd24bec12a7a")
		private String remoteId;
		@Schema(description = "", example = "ed71d378-aaa6-4866-a88f-79f5845bfcda")
		private String localId;
		@Schema(description = "", example = "7242aebc-5f1b-4de7-982a-0655f1de58b3")
		private String code;
		@Schema(description = "", example = "2deca875-dcb4-45e1-89d5-b9d008ecf4c9")
		private String description;
		@Schema(description = "", example = "5356.0")
		private Double amount;
		@Schema(description = "", example = "8cea1305-2d93-4446-b2c4-9f6e3c64b9ac")
		private String typeEntry;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant dateTransaction;
		@Schema(description = "", example = "e4130197-e012-4427-b4d4-66dbf7f513a4")
		private String status;
		@Schema(description = "", example = "d1b03cf4-a0d4-4b4d-93a9-26267e9b01d6")
		private String entityName;
		@Schema(description = "", example = "7239b16c-1632-4770-a11b-75b2d705654c")
		private String entityId;
		@Schema(description = "", example = "0fef8e03-df9e-4b13-8875-ed739dc2977e")
		private String account;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "e7bfe7e4-99e3-4c3a-9680-6207c9177f89")
		private String category;
		@Schema(description = "", example = "62747014-e0c3-4575-bb71-fff8eb2c22ba")
		private String company;
		@Schema(description = "", example = "0aa32040-bbce-4a67-805b-41f32649f570")
		private String customer;
		@Schema(description = "", example = "a6d134e1-9b44-4eb4-ad20-91eefef8f5f8")
		private String debt;

}
