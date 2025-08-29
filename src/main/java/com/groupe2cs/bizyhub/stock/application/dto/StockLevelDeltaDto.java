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
@Schema(name = "StockLevelDeltaDto", description = "Delta DTO for stockLevel changes")
public class StockLevelDeltaDto implements Serializable {

	@Schema(description = "Identifier of the stockLevel", example = "uuid")
	private String id;

	@Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
	private String type = "CREATE";

	@Schema(description = "", example = "158562bc-2d01-46dc-9fdd-ad6f5cd2a6e4")
	private String remoteId;
	@Schema(description = "", example = "8a60bac4-cd04-4ae2-b695-9bc2a7263fa6")
	private String localId;
	@Schema(description = "", example = "38")
	private Integer stockOnHand;
	@Schema(description = "", example = "46")
	private Integer stockAllocated;
	@Schema(description = "", example = "6520d543-813d-4083-8937-c729f03581b7")
	private String account;
	@Schema(description = "", example = "cd879813-4585-4e53-b167-e9703da69d2f")
	private String productVariant;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "12ab1c92-1268-4a44-b04f-00cca5c3480e")
	private String company;

}
