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

	@Schema(description = "", example = "958ce96f-d908-40ed-a4fd-1f53634196b0")
	private String remoteId;
	@Schema(description = "", example = "ba0c256c-c652-4efd-a7f7-6903031c1f2b")
	private String localId;
	@Schema(description = "", example = "edd20806-4607-4028-a5f7-479e435a7cef")
	private String code;
	@Schema(description = "", example = "af8d2d02-a3c5-4fc7-b26a-77d491926e1a")
	private String name;
	@Schema(description = "", example = "966198a1-db18-4203-aeea-bba4e9d17e30")
	private String description;
	@Schema(description = "", example = "75e243e9-e57e-41b7-9275-9b2aba1a168b")
	private String barcode;
	@Schema(description = "", example = "f3418aff-a41c-4013-990a-a6a5252e470e")
	private String unit;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "53b91831-5e8d-4b67-96b7-88b3060cb1f5")
	private String category;
	@Schema(description = "", example = "2647.84")
	private Double defaultPrice;
	@Schema(description = "", example = "a37cf313-bf64-4040-9184-6ecb691c05da")
	private String statuses;
	@Schema(description = "", example = "4294.74")
	private Double purchasePrice;

}
