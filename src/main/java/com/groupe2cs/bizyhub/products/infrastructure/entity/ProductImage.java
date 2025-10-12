package com.groupe2cs.bizyhub.products.infrastructure.entity;

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
@Table(name = "product_image")
public class ProductImage extends AbstractAuditableEntity {

	@Id
	private String id;

	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

	@Column(nullable = false)
	private String filename;

	@Column(nullable = false)
	private String contentType;

	@Column(nullable = false)
	private Long size;

	@Column(nullable = false)
	private String url;

	@ManyToOne
	@JoinColumn(name = "createdBy_id", nullable = true)
	private User createdBy;

	@ManyToOne
	@JoinColumn(name = "tenant_id", nullable = true)
	private Tenant tenant;
}
