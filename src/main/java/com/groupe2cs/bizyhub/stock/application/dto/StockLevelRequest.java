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

	@Schema(description = "", example = "1a6c9ac0-d269-4350-a42b-76390576c7f5")
	private String remoteId;
	@Schema(description = "", example = "e5e36bdd-7f80-41b4-ad9c-31baa3cf1071")
	private String localId;
	@Schema(description = "", example = "83")
	private Integer stockOnHand;
	@Schema(description = "", example = "87")
	private Integer stockAllocated;
	@Schema(description = "", example = "d7ed8243-5335-4a9e-8d1d-f35202a0d944")
	private String productVariant;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "ec610af3-776d-451d-8bd0-b03fcc24a939")
	private String company;

}
