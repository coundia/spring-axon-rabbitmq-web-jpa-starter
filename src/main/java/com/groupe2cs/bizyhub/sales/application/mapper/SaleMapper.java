package com.groupe2cs.bizyhub.sales.application.mapper;

import com.groupe2cs.bizyhub.sales.application.command.CreateSaleCommand;
import com.groupe2cs.bizyhub.sales.application.command.DeleteSaleCommand;
import com.groupe2cs.bizyhub.sales.application.command.UpdateSaleCommand;
import com.groupe2cs.bizyhub.sales.application.dto.SaleRequest;
import com.groupe2cs.bizyhub.sales.application.dto.SaleResponse;
import com.groupe2cs.bizyhub.sales.domain.valueObject.SaleFacture;
import com.groupe2cs.bizyhub.sales.domain.valueObject.SaleId;
import com.groupe2cs.bizyhub.sales.domain.valueObject.SaleQuantity;
import com.groupe2cs.bizyhub.sales.domain.valueObject.SaleTotal_price;
import com.groupe2cs.bizyhub.sales.infrastructure.entity.Sale;

public class SaleMapper {

    public static SaleResponse toResponse(Sale entity) {
        return new SaleResponse(
                entity.getId(), entity.getQuantity(), entity.getTotal_price(), entity.getFacture());
    }

    public static SaleResponse toResponse(CreateSaleCommand command) {
        return new SaleResponse(
                command.getId().value(),
                command.getQuantity().value(),
                command.getTotal_price().value(),
                command.getFacture().value());
    }

    public static SaleResponse toResponse(UpdateSaleCommand command) {
        return new SaleResponse(
                command.getId().value(),
                command.getQuantity().value(),
                command.getTotal_price().value(),
                command.getFacture().value());
    }

    public static CreateSaleCommand toCommand(SaleRequest request, SaleFacture facture) {
        return new CreateSaleCommand(
                SaleQuantity.create(request.getQuantity()),
                SaleTotal_price.create(request.getTotal_price()),
                facture);
    }

    public static UpdateSaleCommand toUpdateCommand(
            SaleId id, SaleRequest request, SaleFacture facture) {
        return new UpdateSaleCommand(
                id,
                SaleQuantity.create(request.getQuantity()),
                SaleTotal_price.create(request.getTotal_price()),
                facture);
    }

    public static DeleteSaleCommand toDeleteCommand(SaleId id) {
        return new DeleteSaleCommand(id);
    }
}
