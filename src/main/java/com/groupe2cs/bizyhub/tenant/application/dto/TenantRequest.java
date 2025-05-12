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

	@Schema(description = "", example = "125f0768-c8d2-4e8f-90ed-23c9a0950560")
	private String name;

	@Schema(description = "", example = "f137a523-b103-4aa1-b85c-8d0ad2be9fdb")
	private String description;

	@Schema(description = "", example = "ae9c4dbc-c42b-4be8-95db-f42a511e46aa")
	private String domain;

	@Schema(description = "", example = "81ef3f0e-dd31-41d6-a679-8c138547b17c")
	private String language;

	@Schema(description = "", example = "true")
	private Boolean active;


}
