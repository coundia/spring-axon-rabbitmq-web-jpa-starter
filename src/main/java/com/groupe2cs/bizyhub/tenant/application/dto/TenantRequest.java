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

	@Schema(description = "", example = "baaf39be-3388-41ee-b5a9-7358b617715c")
	private String name;

	@Schema(description = "", example = "2cc4fd88-bea8-4053-bf83-35c8c58542a7")
	private String description;

	@Schema(description = "", example = "f57ee13f-0008-4160-b17c-a7594b09ca5c")
	private String domain;

	@Schema(description = "", example = "a970c02f-f8c2-45d8-8cf6-bc2ef944a2ed")
	private String language;

	@Schema(description = "", example = "true")
	private Boolean active;


}
