package com.groupe2cs.bizyhub.notifications.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.notifications.domain.exception.NotificationIdNotValid;
import com.groupe2cs.bizyhub.notifications.domain.exception.NotificationDeviceTokenNotValid;
import com.groupe2cs.bizyhub.notifications.domain.exception.NotificationTitleNotValid;
import com.groupe2cs.bizyhub.notifications.domain.exception.NotificationMessageNotValid;
import com.groupe2cs.bizyhub.notifications.domain.exception.NotificationStatusNotValid;
import com.groupe2cs.bizyhub.notifications.domain.exception.NotificationRemoteIdNotValid;
import com.groupe2cs.bizyhub.notifications.domain.exception.NotificationSyncAtNotValid;

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
public class NotificationSyncAt implements Serializable {

private java.time.Instant syncAt;

public NotificationSyncAt(java.time.Instant syncAt) {
this.syncAt = syncAt;
}

public static NotificationSyncAt create(java.time.Instant syncAt) {

	return new NotificationSyncAt(syncAt);
}

public java.time.Instant value() {
return this.syncAt;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof NotificationSyncAt that)) return false;
return this.syncAt.equals(that.syncAt);
}

@Override
public int hashCode() {
return java.util.Objects.hash(syncAt);
}

@Override
public String toString() {
return String.valueOf(syncAt);
}
}
