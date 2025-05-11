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

	@Schema(description = "", example = "9f5a58c8-c51e-45bc-9576-6b8d058fd9d9")
	private String name;

	@Schema(description = "", example = "7c69f790-bf94-4de1-9274-e6971036684e")
	private String description;

	@Schema(description = "", example = "7cb7a34d-69e8-475a-959c-01ecf05dedce")
	private String domain;

	@Schema(description = "", example = "64eba009-a695-4875-b3a7-9da3882b4782")
	private String language;

	@Schema(description = "", example = "false")
	private Boolean active;


}
