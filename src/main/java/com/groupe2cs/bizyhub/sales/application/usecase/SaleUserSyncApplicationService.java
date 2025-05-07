package com.groupe2cs.bizyhub.sales.application.usecase;
import com.groupe2cs.bizyhub.sales.application.command.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.sales.domain.valueObject.*;
import com.groupe2cs.bizyhub.sales.application.dto.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.time.Instant;


@Service
@RequiredArgsConstructor
public class SaleUserSyncApplicationService {

	private final CommandGateway commandGateway;
	private final UserRepository userRepository ;
	public void syncSaleUser(SaleUserSyncRequest request,
MetaRequest metaRequest

) {
		for (var d : request.getDeltas()) {
			switch (d.getType()) {
				case "CREATE" -> {

CreateSaleUserCommand command = CreateSaleUserCommand.builder()
		.name(SaleUserName.create(d.getName()))
		.sales(SaleUserSales.create(d.getSales()))
		.users(SaleUserUsers.create(d.getUsers()))
		.username(SaleUserUsername.create(d.getUsername()))
		.details(SaleUserDetails.create(d.getDetails()))
		.isActive(SaleUserIsActive.create(d.getIsActive()))
		.updatedAt(SaleUserUpdatedAt.create(d.getUpdatedAt()))
		.reference(SaleUserReference.create(d.getReference()))
.build();
        String userName = d.getUsername();
        if(userName != null){
            userName = userName.toLowerCase();
            String userId = userRepository.findByUsernameAndTenantId(userName,metaRequest.getTenantId()).orElseThrow().getId();
            command.setUsers(SaleUserUsers.create(userId));
        }

		if(metaRequest.getTenantId() != null) {
			command.setTenant(SaleUserTenant.create(metaRequest.getTenantId()));
		}
		if(metaRequest.getUserId() != null) {
			command.setCreatedBy( SaleUserCreatedBy.create(metaRequest.getUserId()));
		}

		commandGateway.sendAndWait(
							command
				);

		}
				case "UPDATE" -> {
		UpdateSaleUserCommand update = UpdateSaleUserCommand.builder()
			.id(SaleUserId.create(d.getId()))
			.name(SaleUserName.create(d.getName()))
			.sales(SaleUserSales.create(d.getSales()))
			.users(SaleUserUsers.create(d.getUsers()))
			.username(SaleUserUsername.create(d.getUsername()))
			.details(SaleUserDetails.create(d.getDetails()))
			.isActive(SaleUserIsActive.create(d.getIsActive()))
			.updatedAt(SaleUserUpdatedAt.create(d.getUpdatedAt()))
			.reference(SaleUserReference.create(d.getReference()))
		.build();
	   String userName = d.getUsername();
        if(userName != null){
            userName = userName.toLowerCase();
            String userId = userRepository.findByUsernameAndTenantId(userName,metaRequest.getTenantId()).orElseThrow().getId();
            update.setUsers(SaleUserUsers.create(userId));
        }

		if(metaRequest.getTenantId() != null) {
			//update.setTenant(SaleUserTenant.create(metaRequest.getTenantId()));
		}
		if(metaRequest.getUserId() != null) {
			//update.setCreatedBy( SaleUserCreatedBy.create(metaRequest.getUserId()));
		}

		commandGateway.sendAndWait(
		update
				);

		}
		case "DELETE" -> {
				DeleteSaleUserCommand delete = DeleteSaleUserCommand.builder()
					.id(SaleUserId.create(d.getId()) )
					.build();

				if(metaRequest.getTenantId() != null) {
					//delete.setTenant(SaleUserTenant.create(metaRequest.getTenantId()));
				}

				if(metaRequest.getUserId() != null) {
					//delete.setCreatedBy( SaleUserCreatedBy.create(metaRequest.getUserId()));
				}
				commandGateway.sendAndWait(
				delete
				 );
				}
			}
		}
	}
}
