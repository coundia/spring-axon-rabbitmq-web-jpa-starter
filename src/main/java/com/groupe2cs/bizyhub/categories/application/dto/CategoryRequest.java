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

	@Schema(description = "", example = "5bb2fb14-5ec4-41f1-b799-89275900ce2f")
	private String code;
	@Schema(description = "", example = "765c6194-a42e-441f-877c-63be0aad5cd7")
	private String name;
	@Schema(description = "", example = "cb5bfb31-d759-4b4c-a6e7-303ca140ae1a")
	private String remoteId;
	@Schema(description = "", example = "0c019553-5213-48fa-8660-1c212f391170")
	private String description;
	@Schema(description = "", example = "59c8ba0c-1383-4e8d-a0dd-914be2a34b0b")
	private String typeEntry;
	@Schema(description = "", example = "50")
	private Integer version;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;

}
