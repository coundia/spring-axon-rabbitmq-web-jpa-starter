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
@Schema(name = "ChangeLogRequest", description = "Request payload for ChangeLog operations")
public class ChangeLogRequest implements Serializable {

	@Schema(description = "", example = "c7e8d560-dddb-4100-b2b7-4028ac221d31")
	private String entityTable;
	@Schema(description = "", example = "da621e9e-ba1c-4a49-9deb-10182532fbda")
	private String entityId;
	@Schema(description = "", example = "c3c975b2-3a88-4125-b815-9fa68999a1b1")
	private String remoteId;
	@Schema(description = "", example = "8badfe81-70a1-4b6f-9912-cea0e34884d9")
	private String localId;
	@Schema(description = "", example = "5e098395-7783-4d4c-a6ee-47dcdbf23aa3")
	private String operation;
	@Schema(description = "", example = "1c4a41a2-4e79-44ca-b4c5-4c054ff9e98c")
	private String payload;
	@Schema(description = "", example = "1a4e3e29-7fc9-41af-8acf-80bea45517a4")
	private String status;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "73")
	private Integer attempts;
	@Schema(description = "", example = "7b0ca13b-6685-4d1b-909f-bb01a8733537")
	private String error;

}
