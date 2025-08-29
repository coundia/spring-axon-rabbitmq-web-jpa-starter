package com.groupe2cs.bizyhub.stock.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Schema(name = "StockMovementDeltaDto", description = "Delta DTO for stockMovement changes")
public class StockMovementDeltaDto implements Serializable {

	@Schema(description = "Identifier of the stockMovement", example = "uuid")
	private String id;

	@Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
	private String type = "CREATE";

	@Schema(description = "", example = "c0640585-3b68-41a1-af7c-d21206f50075")
	private String typeStockMovement;
	@Schema(description = "", example = "92")
	private Integer quantity;
	@Schema(description = "", example = "03920fd5-fd73-416d-977b-38b4e688ad31")
	private String remoteId;
	@Schema(description = "", example = "ba6a2798-38ad-4c4f-90ae-a36f8c0dbf2d")
	private String localId;
	@Schema(description = "", example = "f5ff339d-e3d2-4857-a857-f79342b659f6")
	private String account;
	@Schema(description = "", example = "e8ddf2d7-f8ee-473b-86d5-246b4e5aa519")
	private String company;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "209de9ac-44ac-4fe8-9bd7-a95acbed226f")
	private String productVariant;
	@Schema(description = "", example = "41561ac7-8561-42ad-9325-99eb0db4b0eb")
	private String orderLineId;
	@Schema(description = "", example = "4da197bc-81d5-422f-b5cb-797678ac4424")
	private String discriminator;

}
