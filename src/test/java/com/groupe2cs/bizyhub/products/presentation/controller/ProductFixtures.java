package com.groupe2cs.bizyhub.products.presentation.controller;

import com.groupe2cs.bizyhub.products.application.command.CreateProductCommand;
import com.groupe2cs.bizyhub.products.domain.valueObject.ProductName;
import com.groupe2cs.bizyhub.products.domain.valueObject.ProductPrice;
import com.groupe2cs.bizyhub.products.infrastructure.entity.Product;
import com.groupe2cs.bizyhub.products.infrastructure.repository.ProductRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductFixtures {

    public static Product randomOne(ProductRepository repository) {
        Product entity = new Product();
        entity.setId(UUID.randomUUID().toString());
        entity.setName(null);
        entity.setPrice(null);
        return repository.save(entity);
    }

    public static Product existingOrRandom(ProductRepository repository) {
        return repository.findAll().stream().findFirst().orElseGet(() -> randomOne(repository));
    }

    public static Product byId(ProductRepository repository, String id) {
        return repository.findById(id).orElse(null);
    }

    public static List<Product> randomMany(ProductRepository repository, int count) {
        List<Product> items = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            items.add(randomOne(repository));
        }
        return items;
    }

    public static void deleteAll(ProductRepository repository) {
        repository.deleteAll();
    }

    public static String randomOneViaCommand(CommandGateway commandGateway) {
        CreateProductCommand command =
                new CreateProductCommand(ProductName.create(null), ProductPrice.create(null));

        return commandGateway.sendAndWait(command).toString();
    }
}
