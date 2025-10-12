package com.groupe2cs.bizyhub.products.application.dto;

import com.groupe2cs.bizyhub.products.domain.valueObject.*;

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
@Schema(name = "ProductRequest", description = "Request payload for Product operations")
public class ProductRequest implements Serializable {

	@Schema(description = "", example = "c8c9e630-9a14-49fe-9eb5-7918dc81af49")
	private String remoteId;
	@Schema(description = "", example = "e00b2591-b1dd-483f-b5d4-a0de73cd129b")
	private String localId;
	@Schema(description = "", example = "749e1af5-b72f-476b-ac02-723793b85871")
	private String code;
	@Schema(description = "", example = "d21c06f2-ca8c-4750-854d-d49acf756097")
	private String name;
	@Schema(description = "", example = "4b952ace-4975-405d-8a82-522d5f53df0f")
	private String description;
	@Schema(description = "", example = "905b9381-8d25-414c-88e9-bda02e887617")
	private String status;
	@Schema(description = "", example = "true")
	private Boolean isPublic;
	@Schema(description = "", example = "false")
	private Boolean hasSold;
	@Schema(description = "", example = "false")
	private Boolean hasPrice;
	@Schema(description = "", example = "396f8583-b36e-4af8-97f1-8ca6b79ea0db")
	private String level;
	@Schema(description = "", example = "36")
	private Integer quantity;
	@Schema(description = "", example = "f475905c-9e7a-4bc6-b16b-0ecc1648265e")
	private String barcode;
	@Schema(description = "", example = "2739e91d-82b0-414a-875b-e76721dc040a")
	private String company;
	@Schema(description = "", example = "6bfff013-d84c-4c35-8034-cc6a1bd3eeea")
	private String unit;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "8350e8a8-262b-4984-a351-f8ac0e9aec78")
	private String category;
	@Schema(description = "", example = "e75ba3c1-bbf2-4855-9c59-24ee2eb58aef")
	private String account;
	@Schema(description = "", example = "5823.36")
	private Double defaultPrice;
	@Schema(description = "", example = "f1c8a8a8-c964-41f8-adb5-4307055ecfab")
	private String statuses;
	@Schema(description = "", example = "2843.67")
	private Double purchasePrice;

}
