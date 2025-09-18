package com.groupe2cs.bizyhub.products.application.usecase;

import com.groupe2cs.bizyhub.products.application.command.CreateProductCommand;
import com.groupe2cs.bizyhub.products.application.dto.ProductRequest;
import com.groupe2cs.bizyhub.products.application.dto.ProductResponse;
import com.groupe2cs.bizyhub.products.application.mapper.ProductMapper;
import com.groupe2cs.bizyhub.products.domain.valueObject.ProductCreatedBy;
import com.groupe2cs.bizyhub.products.domain.valueObject.ProductTenant;
import com.groupe2cs.bizyhub.products.infrastructure.repository.ProductRepository;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.application.UserValidationService;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class ProductCreateApplicationImageService {

	private final CommandGateway commandGateway;
	private final ProductRepository productRepository;
	private final UserValidationService  userValidationService;

	@Value("${app.projection.retry.attempts:60}")
	private int retryAttempts;

	@Value("${app.projection.retry.sleep-ms:250}")
	private long retrySleepMs;

	public ProductResponse createProduct(ProductRequest request, MetaRequest metaRequest) {

		//should be premium user
		userValidationService.shouldBePremiumUser(metaRequest.getUserId()) ;

		CreateProductCommand command = ProductMapper.toCommand(request);
		command.setCreatedBy(ProductCreatedBy.create(metaRequest.getUserId()));
		command.setTenant(ProductTenant.create(metaRequest.getTenantId()));
		commandGateway.sendAndWait(command);
		return ProductMapper.toResponse(command);
	}

	public ProductResponse createProductSync(ProductRequest request, MetaRequest metaRequest) {

		//should be premium user
		 userValidationService.shouldBePremiumUser(metaRequest.getUserId()) ;

		CreateProductCommand command = ProductMapper.toCommand(request);
		command.setCreatedBy(ProductCreatedBy.create(metaRequest.getUserId()));
		command.setTenant(ProductTenant.create(metaRequest.getTenantId()));
		commandGateway.sendAndWait(command, 30, TimeUnit.SECONDS);
		waitUntilProjectionVisible(command.getId().value());
		return ProductMapper.toResponse(command);
	}

	private void waitUntilProjectionVisible(String productId) {
		for (int i = 0; i < retryAttempts; i++) {
			if (productRepository.findById(productId).isPresent()) return;
			try {
				Thread.sleep(retrySleepMs);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				return;
			}
		}
	}
}
