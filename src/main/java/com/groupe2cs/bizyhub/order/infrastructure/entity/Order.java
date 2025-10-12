package com.groupe2cs.bizyhub.order.infrastructure.entity;

import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;

import java.time.*;
import java.util.*;

import com.groupe2cs.bizyhub.shared.infrastructure.audit.AbstractAuditableEntity;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.AuditListener;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EntityListeners(AuditListener.class)
@Table(name = "orders")
public class Order extends AbstractAuditableEntity {

	@Id
	private String id;


	@Column(nullable = true,
			unique = false

	)

	private String productId;

	@Column(nullable = true,
			unique = false

	)

	private String userId;

	@Column(nullable = true,
			unique = false

	)

	private String identifiant;

	@Column(nullable = true,
			unique = false

	)

	private String telephone;

	@Column(nullable = true,
			unique = false

	)

	private String mail;

	@Column(nullable = true,
			unique = false

	)

	private String ville;

	@Column(nullable = true,
			unique = false

	)

	private String remoteId;

	@Column(nullable = true,
			unique = false

	)

	private String localId;

	@Column(nullable = true,
			unique = false

	)

	private String status;

	@Column(nullable = true,
			unique = false

	)

	private String buyerName;

	@Column(nullable = true,
			unique = false

	)

	private String address;

	@Column(nullable = true,
			unique = false

	)

	private String notes;

	@Column(nullable = true,
			unique = false

	)

	private String message;

	@Column(nullable = true,
			unique = false

	)

	private String typeOrder;

	@Column(nullable = true,
			unique = false

	)

	private String paymentMethod;

	@Column(nullable = true,
			unique = false

	)

	private String deliveryMethod;

	@Column(nullable = true,
			unique = false

	)

	private Double amountCents;

	@Column(nullable = true,
			unique = false

	)

	private Integer quantity;

	@Column(nullable = true,
			unique = false

	)
	@Builder.Default
	private java.time.Instant dateCommand = java.time.Instant.now();
	@ManyToOne
	@JoinColumn(name = "createdBy_id", nullable = true)
	private User createdBy;
	@ManyToOne
	@JoinColumn(name = "tenant_id", nullable = true)
	private Tenant tenant;

	public Order(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Order{" +
				"id='" + id + '\'' +
				", productId=" + productId +
				", userId=" + userId +
				", identifiant=" + identifiant +
				", telephone=" + telephone +
				", mail=" + mail +
				", ville=" + ville +
				", remoteId=" + remoteId +
				", localId=" + localId +
				", status=" + status +
				", buyerName=" + buyerName +
				", address=" + address +
				", notes=" + notes +
				", message=" + message +
				", typeOrder=" + typeOrder +
				", paymentMethod=" + paymentMethod +
				", deliveryMethod=" + deliveryMethod +
				", amountCents=" + amountCents +
				", quantity=" + quantity +
				", dateCommand=" + dateCommand +
				", createdBy=" + createdBy +
				", tenant=" + tenant +
				'}';
	}
}
