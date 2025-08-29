package com.groupe2cs.bizyhub.accounts.domain.event;

import com.groupe2cs.bizyhub.accounts.domain.valueObject.AccountUserId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountUserDeletedEvent implements Serializable {


	private AccountUserId id;

}
