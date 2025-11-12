package com.groupe2cs.bizyhub.message.application.dto;

import com.groupe2cs.bizyhub.message.domain.valueObject.*;
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
@Schema(name = "MessageRequest", description = "Request payload for Message operations")
public class MessageRequest implements Serializable {

	@Schema(description = "", example = "872823cb-a429-4779-aef9-e4d6df4e67e1")
	private String code;
	@Schema(description = "", example = "ae84d8b6-70c8-4e47-b359-15722ae9c586")
	private String email;
	@Schema(description = "", example = "f593cf91-86e2-4f06-ba52-9e4b92e66b13")
	private String phone;
	@Schema(description = "", example = "52cb9d4e-bd55-4d21-8609-b55717b033f8")
	private String content;
	@Schema(description = "", example = "983d3804-c973-4770-9d14-887990360845")
	private String plateforme;
	@Schema(description = "", example = "781d9684-2710-4623-afaf-11251342d639")
	private String source;
	@Schema(description = "", example = "6c4f5cab-7f7c-4ea3-8b07-40a217d8231b")
	private String agent;
	@Schema(description = "", example = "b6db0118-ef4c-4825-8682-30265abcdb19")
	private String status;
	@Schema(description = "", example = "ff8c909e-5b6c-4fdd-9d42-976c69be8289")
	private String description;
	@Schema(description = "", example = "true")
	private Boolean isActive;
	@Schema(description = "", example = "false")
	private Boolean isDefault;
	@Schema(description = "", example = "04684b61-75e0-4fdd-a28b-28bca21306e2")
	private String remoteId;
	@Schema(description = "", example = "f3aad11d-34cf-4af0-9f98-b0ab28b70a53")
	private String localId;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant depotAt;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;

}
