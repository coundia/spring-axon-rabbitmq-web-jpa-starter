package com.groupe2cs.bizyhub.sync.application.dto;

import com.groupe2cs.bizyhub.sync.domain.valueObject.*;
import java.util.UUID;
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
@Schema(name = "SyncStateRequest", description = "Request payload for SyncState operations")
public class SyncStateRequest implements Serializable {

	@Schema(description = "", example = "b9546aee-9a52-4dfe-89b5-ec9da23439cd")
	private String entityTable;
	@Schema(description = "", example = "ad240ade-ee73-4cb4-b2b4-e2352cb401ad")
	private String remoteId;
	@Schema(description = "", example = "b61612d1-6d62-4038-bff0-b6370ac731f9")
	private String localId;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant lastSyncAt;
	@Schema(description = "", example = "afb4e06c-a484-44b7-b5f7-19546e4b7d1c")
	private String lastCursor;

}
