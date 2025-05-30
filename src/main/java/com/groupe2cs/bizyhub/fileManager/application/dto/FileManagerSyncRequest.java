package com.groupe2cs.bizyhub.fileManager.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.util.List;

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

