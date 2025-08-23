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

		@Schema(description = "", example = "66425d71-b85f-4f2c-bc8c-fe11f2895e28")
		private String remoteId;
		@Schema(description = "", example = "33617e2d-d380-4fef-a61e-e4428733ed17")
		private String code;
		@Schema(description = "", example = "e61642ef-84c3-4b88-b559-6d97bf6c0fdc")
		private String description;
		@Schema(description = "", example = "4395.42")
		private Double amount;
		@Schema(description = "", example = "cf951055-19eb-47a5-9792-953b6c48cf3a")
		private String typeEntry;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant dateTransaction;
		@Schema(description = "", example = "e6c92e74-dd9a-45b8-bf19-f799297c7352")
		private String status;
		@Schema(description = "", example = "f639bce2-f378-42b2-8b8b-01d34f06ce61")
		private String entityName;
		@Schema(description = "", example = "65cfa709-f7ef-440d-bbe5-79d3b4549edc")
		private String entityId;
		@Schema(description = "", example = "76bb7512-2dcf-4894-a90a-1c52a3109712")
		private String account;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "dc8fdecf-9a3f-423d-a20e-44a83c3e535c")
		private String category;
		@Schema(description = "", example = "df4ad4f5-6676-4809-9030-144a9fe19fb8")
		private String company;
		@Schema(description = "", example = "126d7197-374b-4e07-a97f-c69a8a66bebf")
		private String customer;
		@Schema(description = "", example = "45197f17-43be-40ef-8f26-b0090d18554b")
		private String debt;

}
