package com.groupe2cs.bizyhub.shared.application.dto;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MetaRequest implements Serializable {
	private String createdBy;
	private String tenantId;
	private String apiKey;
	private String domain;
	private String appName;
	private String ip;
	private String version;
	private String platform;

}
