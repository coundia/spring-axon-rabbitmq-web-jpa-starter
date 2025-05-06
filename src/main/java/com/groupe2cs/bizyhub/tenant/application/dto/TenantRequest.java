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

	@Schema(description = "", example = "57026e13-70b6-4a7c-9e07-7b375228f5bc")
	private String name;

	@Schema(description = "", example = "e2550af5-fb3c-4c45-b4e7-113ed3e997cb")
	private String description;

	@Schema(description = "", example = "fdf069b8-e96a-4daa-b17c-ceb879aa4b55")
	private String domain;

	@Schema(description = "", example = "6a7eb630-323c-44cf-b3c9-a84af65a3c91")
	private String language;

	@Schema(description = "", example = "false")
	private Boolean active;


}
