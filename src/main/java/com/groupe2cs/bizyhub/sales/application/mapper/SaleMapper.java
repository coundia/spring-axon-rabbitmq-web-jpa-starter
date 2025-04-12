package com.groupe2cs.bizyhub.sales.application.mapper;

import com.groupe2cs.bizyhub.sales.application.dto.*;
import com.groupe2cs.bizyhub.sales.domain.valueObject.*;
import com.groupe2cs.bizyhub.sales.domain.*;
import com.groupe2cs.bizyhub.sales.infrastructure.entity.*;
import com.groupe2cs.bizyhub.sales.application.command.*;


public class SaleMapper {

public static SaleResponse toResponse(Sale entity) {
return new SaleResponse(
entity.getId(), entity.getQuantity(), entity.getTotal_price(), entity.getFacture()
);
}

public static SaleResponse toResponse(CreateSaleCommand command) {
return new SaleResponse(
command.getId().value(), command.getQuantity().value(), command.getTotal_price().value(), command.getFacture().value()
);
}

public static SaleResponse toResponse(UpdateSaleCommand command) {
return new SaleResponse(
command.getId().value(), command.getQuantity().value(), command.getTotal_price().value(), command.getFacture().value()
);
}


public static CreateSaleCommand toCommand(
SaleRequest request, SaleFacture facture
) {
return new CreateSaleCommand(
SaleQuantity.create(request.getQuantity()), SaleTotal_price.create(request.getTotal_price()), facture
);
}
public static UpdateSaleCommand toUpdateCommand(SaleId id, SaleRequest request,
SaleFacture  facture) {
return new UpdateSaleCommand(
id, SaleQuantity.create(
request.getQuantity()), SaleTotal_price.create(
request.getTotal_price()),
facture
);
}


public static DeleteSaleCommand toDeleteCommand(SaleId id) {
return new DeleteSaleCommand(id);
}
}
