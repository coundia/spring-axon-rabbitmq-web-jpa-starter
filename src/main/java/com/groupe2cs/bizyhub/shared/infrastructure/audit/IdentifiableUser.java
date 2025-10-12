package com.groupe2cs.bizyhub.shared.infrastructure.audit;

public interface IdentifiableUser {

	String getUsername();

	public String getId();

	public String getTenantId();

}
