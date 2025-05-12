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

	@Schema(description = "", example = "e93cc2fa-d4e7-412c-a992-67161ac84fd1")
	private String name;

	@Schema(description = "", example = "da709c07-fea5-4a23-b0f8-76aba4144f38")
	private String description;

	@Schema(description = "", example = "f8a7d279-b33e-4801-9a32-3491171d2f23")
	private String domain;

	@Schema(description = "", example = "93eeab37-bcd8-4cbb-a8fd-83ceba037909")
	private String language;

	@Schema(description = "", example = "true")
	private Boolean active;


}
