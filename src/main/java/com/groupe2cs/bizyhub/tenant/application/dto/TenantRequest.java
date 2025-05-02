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

	@Schema(description = "", example = "e461d5d9-9542-4a75-b0c9-0e4bb6a3600c")
	private String name;

	@Schema(description = "", example = "c7b09cf2-49a9-4490-975b-c5c172d242d1")
	private String description;

	@Schema(description = "", example = "aa09a7db-56c4-445c-a654-8e2c61e91443")
	private String domain;

	@Schema(description = "", example = "7c3df4db-f721-43bb-9702-f363e31dbf9d")
	private String language;

	@Schema(description = "", example = "true")
	private Boolean active;


}
