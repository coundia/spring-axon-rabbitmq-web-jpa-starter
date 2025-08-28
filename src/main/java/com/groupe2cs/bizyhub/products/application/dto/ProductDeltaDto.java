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

		@Schema(description = "", example = "168a722a-d620-4a01-aca9-f9c420f47c2b")
		private String remoteId;
		@Schema(description = "", example = "7f318707-982c-44de-96a2-1b8dad597963")
		private String localId;
		@Schema(description = "", example = "6ad2d2b3-a287-4a5e-aa4f-9e58af545dca")
		private String code;
		@Schema(description = "", example = "73a8f6d4-ee56-4a06-96c1-319c5f00b5a3")
		private String name;
		@Schema(description = "", example = "efdf31b7-e9b3-4d02-be73-b6dd56615f8d")
		private String description;
		@Schema(description = "", example = "c94eed96-ffdd-4672-9e96-7d2e3cc012cb")
		private String barcode;
		@Schema(description = "", example = "e6ff0c7a-4492-4906-a100-3fb7c13f971c")
		private String unit;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "6688f8c7-306f-44ec-b997-3d07d7454a44")
		private String category;
		@Schema(description = "", example = "1ab4eec2-d4bf-4e8d-9439-ec84f19d9c6d")
		private String account;
		@Schema(description = "", example = "4245.51")
		private Double defaultPrice;
		@Schema(description = "", example = "2d0edac2-8e68-4f3a-a3c3-1319d1ce8dba")
		private String statuses;
		@Schema(description = "", example = "8752.75")
		private Double purchasePrice;

}
