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

	@Schema(description = "", example = "302f3a63-c35d-4a59-bead-450e902e245a")
	private String remoteId;
	@Schema(description = "", example = "a43e1b9c-e67c-48e3-ae8b-09f17f00e5ab")
	private String code;
	@Schema(description = "", example = "5cf997e3-d406-4864-aea5-0d7583d63452")
	private String name;
	@Schema(description = "", example = "3340d83b-f3c6-431b-9ccf-9b29110dea53")
	private String description;
	@Schema(description = "", example = "642cf302-2cf7-484a-8bba-9bcd77735dc6")
	private String phone;
	@Schema(description = "", example = "5faea189-4eca-4cce-8a15-df7c1af97a7b")
	private String email;
	@Schema(description = "", example = "64d99aa0-6130-4326-a128-76380181cbee")
	private String website;
	@Schema(description = "", example = "9b0a4115-0538-40aa-b022-b48921ab0a5c")
	private String taxId;
	@Schema(description = "", example = "fdc4447f-f05b-48fb-8ed2-d0ffc0c9b7f2")
	private String currency;
	@Schema(description = "", example = "2bb1703b-86ec-47e5-9eb5-6d62c8da1765")
	private String addressLine1;
	@Schema(description = "", example = "43286246-f28c-43f3-ba74-60438ec58740")
	private String addressLine2;
	@Schema(description = "", example = "3640c002-05df-4ed6-b7d9-3e208f8e70f9")
	private String city;
	@Schema(description = "", example = "c1ca0d68-1daa-4fe6-9eaf-f7d21274fe12")
	private String region;
	@Schema(description = "", example = "cc51e8bd-d340-4f00-bd1c-4a71c5f7c91a")
	private String country;
	@Schema(description = "", example = "cd306d50-88be-405b-b08c-19bccaada915")
	private String postalCode;
	@Schema(description = "", example = "true")
	private Boolean isActive;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "false")
	private Boolean isDefault;

}
