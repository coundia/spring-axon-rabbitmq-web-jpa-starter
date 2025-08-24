package com.groupe2cs.bizyhub.products.application.dto;

import com.groupe2cs.bizyhub.products.domain.valueObject.*;
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
@Schema(name = "ProductRequest", description = "Request payload for Product operations")
public class ProductRequest implements Serializable {

	@Schema(description = "", example = "3a1e950a-80c3-4968-b6c9-e89032b17148")
	private String remoteId;
	@Schema(description = "", example = "cfa4fc04-b27a-40a9-b92b-f447bee0f4fd")
	private String code;
	@Schema(description = "", example = "628af038-20fb-4321-9d97-9b1617bc2913")
	private String name;
	@Schema(description = "", example = "5a7cb88b-7c91-47ce-88ca-dfc8dffb2299")
	private String description;
	@Schema(description = "", example = "900876e7-6cb3-42df-a214-801aee67706f")
	private String barcode;
	@Schema(description = "", example = "8b9f2db5-f0b4-45a5-ae2d-58014bea9ce6")
	private String unit;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "5fbd750b-96bb-4f3c-8729-120a5b85e37c")
	private String category;
	@Schema(description = "", example = "7069.72")
	private Double defaultPrice;
	@Schema(description = "", example = "adeb29d5-17e9-4f96-93a0-56425e0e0f40")
	private String statuses;
	@Schema(description = "", example = "2106.92")
	private Double purchasePrice;

}
