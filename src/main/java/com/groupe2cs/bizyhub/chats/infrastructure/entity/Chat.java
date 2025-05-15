package com.groupe2cs.bizyhub.chats.infrastructure.entity;

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
@Table(name = "chat")
public class Chat   extends AbstractAuditableEntity  {

	@Id
	private String id;


	@Column(nullable = false, 		columnDefinition = "Text",
		unique = false  ,
		length = 250
	)

	private String messages ;

	@Column(nullable = true, 		columnDefinition = "Text",
		unique = false  ,
		length = 250
	)

	private String responses ;

	@Column(nullable = true, 
		unique = false  ,
		length = 250
	)

	private String state ;
	@ManyToOne
	@JoinColumn(name = "account_id", nullable = true)
	private com.groupe2cs.bizyhub.accounts.infrastructure.entity.Account account;

	@Column(nullable = true, 
		unique = false  
	)
	@Builder.Default
	private java.time.Instant updatedAt  = java.time.Instant.now() ;

	@Column(nullable = true, 
		unique = false  
	)

	private String reference ;
	@ManyToOne
	@JoinColumn(name = "createdBy_id", nullable = true)
	private User createdBy;
	@ManyToOne
	@JoinColumn(name = "tenant_id", nullable = true)
	private Tenant tenant;
	public Chat(String id) {
		this.id = id;
	}

	@Override
 	public String toString() {
		return "Chat{" +
		"id='" + id + '\'' +
			", messages=" + messages +
			", responses=" + responses +
			", state=" + state +
			", account=" + account +
			", updatedAt=" + updatedAt +
			", reference=" + reference +
			", createdBy=" + createdBy +
			", tenant=" + tenant +
		'}';
	}
}
