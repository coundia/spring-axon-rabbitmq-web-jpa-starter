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

	@Schema(description = "", example = "fb5a83f6-d60c-41fb-94b8-1f12c139c0da")
	private String name;

	@Schema(description = "", example = "b8011a85-4db5-44d8-a636-b6b285d178d6")
	private String description;

	@Schema(description = "", example = "d89a51da-dcda-473c-bc9c-28554a567335")
	private String domain;

	@Schema(description = "", example = "ff0bff07-bdb1-4f9c-9bc8-5a091afb007d")
	private String language;

	@Schema(description = "", example = "true")
	private Boolean active;


}
