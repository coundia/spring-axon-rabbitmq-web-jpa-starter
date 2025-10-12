package com.groupe2cs.bizyhub.stock.infrastructure.entity;

import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.AbstractAuditableEntity;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.AuditListener;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EntityListeners(AuditListener.class)
@Table(name = "stock_level")
public class StockLevel extends AbstractAuditableEntity {

	@Id
	private String id;


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

	private Integer stockOnHand;

	@Column(nullable = true,
			unique = false

	)

	private Integer stockAllocated;

	@Column(nullable = true,
			unique = false

	)

	private String account;

	@Column(nullable = true,
			unique = false

	)

	private String productVariant;

	@Column(nullable = true,
			unique = false

	)
	@Builder.Default
	private java.time.Instant syncAt = java.time.Instant.now();

	@Column(nullable = true,
			unique = false

	)

	private String company;
	@ManyToOne
	@JoinColumn(name = "createdBy_id", nullable = true)
	private User createdBy;
	@ManyToOne
	@JoinColumn(name = "tenant_id", nullable = true)
	private Tenant tenant;

	public StockLevel(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "StockLevel{" +
				"id='" + id + '\'' +
				", remoteId=" + remoteId +
				", localId=" + localId +
				", stockOnHand=" + stockOnHand +
				", stockAllocated=" + stockAllocated +
				", account=" + account +
				", productVariant=" + productVariant +
				", syncAt=" + syncAt +
				", company=" + company +
				", createdBy=" + createdBy +
				", tenant=" + tenant +
				'}';
	}
}
