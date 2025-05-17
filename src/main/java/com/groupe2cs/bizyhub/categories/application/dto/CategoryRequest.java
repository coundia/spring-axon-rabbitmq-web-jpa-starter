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

	@Schema(description = "", example = "478d3420-2bdd-4d8e-a216-547f863641e6")
	private String name;

	@Schema(description = "", example = "886537d5-5339-43fc-a3e4-3346b57c107b")
	private String typeCategoryRaw;

	@Schema(description = "", example = "131836d6-da92-465e-b63c-546926b1a2c6")
	private String details;

	@Schema(description = "", example = "true")
	private Boolean isActive;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "ed963c19-4d91-4700-8559-62732d20b8a2")
	private String reference;


}
