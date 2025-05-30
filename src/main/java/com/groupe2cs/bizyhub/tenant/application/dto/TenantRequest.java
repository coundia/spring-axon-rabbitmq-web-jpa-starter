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

	@Schema(description = "", example = "61445562-4261-4988-a67e-5d7cc168e417")
	private String name;
	@Schema(description = "", example = "969f34d5-d006-4155-95ec-cc6533cb815f")
	private String description;
	@Schema(description = "", example = "03ec16ee-423d-43bc-aaa4-d7dcc1cade86")
	private String domain;
	@Schema(description = "", example = "6c82c517-dc4f-4a90-a7b3-4366956bd684")
	private String language;
	@Schema(description = "", example = "false")
	private Boolean active;

}
