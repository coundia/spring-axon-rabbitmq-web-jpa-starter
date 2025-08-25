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

		@Schema(description = "", example = "114df19d-67d1-4988-808f-b206852f589e")
		private String remoteId;
		@Schema(description = "", example = "9fb1e5c6-baa2-4acb-9f25-2664d3fb0d99")
		private String localId;
		@Schema(description = "", example = "1b2f72e5-ae0d-4d22-b9a2-96eb96db37dc")
		private String code;
		@Schema(description = "", example = "acf03e35-9774-4ac8-b7d5-56e8abb057d4")
		private String name;
		@Schema(description = "", example = "14619a2e-1ca0-4723-a418-c2b661c1fd1c")
		private String description;
		@Schema(description = "", example = "479d48a2-2c86-4f2e-a2b6-1e1672d20d8c")
		private String phone;
		@Schema(description = "", example = "bcb21efb-e0a5-4a79-a978-2e0f48409c72")
		private String email;
		@Schema(description = "", example = "0bb9182f-34e7-4e8e-b616-9cada9faeafb")
		private String website;
		@Schema(description = "", example = "c4f11652-a28e-45ab-8c32-2802774ada7d")
		private String taxId;
		@Schema(description = "", example = "7ea5552e-5882-4f5f-9998-89200daf2846")
		private String currency;
		@Schema(description = "", example = "bff9df17-e731-42cd-95b4-0e9b45614c75")
		private String addressLine1;
		@Schema(description = "", example = "3f2bf05b-6838-4654-a270-67e8af308c76")
		private String addressLine2;
		@Schema(description = "", example = "38527d3c-64c8-4857-9fc2-5fcc8745b294")
		private String city;
		@Schema(description = "", example = "c68ee939-5321-4136-9b14-d99fb2406444")
		private String region;
		@Schema(description = "", example = "50c06d9f-c8af-437a-9a77-2cd0fadacf21")
		private String country;
		@Schema(description = "", example = "358efcf0-2490-4ecc-b0fc-c5344dcd2659")
		private String postalCode;
		@Schema(description = "", example = "false")
		private Boolean isActive;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "true")
		private Boolean isDefault;

}
