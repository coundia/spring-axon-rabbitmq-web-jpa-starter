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

	@Schema(description = "", example = "e89e9351-5ed2-4f4f-a242-86ed7e620d61")
	private String remoteId;
	@Schema(description = "", example = "cbf4a774-cedd-41f5-9e8a-73f8c10fc03c")
	private String localId;
	@Schema(description = "", example = "5752d3be-941b-4145-8d8b-9535a09d9dbb")
	private String code;
	@Schema(description = "", example = "8fcf37e1-eb52-4888-a592-fcbc0557a985")
	private String name;
	@Schema(description = "", example = "80922101-a09d-4e22-b114-c8af1ddd2039")
	private String description;
	@Schema(description = "", example = "49de8f44-8653-442b-88e2-caa9558e364c")
	private String phone;
	@Schema(description = "", example = "eadf4895-b991-4fd8-b4aa-94b78033c92e")
	private String email;
	@Schema(description = "", example = "bc9f6930-24ab-4e52-a8f5-e1576478db1b")
	private String website;
	@Schema(description = "", example = "57352882-697f-4c96-ac87-225a142af2e3")
	private String taxId;
	@Schema(description = "", example = "ed06a332-6fc0-4b05-bfbe-84a3465b4d98")
	private String currency;
	@Schema(description = "", example = "5f483134-bec3-4a1a-8807-ba1847037bbe")
	private String addressLine1;
	@Schema(description = "", example = "e8b8cc79-6cc9-4a33-8922-c504711ee0f9")
	private String addressLine2;
	@Schema(description = "", example = "6855947f-8199-442a-9fa9-4a0ffe711d65")
	private String city;
	@Schema(description = "", example = "33cf10ad-b0f3-4f09-8612-3867aa36ab13")
	private String region;
	@Schema(description = "", example = "cc092f0d-9ecb-40e5-8a8e-9277ee876cd7")
	private String country;
	@Schema(description = "", example = "a5c42722-736c-4f48-a630-a1a5f6704cf8")
	private String postalCode;
	@Schema(description = "", example = "true")
	private Boolean isActive;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "true")
	private Boolean isDefault;

}
