package com.groupe2cs.bizyhub.notifications.application.query;

import com.groupe2cs.bizyhub.notifications.domain.valueObject.NotificationStatus;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindByNotificationStatusQuery {

	private final NotificationStatus status;
	private final MetaRequest metaRequest;

}
