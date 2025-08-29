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

	@Schema(description = "", example = "90debcda-0641-43b1-bd1f-2f510edea1c1")
	private String name;
	@Schema(description = "", example = "defb49b9-3a22-4ffd-9d38-76110d8bf6d7")
	private String description;
	@Schema(description = "", example = "fb11eed9-6841-4a78-80d2-4ed314915e05")
	private String domain;
	@Schema(description = "", example = "dbf859bf-b573-440f-b935-974696346559")
	private String language;
	@Schema(description = "", example = "false")
	private Boolean active;

}
