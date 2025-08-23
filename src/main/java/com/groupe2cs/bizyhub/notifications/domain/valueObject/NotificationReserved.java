package com.groupe2cs.bizyhub.notifications.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.notifications.domain.exception.NotificationIdNotValid;
import com.groupe2cs.bizyhub.notifications.domain.exception.NotificationDeviceTokenNotValid;
import com.groupe2cs.bizyhub.notifications.domain.exception.NotificationTitleNotValid;
import com.groupe2cs.bizyhub.notifications.domain.exception.NotificationMessageNotValid;
import com.groupe2cs.bizyhub.notifications.domain.exception.NotificationStatusNotValid;
import com.groupe2cs.bizyhub.notifications.domain.exception.NotificationSyncAtNotValid;
import com.groupe2cs.bizyhub.notifications.domain.exception.NotificationReservedNotValid;

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
public class NotificationReserved implements Serializable {

private String reserved;

public NotificationReserved(String reserved) {
this.reserved = reserved;
}

public static NotificationReserved create(String reserved) {

	return new NotificationReserved(reserved);
}

public String value() {
return this.reserved;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof NotificationReserved that)) return false;
return this.reserved.equals(that.reserved);
}

@Override
public int hashCode() {
return java.util.Objects.hash(reserved);
}

@Override
public String toString() {
return String.valueOf(reserved);
}
}
