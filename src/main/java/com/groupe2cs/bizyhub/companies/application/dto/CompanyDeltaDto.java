package com.groupe2cs.bizyhub.companies.application.dto;

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
@Schema(name = "CompanyDeltaDto", description = "Delta DTO for company changes")
public class CompanyDeltaDto implements Serializable {

    @Schema(description = "Identifier of the company", example = "uuid")
    private String id;

    @Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
    private String type = "CREATE";

		@Schema(description = "", example = "69b821bd-02f5-4fe8-b0ea-d8855843f771")
		private String remoteId;
		@Schema(description = "", example = "62c55c33-4bed-4db5-9bba-c2a6e259a040")
		private String code;
		@Schema(description = "", example = "43599967-db0e-4669-a616-04761c4a030e")
		private String name;
		@Schema(description = "", example = "59cf438d-8e5f-4e29-9538-8b461d4d84a8")
		private String description;
		@Schema(description = "", example = "dd3e677b-053a-472c-8650-a3b79a469a6e")
		private String phone;
		@Schema(description = "", example = "03511979-b1d8-4eba-bebc-b89f3a4670fb")
		private String email;
		@Schema(description = "", example = "29032102-e037-4131-8ce9-0fee8bef7e4e")
		private String website;
		@Schema(description = "", example = "446fdee5-2d62-4350-b155-1496a7fe0bb8")
		private String taxId;
		@Schema(description = "", example = "347dffc9-7cc4-4d7c-a9a1-0a019348f532")
		private String currency;
		@Schema(description = "", example = "a0f906b6-ac38-4205-86a8-f4d99c6f00f4")
		private String addressLine1;
		@Schema(description = "", example = "cb23c276-bc90-4d52-a405-92af6c23c3d7")
		private String addressLine2;
		@Schema(description = "", example = "933ed0e0-e235-4bbb-bc1c-c8dd3a9acd89")
		private String city;
		@Schema(description = "", example = "20102357-99dd-4217-8b31-713a3809c7d2")
		private String region;
		@Schema(description = "", example = "70f2ca52-4193-44ad-a00c-97c0bf218c06")
		private String country;
		@Schema(description = "", example = "921e7aa6-2c9a-49a4-afa7-948af74a3d3d")
		private String postalCode;
		@Schema(description = "", example = "true")
		private Boolean isActive;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "true")
		private Boolean isDefault;

}
