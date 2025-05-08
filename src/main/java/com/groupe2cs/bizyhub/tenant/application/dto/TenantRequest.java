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

	@Schema(description = "", example = "cbf4152b-70f2-474e-8541-c5f6f7c256db")
	private String name;

	@Schema(description = "", example = "54ad3155-3051-4d93-8954-e34259b4ff02")
	private String description;

	@Schema(description = "", example = "f62b00bd-8640-412c-a5ee-b8522dff54f2")
	private String domain;

	@Schema(description = "", example = "37022a16-0251-4c38-90c6-7e0b37939f5d")
	private String language;

	@Schema(description = "", example = "false")
	private Boolean active;


}
