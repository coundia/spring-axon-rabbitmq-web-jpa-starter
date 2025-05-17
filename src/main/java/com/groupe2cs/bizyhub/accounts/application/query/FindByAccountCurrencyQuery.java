package com.groupe2cs.bizyhub.accounts.application.query;

import com.groupe2cs.bizyhub.accounts.domain.valueObject.AccountCurrency;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindByAccountCurrencyQuery {

	private final AccountCurrency currency;
	private final MetaRequest metaRequest;

}
