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

	@Schema(description = "", example = "c8cd145f-9c80-46c6-87d7-394db6701901")
	private String name;

	@Schema(description = "", example = "7dd47976-6ede-44c5-afc2-72d8ab49d64a")
	private String description;

	@Schema(description = "", example = "4b20cec8-34f8-4ec7-ae4f-44a1428d04f5")
	private String domain;

	@Schema(description = "", example = "cbc9c9cd-b655-4999-a23c-4c9300768809")
	private String language;

	@Schema(description = "", example = "true")
	private Boolean active;


}
