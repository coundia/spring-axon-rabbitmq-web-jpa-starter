package com.groupe2cs.bizyhub.accounts.infrastructure.entity;

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
@Table(name = "account_users")
public class AccountUser   extends AbstractAuditableEntity  {

	@Id
	private String id;


	@Column(nullable = true, 
		unique = false

	)

	private String account ;

	@Column(nullable = true, 
		unique = false

	)

	private String user ;

	@Column(nullable = true, 
		unique = false

	)

	private String phone ;

	@Column(nullable = true, 
		unique = false

	)

	private String role ;

	@Column(nullable = true, 
		unique = false

	)

	private String status ;

	@Column(nullable = true, 
		unique = false

	)

	private String invitedBy ;

	@Column(nullable = true, 
		unique = false

	)
	@Builder.Default
	private java.time.Instant syncAt  = java.time.Instant.now() ;

	@Column(nullable = true, 
		unique = false

	)

	private java.time.Instant acceptedAt ;

	@Column(nullable = true, 
		unique = false

	)

	private java.time.Instant revokedAt ;

	@Column(nullable = true, 		columnDefinition = "Text",
		unique = false

	)

	private String message ;

	@Column(nullable = true, 
		unique = false

	)

	private String remoteId ;

	@Column(nullable = true, 
		unique = false

	)

	private String localId ;

	@Column(nullable = true, 
		unique = false

	)

	private Boolean isActive ;
	@ManyToOne
	@JoinColumn(name = "createdBy_id", nullable = true)
	private User createdBy;
	@ManyToOne
	@JoinColumn(name = "tenant_id", nullable = true)
	private Tenant tenant;
	public AccountUser(String id) {
		this.id = id;
	}

	@Override
 	public String toString() {
		return "AccountUser{" +
		"id='" + id + '\'' +
			", account=" + account +
			", user=" + user +
			", phone=" + phone +
			", role=" + role +
			", status=" + status +
			", invitedBy=" + invitedBy +
			", syncAt=" + syncAt +
			", acceptedAt=" + acceptedAt +
			", revokedAt=" + revokedAt +
			", message=" + message +
			", remoteId=" + remoteId +
			", localId=" + localId +
			", isActive=" + isActive +
			", createdBy=" + createdBy +
			", tenant=" + tenant +
		'}';
	}
}
