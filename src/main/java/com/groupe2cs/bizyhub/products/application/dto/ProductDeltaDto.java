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

		@Schema(description = "", example = "53ed050c-efdc-4fc0-86d6-c3d225d07feb")
		private String remoteId;
		@Schema(description = "", example = "3d75291a-a3bf-4651-abd2-fec07ca475fd")
		private String localId;
		@Schema(description = "", example = "8e142480-36ae-45f6-a298-a72a27c43e04")
		private String code;
		@Schema(description = "", example = "62f04aec-e331-4212-b8af-c39a41538a02")
		private String name;
		@Schema(description = "", example = "601c6f82-7d05-44d3-bc22-6ba091d561ab")
		private String description;
		@Schema(description = "", example = "7ca5970c-f779-459b-8863-72b2093052fd")
		private String barcode;
		@Schema(description = "", example = "d6947438-02fe-400e-a752-0d1dc2ef8eba")
		private String unit;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "d180d9b0-8528-4963-ae70-28ee9a57fd7d")
		private String category;
		@Schema(description = "", example = "2701.86")
		private Double defaultPrice;
		@Schema(description = "", example = "e35def48-a87c-4985-ae19-79a3f9bb350e")
		private String statuses;
		@Schema(description = "", example = "5517.78")
		private Double purchasePrice;

}
