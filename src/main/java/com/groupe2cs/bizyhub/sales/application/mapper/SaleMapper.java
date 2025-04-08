package com.groupe2cs.bizyhub.sales.application.mapper;

import com.groupe2cs.bizyhub.sales.application.dto.*;
import com.groupe2cs.bizyhub.sales.domain.valueObject.*;
import com.groupe2cs.bizyhub.sales.domain.*;
import com.groupe2cs.bizyhub.sales.infrastructure.entity.*;
import com.groupe2cs.bizyhub.sales.application.command.*;

public class SaleMapper {

public static SaleResponse toResponse(Sale entity) {
return new SaleResponse(
 entity.getId(),
 entity.getQuantity(),
 entity.getTotal_price()
);
}

public static SaleResponse toResponse(String id, SaleRequest request) {
return new SaleResponse(
id,
 
   request.getQuantity(),
   request.getTotal_price()
);
}

public static CreateSaleCommand toCommand(SaleRequest request) {
return new CreateSaleCommand(
 
  SaleQuantity.create(request.getQuantity()), 
  SaleTotal_price.create(request.getTotal_price()) 
);
}

public static UpdateSaleCommand toUpdateCommand(String id, SaleRequest request) {
return new UpdateSaleCommand(
SaleId.create(id),
   
            SaleQuantity.create(request.getQuantity()), 
            SaleTotal_price.create(request.getTotal_price()) 
);
}

public static DeleteSaleCommand toDeleteCommand(SaleId id) {
return new DeleteSaleCommand(id);
}

}
