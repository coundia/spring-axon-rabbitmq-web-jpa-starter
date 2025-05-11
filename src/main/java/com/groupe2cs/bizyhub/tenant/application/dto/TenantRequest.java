package com.groupe2cs.bizyhub.tenant.application.dto;

import com.groupe2cs.bizyhub.tenant.domain.valueObject.*;
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
@Schema(name = "TenantRequest", description = "Request payload for Tenant operations")
public class TenantRequest implements Serializable {

	@Schema(description = "", example = "2f50d904-2107-4b1b-aa88-01a8ca4531a8")
	private String name;

	@Schema(description = "", example = "d13153ab-27f2-4b43-93d5-207bfa626f19")
	private String description;

	@Schema(description = "", example = "ba56deaf-7000-42db-aba6-90ce2a77c8c0")
	private String domain;

	@Schema(description = "", example = "be994981-2c8a-4c3d-8061-50040f1c772d")
	private String language;

	@Schema(description = "", example = "false")
	private Boolean active;


}
