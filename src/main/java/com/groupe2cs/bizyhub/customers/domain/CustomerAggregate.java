package com.groupe2cs.bizyhub.customers.domain;

import com.groupe2cs.bizyhub.customers.domain.valueObject.*;
import com.groupe2cs.bizyhub.customers.domain.event.*;
import com.groupe2cs.bizyhub.customers.application.command.*;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import static org.axonframework.modelling.command.AggregateLifecycle.apply;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Aggregate
public class CustomerAggregate {

@AggregateIdentifier
private CustomerId id;
private CustomerRemoteId remoteId;
private CustomerCode code;
private CustomerFirstName firstName;
private CustomerLastName lastName;
private CustomerFullName fullName;
private CustomerBalance balance;
private CustomerBalanceDebt balanceDebt;
private CustomerPhone phone;
private CustomerEmail email;
private CustomerNotes notes;
private CustomerStatus status;
private CustomerCompany company;
private CustomerAddressLine1 addressLine1;
private CustomerAddressLine2 addressLine2;
private CustomerCity city;
private CustomerRegion region;
private CustomerCountry country;
private CustomerPostalCode postalCode;
private CustomerSyncAt syncAt;
private CustomerIsActive isActive;
private CustomerCreatedBy createdBy;
private CustomerTenant tenant;


@CommandHandler
public CustomerAggregate(CreateCustomerCommand command) {
apply(new CustomerCreatedEvent(
		command.getId(),
		command.getRemoteId(),
		command.getCode(),
		command.getFirstName(),
		command.getLastName(),
		command.getFullName(),
		command.getBalance(),
		command.getBalanceDebt(),
		command.getPhone(),
		command.getEmail(),
		command.getNotes(),
		command.getStatus(),
		command.getCompany(),
		command.getAddressLine1(),
		command.getAddressLine2(),
		command.getCity(),
		command.getRegion(),
		command.getCountry(),
		command.getPostalCode(),
		command.getSyncAt(),
		command.getIsActive(),
		command.getCreatedBy(),
		command.getTenant()
));
}

@CommandHandler
public void handle(DeleteCustomerCommand command) {
	apply(new CustomerDeletedEvent(
		command.getId()
	));
}

@CommandHandler
public void handle(UpdateCustomerCommand command) {
apply(new CustomerUpdatedEvent(
		command.getId(),
		command.getRemoteId(),
		command.getCode(),
		command.getFirstName(),
		command.getLastName(),
		command.getFullName(),
		command.getBalance(),
		command.getBalanceDebt(),
		command.getPhone(),
		command.getEmail(),
		command.getNotes(),
		command.getStatus(),
		command.getCompany(),
		command.getAddressLine1(),
		command.getAddressLine2(),
		command.getCity(),
		command.getRegion(),
		command.getCountry(),
		command.getPostalCode(),
		command.getSyncAt(),
		command.getIsActive(),
		command.getCreatedBy(),
		command.getTenant()
));
}

@EventSourcingHandler
public void on(CustomerCreatedEvent event) {
	this.id = event.getId();
	this.remoteId = event.getRemoteId();
	this.code = event.getCode();
	this.firstName = event.getFirstName();
	this.lastName = event.getLastName();
	this.fullName = event.getFullName();
	this.balance = event.getBalance();
	this.balanceDebt = event.getBalanceDebt();
	this.phone = event.getPhone();
	this.email = event.getEmail();
	this.notes = event.getNotes();
	this.status = event.getStatus();
	this.company = event.getCompany();
	this.addressLine1 = event.getAddressLine1();
	this.addressLine2 = event.getAddressLine2();
	this.city = event.getCity();
	this.region = event.getRegion();
	this.country = event.getCountry();
	this.postalCode = event.getPostalCode();
	this.syncAt = event.getSyncAt();
	this.isActive = event.getIsActive();
	this.createdBy = event.getCreatedBy();
	this.tenant = event.getTenant();
}

@EventSourcingHandler
public void on(CustomerDeletedEvent event) {
this.id = event.getId();
}

@EventSourcingHandler
public void on(CustomerUpdatedEvent event) {
this.id = event.getId();
	this.remoteId = event.getRemoteId();
	this.code = event.getCode();
	this.firstName = event.getFirstName();
	this.lastName = event.getLastName();
	this.fullName = event.getFullName();
	this.balance = event.getBalance();
	this.balanceDebt = event.getBalanceDebt();
	this.phone = event.getPhone();
	this.email = event.getEmail();
	this.notes = event.getNotes();
	this.status = event.getStatus();
	this.company = event.getCompany();
	this.addressLine1 = event.getAddressLine1();
	this.addressLine2 = event.getAddressLine2();
	this.city = event.getCity();
	this.region = event.getRegion();
	this.country = event.getCountry();
	this.postalCode = event.getPostalCode();
	this.syncAt = event.getSyncAt();
	this.isActive = event.getIsActive();
	this.createdBy = event.getCreatedBy();
	this.tenant = event.getTenant();
}

}
