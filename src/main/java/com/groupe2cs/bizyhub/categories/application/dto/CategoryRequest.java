package com.groupe2cs.bizyhub.categories.application.dto;

import com.groupe2cs.bizyhub.categories.domain.valueObject.*;
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
@Schema(name = "CategoryRequest", description = "Request payload for Category operations")
public class CategoryRequest implements Serializable {

	@Schema(description = "", example = "5c817514-15f7-4739-be4e-36cf9c673808")
	private String code;
	@Schema(description = "", example = "450f2a6d-0818-4a45-8963-e9e797e6abce")
	private String name;
	@Schema(description = "", example = "d512c29d-cafb-41ab-bfde-6386c1cc6b8f")
	private String remoteId;
	@Schema(description = "", example = "562178f8-7cda-4993-bda1-67bdc28c3d72")
	private String localId;
	@Schema(description = "", example = "b6263e31-2c02-4f6c-aa58-87192ece0c93")
	private String account;
	@Schema(description = "", example = "aa803dcc-9e29-4a5a-b56f-39a37b63d9ad")
	private String description;
	@Schema(description = "", example = "86e86bdc-05d6-4508-a052-8d9ebdca16da")
	private String typeEntry;
	@Schema(description = "", example = "9")
	private Integer version;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;

}
