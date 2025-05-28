package com.groupe2cs.bizyhub.categories.infrastructure.entity;

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
@Table(name = "categories")
public class Category   extends AbstractAuditableEntity  {

	@Id
	private String id;


	@Column(nullable = false, 
		unique = false

	)

	private String name ;

	@Column(nullable = true, 
		unique = false

	)

	private String typeCategoryRaw ;

	@Column(nullable = true, 
		unique = false

	)

	private String details ;

	@Column(nullable = false, 
		unique = false

	)
	@Builder.Default
	private Boolean isActive  = true ;
	@ManyToOne
	@JoinColumn(name = "createdBy_id", nullable = true)
	private User createdBy;
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
			", typeCategoryRaw=" + typeCategoryRaw +
			", details=" + details +
			", isActive=" + isActive +
			", createdBy=" + createdBy +
			", tenant=" + tenant +
		'}';
	}
}
