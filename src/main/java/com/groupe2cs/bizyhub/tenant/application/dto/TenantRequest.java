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

	@Schema(description = "", example = "8a6a3942-2d2d-4be7-be0c-1de65fdc1d10")
	private String name;

	@Schema(description = "", example = "f6713e6e-5f77-485a-a320-5ee66ceef715")
	private String description;

	@Schema(description = "", example = "7e103caa-ff61-4f08-8935-e14cb07c697b")
	private String domain;

	@Schema(description = "", example = "7b87aa60-c8a3-4d10-86c9-8756783c2e1d")
	private String language;

	@Schema(description = "", example = "false")
	private Boolean active;


}
