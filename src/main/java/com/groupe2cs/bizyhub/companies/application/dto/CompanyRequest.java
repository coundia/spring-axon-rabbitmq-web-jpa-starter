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

	@Schema(description = "", example = "b95801d3-54bc-4f0d-b39a-b49b4e051bc9")
	private String remoteId;
	@Schema(description = "", example = "03a30f46-ba0c-4f8e-8fcc-8420dedc5ef7")
	private String localId;
	@Schema(description = "", example = "4cb85d2b-2ba0-4402-81ec-8b016392905d")
	private String code;
	@Schema(description = "", example = "48130636-391b-42fe-9774-d8624554aaaa")
	private String name;
	@Schema(description = "", example = "6e0a3503-28ff-49df-9d98-e9902fbe08a4")
	private String description;
	@Schema(description = "", example = "8c82e1ff-a68c-4e3b-ad4c-7456826aaa86")
	private String phone;
	@Schema(description = "", example = "fb029bee-8f29-4230-9981-e1f272d2ab70")
	private String email;
	@Schema(description = "", example = "f0626e27-ae79-4916-88ca-0419d8ee6fe5")
	private String website;
	@Schema(description = "", example = "0cf81f26-0c25-43c3-bf0e-fe942290d750")
	private String taxId;
	@Schema(description = "", example = "59456fb1-18b0-43ee-b66d-24f0577555fa")
	private String currency;
	@Schema(description = "", example = "24d4fe73-30e5-4871-930a-2140c13c1d3f")
	private String addressLine1;
	@Schema(description = "", example = "506647ab-fa7b-4d3d-80ca-163eaf045ca8")
	private String addressLine2;
	@Schema(description = "", example = "1f635198-d7bb-4c20-a34f-bc7c39da3d24")
	private String city;
	@Schema(description = "", example = "c3bcdf31-cd21-44f2-9902-ef2d8aa37243")
	private String region;
	@Schema(description = "", example = "5e1a1085-d8b5-4859-81d8-a53f44cf92e9")
	private String country;
	@Schema(description = "", example = "e6ca7f2c-5804-4bd0-89bc-5be370d78a7f")
	private String postalCode;
	@Schema(description = "", example = "false")
	private Boolean isActive;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "true")
	private Boolean isDefault;

}
