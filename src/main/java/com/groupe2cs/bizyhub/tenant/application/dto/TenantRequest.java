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

	@Schema(description = "", example = "44be0478-a176-4ab8-944c-95a77557426a")
	private String name;

	@Schema(description = "", example = "3983e243-32a2-4def-bb22-2d8dfa997138")
	private String description;

	@Schema(description = "", example = "81c4f37b-1084-4876-9a05-2a9b08940ace")
	private String domain;

	@Schema(description = "", example = "7f099194-308f-4cdf-988a-22e2f23676bf")
	private String language;

	@Schema(description = "", example = "false")
	private Boolean active;


}
