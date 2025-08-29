package com.groupe2cs.bizyhub.customers.domain;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.customers.domain.exception.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.UUID;
import com.groupe2cs.bizyhub.customers.domain.valueObject.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;


public class CustomerAggregateTests extends BaseUnitTests {

@Test
void it_should_create_customer_with_valid_values() {
	CustomerId id = CustomerId.create(UUID.randomUUID().toString());
	CustomerRemoteId remoteId = CustomerRemoteId.create(UUID.randomUUID().toString());
	CustomerLocalId localId = CustomerLocalId.create(UUID.randomUUID().toString());
	CustomerCode code = CustomerCode.create(UUID.randomUUID().toString());
	CustomerFirstName firstName = CustomerFirstName.create(UUID.randomUUID().toString());
	CustomerLastName lastName = CustomerLastName.create(UUID.randomUUID().toString());
	CustomerFullName fullName = CustomerFullName.create(UUID.randomUUID().toString());
	CustomerBalance balance = CustomerBalance.create(1514.6);
	CustomerBalanceDebt balanceDebt = CustomerBalanceDebt.create(6488.23);
	CustomerPhone phone = CustomerPhone.create(UUID.randomUUID().toString());
	CustomerEmail email = CustomerEmail.create(UUID.randomUUID().toString());
	CustomerNotes notes = CustomerNotes.create(UUID.randomUUID().toString());
	CustomerStatus status = CustomerStatus.create(UUID.randomUUID().toString());
	CustomerAccount account = CustomerAccount.create(UUID.randomUUID().toString());
	CustomerCompany company = CustomerCompany.create(UUID.randomUUID().toString());
	CustomerAddressLine1 addressLine1 = CustomerAddressLine1.create(UUID.randomUUID().toString());
	CustomerAddressLine2 addressLine2 = CustomerAddressLine2.create(UUID.randomUUID().toString());
	CustomerCity city = CustomerCity.create(UUID.randomUUID().toString());
	CustomerRegion region = CustomerRegion.create(UUID.randomUUID().toString());
	CustomerCountry country = CustomerCountry.create(UUID.randomUUID().toString());
	CustomerPostalCode postalCode = CustomerPostalCode.create(UUID.randomUUID().toString());
	CustomerSyncAt syncAt = CustomerSyncAt.create(java.time.Instant.now().plusSeconds(3600));
	CustomerIsActive isActive = CustomerIsActive.create(true);
	CustomerCreatedBy createdBy = CustomerCreatedBy.create(UUID.randomUUID().toString());
	CustomerTenant tenant = CustomerTenant.create(UUID.randomUUID().toString());
	CustomerAggregate aggregateCustomerAggregate = new CustomerAggregate(id, remoteId, localId, code, firstName, lastName, fullName, balance, balanceDebt, phone, email, notes, status, account, company, addressLine1, addressLine2, city, region, country, postalCode, syncAt, isActive, createdBy, tenant);
	assertThat(aggregateCustomerAggregate.getId()).isNotNull();
	assertThat(aggregateCustomerAggregate.getId()).isEqualTo(id);
	assertThat(aggregateCustomerAggregate.getRemoteId()).isEqualTo(remoteId);
	assertThat(aggregateCustomerAggregate.getLocalId()).isEqualTo(localId);
	assertThat(aggregateCustomerAggregate.getCode()).isEqualTo(code);
	assertThat(aggregateCustomerAggregate.getFirstName()).isEqualTo(firstName);
	assertThat(aggregateCustomerAggregate.getLastName()).isEqualTo(lastName);
	assertThat(aggregateCustomerAggregate.getFullName()).isEqualTo(fullName);
	assertThat(aggregateCustomerAggregate.getBalance()).isEqualTo(balance);
	assertThat(aggregateCustomerAggregate.getBalanceDebt()).isEqualTo(balanceDebt);
	assertThat(aggregateCustomerAggregate.getPhone()).isEqualTo(phone);
	assertThat(aggregateCustomerAggregate.getEmail()).isEqualTo(email);
	assertThat(aggregateCustomerAggregate.getNotes()).isEqualTo(notes);
	assertThat(aggregateCustomerAggregate.getStatus()).isEqualTo(status);
	assertThat(aggregateCustomerAggregate.getAccount()).isEqualTo(account);
	assertThat(aggregateCustomerAggregate.getCompany()).isEqualTo(company);
	assertThat(aggregateCustomerAggregate.getAddressLine1()).isEqualTo(addressLine1);
	assertThat(aggregateCustomerAggregate.getAddressLine2()).isEqualTo(addressLine2);
	assertThat(aggregateCustomerAggregate.getCity()).isEqualTo(city);
	assertThat(aggregateCustomerAggregate.getRegion()).isEqualTo(region);
	assertThat(aggregateCustomerAggregate.getCountry()).isEqualTo(country);
	assertThat(aggregateCustomerAggregate.getPostalCode()).isEqualTo(postalCode);
	assertThat(aggregateCustomerAggregate.getSyncAt()).isEqualTo(syncAt);
	assertThat(aggregateCustomerAggregate.getIsActive()).isEqualTo(isActive);
	assertThat(aggregateCustomerAggregate.getCreatedBy()).isEqualTo(createdBy);
	assertThat(aggregateCustomerAggregate.getTenant()).isEqualTo(tenant);
}

		@Test
		void it_should_throw_when_id_is_invalid() {
		CustomerIdNotValid error = assertThrows(CustomerIdNotValid.class, () -> CustomerId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
		}
		@Test
		void it_should_throw_when_balance_is_invalid() {
		CustomerBalanceNotValid error = assertThrows(CustomerBalanceNotValid.class, () -> CustomerBalance.create(null));
		assertThat(error.getMessage()).isEqualTo("Balance is invalid");
		}
		@Test
		void it_should_throw_when_balanceDebt_is_invalid() {
		CustomerBalanceDebtNotValid error = assertThrows(CustomerBalanceDebtNotValid.class, () -> CustomerBalanceDebt.create(null));
		assertThat(error.getMessage()).isEqualTo("BalanceDebt is invalid");
		}

}
