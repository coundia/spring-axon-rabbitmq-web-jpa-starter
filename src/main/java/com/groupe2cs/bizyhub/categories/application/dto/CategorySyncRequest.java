package com.groupe2cs.bizyhub.categories.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "CategorySyncRequest", description = "Request payload for synchronizing categorys")
public class CategorySyncRequest implements Serializable {

	@Schema(description = "Batch of category deltas")
	private List<CategoryDeltaDto> deltas;
}

