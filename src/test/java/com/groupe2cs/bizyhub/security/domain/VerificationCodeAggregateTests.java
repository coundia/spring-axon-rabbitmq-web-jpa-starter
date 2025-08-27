package com.groupe2cs.bizyhub.security.domain;

import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import com.groupe2cs.bizyhub.security.domain.exception.*;
import com.groupe2cs.bizyhub.shared.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;


public class VerificationCodeAggregateTests extends BaseUnitTests {

@Test
void it_should_create_verificationCode_with_valid_values() {
	VerificationCodeId id = VerificationCodeId.create(UUID.randomUUID().toString());
	VerificationCodeNotes notes = VerificationCodeNotes.create(UUID.randomUUID().toString());
	VerificationCodeToken token = VerificationCodeToken.create(UUID.randomUUID().toString());
	VerificationCodeUsername username = VerificationCodeUsername.create(UUID.randomUUID().toString());
	VerificationCodePhone phone = VerificationCodePhone.create(UUID.randomUUID().toString());
	VerificationCodeEmail email = VerificationCodeEmail.create(UUID.randomUUID().toString());
	VerificationCodeCode code = VerificationCodeCode.create(UUID.randomUUID().toString());
	VerificationCodeStatus status = VerificationCodeStatus.create(UUID.randomUUID().toString());
	VerificationCodeSource source = VerificationCodeSource.create(UUID.randomUUID().toString());
	VerificationCodeExpiration expiration = VerificationCodeExpiration.create(java.time.Instant.now().plusSeconds(3600));
	VerificationCodeCreatedBy createdBy = VerificationCodeCreatedBy.create(UUID.randomUUID().toString());
	VerificationCodeTenant tenant = VerificationCodeTenant.create(UUID.randomUUID().toString());
	VerificationCodeAggregate aggregateVerificationCodeAggregate = new VerificationCodeAggregate(id, notes, token, username, phone, email, code, status, source, expiration, createdBy, tenant);
	assertThat(aggregateVerificationCodeAggregate.getId()).isNotNull();
	assertThat(aggregateVerificationCodeAggregate.getId()).isEqualTo(id);
	assertThat(aggregateVerificationCodeAggregate.getNotes()).isEqualTo(notes);
	assertThat(aggregateVerificationCodeAggregate.getToken()).isEqualTo(token);
	assertThat(aggregateVerificationCodeAggregate.getUsername()).isEqualTo(username);
	assertThat(aggregateVerificationCodeAggregate.getPhone()).isEqualTo(phone);
	assertThat(aggregateVerificationCodeAggregate.getEmail()).isEqualTo(email);
	assertThat(aggregateVerificationCodeAggregate.getCode()).isEqualTo(code);
	assertThat(aggregateVerificationCodeAggregate.getStatus()).isEqualTo(status);
	assertThat(aggregateVerificationCodeAggregate.getSource()).isEqualTo(source);
	assertThat(aggregateVerificationCodeAggregate.getExpiration()).isEqualTo(expiration);
	assertThat(aggregateVerificationCodeAggregate.getCreatedBy()).isEqualTo(createdBy);
	assertThat(aggregateVerificationCodeAggregate.getTenant()).isEqualTo(tenant);
}

		@Test
		void it_should_throw_when_id_is_invalid() {
		VerificationCodeIdNotValid error = assertThrows(VerificationCodeIdNotValid.class, () -> VerificationCodeId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
		}

}
