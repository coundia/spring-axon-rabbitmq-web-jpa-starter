package com.groupe2cs.bizyhub.settings.domain.event;

import com.groupe2cs.bizyhub.settings.domain.valueObject.SettingId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SettingDeletedEvent implements Serializable {


	private SettingId id;

}
