package com.groupe2cs.bizyhub.sync.domain.event;

import com.groupe2cs.bizyhub.sync.domain.valueObject.ChangeLogId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChangeLogDeletedEvent implements Serializable {


	private ChangeLogId id;

}
