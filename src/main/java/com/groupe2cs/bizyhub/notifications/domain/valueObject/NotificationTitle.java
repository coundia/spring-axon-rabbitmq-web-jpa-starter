package com.groupe2cs.bizyhub.notifications.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.notifications.domain.exception.NotificationIdNotValid;
import com.groupe2cs.bizyhub.notifications.domain.exception.NotificationDeviceTokenNotValid;
import com.groupe2cs.bizyhub.notifications.domain.exception.NotificationTitleNotValid;

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
public class NotificationTitle implements Serializable {

private String title;

public NotificationTitle(String title) {
this.title = title;
}

public static NotificationTitle create(String title) {

if (title == null || title.isBlank()) {
throw new NotificationTitleNotValid("Title is invalid");
}
return new NotificationTitle(title);
}

public String value() {
return this.title;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof NotificationTitle that)) return false;
return this.title.equals(that.title);
}

@Override
public int hashCode() {
return java.util.Objects.hash(title);
}

@Override
public String toString() {
return String.valueOf(title);
}
}
