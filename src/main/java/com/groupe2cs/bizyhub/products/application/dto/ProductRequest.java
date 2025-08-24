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

	@Schema(description = "", example = "06847d7d-824e-4f82-8783-97b27874a7a7")
	private String remoteId;
	@Schema(description = "", example = "59dc38e6-fdd2-468b-bb88-f812221d4dea")
	private String localId;
	@Schema(description = "", example = "55d4bd78-cfc5-40b8-a1b6-5887d508c292")
	private String code;
	@Schema(description = "", example = "a71b7530-b6cc-40f7-8ca1-91ef35c980aa")
	private String name;
	@Schema(description = "", example = "49019853-ed29-46f3-a1f1-2dc5c57802d0")
	private String description;
	@Schema(description = "", example = "e3975720-1658-46e4-8a6d-eeb34d8f46bb")
	private String barcode;
	@Schema(description = "", example = "6ae2c706-75e7-4e1b-9ffd-6daed778ff9d")
	private String unit;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "9308a965-baf2-4289-9cff-6ba0bde51a9f")
	private String category;
	@Schema(description = "", example = "4277.28")
	private Double defaultPrice;
	@Schema(description = "", example = "79656b20-306b-4d19-a694-53190e643b16")
	private String statuses;
	@Schema(description = "", example = "6336.82")
	private Double purchasePrice;

}
