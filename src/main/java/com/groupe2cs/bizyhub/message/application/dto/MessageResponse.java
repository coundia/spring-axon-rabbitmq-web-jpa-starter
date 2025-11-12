package com.groupe2cs.bizyhub.message.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "MessageResponse", description = "Response payload for Message")
public class MessageResponse implements Serializable {

	@Schema(description = "", example = "")
	private String id;
	@Schema(description = "", example = "")
	private String code;
	@Schema(description = "", example = "")
	private String email;
	@Schema(description = "", example = "")
	private String phone;
	@Schema(description = "", example = "")
	private String content;
	@Schema(description = "", example = "")
	private String plateforme;
	@Schema(description = "", example = "")
	private String source;
	@Schema(description = "", example = "")
	private String agent;
	@Schema(description = "", example = "")
	private String status;
	@Schema(description = "", example = "")
	private String description;
	@Schema(description = "", example = "")
	private Boolean isActive;
	@Schema(description = "", example = "")
	private Boolean isDefault;
	@Schema(description = "", example = "")
	private String remoteId;
	@Schema(description = "", example = "")
	private String localId;
	@Schema(description = "", example = "")
	private java.time.Instant depotAt;
	@Schema(description = "", example = "")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "")
	private String createdBy;
	@Schema(description = "", example = "")
	private String tenant;

}
