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

	@Schema(description = "", example = "2a4af217-0f02-41f3-8ea5-dcbba1f03913")
	private String code;
	@Schema(description = "", example = "10e34a91-768d-49a5-bed4-4e8cc2d7c901")
	private String name;
	@Schema(description = "", example = "5db866e7-1e27-4c42-b628-5ddfc80492e3")
	private String remoteId;
	@Schema(description = "", example = "bce0ee61-adc7-45e3-80d8-fb0ccd83dccc")
	private String description;
	@Schema(description = "", example = "47a79473-6769-4d1c-a14e-3af54ca147b2")
	private String typeEntry;
	@Schema(description = "", example = "52")
	private Integer version;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;

}
