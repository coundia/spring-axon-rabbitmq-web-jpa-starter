package com.groupe2cs.bizyhub.accounts.application.usecase;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
import com.groupe2cs.bizyhub.accounts.application.dto.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.accounts.application.command.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.time.Instant;


@Service
@RequiredArgsConstructor
public class AccountUserSyncApplicationService {

	private final CommandGateway commandGateway;
	private final UserRepository userRepository ;
	public void syncAccountUser(AccountUserSyncRequest request,
MetaRequest metaRequest

) {
		for (var d : request.getDeltas()) {
			switch (d.getType()) {
				case "CREATE" -> {

CreateAccountUserCommand command = CreateAccountUserCommand.builder()
		.name(AccountUserName.create(d.getName()))
		.account(AccountUserAccount.create(d.getAccount()))
		.user(AccountUserUser.create(d.getUser()))
		.username(AccountUserUsername.create(d.getUsername()))
		.details(AccountUserDetails.create(d.getDetails()))
		.isActive(AccountUserIsActive.create(d.getIsActive()))
		.updatedAt(AccountUserUpdatedAt.create(d.getUpdatedAt()))
		.reference(AccountUserReference.create(d.getReference()))
.build();
        String userName = d.getUsername();
        if(userName != null){
            userName = userName.toLowerCase();
            String userId = userRepository.findByUsernameAndTenantId(userName,metaRequest.getTenantId())
            .stream()
            .findFirst()
            .orElseThrow().getId();
            command.setUser(AccountUserUser.create(userId));
        }

		if(metaRequest.getTenantId() != null) {
			command.setTenant(AccountUserTenant.create(metaRequest.getTenantId()));
		}
		if(metaRequest.getUserId() != null) {
			command.setCreatedBy( AccountUserCreatedBy.create(metaRequest.getUserId()));
		}

		commandGateway.sendAndWait(
							command
				);

		}
				case "UPDATE" -> {
		UpdateAccountUserCommand update = UpdateAccountUserCommand.builder()
			.id(AccountUserId.create(d.getId()))
			.name(AccountUserName.create(d.getName()))
			.account(AccountUserAccount.create(d.getAccount()))
			.user(AccountUserUser.create(d.getUser()))
			.username(AccountUserUsername.create(d.getUsername()))
			.details(AccountUserDetails.create(d.getDetails()))
			.isActive(AccountUserIsActive.create(d.getIsActive()))
			.updatedAt(AccountUserUpdatedAt.create(d.getUpdatedAt()))
			.reference(AccountUserReference.create(d.getReference()))
		.build();
	   String userName = d.getUsername();
        if(userName != null){
            userName = userName.toLowerCase();
            String userId = userRepository.findByUsernameAndTenantId(userName,metaRequest.getTenantId())
            .stream()
            .findFirst()
            .orElseThrow()
            .getId();
            update.setUser(AccountUserUser.create(userId));
        }

		if(metaRequest.getTenantId() != null) {
			//update.setTenant(AccountUserTenant.create(metaRequest.getTenantId()));
		}
		if(metaRequest.getUserId() != null) {
			//update.setCreatedBy( AccountUserCreatedBy.create(metaRequest.getUserId()));
		}

		commandGateway.sendAndWait(
		update
				);

		}
		case "DELETE" -> {
				DeleteAccountUserCommand delete = DeleteAccountUserCommand.builder()
					.id(AccountUserId.create(d.getId()) )
					.build();

				if(metaRequest.getTenantId() != null) {
					//delete.setTenant(AccountUserTenant.create(metaRequest.getTenantId()));
				}

				if(metaRequest.getUserId() != null) {
					//delete.setCreatedBy( AccountUserCreatedBy.create(metaRequest.getUserId()));
				}
				commandGateway.sendAndWait(
				delete
				 );
				}
			}
		}
	}
}
