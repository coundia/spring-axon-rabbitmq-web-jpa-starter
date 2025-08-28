package com.groupe2cs.bizyhub.notifications.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.notifications.domain.exception.NotificationIdNotValid;
import com.groupe2cs.bizyhub.notifications.domain.exception.NotificationDeviceTokenNotValid;
import com.groupe2cs.bizyhub.notifications.domain.exception.NotificationTitleNotValid;
import com.groupe2cs.bizyhub.notifications.domain.exception.NotificationMessageNotValid;
import com.groupe2cs.bizyhub.notifications.domain.exception.NotificationStatusNotValid;
import com.groupe2cs.bizyhub.notifications.domain.exception.NotificationRemoteIdNotValid;
import com.groupe2cs.bizyhub.notifications.domain.exception.NotificationAccountNotValid;

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
public class NotificationAccount implements Serializable {

private String account;

public NotificationAccount(String account) {
this.account = account;
}

public static NotificationAccount create(String account) {

	return new NotificationAccount(account);
}

public String value() {
return this.account;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof NotificationAccount that)) return false;
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
