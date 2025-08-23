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

	@Schema(description = "", example = "680de948-5d8b-4671-b866-ac3cb332d718")
	private String name;
	@Schema(description = "", example = "3f9049bd-6698-486a-aae8-f484261f2e16")
	private String description;
	@Schema(description = "", example = "b6f1ed04-4e30-4bf9-a015-ba08454f949d")
	private String domain;
	@Schema(description = "", example = "10063034-5715-4713-bb6f-cadfc74ff05e")
	private String language;
	@Schema(description = "", example = "false")
	private Boolean active;

}
