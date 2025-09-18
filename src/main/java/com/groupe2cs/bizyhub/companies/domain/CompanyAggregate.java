package com.groupe2cs.bizyhub.companies.domain;

import com.groupe2cs.bizyhub.companies.domain.valueObject.*;
import com.groupe2cs.bizyhub.companies.domain.event.*;
import com.groupe2cs.bizyhub.companies.application.command.*;
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
public class CompanyAggregate {

@AggregateIdentifier
private CompanyId id;
private CompanyRemoteId remoteId;
private CompanyLocalId localId;
private CompanyCode code;
private CompanyName name;
private CompanyDescription description;
private CompanyPhone phone;
private CompanyEmail email;
private CompanyWebsite website;
private CompanyTaxId taxId;
private CompanyCurrency currency;
private CompanyAddressLine1 addressLine1;
private CompanyAddressLine2 addressLine2;
private CompanyCity city;
private CompanyRegion region;
private CompanyCountry country;
private CompanyAccount account;
private CompanyPostalCode postalCode;
private CompanyIsActive isActive;
private CompanyStatus status;
private CompanyIsPublic isPublic;
private CompanySyncAt syncAt;
private CompanyIsDefault isDefault;
private CompanyCreatedBy createdBy;
private CompanyTenant tenant;


@CommandHandler
public CompanyAggregate(CreateCompanyCommand command) {
apply(new CompanyCreatedEvent(
		command.getId(),
		command.getRemoteId(),
		command.getLocalId(),
		command.getCode(),
		command.getName(),
		command.getDescription(),
		command.getPhone(),
		command.getEmail(),
		command.getWebsite(),
		command.getTaxId(),
		command.getCurrency(),
		command.getAddressLine1(),
		command.getAddressLine2(),
		command.getCity(),
		command.getRegion(),
		command.getCountry(),
		command.getAccount(),
		command.getPostalCode(),
		command.getIsActive(),
		command.getStatus(),
		command.getIsPublic(),
		command.getSyncAt(),
		command.getIsDefault(),
		command.getCreatedBy(),
		command.getTenant()
));
}

@CommandHandler
public void handle(DeleteCompanyCommand command) {
	apply(new CompanyDeletedEvent(
		command.getId()
	));
}

@CommandHandler
public void handle(UpdateCompanyCommand command) {
apply(new CompanyUpdatedEvent(
		command.getId(),
		command.getRemoteId(),
		command.getLocalId(),
		command.getCode(),
		command.getName(),
		command.getDescription(),
		command.getPhone(),
		command.getEmail(),
		command.getWebsite(),
		command.getTaxId(),
		command.getCurrency(),
		command.getAddressLine1(),
		command.getAddressLine2(),
		command.getCity(),
		command.getRegion(),
		command.getCountry(),
		command.getAccount(),
		command.getPostalCode(),
		command.getIsActive(),
		command.getStatus(),
		command.getIsPublic(),
		command.getSyncAt(),
		command.getIsDefault(),
		command.getCreatedBy(),
		command.getTenant()
));
}

@EventSourcingHandler
public void on(CompanyCreatedEvent event) {
	this.id = event.getId();
	this.remoteId = event.getRemoteId();
	this.localId = event.getLocalId();
	this.code = event.getCode();
	this.name = event.getName();
	this.description = event.getDescription();
	this.phone = event.getPhone();
	this.email = event.getEmail();
	this.website = event.getWebsite();
	this.taxId = event.getTaxId();
	this.currency = event.getCurrency();
	this.addressLine1 = event.getAddressLine1();
	this.addressLine2 = event.getAddressLine2();
	this.city = event.getCity();
	this.region = event.getRegion();
	this.country = event.getCountry();
	this.account = event.getAccount();
	this.postalCode = event.getPostalCode();
	this.isActive = event.getIsActive();
	this.status = event.getStatus();
	this.isPublic = event.getIsPublic();
	this.syncAt = event.getSyncAt();
	this.isDefault = event.getIsDefault();
	this.createdBy = event.getCreatedBy();
	this.tenant = event.getTenant();
}

@EventSourcingHandler
public void on(CompanyDeletedEvent event) {
this.id = event.getId();
}

@EventSourcingHandler
public void on(CompanyUpdatedEvent event) {
this.id = event.getId();
	this.remoteId = event.getRemoteId();
	this.localId = event.getLocalId();
	this.code = event.getCode();
	this.name = event.getName();
	this.description = event.getDescription();
	this.phone = event.getPhone();
	this.email = event.getEmail();
	this.website = event.getWebsite();
	this.taxId = event.getTaxId();
	this.currency = event.getCurrency();
	this.addressLine1 = event.getAddressLine1();
	this.addressLine2 = event.getAddressLine2();
	this.city = event.getCity();
	this.region = event.getRegion();
	this.country = event.getCountry();
	this.account = event.getAccount();
	this.postalCode = event.getPostalCode();
	this.isActive = event.getIsActive();
	this.status = event.getStatus();
	this.isPublic = event.getIsPublic();
	this.syncAt = event.getSyncAt();
	this.isDefault = event.getIsDefault();
	this.createdBy = event.getCreatedBy();
	this.tenant = event.getTenant();
}

}
