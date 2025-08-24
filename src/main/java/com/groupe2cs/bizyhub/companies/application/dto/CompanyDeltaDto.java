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

		@Schema(description = "", example = "77995a2d-5fd8-46ec-82d2-1d52686d2061")
		private String remoteId;
		@Schema(description = "", example = "d6021e5e-7b6e-4f0b-a701-aa3aadb79c80")
		private String localId;
		@Schema(description = "", example = "26a7eb8d-a46a-4254-b59d-a25494e5de4d")
		private String code;
		@Schema(description = "", example = "d345a1c3-8b39-4b1a-9bba-c49c28b25d5a")
		private String name;
		@Schema(description = "", example = "c3e2afa3-9efe-428d-8250-b981630199a6")
		private String description;
		@Schema(description = "", example = "d60648ae-5450-48a7-ac4e-de03c024dbcf")
		private String phone;
		@Schema(description = "", example = "fa9197c9-3044-41c6-8fe4-1b6c47a79393")
		private String email;
		@Schema(description = "", example = "bd14aa03-1e33-4814-ba29-70399e459d0f")
		private String website;
		@Schema(description = "", example = "c0dd087b-693f-451d-a5af-5208edd3be9f")
		private String taxId;
		@Schema(description = "", example = "cefb7b74-8e11-4379-870d-931337afa60e")
		private String currency;
		@Schema(description = "", example = "aa0ab737-cd49-4e68-a561-0e60b04925e5")
		private String addressLine1;
		@Schema(description = "", example = "7359cefc-5591-4683-931a-01a54c9605bf")
		private String addressLine2;
		@Schema(description = "", example = "c3857fa6-3d4d-4935-b931-ae5e1494eefc")
		private String city;
		@Schema(description = "", example = "9a9b90f9-06b4-4271-a5d3-f62971fbd8cb")
		private String region;
		@Schema(description = "", example = "9b4df8ce-3236-409f-b546-48a8003be878")
		private String country;
		@Schema(description = "", example = "54b7d766-5498-48d5-ba9a-629b4b0e746a")
		private String postalCode;
		@Schema(description = "", example = "true")
		private Boolean isActive;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "false")
		private Boolean isDefault;

}
