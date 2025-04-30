package com.groupe2cs.bizyhub.categories.infrastructure.entity;

import com.groupe2cs.bizyhub.security.infrastructure.entity.CustomUser;
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
@Table(name = "categories")
public class Category extends AbstractAuditableEntity {

	@Id
	private String id;


	@Column(nullable = false,
			unique = false,
			length = 250
	)

	private String name;

	@Column(nullable = true,
			unique = false,
			length = 250
	)

	private String typeCategory;

	@Column(nullable = true,
			unique = false,
			length = 250
	)

	private String parentId;

	@Column(nullable = false,
			unique = false,
			length = 250
	)
	@Builder.Default
	private Boolean isDefault = false;

	@Column(nullable = true,
			unique = false,
			length = 250
	)
	@Builder.Default
	private String icon = "questionmark";

	@Column(nullable = true,
			unique = false,
			length = 250
	)
	@Builder.Default
	private String colorHex = "#FFFFFF";
	@ManyToOne
	@JoinColumn(name = "createdBy_id", nullable = true)
	private CustomUser createdBy;
	@ManyToOne
	@JoinColumn(name = "tenant_id", nullable = true)
	private Tenant tenant;

	public Category(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Category{" +
				"id='" + id + '\'' +
				", name=" + name +
				", typeCategory=" + typeCategory +
				", parentId=" + parentId +
				", isDefault=" + isDefault +
				", icon=" + icon +
				", colorHex=" + colorHex +
				", createdBy=" + createdBy +
				", tenant=" + tenant +
				'}';
	}
}
