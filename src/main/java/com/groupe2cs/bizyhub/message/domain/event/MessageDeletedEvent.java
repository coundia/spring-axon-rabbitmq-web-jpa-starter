package com.groupe2cs.bizyhub.message.domain.event;

import com.groupe2cs.bizyhub.message.domain.valueObject.MessageId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageDeletedEvent implements Serializable {


	private MessageId id;

}
