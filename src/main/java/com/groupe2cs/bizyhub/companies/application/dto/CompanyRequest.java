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

	@Schema(description = "", example = "56d1150a-bc6f-4385-a080-902c8c271697")
	private String remoteId;
	@Schema(description = "", example = "973a4140-559c-41bb-aae1-1b54310e1c01")
	private String code;
	@Schema(description = "", example = "59eed48d-a363-43b4-b5d0-256994339a5c")
	private String name;
	@Schema(description = "", example = "7c782829-6664-4cc0-97e8-eb5d707310ee")
	private String description;
	@Schema(description = "", example = "34cb67f2-613a-41c1-a05c-191bb30283c4")
	private String phone;
	@Schema(description = "", example = "750f3692-87c6-4f64-909a-529624290285")
	private String email;
	@Schema(description = "", example = "6efe160e-eb08-435d-9ef7-e361021cb576")
	private String website;
	@Schema(description = "", example = "3875332f-5444-491d-b455-5885a612e726")
	private String taxId;
	@Schema(description = "", example = "c8770107-001c-4caa-acde-6591ae927183")
	private String currency;
	@Schema(description = "", example = "aa28a3fb-4c5b-4c0d-84cd-3bd170c6e04d")
	private String addressLine1;
	@Schema(description = "", example = "3d182dc9-e3d4-4fe7-9a03-f059e4ea09b9")
	private String addressLine2;
	@Schema(description = "", example = "dff73d36-0e40-41b3-9c5f-331cf1db7d85")
	private String city;
	@Schema(description = "", example = "3f715303-71b1-4f04-87e3-b51be69051e5")
	private String region;
	@Schema(description = "", example = "8c8a544a-2c03-4fc6-aab9-442f4c4c9485")
	private String country;
	@Schema(description = "", example = "423e7aec-aac2-4d0c-9a7e-d246cf9e28b7")
	private String postalCode;
	@Schema(description = "", example = "false")
	private Boolean isActive;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "true")
	private Boolean isDefault;

}
