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

	@Schema(description = "", example = "0ecacf36-bcf1-4b18-882b-92be30e0b639")
	private String remoteId;
	@Schema(description = "", example = "e91945a8-a42c-4d2b-b3a9-0cd814645c02")
	private String localId;
	@Schema(description = "", example = "18879053-13bd-491b-a351-7f05613ea824")
	private String code;
	@Schema(description = "", example = "2266be7c-265f-41f3-bdb9-277bf5826643")
	private String name;
	@Schema(description = "", example = "77405668-14de-4119-bb2d-57322c772132")
	private String description;
	@Schema(description = "", example = "b51abc91-f772-4819-87c5-a5dfeb2079cf")
	private String phone;
	@Schema(description = "", example = "ad5cf940-a2ec-498c-9ae8-0f1bd8856193")
	private String email;
	@Schema(description = "", example = "acbce98b-e466-424c-a8c9-8f6f91a142dc")
	private String website;
	@Schema(description = "", example = "eb6bc7d9-fb5f-4bfc-bf44-3395e50fec51")
	private String taxId;
	@Schema(description = "", example = "f42ff32c-79c3-4c26-9796-e359f3ce3286")
	private String currency;
	@Schema(description = "", example = "c4202d2f-c5f0-44a9-9b6a-4344135336b1")
	private String addressLine1;
	@Schema(description = "", example = "a7cc535b-6c54-492f-9863-1ae52dcee99f")
	private String addressLine2;
	@Schema(description = "", example = "eb8a00f0-45be-4e3b-9ad5-961140b3569e")
	private String city;
	@Schema(description = "", example = "2cb9a009-10e9-45ef-9d22-d819517a19d3")
	private String region;
	@Schema(description = "", example = "d5c88c35-72b2-46f4-9a92-e2fa4835dd7e")
	private String country;
	@Schema(description = "", example = "ff25ce0f-accb-4eb4-aaec-9ea5c72e9d44")
	private String account;
	@Schema(description = "", example = "83e8c87e-2bec-48fc-b7a7-48dba879b38c")
	private String postalCode;
	@Schema(description = "", example = "false")
	private Boolean isActive;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "false")
	private Boolean isDefault;

}
