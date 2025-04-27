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

	@Schema(description = "", example = "8f5a70b8-75b2-4b0d-9e98-cab93b3cffa4")
	private String name;

	@Schema(description = "", example = "1db6e1fe-686b-43aa-8f06-709a9ff6c067")
	private String description;

	@Schema(description = "", example = "7e6311e9-1475-4e38-ad61-3132b6193dee")
	private String domain;

	@Schema(description = "", example = "25cb65b1-affe-4368-850c-94855173e9a9")
	private String language;

	@Schema(description = "", example = "false")
	private Boolean active;


}
