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

	@Schema(description = "", example = "a136a968-d9db-4905-9ed9-79c3a603dff9")
	private String name;
	@Schema(description = "", example = "d136ce28-bcee-4f46-94c8-c463681f94be")
	private String description;
	@Schema(description = "", example = "4f8ed20c-caba-46d9-9447-ede6b5eac638")
	private String domain;
	@Schema(description = "", example = "fcf439b7-a4ec-40ea-9e28-64ad5895fd58")
	private String language;
	@Schema(description = "", example = "true")
	private Boolean active;

}
