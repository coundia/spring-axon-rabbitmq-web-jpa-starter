package com.groupe2cs.bizyhub.settings.application.usecase;

import com.groupe2cs.bizyhub.settings.application.command.DeleteSettingCommand;
import com.groupe2cs.bizyhub.settings.domain.valueObject.SettingId;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SettingDeleteApplicationService {

	private final CommandGateway commandGateway;

	public void deleteSetting(SettingId idVo, MetaRequest metaRequest) {

		DeleteSettingCommand command = new DeleteSettingCommand(idVo);
		commandGateway.sendAndWait(command);
	}
}
