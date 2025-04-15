package com.groupe2cs.bizyhub.sales.presentation.controller;

import com.groupe2cs.bizyhub.sales.application.command.CreateSaleCommand;
import com.groupe2cs.bizyhub.sales.domain.valueObject.SaleFacture;
import com.groupe2cs.bizyhub.sales.domain.valueObject.SaleProduct;
import com.groupe2cs.bizyhub.sales.domain.valueObject.SaleQuantity;
import com.groupe2cs.bizyhub.sales.domain.valueObject.SaleTotal_price;
import com.groupe2cs.bizyhub.sales.infrastructure.entity.Sale;
import com.groupe2cs.bizyhub.sales.infrastructure.repository.SaleRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SaleFixtures {

    public static Sale randomOne(SaleRepository repository) {
        Sale entity = new Sale();
        entity.setId(UUID.randomUUID().toString());
        entity.setQuantity(null);
        entity.setTotal_price(null);
        entity.setFacture(null);
        entity.setProduct(null);
        return repository.save(entity);
    }

    public static Sale existingOrRandom(SaleRepository repository) {
        return repository.findAll().stream().findFirst().orElseGet(() -> randomOne(repository));
    }

    public static Sale byId(SaleRepository repository, String id) {
        return repository.findById(id).orElse(null);
    }

    public static List<Sale> randomMany(SaleRepository repository, int count) {
        List<Sale> items = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            items.add(randomOne(repository));
        }
        return items;
    }

    public static void deleteAll(SaleRepository repository) {
        repository.deleteAll();
    }

    public static String randomOneViaCommand(CommandGateway commandGateway) {
        CreateSaleCommand command = new CreateSaleCommand(
                SaleQuantity.create(


                        null
                ), SaleTotal_price.create(


                null
        ), SaleFacture.create(


                null
        ), SaleProduct.create(


                null
        ));
        return commandGateway.sendAndWait(command).toString();
    }


}
