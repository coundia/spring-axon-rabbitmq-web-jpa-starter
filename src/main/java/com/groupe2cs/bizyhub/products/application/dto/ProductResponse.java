package com.groupe2cs.bizyhub.products.application.dto;

import com.groupe2cs.bizyhub.products.domain.valueObject.*;
import com.groupe2cs.bizyhub.products.infrastructure.entity.*;
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
@Schema(name = "ProductResponse", description = "Response payload for Product")
public class ProductResponse implements Serializable {

	@Schema(description = "", example = "")
	private String id;
	@Schema(description = "", example = "")
	private String remoteId;
	@Schema(description = "", example = "")
	private String localId;
	@Schema(description = "", example = "")
	private String code;
	@Schema(description = "", example = "")
	private String name;
	@Schema(description = "", example = "")
	private String description;
	@Schema(description = "", example = "")
	private String status;
	@Schema(description = "", example = "")
	private Boolean isPublic;
	@Schema(description = "", example = "")
	private Boolean hasSold;
	@Schema(description = "", example = "")
	private Boolean hasPrice;
	@Schema(description = "", example = "")
	private String level;
	@Schema(description = "", example = "")
	private Integer quantity;
	@Schema(description = "", example = "")
	private String barcode;
	@Schema(description = "", example = "")
	private String company;
	@Schema(description = "", example = "")
	private String unit;
	@Schema(description = "", example = "")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "")
	private String category;
	@Schema(description = "", example = "")
	private String account;
	@Schema(description = "", example = "")
	private Double defaultPrice;
	@Schema(description = "", example = "")
	private String statuses;
	@Schema(description = "", example = "")
	private Double purchasePrice;
	@Schema(description = "", example = "")
	private String createdBy;
	@Schema(description = "", example = "")
	private String tenant;

}
