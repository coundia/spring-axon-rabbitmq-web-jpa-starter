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

	@Schema(description = "", example = "96075d2d-57cb-40ab-b41a-877a809762da")
	private String name;

	@Schema(description = "", example = "7d22ecd1-b64a-4993-a4ac-d4c3aecdb464")
	private String description;

	@Schema(description = "", example = "aa623f15-5389-4a39-a3fa-fa6413659f35")
	private String domain;

	@Schema(description = "", example = "4748638f-3269-454a-a01c-61b55231371c")
	private String language;

	@Schema(description = "", example = "true")
	private Boolean active;


}
