package com.groupe2cs.bizyhub.tenant.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "TenantResponse", description = "Response payload for Tenant")
public class TenantResponse implements Serializable {

	@Schema(description = "", example = "")
	private String id;
	@Schema(description = "", example = "")
	private String name;
	@Schema(description = "", example = "")
	private String description;
	@Schema(description = "", example = "")
	private String domain;
	@Schema(description = "", example = "")
	private String language;
	@Schema(description = "", example = "")
	private Boolean active;

}
