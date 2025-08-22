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

	@Schema(description = "", example = "908b3d47-1b07-4d9e-a2a8-2b932edd5727")
	private String name;
	@Schema(description = "", example = "c535f6e7-d459-4576-ade8-e2bb817e3cea")
	private String description;
	@Schema(description = "", example = "f781cc11-59d5-4e7e-bfab-39b09a5fa599")
	private String domain;
	@Schema(description = "", example = "7e2cc548-bfc2-4940-a924-04857a2300aa")
	private String language;
	@Schema(description = "", example = "true")
	private Boolean active;

}
