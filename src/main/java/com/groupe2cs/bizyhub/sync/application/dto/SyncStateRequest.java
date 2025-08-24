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

	@Schema(description = "", example = "a3038c85-2a23-4c0e-b122-90f63f332e2a")
	private String entityTable;
	@Schema(description = "", example = "aa18dca5-207a-4fef-9d42-f3bb51e2e0d3")
	private String remoteId;
	@Schema(description = "", example = "6f0575d2-2d27-4cc7-94d3-243350d382dd")
	private String localId;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant lastSyncAt;
	@Schema(description = "", example = "a349b59f-28b3-482c-a493-027bbfe6de1f")
	private String lastCursor;

}
