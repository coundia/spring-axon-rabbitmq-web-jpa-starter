package com.groupe2cs.bizyhub.products.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "ProductRequest", description = "Request payload for Product operations")
public class ProductRequest implements Serializable {

	@Schema(description = "", example = "2116ca14-74c4-4777-b9ba-0a528fa4bf5b")
	private String remoteId;
	@Schema(description = "", example = "e61ffc5f-42e2-405b-acc7-7d67f147fb92")
	private String localId;
	@Schema(description = "", example = "660adf1b-f703-4a77-8b69-c8ce2bc904e2")
	private String code;
	@Schema(description = "", example = "b3cd999d-e9a0-44ba-a452-cfce49e9d441")
	private String name;
	@Schema(description = "", example = "aec0d79b-67a0-43bd-87cd-20b8796d3f98")
	private String description;
	@Schema(description = "", example = "22de6707-aff1-4bef-ab69-dd3cb8362f0d")
	private String barcode;
	@Schema(description = "", example = "1ccf42ce-221f-4a84-9166-0a1838501d82")
	private String unit;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "d285021e-fa78-4b02-96c2-a95932cdc254")
	private String category;
	@Schema(description = "", example = "8fda1f06-bda2-4572-a1ae-88d2c8f91ac0")
	private String account;
	@Schema(description = "", example = "9449.71")
	private Double defaultPrice;
	@Schema(description = "", example = "2129b015-7220-44a8-915a-b72f16a8484f")
	private String statuses;
	@Schema(description = "", example = "5582.31")
	private Double purchasePrice;

}
