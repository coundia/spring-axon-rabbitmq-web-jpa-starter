package com.groupe2cs.bizyhub.categories.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "CategoryResponse", description = "Response payload for Category")
public class CategoryResponse implements Serializable {

	@Schema(description = "", example = "")
	private String id;
	@Schema(description = "", example = "")
	private String name;
	@Schema(description = "", example = "")
	private String typeCategoryRaw;
	@Schema(description = "", example = "")
	private String details;
	@Schema(description = "", example = "")
	private Boolean isActive;
	@Schema(description = "", example = "")
	private java.time.Instant updatedAt;
	@Schema(description = "", example = "")
	private String reference;

}
