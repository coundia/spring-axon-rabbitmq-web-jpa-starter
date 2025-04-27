package com.groupe2cs.bizyhub.tenant.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "TenantRequest", description = "Request payload for Tenant operations")
public class TenantRequest implements Serializable {

	@Schema(description = "", example = "ed19eb44-d069-410b-ac65-feaeb101bc6b")
	private String name;

	@Schema(description = "", example = "c11d1daf-94d9-422d-8b2e-2f9de5ac00c2")
	private String description;

	@Schema(description = "", example = "5742736a-ce7e-4116-ae3d-6dead388d616")
	private String domain;

	@Schema(description = "", example = "c9fba6ee-cec7-40a0-9443-f521f523a684")
	private String language;

	@Schema(description = "", example = "true")
	private Boolean active;


}
