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

	@Schema(description = "", example = "082872a2-5310-4c93-84a0-f7d218e1d93a")
	private String typeStockMovement;
	@Schema(description = "", example = "12")
	private Integer quantity;
	@Schema(description = "", example = "8d4ed9f5-6ab9-4be4-b186-3d416a02ebad")
	private String remoteId;
	@Schema(description = "", example = "6fa0f355-b71e-47cd-ab62-3db7f44d4c3c")
	private String localId;
	@Schema(description = "", example = "1547bad9-f5c3-4f2f-af86-aaf307afcced")
	private String company;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "005a5405-794d-4a8d-8aec-e8b589236cea")
	private String productVariant;
	@Schema(description = "", example = "09d4a87f-c221-4a45-af7f-2a247566f24d")
	private String orderLineId;
	@Schema(description = "", example = "87ec593c-26f3-4635-af39-da2818d3e17d")
	private String discriminator;

}
