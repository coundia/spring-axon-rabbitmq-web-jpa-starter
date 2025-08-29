package com.groupe2cs.bizyhub.companies.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

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

	@Schema(description = "", example = "4b525f0e-e590-4a15-b670-7ada900597f3")
	private String remoteId;
	@Schema(description = "", example = "2b55f463-66f9-4493-aa5a-b34a208afb28")
	private String localId;
	@Schema(description = "", example = "c534d432-3bd0-47b2-babc-99f8b0ce38d9")
	private String code;
	@Schema(description = "", example = "e78ef7d8-3bfe-4e27-9a92-26b68c37db19")
	private String name;
	@Schema(description = "", example = "2e073b2b-9a28-4329-9e3c-0b5ac6b33947")
	private String description;
	@Schema(description = "", example = "ef4a21e4-e971-4e65-a059-f7c9f4edc644")
	private String phone;
	@Schema(description = "", example = "3a8b5c16-bfe4-40af-a66d-01e2bdbac7fc")
	private String email;
	@Schema(description = "", example = "e086fa15-93f1-4398-aab3-b5437895146c")
	private String website;
	@Schema(description = "", example = "883b34f7-6c3a-4d56-b86d-03bfb1b4eabe")
	private String taxId;
	@Schema(description = "", example = "b0772164-c00b-4c44-b9d3-316d24bd7415")
	private String currency;
	@Schema(description = "", example = "764b953a-afd0-472d-93cb-23c05fc62eb6")
	private String addressLine1;
	@Schema(description = "", example = "709e92af-1c85-4ffa-8f57-a5451d16ec3e")
	private String addressLine2;
	@Schema(description = "", example = "3bb224ee-4e4b-449e-ac93-ed6dbaab41b2")
	private String city;
	@Schema(description = "", example = "fb2e63b8-e6ce-4312-b788-23e87d9c72f4")
	private String region;
	@Schema(description = "", example = "6df2c496-3dfb-4f40-9f97-ed53904db837")
	private String country;
	@Schema(description = "", example = "a7f58ddd-64dc-420b-aaba-9117359d8e88")
	private String account;
	@Schema(description = "", example = "06460a31-a2a7-4001-819e-e88a82ecd1c1")
	private String postalCode;
	@Schema(description = "", example = "false")
	private Boolean isActive;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "false")
	private Boolean isDefault;

}
