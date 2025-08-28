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

	@Schema(description = "", example = "12d01e5b-e4bb-4baa-a87c-438eaa5ae110")
	private String name;
	@Schema(description = "", example = "e6505f8f-2adc-459d-ab33-87d5a979ffed")
	private String value;
	@Schema(description = "", example = "6298bf47-2972-4a93-8503-f45664423a9c")
	private String locale;
	@Schema(description = "", example = "e76df59a-aaf0-45f6-8764-f01e50618136")
	private String remoteId;
	@Schema(description = "", example = "85ea4e53-35e2-444a-b4d6-af61ddff60c5")
	private String localId;
	@Schema(description = "", example = "ae51486f-6636-4a19-a338-f5c6abe7a1da")
	private String account;
	@Schema(description = "", example = "63340f43-df50-4d24-9c8f-b7a1924db945")
	private String details;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "true")
	private Boolean isActive;

}
