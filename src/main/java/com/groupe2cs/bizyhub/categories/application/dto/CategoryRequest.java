package com.groupe2cs.bizyhub.categories.application.dto;

import com.groupe2cs.bizyhub.categories.domain.valueObject.*;
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
@Schema(name = "CategoryRequest", description = "Request payload for Category operations")
public class CategoryRequest implements Serializable {

	@Schema(description = "", example = "af61281c-b93c-48f8-baf5-c3b132eb29a9")
	private String code;
	@Schema(description = "", example = "c818332a-713b-4e6b-b2a1-811a17c63ae2")
	private String name;
	@Schema(description = "", example = "bf13d8f0-0f01-4cfb-b037-fb534c6f8c87")
	private String remoteId;
	@Schema(description = "", example = "833dbd7a-de99-4ad6-bbdb-06d669b2ee70")
	private String localId;
	@Schema(description = "", example = "d02e2bf6-bf06-4e6c-9483-58ae4d2e30ca")
	private String account;
	@Schema(description = "", example = "5af31bb1-345f-4162-bd5b-ae082333957f")
	private String description;
	@Schema(description = "", example = "3cace001-754a-4e8b-9aeb-492d150bf880")
	private String typeEntry;
	@Schema(description = "", example = "85")
	private Integer version;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;

}
