package com.groupe2cs.bizyhub.tenant.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "TenantRequest", description = "Request payload for Tenant operations")
public class TenantRequest implements Serializable {

	@Schema(description = "", example = "506d8459-7320-4db1-aa22-f1d0275cf758")
	private String name;

	@Schema(description = "", example = "693ed7c4-2b60-4cdf-aab0-fc50ea9e5226")
	private String description;

	@Schema(description = "", example = "6bbf7677-926a-4b26-80af-806cb0115514")
	private String domain;

	@Schema(description = "", example = "d830c501-0238-4187-af74-b17c709f3ddf")
	private String language;

	@Schema(description = "", example = "true")
	private Boolean active;


}
