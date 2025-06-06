package com.groupe2cs.bizyhub.shared.application.dto;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MetaRequest implements Serializable {
	private String userId;
	private String tenantId;
	private String tenantName;
	private String apiKey;
	private String domain;
	private String appName;
	private String ip;
	private String version;
	private String platform;
	private Boolean isAdmin;
	private String objectId;
	private String objectName;
	private Boolean isPublic = false;

	public Boolean isAdmin() {
		return this.isAdmin != null && this.isAdmin;
	}

	public Boolean getIsPublic() {
		if (isPublic == null) {
			return false;
		}
		return isPublic;
	}

}
