package com.groupe2cs.bizyhub.settings.application.dto;

import com.groupe2cs.bizyhub.settings.domain.valueObject.*;
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
@Schema(name = "SettingRequest", description = "Request payload for Setting operations")
public class SettingRequest implements Serializable {

	@Schema(description = "", example = "e65b8232-a962-4e8b-b19a-6f8ecc23cd3d")
	private String name;
	@Schema(description = "", example = "e8b689b7-7d7b-4c9d-a7fa-f86c1c97856a")
	private String value;
	@Schema(description = "", example = "c94420ee-e625-4814-92f9-a9ed50f1d57e")
	private String locale;
	@Schema(description = "", example = "0074cb61-fab4-4614-8226-7f44ad390bc4")
	private String remoteId;
	@Schema(description = "", example = "55dfe636-a956-4585-baf3-d8b72c72d93d")
	private String localId;
	@Schema(description = "", example = "239983ad-cc0d-4c5b-808d-1395c25d5b37")
	private String account;
	@Schema(description = "", example = "5b6abdd2-6689-4f14-a13f-6608eec82118")
	private String details;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "false")
	private Boolean isActive;

}
