package com.groupe2cs.bizyhub.notifications.domain;

import java.util.UUID;
import com.groupe2cs.bizyhub.notifications.domain.exception.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import com.groupe2cs.bizyhub.shared.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.groupe2cs.bizyhub.notifications.domain.valueObject.*;


public class NotificationAggregateTests extends BaseUnitTests {

@Test
void it_should_create_notification_with_valid_values() {
	NotificationId id = NotificationId.create(UUID.randomUUID().toString());
	NotificationDeviceToken deviceToken = NotificationDeviceToken.create(UUID.randomUUID().toString());
	NotificationTitle title = NotificationTitle.create(UUID.randomUUID().toString());
	NotificationMessage message = NotificationMessage.create(UUID.randomUUID().toString());
	NotificationStatus status = NotificationStatus.create(UUID.randomUUID().toString());
	NotificationReserved reserved = NotificationReserved.create(UUID.randomUUID().toString());
	NotificationErrorMessage errorMessage = NotificationErrorMessage.create(UUID.randomUUID().toString());
	NotificationUpdatedAt updatedAt = NotificationUpdatedAt.create(java.time.Instant.now().plusSeconds(3600));
	NotificationReference reference = NotificationReference.create(UUID.randomUUID().toString());
	NotificationCreatedBy createdBy = NotificationCreatedBy.create(UUID.randomUUID().toString());
	NotificationTenant tenant = NotificationTenant.create(UUID.randomUUID().toString());
	NotificationAggregate aggregateNotificationAggregate = new NotificationAggregate(id, deviceToken, title, message, status, reserved, errorMessage, updatedAt, reference, createdBy, tenant);
	assertThat(aggregateNotificationAggregate.getId()).isNotNull();
	assertThat(aggregateNotificationAggregate.getId()).isEqualTo(id);
	assertThat(aggregateNotificationAggregate.getDeviceToken()).isEqualTo(deviceToken);
	assertThat(aggregateNotificationAggregate.getTitle()).isEqualTo(title);
	assertThat(aggregateNotificationAggregate.getMessage()).isEqualTo(message);
	assertThat(aggregateNotificationAggregate.getStatus()).isEqualTo(status);
	assertThat(aggregateNotificationAggregate.getReserved()).isEqualTo(reserved);
	assertThat(aggregateNotificationAggregate.getErrorMessage()).isEqualTo(errorMessage);
	assertThat(aggregateNotificationAggregate.getUpdatedAt()).isEqualTo(updatedAt);
	assertThat(aggregateNotificationAggregate.getReference()).isEqualTo(reference);
	assertThat(aggregateNotificationAggregate.getCreatedBy()).isEqualTo(createdBy);
	assertThat(aggregateNotificationAggregate.getTenant()).isEqualTo(tenant);
}

		@Test
		void it_should_throw_when_id_is_invalid() {
		NotificationIdNotValid error = assertThrows(NotificationIdNotValid.class, () -> NotificationId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
		}
		@Test
		void it_should_throw_when_deviceToken_is_invalid() {
		NotificationDeviceTokenNotValid error = assertThrows(NotificationDeviceTokenNotValid.class, () -> NotificationDeviceToken.create(""));
		assertThat(error.getMessage()).isEqualTo("DeviceToken is invalid");
		}
		@Test
		void it_should_throw_when_title_is_invalid() {
		NotificationTitleNotValid error = assertThrows(NotificationTitleNotValid.class, () -> NotificationTitle.create(""));
		assertThat(error.getMessage()).isEqualTo("Title is invalid");
		}
		@Test
		void it_should_throw_when_message_is_invalid() {
		NotificationMessageNotValid error = assertThrows(NotificationMessageNotValid.class, () -> NotificationMessage.create(""));
		assertThat(error.getMessage()).isEqualTo("Message is invalid");
		}
		@Test
		void it_should_throw_when_status_is_invalid() {
		NotificationStatusNotValid error = assertThrows(NotificationStatusNotValid.class, () -> NotificationStatus.create(""));
		assertThat(error.getMessage()).isEqualTo("Status is invalid");
		}
		@Test
		void it_should_throw_when_reserved_is_invalid() {
		NotificationReservedNotValid error = assertThrows(NotificationReservedNotValid.class, () -> NotificationReserved.create(""));
		assertThat(error.getMessage()).isEqualTo("Reserved is invalid");
		}
		@Test
		void it_should_throw_when_errorMessage_is_invalid() {
		NotificationErrorMessageNotValid error = assertThrows(NotificationErrorMessageNotValid.class, () -> NotificationErrorMessage.create(""));
		assertThat(error.getMessage()).isEqualTo("ErrorMessage is invalid");
		}
		@Test
		void it_should_throw_when_updatedAt_is_invalid() {
		NotificationUpdatedAtNotValid error = assertThrows(NotificationUpdatedAtNotValid.class, () -> NotificationUpdatedAt.create(null));
		assertThat(error.getMessage()).isEqualTo("UpdatedAt is invalid");
		}
		@Test
		void it_should_throw_when_reference_is_invalid() {
		NotificationReferenceNotValid error = assertThrows(NotificationReferenceNotValid.class, () -> NotificationReference.create(""));
		assertThat(error.getMessage()).isEqualTo("Reference is invalid");
		}
		@Test
		void it_should_throw_when_createdBy_is_invalid() {
		NotificationCreatedByNotValid error = assertThrows(NotificationCreatedByNotValid.class, () -> NotificationCreatedBy.create(""));
		assertThat(error.getMessage()).isEqualTo("CreatedBy is invalid");
		}
		@Test
		void it_should_throw_when_tenant_is_invalid() {
		NotificationTenantNotValid error = assertThrows(NotificationTenantNotValid.class, () -> NotificationTenant.create(""));
		assertThat(error.getMessage()).isEqualTo("Tenant is invalid");
		}

}
