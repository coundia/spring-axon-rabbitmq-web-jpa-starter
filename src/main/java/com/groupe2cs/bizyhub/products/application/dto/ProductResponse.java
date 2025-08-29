package com.groupe2cs.bizyhub.products.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

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
	private String barcode;
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
