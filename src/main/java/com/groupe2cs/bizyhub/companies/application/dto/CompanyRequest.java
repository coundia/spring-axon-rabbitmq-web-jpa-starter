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

	@Schema(description = "", example = "426ea4e8-c2b9-4623-8ab4-dd8c7acddf33")
	private String remoteId;
	@Schema(description = "", example = "480adc4c-d2cf-4180-afcf-204aba09ab46")
	private String localId;
	@Schema(description = "", example = "5a4bef28-90fb-40f1-bc0e-1d8d4ff186a1")
	private String code;
	@Schema(description = "", example = "e46b61fd-28b0-4971-9a6b-1a333d31cef9")
	private String name;
	@Schema(description = "", example = "f57db063-f81d-4948-ace7-c848e981f22f")
	private String description;
	@Schema(description = "", example = "a9e16f4f-d470-4ede-84d8-0514e9d6d8c8")
	private String phone;
	@Schema(description = "", example = "1bb2b9a8-710a-4c34-9735-85a7f3f10ca5")
	private String email;
	@Schema(description = "", example = "51f74f1b-f2ef-4b3d-8148-2ca1c52b7dd6")
	private String website;
	@Schema(description = "", example = "44011c65-cd09-4f34-a8e9-a739c1000cf7")
	private String taxId;
	@Schema(description = "", example = "67a29e72-6e68-40d0-ab9b-91c196721640")
	private String currency;
	@Schema(description = "", example = "2532a476-40aa-4085-b337-4153d969a0b2")
	private String addressLine1;
	@Schema(description = "", example = "cae0bf60-585a-488e-bacd-b25ca19bc313")
	private String addressLine2;
	@Schema(description = "", example = "86a408d7-9efd-4504-9ca8-a6e003bda5b7")
	private String city;
	@Schema(description = "", example = "7289e364-2769-4047-842a-efe2ac459337")
	private String region;
	@Schema(description = "", example = "399b7dbd-5d8e-4b0e-a4f8-fcf559b22776")
	private String country;
	@Schema(description = "", example = "e0113029-41c5-453d-ad87-71b57a9a429f")
	private String account;
	@Schema(description = "", example = "32d7a99f-1960-4573-b8a6-7681a4dd9ad0")
	private String postalCode;
	@Schema(description = "", example = "true")
	private Boolean isActive;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "false")
	private Boolean isDefault;

}
