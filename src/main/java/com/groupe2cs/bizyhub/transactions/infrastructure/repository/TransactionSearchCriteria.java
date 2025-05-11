package com.groupe2cs.bizyhub.transactions.infrastructure.repository;

import java.time.Instant;

public class TransactionSearchCriteria {

	private String type;
	private Boolean isActive;
	private String categoryId;
	private String reference;
	private Instant fromDate;
	private Instant toDate;
}

