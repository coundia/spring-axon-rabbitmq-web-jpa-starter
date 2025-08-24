package com.groupe2cs.bizyhub.companies.application.dto;

import com.groupe2cs.bizyhub.companies.domain.valueObject.*;
import java.util.UUID;
import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "CompanyRequest", description = "Request payload for Company operations")
public class CompanyRequest implements Serializable {

	@Schema(description = "", example = "5312f456-e8c2-4c5b-add7-f8b71036714b")
	private String remoteId;
	@Schema(description = "", example = "d4dfa5f3-d676-4500-bed2-9fe4659cb466")
	private String localId;
	@Schema(description = "", example = "9f10ed9d-0864-46f7-85ca-ca2c72f47a8d")
	private String code;
	@Schema(description = "", example = "b39803d9-a696-47e1-9434-e4d2c55f335a")
	private String name;
	@Schema(description = "", example = "557ab27d-8b99-440f-a414-87692136547b")
	private String description;
	@Schema(description = "", example = "02e18ecb-9bb0-46f5-9b48-b1933012cfc9")
	private String phone;
	@Schema(description = "", example = "44fbcdfd-15d4-4ea9-abfd-33cda04154be")
	private String email;
	@Schema(description = "", example = "76138ddc-cb2c-4255-a40b-c68d0bd4a0a7")
	private String website;
	@Schema(description = "", example = "2335fc1e-b0d8-448c-8744-238bb916b826")
	private String taxId;
	@Schema(description = "", example = "858c2f7a-9a67-4d43-a101-c92aab76af12")
	private String currency;
	@Schema(description = "", example = "c6d86cca-38fd-42cc-b992-808cefb88570")
	private String addressLine1;
	@Schema(description = "", example = "a6a867be-ff21-4390-b437-a8ee06a22bbb")
	private String addressLine2;
	@Schema(description = "", example = "3daec6e5-5f39-4e03-b787-bd6c8efc6b4d")
	private String city;
	@Schema(description = "", example = "0c14ed8f-44a8-4d63-8e7e-f80cdc5507ad")
	private String region;
	@Schema(description = "", example = "2a7a115d-155f-45df-afbf-c8f7d3953066")
	private String country;
	@Schema(description = "", example = "7c4c7580-c42f-4c96-aafa-d5602f6058de")
	private String postalCode;
	@Schema(description = "", example = "false")
	private Boolean isActive;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "false")
	private Boolean isDefault;

}
