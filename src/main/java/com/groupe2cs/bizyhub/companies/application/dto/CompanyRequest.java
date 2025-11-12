package com.groupe2cs.bizyhub.companies.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "CompanyRequest", description = "Request payload for Company operations")
public class CompanyRequest implements Serializable {

	@Schema(description = "", example = "3aa6f742-2954-408a-9251-fbf17d31a038")
	private String remoteId;
	@Schema(description = "", example = "8e781409-a0ee-43c4-be0b-3180afb5fb8f")
	private String localId;
	@Schema(description = "", example = "99bfba7c-45b1-4e22-a3de-0303c768f1b9")
	private String code;
	@Schema(description = "", example = "561eac9a-c962-42ee-b830-e8f0cf3e8e62")
	private String name;
	@Schema(description = "", example = "0d9caf5a-4ccb-4e95-b8e3-09d139239726")
	private String description;
	@Schema(description = "", example = "456bbb70-89dd-480a-970c-5b28628eecd5")
	private String phone;
	@Schema(description = "", example = "afaede49-a30d-48c1-bbde-d4fcedbf39ad")
	private String email;
	@Schema(description = "", example = "34eaf9e1-c9ee-4197-b9bb-6113d42f72eb")
	private String website;
	@Schema(description = "", example = "83a57cb7-8612-497f-a0f4-00acc0206cc1")
	private String taxId;
	@Schema(description = "", example = "b7a7c626-8b72-4dc6-8c56-1e29aeafb80a")
	private String currency;
	@Schema(description = "", example = "847c5fc0-417a-4681-91d2-7e58bf7c45ab")
	private String addressLine1;
	@Schema(description = "", example = "1229c873-59ec-42ca-8832-583e807f6741")
	private String addressLine2;
	@Schema(description = "", example = "ab864532-719e-475f-ab61-b040154fbb2c")
	private String city;
	@Schema(description = "", example = "2013a8c2-3ba8-4b0d-925d-7a8f82239726")
	private String region;
	@Schema(description = "", example = "cfc2b312-7fd8-4ea9-a6b4-0d4033b7d050")
	private String country;
	@Schema(description = "", example = "389af338-20f8-4939-a4a0-9540b96d157c")
	private String account;
	@Schema(description = "", example = "b20bb9aa-0934-467b-bac0-1c676b2a3b9d")
	private String postalCode;
	@Schema(description = "", example = "false")
	private Boolean isActive;
	@Schema(description = "", example = "22f7302a-2de0-4d34-9af1-9eb44bee168e")
	private String status;
	@Schema(description = "", example = "false")
	private Boolean isPublic;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "true")
	private Boolean isDefault;

}
