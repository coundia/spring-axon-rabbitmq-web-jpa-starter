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

	@Schema(description = "", example = "d329cdb7-bcc0-4f67-b1c6-34696d20b625")
	private String name;

	@Schema(description = "", example = "554ee31b-6b94-49ad-8f1f-51a6dd321709")
	private String description;

	@Schema(description = "", example = "9b57e8f3-0e4b-4399-9491-7c3476c704df")
	private String domain;

	@Schema(description = "", example = "1e12bce8-0d24-44ba-aed2-c19596187cab")
	private String language;

	@Schema(description = "", example = "true")
	private Boolean active;


}
