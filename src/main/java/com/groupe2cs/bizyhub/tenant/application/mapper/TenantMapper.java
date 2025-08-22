package com.groupe2cs.bizyhub.tenant.application.mapper;

	import com.groupe2cs.bizyhub.tenant.application.dto.*;
	import com.groupe2cs.bizyhub.tenant.domain.valueObject.*;
	import com.groupe2cs.bizyhub.tenant.domain.*;
	import com.groupe2cs.bizyhub.tenant.infrastructure.entity.*;
	import com.groupe2cs.bizyhub.tenant.application.command.*;

public class TenantMapper {

public static TenantResponse toResponse(Tenant entity) {
return TenantResponse.builder()
		.id(entity.getId())
		.name(entity.getName())
		.description(entity.getDescription())
		.domain(entity.getDomain())
		.language(entity.getLanguage())
		.active(entity.getActive())
    .createdBy(entity.getCreatedBy() != null ? entity.getCreatedBy().getUsername(): null)
    .tenant(entity.getTenant() != null ? entity.getTenant().getId() : null)
.build();
}

public static TenantResponse toResponse(CreateTenantCommand command) {
return TenantResponse.builder()
	.id(command.getId().value())
	.name(command.getName().value())
	.description(command.getDescription().value())
	.domain(command.getDomain().value())
	.language(command.getLanguage().value())
	.active(command.getActive().value())
.build();
}

public static TenantResponse toResponse(UpdateTenantCommand command) {
return TenantResponse.builder()
	.id(command.getId().value())
	.name(command.getName().value())
	.description(command.getDescription().value())
	.domain(command.getDomain().value())
	.language(command.getLanguage().value())
	.active(command.getActive().value())
.build();
}

public static CreateTenantCommand toCommand(
TenantRequest request
) {
return CreateTenantCommand.builder()
	.name(TenantName.create(request.getName()))
	.description(TenantDescription.create(request.getDescription()))
	.domain(TenantDomain.create(request.getDomain()))
	.language(TenantLanguage.create(request.getLanguage()))
	.active(TenantActive.create(request.getActive()))
.build();
}

	public static UpdateTenantCommand toUpdateCommand(TenantId id, TenantRequest request) {
	return UpdateTenantCommand.builder()
	.id(id)
		.name(TenantName.create(request.getName()))
		.description(TenantDescription.create(request.getDescription()))
		.domain(TenantDomain.create(request.getDomain()))
		.language(TenantLanguage.create(request.getLanguage()))
		.active(TenantActive.create(request.getActive()))
	.build();
	}


public static DeleteTenantCommand toDeleteCommand(TenantId id) {
return DeleteTenantCommand.builder()
.id(id)
.build();
}
}
