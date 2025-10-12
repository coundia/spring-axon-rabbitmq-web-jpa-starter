package com.groupe2cs.bizyhub.stock.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "StockLevelRequest", description = "Request payload for StockLevel operations")
public class StockLevelRequest implements Serializable {

	@Schema(description = "", example = "5b223c37-0d51-4930-9a19-3b0e8a471162")
	private String remoteId;
	@Schema(description = "", example = "d1221f4d-0f39-4a39-8e17-beb5a5d978a9")
	private String localId;
	@Schema(description = "", example = "87")
	private Integer stockOnHand;
	@Schema(description = "", example = "7")
	private Integer stockAllocated;
	@Schema(description = "", example = "9c639c7a-5ec7-4597-a221-ec478559f917")
	private String account;
	@Schema(description = "", example = "d561580e-01b4-44fb-ae5a-de42a4c3de3c")
	private String productVariant;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "7d53b425-adeb-42ab-86ec-b0058eddc97a")
	private String company;

}
