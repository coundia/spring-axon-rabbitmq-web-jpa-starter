package com.groupe2cs.bizyhub.categories.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "CategoryResponse", description = "Response payload for Category")
public class CategoryResponse implements Serializable {

	@Schema(description = "", example = "")
	private String id;
	@Schema(description = "", example = "")
	private String code;
	@Schema(description = "", example = "")
	private String name;
	@Schema(description = "", example = "")
	private String remoteId;
	@Schema(description = "", example = "")
	private String localId;
	@Schema(description = "", example = "")
	private String account;
	@Schema(description = "", example = "")
	private String status;
	@Schema(description = "", example = "")
	private Boolean isPublic;
	@Schema(description = "", example = "")
	private String description;
	@Schema(description = "", example = "")
	private String typeEntry;
	@Schema(description = "", example = "")
	private Integer version;
	@Schema(description = "", example = "")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "")
	private String createdBy;
	@Schema(description = "", example = "")
	private String tenant;

}
