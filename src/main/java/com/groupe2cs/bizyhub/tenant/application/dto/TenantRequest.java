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

	@Schema(description = "", example = "b384a158-886b-46a6-ad19-bab0f3627f6e")
	private String name;

	@Schema(description = "", example = "cf8d8f89-3882-45e9-a048-553fbf5608d5")
	private String description;

	@Schema(description = "", example = "51a85a83-15de-4f81-87af-14715153ba70")
	private String domain;

	@Schema(description = "", example = "fea0518b-742e-45df-9195-99aa2575ed70")
	private String language;

	@Schema(description = "", example = "true")
	private Boolean active;


}
