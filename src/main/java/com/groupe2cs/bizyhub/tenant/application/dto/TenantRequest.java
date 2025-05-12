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

	@Schema(description = "", example = "f69daceb-e726-4edf-b1ec-599507ee6fcf")
	private String name;

	@Schema(description = "", example = "65399cdd-b813-4beb-9eeb-161a460daa77")
	private String description;

	@Schema(description = "", example = "2dbbac11-c261-4e2e-8782-139855a6312a")
	private String domain;

	@Schema(description = "", example = "ae8d0ac7-5d9a-4c86-bc82-3357563272a7")
	private String language;

	@Schema(description = "", example = "false")
	private Boolean active;


}
