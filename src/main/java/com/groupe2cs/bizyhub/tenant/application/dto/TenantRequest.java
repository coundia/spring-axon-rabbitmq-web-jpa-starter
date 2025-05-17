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

	@Schema(description = "", example = "46cac62a-f8ef-4b36-a523-a81b1f5238f6")
	private String name;

	@Schema(description = "", example = "667cbec2-7ae1-49db-b2cd-727055a9e990")
	private String description;

	@Schema(description = "", example = "778c6e96-c7a8-4e52-aade-656d20a70a82")
	private String domain;

	@Schema(description = "", example = "7b330ebd-a05b-457a-bea6-50c8850ccc09")
	private String language;

	@Schema(description = "", example = "true")
	private Boolean active;


}
