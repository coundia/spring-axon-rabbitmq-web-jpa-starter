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
@Schema(name = "TransactionDeltaDto", description = "Delta DTO for transaction changes")
public class TransactionDeltaDto implements Serializable {

	@Schema(description = "Identifier of the transaction", example = "uuid")
	private String id;

	@Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
	private String type = "CREATE";

	@Schema(description = "", example = "780245a3-454e-4bd8-89b1-10ae206d7e3d")
	private String remoteId;
	@Schema(description = "", example = "e0e26b42-cf8d-4e77-ab88-e4e19c5f4471")
	private String localId;
	@Schema(description = "", example = "055202a2-4a43-4f89-ab47-03bcd87db99d")
	private String code;
	@Schema(description = "", example = "0ab7178a-5430-44c5-bf4a-9e50510018f3")
	private String description;
	@Schema(description = "", example = "7752.74")
	private Double amount;
	@Schema(description = "", example = "af76f4ec-40e9-4f38-8b4a-d6b31d734abe")
	private String typeEntry;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant dateTransaction;
	@Schema(description = "", example = "f7c6081b-e0f7-4c2b-8424-ffab6a98a91a")
	private String status;
	@Schema(description = "", example = "314b0ac8-8912-4a4f-a66a-10f7eff55613")
	private String entityName;
	@Schema(description = "", example = "41d477b3-1d96-45a4-bc3f-1ce763a2af0a")
	private String entityId;
	@Schema(description = "", example = "f4b7bb57-edbb-4d8e-ab49-25d3f2b2d7e0")
	private String account;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "a9b111b4-d70d-4182-a946-eae94065091c")
	private String category;
	@Schema(description = "", example = "cbab038e-7aae-4ed2-9dda-1c0dae7a5c24")
	private String company;
	@Schema(description = "", example = "826e92b5-2746-4b3e-a8e2-6835b67a2171")
	private String customer;
	@Schema(description = "", example = "ccde2a33-3a68-4b7b-8fd1-7561a9e7ec1c")
	private String debt;

}
