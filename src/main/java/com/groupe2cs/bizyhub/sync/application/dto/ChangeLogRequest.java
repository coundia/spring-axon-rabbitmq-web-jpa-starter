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

	@Schema(description = "", example = "c8b7f4f8-b438-44f9-8625-220c3d0bf388")
	private String entityTable;
	@Schema(description = "", example = "2f4da547-a1d1-4594-bac5-35c5777d8328")
	private String account;
	@Schema(description = "", example = "35b59b0b-a6bf-466c-a8e3-01393f9b579c")
	private String remoteId;
	@Schema(description = "", example = "78c5b652-2bcb-4931-ace4-0172049a7649")
	private String localId;
	@Schema(description = "", example = "500294cc-f0fc-4592-95b4-36e6cc64258c")
	private String operation;
	@Schema(description = "", example = "1b8eac92-9ee5-4206-ae5d-d9f2ae9f3cab")
	private String payload;
	@Schema(description = "", example = "c83ad5b8-063e-410d-8648-2b6ac19d1b81")
	private String status;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "14")
	private Integer attempts;
	@Schema(description = "", example = "1e32da65-b392-43cc-a7ac-086872857e9b")
	private String error;

}
