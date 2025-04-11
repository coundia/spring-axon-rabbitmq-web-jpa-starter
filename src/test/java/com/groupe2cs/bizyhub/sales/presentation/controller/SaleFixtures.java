package com.groupe2cs.bizyhub.sales.presentation.controller;

	import com.groupe2cs.bizyhub.sales.shared.*;
	import com.groupe2cs.bizyhub.sales.application.dto.*;
	import com.groupe2cs.bizyhub.sales.infrastructure.entity.*;
	import com.groupe2cs.bizyhub.sales.infrastructure.repository.*;
	import com.groupe2cs.bizyhub.sales.application.command.*;

import com.groupe2cs.bizyhub.sales.domain.valueObject.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.mock.web.MockMultipartFile;

public class SaleFixtures {

public static Sale randomOne(SaleRepository repository) {
Sale entity = new Sale();
entity.setId(UUID.randomUUID().toString());
			entity.setQuantity(123);
			entity.setTotal_price(999.99);
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
			
			123
			
			
			),
			SaleTotal_price.create(
			
			
			999.99
			
			)
,
	null
	//new MockMultipartFile("facture", "fake.txt", "text/plain", "Hello".getBytes())
);
return commandGateway.sendAndWait(command).toString();
}


}
