package com.groupe2cs.bizyhub.accounts.domain;

import com.groupe2cs.bizyhub.shared.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;
import com.groupe2cs.bizyhub.accounts.domain.exception.*;
import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
import org.junit.jupiter.api.Test;


public class AccountUserAggregateTests extends BaseUnitTests {

@Test
void it_should_create_accountUser_with_valid_values() {
	AccountUserId id = AccountUserId.create(UUID.randomUUID().toString());
	AccountUserAccount account = AccountUserAccount.create(UUID.randomUUID().toString());
	AccountUserUser user = AccountUserUser.create(UUID.randomUUID().toString());
	AccountUserIdentity identity = AccountUserIdentity.create(UUID.randomUUID().toString());
	AccountUserPhone phone = AccountUserPhone.create(UUID.randomUUID().toString());
	AccountUserEmail email = AccountUserEmail.create(UUID.randomUUID().toString());
	AccountUserRole role = AccountUserRole.create(UUID.randomUUID().toString());
	AccountUserStatus status = AccountUserStatus.create(UUID.randomUUID().toString());
	AccountUserInvitedBy invitedBy = AccountUserInvitedBy.create(UUID.randomUUID().toString());
	AccountUserSyncAt syncAt = AccountUserSyncAt.create(java.time.Instant.now().plusSeconds(3600));
	AccountUserAcceptedAt acceptedAt = AccountUserAcceptedAt.create(java.time.Instant.now().plusSeconds(3600));
	AccountUserRevokedAt revokedAt = AccountUserRevokedAt.create(java.time.Instant.now().plusSeconds(3600));
	AccountUserMessage message = AccountUserMessage.create(UUID.randomUUID().toString());
	AccountUserRemoteId remoteId = AccountUserRemoteId.create(UUID.randomUUID().toString());
	AccountUserLocalId localId = AccountUserLocalId.create(UUID.randomUUID().toString());
	AccountUserIsActive isActive = AccountUserIsActive.create(false);
	AccountUserCreatedBy createdBy = AccountUserCreatedBy.create(UUID.randomUUID().toString());
	AccountUserTenant tenant = AccountUserTenant.create(UUID.randomUUID().toString());
	AccountUserAggregate aggregateAccountUserAggregate = new AccountUserAggregate(id, account, user, identity, phone, email, role, status, invitedBy, syncAt, acceptedAt, revokedAt, message, remoteId, localId, isActive, createdBy, tenant);
	assertThat(aggregateAccountUserAggregate.getId()).isNotNull();
	assertThat(aggregateAccountUserAggregate.getId()).isEqualTo(id);
	assertThat(aggregateAccountUserAggregate.getAccount()).isEqualTo(account);
	assertThat(aggregateAccountUserAggregate.getUser()).isEqualTo(user);
	assertThat(aggregateAccountUserAggregate.getIdentity()).isEqualTo(identity);
	assertThat(aggregateAccountUserAggregate.getPhone()).isEqualTo(phone);
	assertThat(aggregateAccountUserAggregate.getEmail()).isEqualTo(email);
	assertThat(aggregateAccountUserAggregate.getRole()).isEqualTo(role);
	assertThat(aggregateAccountUserAggregate.getStatus()).isEqualTo(status);
	assertThat(aggregateAccountUserAggregate.getInvitedBy()).isEqualTo(invitedBy);
	assertThat(aggregateAccountUserAggregate.getSyncAt()).isEqualTo(syncAt);
	assertThat(aggregateAccountUserAggregate.getAcceptedAt()).isEqualTo(acceptedAt);
	assertThat(aggregateAccountUserAggregate.getRevokedAt()).isEqualTo(revokedAt);
	assertThat(aggregateAccountUserAggregate.getMessage()).isEqualTo(message);
	assertThat(aggregateAccountUserAggregate.getRemoteId()).isEqualTo(remoteId);
	assertThat(aggregateAccountUserAggregate.getLocalId()).isEqualTo(localId);
	assertThat(aggregateAccountUserAggregate.getIsActive()).isEqualTo(isActive);
	assertThat(aggregateAccountUserAggregate.getCreatedBy()).isEqualTo(createdBy);
	assertThat(aggregateAccountUserAggregate.getTenant()).isEqualTo(tenant);
}

		@Test
		void it_should_throw_when_id_is_invalid() {
		AccountUserIdNotValid error = assertThrows(AccountUserIdNotValid.class, () -> AccountUserId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
		}

}
