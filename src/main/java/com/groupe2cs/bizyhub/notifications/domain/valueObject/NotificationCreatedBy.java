package com.groupe2cs.bizyhub.notifications.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.notifications.domain.exception.NotificationIdNotValid;
import com.groupe2cs.bizyhub.notifications.domain.exception.NotificationDeviceTokenNotValid;
import com.groupe2cs.bizyhub.notifications.domain.exception.NotificationTitleNotValid;
import com.groupe2cs.bizyhub.notifications.domain.exception.NotificationMessageNotValid;
import com.groupe2cs.bizyhub.notifications.domain.exception.NotificationStatusNotValid;
import com.groupe2cs.bizyhub.notifications.domain.exception.NotificationRemoteIdNotValid;
import com.groupe2cs.bizyhub.notifications.domain.exception.NotificationAccountNotValid;
import com.groupe2cs.bizyhub.notifications.domain.exception.NotificationLocalIdNotValid;
import com.groupe2cs.bizyhub.notifications.domain.exception.NotificationSyncAtNotValid;
import com.groupe2cs.bizyhub.notifications.domain.exception.NotificationReservedNotValid;
import com.groupe2cs.bizyhub.notifications.domain.exception.NotificationErrorMessageNotValid;
import com.groupe2cs.bizyhub.notifications.domain.exception.NotificationCreatedByNotValid;

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
public class NotificationCreatedBy implements Serializable {

private String createdBy;

public NotificationCreatedBy(String createdBy) {
this.createdBy = createdBy;
}

public static NotificationCreatedBy create(String createdBy) {

	return new NotificationCreatedBy(createdBy);
}

public String value() {
return this.createdBy;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof NotificationCreatedBy that)) return false;
return this.createdBy.equals(that.createdBy);
}

@Override
public int hashCode() {
return java.util.Objects.hash(createdBy);
}

@Override
public String toString() {
return String.valueOf(createdBy);
}
}
