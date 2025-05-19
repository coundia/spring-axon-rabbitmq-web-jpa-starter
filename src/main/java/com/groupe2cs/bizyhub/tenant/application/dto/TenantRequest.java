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

	@Schema(description = "", example = "6b724f25-2f1f-4ba4-8a04-f8d7cdbb661a")
	private String name;

	@Schema(description = "", example = "68db3e37-3202-4667-ae1b-da93a97d8708")
	private String description;

	@Schema(description = "", example = "365a002b-8285-4bf9-bc08-00c18c72fd5d")
	private String domain;

	@Schema(description = "", example = "19621a4c-3500-4fd4-8182-c15395ce11a4")
	private String language;

	@Schema(description = "", example = "true")
	private Boolean active;


}
