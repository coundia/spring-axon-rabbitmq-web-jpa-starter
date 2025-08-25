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

	@Schema(description = "", example = "b9585a1e-b816-4eed-8fc4-59a5f8592126")
	private String name;
	@Schema(description = "", example = "0d61facb-5bff-40a7-a3bd-61c7107f46eb")
	private String value;
	@Schema(description = "", example = "fe2785ed-2b36-474e-87b4-ea71011e5b4f")
	private String locale;
	@Schema(description = "", example = "2bb0fb30-3931-484f-83c3-6f3271246936")
	private String remoteId;
	@Schema(description = "", example = "91b87aea-eeeb-4706-9a07-75d4dc06af27")
	private String localId;
	@Schema(description = "", example = "cf77ad47-6d0c-4a2b-a079-32a9d1d43466")
	private String details;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "false")
	private Boolean isActive;

}
