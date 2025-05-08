package com.groupe2cs.bizyhub.accounts.application.dto;

import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
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
@Schema(name = "AccountUserRequest", description = "Request payload for AccountUser operations")
public class AccountUserRequest implements Serializable {

	@Schema(description = "", example = "d139bfa6-1291-40c9-aada-229fcdc21f9d")
	private String name;

	@Schema(description = "", example = "b4293378-2247-4743-8fc0-e866b13bef4a")
	private String account;

	@Schema(description = "", example = "06cefd70-8195-4aeb-82e4-2e49e2f2a076")
	private String user;

	@Schema(description = "", example = "fc2d960c-58c9-424a-8496-f5f129ee41ce")
	private String username;

	@Schema(description = "", example = "40c97e86-1856-49eb-9d47-cae4bf7d80f4")
	private String details;

	@Schema(description = "", example = "true")
	private Boolean isActive;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "9d0dfe30-684d-42f5-bc8d-7d8a016b1de4")
	private String reference;


}
