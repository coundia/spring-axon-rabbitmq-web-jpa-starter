package com.groupe2cs.bizyhub.notifications.domain.event;

import com.groupe2cs.bizyhub.notifications.domain.valueObject.NotificationId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDeletedEvent implements Serializable {


	private NotificationId id;

}
