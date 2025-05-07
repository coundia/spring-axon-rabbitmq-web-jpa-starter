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

	@Schema(description = "", example = "69548c99-fcf1-4ca3-9adf-a3982634d143")
	private String name;

	@Schema(description = "", example = "f6e53aac-68de-46b9-8b81-60232320ec9a")
	private String description;

	@Schema(description = "", example = "090cdad0-6a13-4a49-92c6-024bb88e7421")
	private String domain;

	@Schema(description = "", example = "2e17255b-9ec9-4af2-9cbb-e2a60ba366fe")
	private String language;

	@Schema(description = "", example = "true")
	private Boolean active;


}
