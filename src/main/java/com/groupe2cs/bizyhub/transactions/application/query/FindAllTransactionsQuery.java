package com.groupe2cs.bizyhub.transactions.application.query;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FindAllTransactionsQuery {

private final int page;
private final int limit;

}
