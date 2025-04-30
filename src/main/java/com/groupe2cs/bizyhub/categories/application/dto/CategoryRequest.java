package com.groupe2cs.bizyhub.categories.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "CategoryRequest", description = "Request payload for Category operations")
public class CategoryRequest implements Serializable {

	@Schema(description = "", example = "47cade8f-8d1a-4cb4-9adc-1c0a9ab24d3b")
	private String name;

	@Schema(description = "", example = "49252d09-e2f2-40c9-9e31-c0e3b3364ee4")
	private String typeCategory;

	@Schema(description = "", example = "c2c9cfc6-f58b-4d13-a963-a3f265e614a2")
	private String parentId;

	@Schema(description = "", example = "true")
	private Boolean isDefault;

	@Schema(description = "", example = "8cb30710-1831-45be-b550-3c1954458606")
	private String icon;

	@Schema(description = "", example = "16a322fc-5780-4a4d-b665-b0f80821e9e0")
	private String colorHex;


}
