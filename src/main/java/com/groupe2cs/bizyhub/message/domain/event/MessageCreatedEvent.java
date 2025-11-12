package com.groupe2cs.bizyhub.message.domain.event;

	import com.groupe2cs.bizyhub.message.domain.valueObject.*;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.*;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageCreatedEvent implements Serializable {

    private MessageId id;
    private MessageCode code;
    private MessageEmail email;
    private MessagePhone phone;
    private MessageContent content;
    private MessagePlateforme plateforme;
    private MessageSource source;
    private MessageAgent agent;
    private MessageStatus status;
    private MessageDescription description;
    private MessageIsActive isActive;
    private MessageIsDefault isDefault;
    private MessageRemoteId remoteId;
    private MessageLocalId localId;
    private MessageDepotAt depotAt;
    private MessageSyncAt syncAt;
    private MessageCreatedBy createdBy;
    private MessageTenant tenant;



}
