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

	@Schema(description = "", example = "fb20c5c7-8d8b-405c-9e8c-daa3b3418647")
	private String name;
	@Schema(description = "", example = "c5af7310-8cf8-4b9d-b01e-db53695a4dd6")
	private String value;
	@Schema(description = "", example = "f024ef5f-94e9-4c7f-8e31-1057a27e3565")
	private String locale;
	@Schema(description = "", example = "b786044a-926b-41e3-a42c-86198594683e")
	private String details;
	@Schema(description = "", example = "false")
	private Boolean isActive;

}
