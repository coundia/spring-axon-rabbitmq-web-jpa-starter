package com.groupe2cs.bizyhub.products.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Schema(name = "ProductDeltaDto", description = "Delta DTO for product changes")
public class ProductDeltaDto implements Serializable {

	@Schema(description = "Identifier of the product", example = "uuid")
	private String id;

	@Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
	private String type = "CREATE";

	@Schema(description = "", example = "33cf362f-e4e0-410c-ad0d-42df9a8927fa")
	private String remoteId;
	@Schema(description = "", example = "61861630-2100-4c5e-8cdf-82dd0cc7fa22")
	private String localId;
	@Schema(description = "", example = "73983cb6-9174-4171-acb8-e5c790e5c038")
	private String code;
	@Schema(description = "", example = "fdc5306d-a183-431c-9e7a-22e0a5245a7f")
	private String name;
	@Schema(description = "", example = "f7ddb3c3-e292-4041-830c-f5f6c924a626")
	private String description;
	@Schema(description = "", example = "7a630fe2-b68c-4045-9c00-bd84088fc540")
	private String barcode;
	@Schema(description = "", example = "7288ca09-0792-4186-911b-8f6df46576ed")
	private String unit;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "4d062c2d-a9f0-416b-ac7a-10512b487a46")
	private String category;
	@Schema(description = "", example = "71e060ce-4931-4e1d-8b40-fe6b0a7afe2c")
	private String account;
	@Schema(description = "", example = "6572.03")
	private Double defaultPrice;
	@Schema(description = "", example = "392e2136-313b-4276-8c17-e05e64a9be38")
	private String statuses;
	@Schema(description = "", example = "6467.56")
	private Double purchasePrice;

}
