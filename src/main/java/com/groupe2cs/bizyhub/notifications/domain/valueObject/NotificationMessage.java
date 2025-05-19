package com.groupe2cs.bizyhub.notifications.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.notifications.domain.exception.NotificationIdNotValid;
import com.groupe2cs.bizyhub.notifications.domain.exception.NotificationDeviceTokenNotValid;
import com.groupe2cs.bizyhub.notifications.domain.exception.NotificationTitleNotValid;
import com.groupe2cs.bizyhub.notifications.domain.exception.NotificationMessageNotValid;

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
public class NotificationMessage implements Serializable {

private String message;

public NotificationMessage(String message) {
this.message = message;
}

public static NotificationMessage create(String message) {

	return new NotificationMessage(message);
}

public String value() {
return this.message;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof NotificationMessage that)) return false;
return this.message.equals(that.message);
}

@Override
public int hashCode() {
return java.util.Objects.hash(message);
}

@Override
public String toString() {
return String.valueOf(message);
}
}
