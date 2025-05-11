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

	@Schema(description = "", example = "705803e0-c02e-48d0-b168-fe4a9abf36e9")
	private String name;

	@Schema(description = "", example = "f874136a-d645-4431-886f-8cc530d171dd")
	private String description;

	@Schema(description = "", example = "0f999151-2e42-4da3-ba33-96e628465c9b")
	private String domain;

	@Schema(description = "", example = "2decdc29-84b0-4f74-ad7a-cece380ed27c")
	private String language;

	@Schema(description = "", example = "false")
	private Boolean active;


}
