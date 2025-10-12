package com.groupe2cs.bizyhub.sync.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "ChangeLogResponse", description = "Response payload for ChangeLog")
public class ChangeLogResponse implements Serializable {

	@Schema(description = "", example = "")
	private String id;
	@Schema(description = "", example = "")
	private String entityTable;
	@Schema(description = "", example = "")
	private String account;
	@Schema(description = "", example = "")
	private String remoteId;
	@Schema(description = "", example = "")
	private String localId;
	@Schema(description = "", example = "")
	private String operation;
	@Schema(description = "", example = "")
	private String payload;
	@Schema(description = "", example = "")
	private String status;
	@Schema(description = "", example = "")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "")
	private Integer attempts;
	@Schema(description = "", example = "")
	private String error;
	@Schema(description = "", example = "")
	private String createdBy;
	@Schema(description = "", example = "")
	private String tenant;

}
