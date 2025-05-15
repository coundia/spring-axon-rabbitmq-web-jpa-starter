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

	@Schema(description = "", example = "a045105c-72d7-4500-97c1-a18c37a16166")
	private String name;

	@Schema(description = "", example = "ea8472a3-2f67-4a62-bc83-a829d1e5db18")
	private String description;

	@Schema(description = "", example = "1a93187a-4c54-4ee7-b236-3079351234c9")
	private String domain;

	@Schema(description = "", example = "6e5524b9-14f8-4da7-aee9-659ab8607cce")
	private String language;

	@Schema(description = "", example = "false")
	private Boolean active;


}
