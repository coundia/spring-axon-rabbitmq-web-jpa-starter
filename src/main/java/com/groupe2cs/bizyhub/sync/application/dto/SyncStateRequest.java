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

	@Schema(description = "", example = "22beef5d-efee-4ea1-be76-ac7ac509f96d")
	private String entityTable;
	@Schema(description = "", example = "28e7af78-45cc-428f-b77a-32f09932e326")
	private String remoteId;
	@Schema(description = "", example = "eed5f92a-8f16-4b31-b227-66f3958d0ab2")
	private String localId;
	@Schema(description = "", example = "b83a0d58-8691-4cb0-b1f4-6cfb96edf96a")
	private String account;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant lastSyncAt;
	@Schema(description = "", example = "66442137-1f3d-4777-8bec-51832b0f5d07")
	private String lastCursor;

}
