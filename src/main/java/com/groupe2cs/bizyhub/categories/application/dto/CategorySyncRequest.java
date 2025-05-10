package com.groupe2cs.bizyhub.categories.application.dto;

import java.util.List;
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
@Schema(name = "CategorySyncRequest", description = "Request payload for synchronizing categorys")
public class CategorySyncRequest implements Serializable {

@Schema(description = "Batch of category deltas")
private List<CategoryDeltaDto> deltas;
	}

