package com.groupe2cs.bizyhub.fileManager.infrastructure.entity;

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
@Table(name = "file_managers")
public class FileManager extends AbstractAuditableEntity {

	@Id
	private String id;


	@Column(nullable = false,
			unique = false

	)

	private String name;

	@Column(nullable = true,
			unique = false

	)

	private String details;

	@Column(nullable = true,
			unique = false

	)

	private String objectId;

	@Column(nullable = true,
			unique = false

	)

	private String objectName;

	@Column(nullable = true,
			unique = false

	)

	private String originalName;

	@Column(nullable = true,
			unique = false

	)

	private String mimeType;

	@Column(nullable = true,
			unique = false

	)

	private Long size;

	@Column(nullable = true,
			unique = false

	)

	private String path;

	@Column(nullable = true,
			unique = false

	)

	private String uri;

	@Column(nullable = true,
			unique = false

	)

	private Boolean isPublic;
	@ManyToOne
	@JoinColumn(name = "createdBy_id", nullable = true)
	private User createdBy;
	@ManyToOne
	@JoinColumn(name = "tenant_id", nullable = true)
	private Tenant tenant;

	public FileManager(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "FileManager{" +
				"id='" + id + '\'' +
				", name=" + name +
				", details=" + details +
				", objectId=" + objectId +
				", objectName=" + objectName +
				", originalName=" + originalName +
				", mimeType=" + mimeType +
				", size=" + size +
				", path=" + path +
				", uri=" + uri +
				", isPublic=" + isPublic +
				", createdBy=" + createdBy +
				", tenant=" + tenant +
				'}';
	}
}
