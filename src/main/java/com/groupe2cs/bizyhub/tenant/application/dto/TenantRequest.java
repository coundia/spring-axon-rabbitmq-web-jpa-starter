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

	@Schema(description = "", example = "7c1d37c2-256d-4a15-aa89-4865083a3168")
	private String name;

	@Schema(description = "", example = "394da316-9b83-4d41-b723-59ffeffb95d3")
	private String description;

	@Schema(description = "", example = "60495bcf-c696-425c-8f46-606ec60f6a73")
	private String domain;

	@Schema(description = "", example = "395e5374-34c7-4399-a439-c13c0bee6d26")
	private String language;

	@Schema(description = "", example = "false")
	private Boolean active;


}
