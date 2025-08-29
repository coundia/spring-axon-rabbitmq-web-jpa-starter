package com.groupe2cs.bizyhub.settings.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Schema(name = "SettingSyncRequest", description = "Request payload for synchronizing settings")
public class SettingSyncRequest implements Serializable {

	@Schema(description = "Batch of setting deltas")
	private List<SettingDeltaDto> deltas;
}

