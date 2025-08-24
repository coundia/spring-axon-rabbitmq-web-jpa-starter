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

	@Schema(description = "", example = "f33a1aac-5c01-44ad-8ddd-d98407f0d0cb")
	private String name;
	@Schema(description = "", example = "cbf9371e-74a7-46cf-91e9-ded71fb51839")
	private String description;
	@Schema(description = "", example = "5e21bb35-6dc4-4f3e-8a48-3658f6706394")
	private String domain;
	@Schema(description = "", example = "824b1d6a-1b7a-4496-a829-3c0c15a4ca03")
	private String language;
	@Schema(description = "", example = "false")
	private Boolean active;

}
