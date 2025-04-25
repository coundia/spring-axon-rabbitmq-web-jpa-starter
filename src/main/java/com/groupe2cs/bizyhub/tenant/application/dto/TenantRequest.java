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

	@Schema(description = "", example = "d2e553a0-6235-4ade-953a-651d8abba453")
	private String name;

	@Schema(description = "", example = "b9fd6137-5675-4d6d-a14b-a3c681cbfc2a")
	private String description;

	@Schema(description = "", example = "773202a4-3411-4320-9b40-17feb0ab51d0")
	private String domain;

	@Schema(description = "", example = "5d24a875-cadf-4d4c-b1eb-8fb08ab231d5")
	private String language;

	@Schema(description = "", example = "true")
	private Boolean active;


}
