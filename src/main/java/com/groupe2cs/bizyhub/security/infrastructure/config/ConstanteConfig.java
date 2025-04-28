package com.groupe2cs.bizyhub.security.infrastructure.config;

import java.util.Set;

public class ConstanteConfig {

	public static final String API_KEY_HEADER = "X-API-KEY";
	public static final String TENANT_HEADER = "X-TENANT-NAME";

	public static final String DEFAULT_TENANT = "system";

	public static final String ROLE_ADMIN = "ROLE_ADMIN";
	public static final String ROLE_USER = "ROLE_USER";
	public static final String ADMIN_USERNAME = "admin";
	public static final String USER_USERNAME = "user";
	public static final String PASSWORD_ADMIN = "admin";
	public static final String ADMIN = "admin";
	public static final String USER = "user";
	public static final String PASSWORD_USER = "user";

	public static final String IS_ADMIN = "IS_ADMIN";
	public static final String READ = "READ";
	public static final String WRITE = "WRITE";
	public static final String DELETE = "DELETE";
	public static final Set<String> DEFAULT_PERMISSIONS = Set.of(READ, WRITE, DELETE, IS_ADMIN);

}
