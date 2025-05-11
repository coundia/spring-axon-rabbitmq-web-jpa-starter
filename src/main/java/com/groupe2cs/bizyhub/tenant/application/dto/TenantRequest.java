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

	@Schema(description = "", example = "5078878e-c216-4641-891a-76bba5877fa3")
	private String name;

	@Schema(description = "", example = "821e2cfc-1796-4ca6-84b0-405edd1b86f9")
	private String description;

	@Schema(description = "", example = "2fb744b5-b70d-40ed-b996-8e096258e1c3")
	private String domain;

	@Schema(description = "", example = "b57b562e-5f86-4c59-81fd-14c325bbe152")
	private String language;

	@Schema(description = "", example = "true")
	private Boolean active;


}
