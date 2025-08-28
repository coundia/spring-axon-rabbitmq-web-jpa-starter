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

	@Schema(description = "", example = "84a89f92-55a1-4483-932f-44c9f2606ee0")
	private String name;
	@Schema(description = "", example = "3316cbd6-42c7-4262-a52d-4ad5e9cae154")
	private String description;
	@Schema(description = "", example = "0a1f7bdc-8bf5-4373-ba37-cf3aea70fc41")
	private String domain;
	@Schema(description = "", example = "0f1f1169-e248-4226-8aa8-74ee482f1011")
	private String language;
	@Schema(description = "", example = "false")
	private Boolean active;

}
