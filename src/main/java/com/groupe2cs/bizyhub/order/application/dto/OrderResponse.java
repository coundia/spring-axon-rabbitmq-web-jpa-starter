package com.groupe2cs.bizyhub.order.application.dto;

import com.groupe2cs.bizyhub.order.domain.valueObject.*;
import com.groupe2cs.bizyhub.order.infrastructure.entity.*;
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
@Schema(name = "OrderResponse", description = "Response payload for Order")
public class OrderResponse implements Serializable {

	@Schema(description = "", example = "")
	private String id;
	@Schema(description = "", example = "")
	private String productId;
	@Schema(description = "", example = "")
	private String userId;
	@Schema(description = "", example = "")
	private String identifiant;
	@Schema(description = "", example = "")
	private String telephone;
	@Schema(description = "", example = "")
	private String mail;
	@Schema(description = "", example = "")
	private String ville;
	@Schema(description = "", example = "")
	private String remoteId;
	@Schema(description = "", example = "")
	private String localId;
	@Schema(description = "", example = "")
	private String status;
	@Schema(description = "", example = "")
	private String buyerName;
	@Schema(description = "", example = "")
	private String address;
	@Schema(description = "", example = "")
	private String notes;
	@Schema(description = "", example = "")
	private String message;
	@Schema(description = "", example = "")
	private String typeOrder;
	@Schema(description = "", example = "")
	private String paymentMethod;
	@Schema(description = "", example = "")
	private String deliveryMethod;
	@Schema(description = "", example = "")
	private Double amountCents;
	@Schema(description = "", example = "")
	private Integer quantity;
	@Schema(description = "", example = "")
	private java.time.Instant dateCommand;
	@Schema(description = "", example = "")
	private String createdBy;
	@Schema(description = "", example = "")
	private String tenant;

}
