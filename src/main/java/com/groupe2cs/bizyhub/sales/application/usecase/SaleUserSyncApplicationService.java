package com.groupe2cs.bizyhub.sales.application.usecase;

import com.groupe2cs.bizyhub.sales.application.command.CreateSaleUserCommand;
import com.groupe2cs.bizyhub.sales.application.command.DeleteSaleUserCommand;
import com.groupe2cs.bizyhub.sales.application.command.UpdateSaleUserCommand;
import com.groupe2cs.bizyhub.sales.application.dto.SaleUserSyncRequest;
import com.groupe2cs.bizyhub.sales.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.application.query.FindByUserUsernameQuery;
import com.groupe2cs.bizyhub.security.application.usecase.UserReadApplicationService;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserUsername;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

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

				String userName = d.getUsername().toLowerCase();
				String userId = d.getUsers();

				  userId = userRepository.findByUsernameAndTenantId(userName,metaRequest.getTenantId()).orElseThrow().getId();

					CreateSaleUserCommand command = CreateSaleUserCommand.builder()
							.sales(SaleUserSales.create(d.getSales()))

							.users(SaleUserUsers.create(userId))

							.username(SaleUserUsername.create(d.getUsername()))
							.email(SaleUserEmail.create(d.getEmail()))
							.details(SaleUserDetails.create(d.getDetails()))
							.isActive(SaleUserIsActive.create(d.getIsActive()))
							.updatedAt(SaleUserUpdatedAt.create(d.getUpdatedAt()))
							.reference(SaleUserReference.create(d.getReference()))
							.build();
					if (metaRequest.getTenantId() != null) {
						command.setTenant(SaleUserTenant.create(metaRequest.getTenantId()));
					}
					if (metaRequest.getUserId() != null) {
						command.setCreatedBy(SaleUserCreatedBy.create(metaRequest.getUserId()));
					}

					commandGateway.sendAndWait(
							command
					);

				}
				case "UPDATE" -> {
					UpdateSaleUserCommand update = UpdateSaleUserCommand.builder()
							.id(SaleUserId.create(d.getId()))
							.sales(SaleUserSales.create(d.getSales()))
							.users(SaleUserUsers.create(d.getUsers()))
							.username(SaleUserUsername.create(d.getUsername()))
							.email(SaleUserEmail.create(d.getEmail()))
							.details(SaleUserDetails.create(d.getDetails()))
							.isActive(SaleUserIsActive.create(d.getIsActive()))
							.updatedAt(SaleUserUpdatedAt.create(d.getUpdatedAt()))
							.reference(SaleUserReference.create(d.getReference()))
							.build();

					if (metaRequest.getTenantId() != null) {
						//command.setTenant(SaleUserTenant.create(metaRequest.getTenantId()));
					}
					if (metaRequest.getUserId() != null) {
						//command.setCreatedBy( SaleUserCreatedBy.create(metaRequest.getUserId()));
					}

					commandGateway.sendAndWait(
							update
					);

				}
				case "DELETE" -> {
					DeleteSaleUserCommand delete = DeleteSaleUserCommand.builder()
							.id(SaleUserId.create(d.getId()))
							.build();

					if (metaRequest.getTenantId() != null) {
						//delete.setTenant(SaleUserTenant.create(metaRequest.getTenantId()));
					}

					if (metaRequest.getUserId() != null) {
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
