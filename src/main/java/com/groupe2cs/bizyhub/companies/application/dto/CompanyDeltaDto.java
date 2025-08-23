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

		@Schema(description = "", example = "f2e7d1cf-9aaf-4a06-bd3d-b1e7fe6105c9")
		private String remoteId;
		@Schema(description = "", example = "bc6a396c-b7dc-4d21-a517-8cf7c8164c26")
		private String code;
		@Schema(description = "", example = "e54e8569-fdeb-4b60-842e-5bffa4134593")
		private String name;
		@Schema(description = "", example = "ce0c6a04-aef4-488b-ab5f-b2e7d488fa57")
		private String description;
		@Schema(description = "", example = "e0172c2b-d7be-472b-aa93-ccde4888daa9")
		private String phone;
		@Schema(description = "", example = "27f0d50b-6321-43ba-8e86-b3b4819a28b2")
		private String email;
		@Schema(description = "", example = "80f4cad7-3f5f-4012-97b7-746686deeb29")
		private String website;
		@Schema(description = "", example = "669d2b25-f54f-4205-b80c-bdc2c3b01c0f")
		private String taxId;
		@Schema(description = "", example = "8ad08253-146e-462f-aeab-1cef19095a1b")
		private String currency;
		@Schema(description = "", example = "4a405b7f-1952-47fd-aa8a-2faa3727d779")
		private String addressLine1;
		@Schema(description = "", example = "fb0fd360-b4fd-4e2a-a7b2-b184a0bc60fc")
		private String addressLine2;
		@Schema(description = "", example = "91e2feeb-f085-47ca-8448-6222e7438c50")
		private String city;
		@Schema(description = "", example = "a8c60b23-eec6-46c7-a017-6d9764b7b725")
		private String region;
		@Schema(description = "", example = "ab8ae437-9645-45d3-bb50-0c36174bb12e")
		private String country;
		@Schema(description = "", example = "ae2ca72d-65af-487b-93fa-04b9fccfdc35")
		private String postalCode;
		@Schema(description = "", example = "true")
		private Boolean isActive;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "false")
		private Boolean isDefault;

}
