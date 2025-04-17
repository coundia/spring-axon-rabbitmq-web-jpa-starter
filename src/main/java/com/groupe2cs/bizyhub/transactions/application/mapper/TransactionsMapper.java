package com.groupe2cs.bizyhub.transactions.application.mapper;

import com.groupe2cs.bizyhub.transactions.application.dto.*;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import com.groupe2cs.bizyhub.transactions.domain.*;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.*;
import com.groupe2cs.bizyhub.transactions.application.command.*;


public class TransactionsMapper {

public static TransactionsResponse toResponse(Transactions entity) {
return new TransactionsResponse(
		entity.getId(), 
		entity.getReference(), 
		entity.getAmount()
);
}

public static TransactionsResponse toResponse(CreateTransactionsCommand command) {
return new TransactionsResponse(
command.getId().value(), command.getReference().value(), command.getAmount().value()
);
}

public static TransactionsResponse toResponse(UpdateTransactionsCommand command) {
return new TransactionsResponse(
command.getId().value(), command.getReference().value(), command.getAmount().value()
);
}


public static CreateTransactionsCommand toCommand(
TransactionsRequest request
) {
return new CreateTransactionsCommand(
TransactionsReference.create(request.getReference()), TransactionsAmount.create(request.getAmount())
);
}
public static UpdateTransactionsCommand toUpdateCommand(TransactionsId id, TransactionsRequest request) {
return new UpdateTransactionsCommand(
id, TransactionsReference.create(request.getReference()), TransactionsAmount.create(request.getAmount())
);
}


public static DeleteTransactionsCommand toDeleteCommand(TransactionsId id) {
return new DeleteTransactionsCommand(id);
}
}
