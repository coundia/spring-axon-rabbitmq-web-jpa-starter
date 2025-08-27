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

		@Schema(description = "", example = "74eac467-17b2-4ba6-89d1-0fcf13ae7147")
		private String remoteId;
		@Schema(description = "", example = "0345c718-5035-4084-bb3d-896f70ccf638")
		private String localId;
		@Schema(description = "", example = "bca879aa-fa6e-4545-b041-55fcd4bdd66c")
		private String code;
		@Schema(description = "", example = "563b5a84-0412-44ea-b33a-118ccf445b25")
		private String name;
		@Schema(description = "", example = "819c61e8-ca1f-4f9f-86b9-d8925b09a54e")
		private String description;
		@Schema(description = "", example = "ea9df7c7-a889-4d8e-992d-fe2ec083eb8d")
		private String phone;
		@Schema(description = "", example = "5c0e0d89-4a7f-4ad6-a2aa-aea0a5214fea")
		private String email;
		@Schema(description = "", example = "2b922f6e-fc37-455d-a842-d2be540c1dc8")
		private String website;
		@Schema(description = "", example = "6f25c9e9-bbc8-4c6b-9068-0cd1d8000325")
		private String taxId;
		@Schema(description = "", example = "06a54827-e33c-4196-8740-cc1f51787650")
		private String currency;
		@Schema(description = "", example = "471507e5-612e-489d-aa7d-47088232dd1c")
		private String addressLine1;
		@Schema(description = "", example = "67f20c9b-40e6-4c88-8049-356b4a8e09c8")
		private String addressLine2;
		@Schema(description = "", example = "5941fc0f-011c-49f4-b350-3ef4a51bb8f3")
		private String city;
		@Schema(description = "", example = "4a97dfda-6b87-4fff-8d0f-893c7e277a00")
		private String region;
		@Schema(description = "", example = "76921f41-443f-44b3-b972-f5ac9a7d284b")
		private String country;
		@Schema(description = "", example = "54266f5b-df62-43ca-901f-f33f3a9a4c58")
		private String postalCode;
		@Schema(description = "", example = "true")
		private Boolean isActive;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "true")
		private Boolean isDefault;

}
