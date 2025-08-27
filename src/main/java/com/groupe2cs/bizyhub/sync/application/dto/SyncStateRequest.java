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

	@Schema(description = "", example = "06ef4566-9306-415d-af07-a8718cc71ddc")
	private String entityTable;
	@Schema(description = "", example = "fac4b4c2-ac7b-468f-9b1c-a49566c2250d")
	private String remoteId;
	@Schema(description = "", example = "871e9e28-700d-421e-b714-147478abf599")
	private String localId;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant lastSyncAt;
	@Schema(description = "", example = "ef6da4d6-59c3-4538-a72a-d9cc57c094c4")
	private String lastCursor;

}
