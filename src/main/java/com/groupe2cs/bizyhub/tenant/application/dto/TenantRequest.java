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

	@Schema(description = "", example = "4d12d517-3cef-4834-ba92-5ce8d8041c72")
	private String name;
	@Schema(description = "", example = "c445c6bd-89c8-4914-9d24-c502bda53241")
	private String description;
	@Schema(description = "", example = "bfb99e6d-1e52-4d38-b639-35a6183fd5c0")
	private String domain;
	@Schema(description = "", example = "a4bb2a08-2ad9-4471-866d-d86549d12f84")
	private String language;
	@Schema(description = "", example = "false")
	private Boolean active;

}
