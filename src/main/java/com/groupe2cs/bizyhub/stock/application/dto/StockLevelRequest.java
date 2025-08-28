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

	@Schema(description = "", example = "3568eed7-2249-4a48-9c9c-0b8ad53b5a85")
	private String remoteId;
	@Schema(description = "", example = "9beb1798-b259-4e1c-aeb9-fb400d998b34")
	private String localId;
	@Schema(description = "", example = "30")
	private Integer stockOnHand;
	@Schema(description = "", example = "67")
	private Integer stockAllocated;
	@Schema(description = "", example = "883881e6-b731-4d7d-a989-0b863efdddde")
	private String account;
	@Schema(description = "", example = "eb7b34c4-4191-42c3-8fc3-662b8b22bb63")
	private String productVariant;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "b2e7d698-64b8-4083-b687-72fb9d86b508")
	private String company;

}
