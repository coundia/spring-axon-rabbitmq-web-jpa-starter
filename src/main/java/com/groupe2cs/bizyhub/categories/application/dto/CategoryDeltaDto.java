package com.groupe2cs.bizyhub.categories.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "CategoryDeltaDto", description = "Delta DTO for category changes")
public class CategoryDeltaDto implements Serializable {

	@Schema(description = "Identifier of the category", example = "uuid")
	private String id;

	@Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
	private String type = "CREATE";

	@Schema(description = "", example = "07fda110-10e2-4f50-bf78-2b1cf51f0a3b")
	private String name;
	@Schema(description = "", example = "0d56233f-b607-47c1-989a-b8caac446c4b")
	private String typeCategory;
	@Schema(description = "", example = "e0aee0f8-c24e-44e3-8971-5f9a425a4b19")
	private String parentId;
	@Schema(description = "", example = "true")
	private Boolean isDefault;
	@Schema(description = "", example = "96df127a-f3c7-4887-a996-d50be601faaa")
	private String icon;
	@Schema(description = "", example = "c7126f84-89f9-4a20-870f-5fbe8c0d40b7")
	private String colorHex;

}
