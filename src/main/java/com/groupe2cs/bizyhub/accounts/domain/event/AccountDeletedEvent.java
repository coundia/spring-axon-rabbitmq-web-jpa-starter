package com.groupe2cs.bizyhub.accounts.domain.event;

import com.groupe2cs.bizyhub.accounts.domain.valueObject.AccountId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDeletedEvent implements Serializable {


	private AccountId id;

}
