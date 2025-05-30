package com.groupe2cs.bizyhub.shared.infrastructure.audit;

public interface IdentifiableUser {

	String getUsername();

	String getId();

	String getTenantId();

}
