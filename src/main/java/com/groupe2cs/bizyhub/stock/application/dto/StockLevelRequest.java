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
@Schema(name = "StockLevelRequest", description = "Request payload for StockLevel operations")
public class StockLevelRequest implements Serializable {

	@Schema(description = "", example = "963b3b3c-ca45-4f3e-8538-0b431a1f4ba8")
	private String remoteId;
	@Schema(description = "", example = "6a48a74e-5092-4b8d-bf51-3008a84cade0")
	private String localId;
	@Schema(description = "", example = "47")
	private Integer stockOnHand;
	@Schema(description = "", example = "70")
	private Integer stockAllocated;
	@Schema(description = "", example = "c28f4e94-b3e9-48bf-b042-30bb00789475")
	private String productVariant;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "b3a4b6f6-6ee2-4809-a5a4-b5393931291a")
	private String company;

}
