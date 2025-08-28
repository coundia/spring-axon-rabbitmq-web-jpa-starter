package com.groupe2cs.bizyhub.sync.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.sync.domain.exception.SyncStateIdNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.SyncStateEntityTableNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.SyncStateRemoteIdNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.SyncStateLocalIdNotValid;
import com.groupe2cs.bizyhub.sync.domain.exception.SyncStateAccountNotValid;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class SyncStateAccount implements Serializable {

private String account;

public SyncStateAccount(String account) {
this.account = account;
}

public static SyncStateAccount create(String account) {

	return new SyncStateAccount(account);
}

public String value() {
return this.account;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof SyncStateAccount that)) return false;
return this.account.equals(that.account);
}

@Override
public int hashCode() {
return java.util.Objects.hash(account);
}

@Override
public String toString() {
return String.valueOf(account);
}
}
