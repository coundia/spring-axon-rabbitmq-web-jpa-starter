package com.groupe2cs.bizyhub.products.application.dto;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import lombok.ToString;
import io.swagger.v3.oas.annotations.media.Schema;

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

		@Schema(description = "", example = "3b24d217-c1d3-4279-9e71-d160ad4578d7")
		private String remoteId;
		@Schema(description = "", example = "3e235507-1867-4e59-b1da-b0a1fd93a7fe")
		private String localId;
		@Schema(description = "", example = "d313122e-c69e-4186-a88b-a38c4d0e32e7")
		private String code;
		@Schema(description = "", example = "7b94b7b4-a5ab-44a5-8669-23b3a6cb2382")
		private String name;
		@Schema(description = "", example = "699a150c-2ea7-4fa5-8bd9-b83e2db4b314")
		private String description;
		@Schema(description = "", example = "f1b4f8f0-e2cd-4f50-a873-716538a5c275")
		private String barcode;
		@Schema(description = "", example = "bddee8bf-ae84-46a3-8f91-49442239541c")
		private String unit;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "dd19c4de-a076-4808-a0f4-21b40c8d2682")
		private String category;
		@Schema(description = "", example = "7601.29")
		private Double defaultPrice;
		@Schema(description = "", example = "d6cf2df7-82aa-46a6-8451-251cd6f01629")
		private String statuses;
		@Schema(description = "", example = "9710.16")
		private Double purchasePrice;

}
