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

	@Schema(description = "", example = "2abb0bfe-111c-42e8-af87-1c2cd1fcfd34")
	private String name;

	@Schema(description = "", example = "9c8c5ccc-b039-44f4-bfbb-bbd710916113")
	private String description;

	@Schema(description = "", example = "9cdfb3bb-3d85-4511-a8a1-b33e99fcfcf9")
	private String domain;

	@Schema(description = "", example = "9d85c826-0705-448c-b8a4-dca89113c227")
	private String language;

	@Schema(description = "", example = "false")
	private Boolean active;


}
