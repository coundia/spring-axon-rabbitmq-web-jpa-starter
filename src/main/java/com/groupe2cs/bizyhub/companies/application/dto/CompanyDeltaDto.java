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

	@Schema(description = "", example = "8213fa9e-8cd0-40c3-ab32-bbe84c47a424")
	private String remoteId;
	@Schema(description = "", example = "ffbd8f37-1191-4f4e-91df-564464cde2d8")
	private String localId;
	@Schema(description = "", example = "cb00ddb6-ab6c-4269-9561-3e2fee19be92")
	private String code;
	@Schema(description = "", example = "14e79672-c57c-48fc-b3cf-8035c5e6a967")
	private String name;
	@Schema(description = "", example = "eda36a5f-5f65-4d44-9782-d5ce70daca21")
	private String description;
	@Schema(description = "", example = "d4d59e55-1990-42fa-96e2-ecc519e87c16")
	private String phone;
	@Schema(description = "", example = "079d2d86-42cd-4974-8cdd-fe62ad5a2e99")
	private String email;
	@Schema(description = "", example = "91a64112-fb44-40ed-a18e-acfae11ac4a0")
	private String website;
	@Schema(description = "", example = "0be59b9c-149b-4c62-ae4b-390c50d8a0c3")
	private String taxId;
	@Schema(description = "", example = "c4f35939-91f4-4691-90ad-2459ae0ab8a1")
	private String currency;
	@Schema(description = "", example = "38b3a4af-fc88-4bf5-992c-3bdb9d033fc6")
	private String addressLine1;
	@Schema(description = "", example = "48139cf6-e44e-4513-8802-18bccf6804ae")
	private String addressLine2;
	@Schema(description = "", example = "77d7beac-fa01-41ff-b6cc-094091bcd957")
	private String city;
	@Schema(description = "", example = "11181482-a499-4ef1-bc94-111112bb5994")
	private String region;
	@Schema(description = "", example = "3a85f797-be45-4181-b73c-5aa0ac5ac0ac")
	private String country;
	@Schema(description = "", example = "be85c9a1-c5e3-42a1-99dc-05ee4fcf2442")
	private String account;
	@Schema(description = "", example = "bca5860a-2039-4410-9145-9fb211154958")
	private String postalCode;
	@Schema(description = "", example = "false")
	private Boolean isActive;
	@Schema(description = "", example = "88bb4e6f-34a2-4b80-8046-04db4700b32e")
	private String status;
	@Schema(description = "", example = "true")
	private Boolean isPublic;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "false")
	private Boolean isDefault;

}
