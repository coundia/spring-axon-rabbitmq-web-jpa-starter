package com.groupe2cs.bizyhub.stock.application.dto;

import com.groupe2cs.bizyhub.stock.domain.valueObject.*;
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
@Schema(name = "StockMovementRequest", description = "Request payload for StockMovement operations")
public class StockMovementRequest implements Serializable {

	@Schema(description = "", example = "0a2f6b0b-a1df-49a2-8ca9-63578815929b")
	private String typeStockMovement;
	@Schema(description = "", example = "62")
	private Integer quantity;
	@Schema(description = "", example = "e3da0ec0-e591-4175-b265-aaa65119f93b")
	private String remoteId;
	@Schema(description = "", example = "81d75ede-c945-4329-88df-d14d4a75e1bc")
	private String localId;
	@Schema(description = "", example = "42af8927-ee42-4d63-9301-99ec007a710c")
	private String company;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "e230b257-bee9-4afc-ae82-f540b2a91224")
	private String productVariant;
	@Schema(description = "", example = "34c143de-4b78-4bb3-850a-70976f6d9cbe")
	private String orderLineId;
	@Schema(description = "", example = "8c5f33c5-502d-422a-a5c8-2354feaafa37")
	private String discriminator;

}
