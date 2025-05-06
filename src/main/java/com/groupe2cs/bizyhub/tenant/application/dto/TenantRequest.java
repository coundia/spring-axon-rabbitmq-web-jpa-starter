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

	@Schema(description = "", example = "9d601ca8-878d-4fa7-b0f5-e1fe33729a5d")
	private String name;

	@Schema(description = "", example = "75573540-c758-49b4-9eef-180d158146b1")
	private String description;

	@Schema(description = "", example = "b7533436-54cb-48f2-a250-35eed786a6b7")
	private String domain;

	@Schema(description = "", example = "ae06ebac-6a8d-4847-8dce-fa6423de6fa4")
	private String language;

	@Schema(description = "", example = "false")
	private Boolean active;


}
