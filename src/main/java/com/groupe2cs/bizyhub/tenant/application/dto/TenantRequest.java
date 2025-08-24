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

	@Schema(description = "", example = "d95ee038-a15a-43df-bd1e-a67978c37650")
	private String name;
	@Schema(description = "", example = "ad5948c5-ea22-41e1-9ff2-2805f5492574")
	private String description;
	@Schema(description = "", example = "c035cd74-2770-404b-88f2-17514debbb2b")
	private String domain;
	@Schema(description = "", example = "57a6447f-2844-457c-af6a-30e57c85e21f")
	private String language;
	@Schema(description = "", example = "true")
	private Boolean active;

}
