package com.groupe2cs.bizyhub.categories.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Schema(name = "CategoryDeltaDto", description = "Delta DTO for category changes")
public class CategoryDeltaDto implements Serializable {

	@Schema(description = "Identifier of the category", example = "uuid")
	private String id;

	@Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
	private String type = "CREATE";

	@Schema(description = "", example = "593e061b-03a2-486a-9544-2ddc6942e86d")
	private String code;
	@Schema(description = "", example = "53aeb967-df3c-498a-b50b-82b532991e99")
	private String name;
	@Schema(description = "", example = "2b1ffd70-f4a8-426d-a98f-c7dc191c6b29")
	private String remoteId;
	@Schema(description = "", example = "0180481a-f0c2-4e19-af15-74b61182421f")
	private String localId;
	@Schema(description = "", example = "131398ef-9885-48ba-af79-456ee859b350")
	private String account;
	@Schema(description = "", example = "1770cf7e-8c1f-44b4-b555-4753a5770881")
	private String description;
	@Schema(description = "", example = "ba890ea9-e59b-456a-8ac3-3427a51c7754")
	private String typeEntry;
	@Schema(description = "", example = "94")
	private Integer version;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;

}
