package com.groupe2cs.bizyhub.products.application.dto;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import lombok.ToString;
import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Schema(name = "ProductDeltaDto", description = "Delta DTO for product changes")
public class ProductDeltaDto implements Serializable {

	@Schema(description = "Identifier of the product", example = "uuid")
	private String id;

	@Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
	private String type = "CREATE";

	@Schema(description = "", example = "d021fa3a-8a89-449a-a3e2-e05b88ca104a")
	private String remoteId;
	@Schema(description = "", example = "b2478295-df78-46a2-bb38-a6e4e003d542")
	private String localId;
	@Schema(description = "", example = "35df3f95-dc8f-4f07-8dad-532686b96073")
	private String code;
	@Schema(description = "", example = "8edbd483-82c5-42f2-88e9-e67df17305fd")
	private String name;
	@Schema(description = "", example = "a2dfbb82-7a1b-4cc2-af8a-0d39c6e1e427")
	private String description;
	@Schema(description = "", example = "cda1ead2-b0a4-44ad-b023-b97931c9bdee")
	private String status;
	@Schema(description = "", example = "false")
	private Boolean isPublic;
	@Schema(description = "", example = "true")
	private Boolean hasSold;
	@Schema(description = "", example = "true")
	private Boolean hasPrice;
	@Schema(description = "", example = "f44ac59a-9d14-44cd-b130-5e28f898fcfc")
	private String level;
	@Schema(description = "", example = "69")
	private Integer quantity;
	@Schema(description = "", example = "af5437e0-c351-4353-b914-093644578f9c")
	private String barcode;
	@Schema(description = "", example = "f72cd590-a380-4aef-936f-cb4fc743f506")
	private String company;
	@Schema(description = "", example = "9bc67166-4182-4765-a0b6-7cce7c7a5e41")
	private String unit;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "4fdf7490-2072-46a7-9016-3b0b029357df")
	private String category;
	@Schema(description = "", example = "f896f3ed-da2e-4235-9353-6750f55d1872")
	private String account;
	@Schema(description = "", example = "7090.55")
	private Double defaultPrice;
	@Schema(description = "", example = "e2a7aa3d-eda0-4aca-a078-366f05d6a8bd")
	private String statuses;
	@Schema(description = "", example = "4400.43")
	private Double purchasePrice;

}
