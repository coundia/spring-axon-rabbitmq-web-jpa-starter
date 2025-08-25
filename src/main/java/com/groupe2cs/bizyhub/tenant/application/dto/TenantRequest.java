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

	@Schema(description = "", example = "26eecd3f-c5f5-4d7d-8b28-6d71ce3353f2")
	private String name;
	@Schema(description = "", example = "6b7f2022-c771-41e5-9a42-cac2e5de9292")
	private String description;
	@Schema(description = "", example = "97d72410-2cc2-4c54-a074-46db2c4616fd")
	private String domain;
	@Schema(description = "", example = "10ec7016-9dc6-46a7-bf0d-0e7eb5985f35")
	private String language;
	@Schema(description = "", example = "true")
	private Boolean active;

}
