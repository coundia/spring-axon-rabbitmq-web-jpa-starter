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

	@Schema(description = "", example = "ca919474-5041-4fcd-9377-6468cd97244d")
	private String name;
	@Schema(description = "", example = "205136b4-9af4-4ea4-b300-cee0215fe5fa")
	private String value;
	@Schema(description = "", example = "a438a5f8-97ce-4a90-964a-46ca33213bbf")
	private String locale;
	@Schema(description = "", example = "22f19acc-1680-4f91-ab6b-d833790b5db7")
	private String details;
	@Schema(description = "", example = "false")
	private Boolean isActive;

}
