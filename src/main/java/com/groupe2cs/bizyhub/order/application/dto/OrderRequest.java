package com.groupe2cs.bizyhub.order.application.dto;

import com.groupe2cs.bizyhub.order.domain.valueObject.*;
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
@Schema(name = "OrderRequest", description = "Request payload for Order operations")
public class OrderRequest implements Serializable {

	@Schema(description = "", example = "cfb0f506-e995-4f43-be07-3def1fb0df8a")
	private String productId;
	@Schema(description = "", example = "3f7fd57c-b3f4-4a5d-8f33-bd213cf36819")
	private String userId;
	@Schema(description = "", example = "ba793c73-4335-43e6-be00-3b576be4cf32")
	private String identifiant;
	@Schema(description = "", example = "e2862ac5-0363-41ea-8b99-8acdc0dfb7fa")
	private String telephone;
	@Schema(description = "", example = "785a983e-b13c-4a4e-9be6-bdb4865589e0")
	private String mail;
	@Schema(description = "", example = "f96e1155-d513-4051-9d7e-b2f0e30c202a")
	private String ville;
	@Schema(description = "", example = "6a41b2e6-1b4b-4501-8fa8-df5443d67981")
	private String remoteId;
	@Schema(description = "", example = "42f091ce-7134-4291-97a9-c94e0da4d6bc")
	private String localId;
	@Schema(description = "", example = "0a86fd82-b562-483b-83ed-9b5fd48b264a")
	private String status;
	@Schema(description = "", example = "05fca301-ba64-4d69-ab24-e985aec4b1f9")
	private String buyerName;
	@Schema(description = "", example = "9fa2ec49-7e26-4952-a9d2-dc06e64a51e6")
	private String address;
	@Schema(description = "", example = "3339869c-97ff-430e-85ed-0519610baba8")
	private String notes;
	@Schema(description = "", example = "100b8fd4-a9aa-4913-bb8b-5e90f8c2c36e")
	private String message;
	@Schema(description = "", example = "2198edfa-da21-4f59-af62-e0c2c4509c3a")
	private String typeOrder;
	@Schema(description = "", example = "b1120b3d-038b-4b11-b1b9-b44269e4fe55")
	private String paymentMethod;
	@Schema(description = "", example = "4bc1ce7a-4174-4388-9bf0-5460703970c8")
	private String deliveryMethod;
	@Schema(description = "", example = "4748.41")
	private Double amountCents;
	@Schema(description = "", example = "21")
	private Integer quantity;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant dateCommand;

}
