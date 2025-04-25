package com.groupe2cs.bizyhub.security.application.query;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FindAllPermissionQuery {

private final int page;
private final int limit;

}
