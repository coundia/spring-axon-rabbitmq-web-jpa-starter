package com.groupe2cs.bizyhub.debts.domain.event;

import com.groupe2cs.bizyhub.debts.domain.valueObject.DebtId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DebtDeletedEvent implements Serializable {


	private DebtId id;

}
