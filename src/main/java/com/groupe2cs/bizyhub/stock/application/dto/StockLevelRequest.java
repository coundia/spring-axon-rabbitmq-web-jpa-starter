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

	@Schema(description = "", example = "65ff9b8d-8181-4b0c-8933-23c19d670cce")
	private String remoteId;
	@Schema(description = "", example = "68")
	private Integer stockOnHand;
	@Schema(description = "", example = "21")
	private Integer stockAllocated;
	@Schema(description = "", example = "966555fb-642f-41d6-ab3c-732b034e4eaf")
	private String productVariant;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "52319a5c-0098-4af9-b73f-90a3f927cb65")
	private String company;

}
