package com.groupe2cs.bizyhub.settings.application.dto;

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
@Schema(name = "SettingSyncRequest", description = "Request payload for synchronizing settings")
public class SettingSyncRequest implements Serializable {

@Schema(description = "Batch of setting deltas")
private List<SettingDeltaDto> deltas;
	}

