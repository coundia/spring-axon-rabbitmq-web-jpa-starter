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

	@Schema(description = "", example = "5b3150b2-6af3-4f96-98c4-58c7bee42425")
	private String name;
	@Schema(description = "", example = "fcc2811e-04c8-475e-9243-9bef667e56bf")
	private String description;
	@Schema(description = "", example = "0f038412-6101-4926-ad51-ca04c6b26e75")
	private String domain;
	@Schema(description = "", example = "2bb21339-e247-47be-bb89-a2c6d96c84ae")
	private String language;
	@Schema(description = "", example = "true")
	private Boolean active;

}
