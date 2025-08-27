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

	@Schema(description = "", example = "33a81d51-c860-4e37-bd58-e489b4c9dd2f")
	private String entityTable;
	@Schema(description = "", example = "0efccf0b-0d8c-4d02-85b1-73ffd8e2993d")
	private String entityId;
	@Schema(description = "", example = "b91b3af6-a863-436a-9108-f9bdbe606a40")
	private String remoteId;
	@Schema(description = "", example = "09618725-0b3b-4f5a-960d-1ac2453558a4")
	private String localId;
	@Schema(description = "", example = "35a67df1-cba7-41cf-8c2a-c2d5d4a3d8fa")
	private String operation;
	@Schema(description = "", example = "bfc27025-24cf-48ed-91a8-998ebda59341")
	private String payload;
	@Schema(description = "", example = "8a5c8287-0172-430f-b55f-c4c3c1f514b9")
	private String status;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "70")
	private Integer attempts;
	@Schema(description = "", example = "1bf0c3fb-ac08-4423-971e-537bcacdcef3")
	private String error;

}
