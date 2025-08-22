package com.groupe2cs.bizyhub.fileManager.application.dto;

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
@Schema(name = "FileManagerSyncRequest", description = "Request payload for synchronizing fileManagers")
public class FileManagerSyncRequest implements Serializable {

@Schema(description = "Batch of fileManager deltas")
private List<FileManagerDeltaDto> deltas;
	}

