package com.groupe2cs.bizyhub.security.application.mapper;

	import com.groupe2cs.bizyhub.security.application.dto.*;
	import com.groupe2cs.bizyhub.security.domain.valueObject.*;
	import com.groupe2cs.bizyhub.security.domain.*;
	import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
	import com.groupe2cs.bizyhub.security.application.command.*;

public class UserMapper {

public static UserResponse toResponse(User entity) {
return UserResponse.builder()
		.id(entity.getId())
		.username(entity.getUsername())
		.password(entity.getPassword())
		.firstName(entity.getFirstName())
		.lastName(entity.getLastName())
		.email(entity.getEmail())
		.telephone(entity.getTelephone())
		.limitPerDay(entity.getLimitPerDay())
		.isPremium(entity.getIsPremium())
		.enabled(entity.getEnabled())
		.isBan(entity.getIsBan())
    .createdBy(entity.getCreatedBy().getUsername())
    .tenant(entity.getTenant().getName())
.build();
}

public static UserResponse toResponse(CreateUserCommand command) {
return UserResponse.builder()
	.id(command.getId().value())
	.username(command.getUsername().value())
	.password(command.getPassword().value())
	.firstName(command.getFirstName().value())
	.lastName(command.getLastName().value())
	.email(command.getEmail().value())
	.telephone(command.getTelephone().value())
	.limitPerDay(command.getLimitPerDay().value())
	.isPremium(command.getIsPremium().value())
	.enabled(command.getEnabled().value())
	.isBan(command.getIsBan().value())
.build();
}

public static UserResponse toResponse(UpdateUserCommand command) {
return UserResponse.builder()
	.id(command.getId().value())
	.username(command.getUsername().value())
	.password(command.getPassword().value())
	.firstName(command.getFirstName().value())
	.lastName(command.getLastName().value())
	.email(command.getEmail().value())
	.telephone(command.getTelephone().value())
	.limitPerDay(command.getLimitPerDay().value())
	.isPremium(command.getIsPremium().value())
	.enabled(command.getEnabled().value())
	.isBan(command.getIsBan().value())
.build();
}

public static CreateUserCommand toCommand(
UserRequest request
) {
return CreateUserCommand.builder()
	.username(UserUsername.create(request.getUsername()))
	.password(UserPassword.create(request.getPassword()))
	.firstName(UserFirstName.create(request.getFirstName()))
	.lastName(UserLastName.create(request.getLastName()))
	.email(UserEmail.create(request.getEmail()))
	.telephone(UserTelephone.create(request.getTelephone()))
	.limitPerDay(UserLimitPerDay.create(request.getLimitPerDay()))
	.isPremium(UserIsPremium.create(request.getIsPremium()))
	.enabled(UserEnabled.create(request.getEnabled()))
	.isBan(UserIsBan.create(request.getIsBan()))
.build();
}

	public static UpdateUserCommand toUpdateCommand(UserId id, UserRequest request) {
	return UpdateUserCommand.builder()
	.id(id)
		.username(UserUsername.create(request.getUsername()))
		.password(UserPassword.create(request.getPassword()))
		.firstName(UserFirstName.create(request.getFirstName()))
		.lastName(UserLastName.create(request.getLastName()))
		.email(UserEmail.create(request.getEmail()))
		.telephone(UserTelephone.create(request.getTelephone()))
		.limitPerDay(UserLimitPerDay.create(request.getLimitPerDay()))
		.isPremium(UserIsPremium.create(request.getIsPremium()))
		.enabled(UserEnabled.create(request.getEnabled()))
		.isBan(UserIsBan.create(request.getIsBan()))
	.build();
	}


public static DeleteUserCommand toDeleteCommand(UserId id) {
return DeleteUserCommand.builder()
.id(id)
.build();
}
}
