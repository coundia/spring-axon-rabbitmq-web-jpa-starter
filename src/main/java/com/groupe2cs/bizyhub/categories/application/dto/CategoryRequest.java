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

	@Schema(description = "", example = "108269ec-7820-4373-8342-ac4be57b142e")
	private String name;
	@Schema(description = "", example = "aa3b23f7-4d5a-40df-b4c8-73fe165bbd4b")
	private String typeCategoryRaw;
	@Schema(description = "", example = "0b75fd5d-6ff4-41e0-b5ff-656576639e86")
	private String details;
	@Schema(description = "", example = "false")
	private Boolean isActive;

}
