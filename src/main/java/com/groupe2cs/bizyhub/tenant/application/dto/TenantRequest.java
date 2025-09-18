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

	@Schema(description = "", example = "406573e8-dc7c-4e27-baba-8c272f365b86")
	private String name;
	@Schema(description = "", example = "1bb3b5c2-0eaf-4324-9880-bae7b3849caa")
	private String description;
	@Schema(description = "", example = "9792d9bc-816c-4fe5-a51a-f3ae393f0d3b")
	private String domain;
	@Schema(description = "", example = "17df79a5-e371-4974-a06c-2d4aad0ebd33")
	private String language;
	@Schema(description = "", example = "false")
	private Boolean active;

}
