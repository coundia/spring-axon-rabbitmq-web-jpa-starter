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

	@Schema(description = "", example = "8f94ab85-7c1a-4651-9d1c-18e73e431889")
	private String entityTable;
	@Schema(description = "", example = "9414b9ee-26bc-425d-b0e0-4e71fe7deb9f")
	private String entityId;
	@Schema(description = "", example = "87af26e1-ea21-4f4d-b571-1604c96ab2fa")
	private String remoteId;
	@Schema(description = "", example = "efd03449-9d74-4c32-a924-c4883f9eeb28")
	private String operation;
	@Schema(description = "", example = "5bf91029-880e-4995-89ef-f217639f0bb1")
	private String payload;
	@Schema(description = "", example = "6ce3804b-c6fd-4f47-ba76-b2770a52cbb3")
	private String status;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "90")
	private Integer attempts;
	@Schema(description = "", example = "e127dfdb-bdd4-4d04-b0c6-224a560dd2a8")
	private String error;

}
