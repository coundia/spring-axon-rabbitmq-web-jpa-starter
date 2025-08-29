package com.groupe2cs.bizyhub.sync.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "SyncStateRequest", description = "Request payload for SyncState operations")
public class SyncStateRequest implements Serializable {

	@Schema(description = "", example = "ac15f208-f8c2-445c-9dbb-e339932ddf71")
	private String entityTable;
	@Schema(description = "", example = "0e7d8e4e-c9fb-4ed9-9c38-aeda14033aae")
	private String remoteId;
	@Schema(description = "", example = "3127162a-3c2b-4950-8c54-13ee948ee777")
	private String localId;
	@Schema(description = "", example = "5d74c4ad-5d46-4cf8-8ae1-e6d9a718774e")
	private String account;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant lastSyncAt;
	@Schema(description = "", example = "32ab5c3e-c453-4def-8e03-adf5ea729c18")
	private String lastCursor;

}
