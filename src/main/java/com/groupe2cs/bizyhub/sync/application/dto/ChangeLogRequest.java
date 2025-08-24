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

	@Schema(description = "", example = "4057aeba-767d-4889-91d6-52fd29432c1d")
	private String entityTable;
	@Schema(description = "", example = "1f2137c2-c3fd-4872-a2da-c28fc1c3a4be")
	private String entityId;
	@Schema(description = "", example = "1f0ad069-6011-421a-a068-515efeb47ea1")
	private String remoteId;
	@Schema(description = "", example = "32ffd09d-b448-4e3f-b25c-c92fae51ac93")
	private String localId;
	@Schema(description = "", example = "8d3b2637-fb62-4e36-9257-c0e3d31cafea")
	private String operation;
	@Schema(description = "", example = "506f77ac-dd12-492a-acf6-bf92f6e3faef")
	private String payload;
	@Schema(description = "", example = "606d4497-a368-42c1-8389-dc4e042b811a")
	private String status;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "39")
	private Integer attempts;
	@Schema(description = "", example = "ee7315a9-c787-44fc-9eaf-ad0c3c89a698")
	private String error;

}
