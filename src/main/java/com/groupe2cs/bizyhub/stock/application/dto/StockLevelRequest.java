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

	@Schema(description = "", example = "fb06710c-2eea-4442-8926-d71b993f5556")
	private String remoteId;
	@Schema(description = "", example = "9675dd15-182e-4d74-a9bd-2cf7c8d09474")
	private String localId;
	@Schema(description = "", example = "72")
	private Integer stockOnHand;
	@Schema(description = "", example = "58")
	private Integer stockAllocated;
	@Schema(description = "", example = "dccd1ab5-de9b-44a1-9d0e-38f0941f1a84")
	private String productVariant;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "da239abd-2803-47bf-a2d3-32b703a73c3c")
	private String company;

}
