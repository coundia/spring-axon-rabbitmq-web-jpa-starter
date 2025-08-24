package com.groupe2cs.bizyhub.notifications.domain;

import com.groupe2cs.bizyhub.shared.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.groupe2cs.bizyhub.notifications.domain.valueObject.*;
import java.util.UUID;
import com.groupe2cs.bizyhub.notifications.domain.exception.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;


public class NotificationAggregateTests extends BaseUnitTests {

@Test
void it_should_create_notification_with_valid_values() {
	NotificationId id = NotificationId.create(UUID.randomUUID().toString());
	NotificationDeviceToken deviceToken = NotificationDeviceToken.create(UUID.randomUUID().toString());
	NotificationTitle title = NotificationTitle.create(UUID.randomUUID().toString());
	NotificationMessage message = NotificationMessage.create(UUID.randomUUID().toString());
	NotificationStatus status = NotificationStatus.create(UUID.randomUUID().toString());
	NotificationRemoteId remoteId = NotificationRemoteId.create(UUID.randomUUID().toString());
	NotificationLocalId localId = NotificationLocalId.create(UUID.randomUUID().toString());
	NotificationSyncAt syncAt = NotificationSyncAt.create(java.time.Instant.now().plusSeconds(3600));
	NotificationReserved reserved = NotificationReserved.create(UUID.randomUUID().toString());
	NotificationErrorMessage errorMessage = NotificationErrorMessage.create(UUID.randomUUID().toString());
	NotificationCreatedBy createdBy = NotificationCreatedBy.create(UUID.randomUUID().toString());
	NotificationTenant tenant = NotificationTenant.create(UUID.randomUUID().toString());
	NotificationAggregate aggregateNotificationAggregate = new NotificationAggregate(id, deviceToken, title, message, status, remoteId, localId, syncAt, reserved, errorMessage, createdBy, tenant);
	assertThat(aggregateNotificationAggregate.getId()).isNotNull();
	assertThat(aggregateNotificationAggregate.getId()).isEqualTo(id);
	assertThat(aggregateNotificationAggregate.getDeviceToken()).isEqualTo(deviceToken);
	assertThat(aggregateNotificationAggregate.getTitle()).isEqualTo(title);
	assertThat(aggregateNotificationAggregate.getMessage()).isEqualTo(message);
	assertThat(aggregateNotificationAggregate.getStatus()).isEqualTo(status);
	assertThat(aggregateNotificationAggregate.getRemoteId()).isEqualTo(remoteId);
	assertThat(aggregateNotificationAggregate.getLocalId()).isEqualTo(localId);
	assertThat(aggregateNotificationAggregate.getSyncAt()).isEqualTo(syncAt);
	assertThat(aggregateNotificationAggregate.getReserved()).isEqualTo(reserved);
	assertThat(aggregateNotificationAggregate.getErrorMessage()).isEqualTo(errorMessage);
	assertThat(aggregateNotificationAggregate.getCreatedBy()).isEqualTo(createdBy);
	assertThat(aggregateNotificationAggregate.getTenant()).isEqualTo(tenant);
}

		@Test
		void it_should_throw_when_id_is_invalid() {
		NotificationIdNotValid error = assertThrows(NotificationIdNotValid.class, () -> NotificationId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
		}
		@Test
		void it_should_throw_when_title_is_invalid() {
		NotificationTitleNotValid error = assertThrows(NotificationTitleNotValid.class, () -> NotificationTitle.create(""));
		assertThat(error.getMessage()).isEqualTo("Title is invalid");
		}

}
