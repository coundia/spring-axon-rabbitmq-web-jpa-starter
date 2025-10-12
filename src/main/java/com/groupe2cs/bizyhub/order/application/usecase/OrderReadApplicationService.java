package com.groupe2cs.bizyhub.order.application.usecase;

import com.groupe2cs.bizyhub.order.application.mapper.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.order.application.query.*;
import com.groupe2cs.bizyhub.order.application.dto.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.order.domain.valueObject.*;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class OrderReadApplicationService {

	private final QueryGateway queryGateway;


	public OrderPagedResponse findAll(int page, int limit, MetaRequest metaRequest) {

		FindAllOrderQuery query = new FindAllOrderQuery(page, limit, metaRequest);
		CompletableFuture<OrderPagedResponse> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(OrderPagedResponse.class));
		return future.join();
	}


	public OrderResponse findByOrderId(OrderId value, MetaRequest metaRequest) {

		FindByOrderIdQuery query = new FindByOrderIdQuery(value, metaRequest);
		CompletableFuture<OrderResponse> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(OrderResponse.class));
		return future.join();
	}


	public List<OrderResponse> findByOrderProductId(
			OrderProductId value,
			MetaRequest metaRequest
	) {

		FindByOrderProductIdQuery query = new FindByOrderProductIdQuery(value, metaRequest);
		CompletableFuture<List<OrderResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(OrderResponse.class));
		return future.join();
	}

	public List<OrderResponse> findByOrderUserId(
			OrderUserId value,
			MetaRequest metaRequest
	) {

		FindByOrderUserIdQuery query = new FindByOrderUserIdQuery(value, metaRequest);
		CompletableFuture<List<OrderResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(OrderResponse.class));
		return future.join();
	}

	public List<OrderResponse> findByOrderIdentifiant(
			OrderIdentifiant value,
			MetaRequest metaRequest
	) {

		FindByOrderIdentifiantQuery query = new FindByOrderIdentifiantQuery(value, metaRequest);
		CompletableFuture<List<OrderResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(OrderResponse.class));
		return future.join();
	}

	public List<OrderResponse> findByOrderTelephone(
			OrderTelephone value,
			MetaRequest metaRequest
	) {

		FindByOrderTelephoneQuery query = new FindByOrderTelephoneQuery(value, metaRequest);
		CompletableFuture<List<OrderResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(OrderResponse.class));
		return future.join();
	}

	public List<OrderResponse> findByOrderMail(
			OrderMail value,
			MetaRequest metaRequest
	) {

		FindByOrderMailQuery query = new FindByOrderMailQuery(value, metaRequest);
		CompletableFuture<List<OrderResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(OrderResponse.class));
		return future.join();
	}

	public List<OrderResponse> findByOrderVille(
			OrderVille value,
			MetaRequest metaRequest
	) {

		FindByOrderVilleQuery query = new FindByOrderVilleQuery(value, metaRequest);
		CompletableFuture<List<OrderResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(OrderResponse.class));
		return future.join();
	}

	public List<OrderResponse> findByOrderRemoteId(
			OrderRemoteId value,
			MetaRequest metaRequest
	) {

		FindByOrderRemoteIdQuery query = new FindByOrderRemoteIdQuery(value, metaRequest);
		CompletableFuture<List<OrderResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(OrderResponse.class));
		return future.join();
	}

	public List<OrderResponse> findByOrderLocalId(
			OrderLocalId value,
			MetaRequest metaRequest
	) {

		FindByOrderLocalIdQuery query = new FindByOrderLocalIdQuery(value, metaRequest);
		CompletableFuture<List<OrderResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(OrderResponse.class));
		return future.join();
	}

	public List<OrderResponse> findByOrderStatus(
			OrderStatus value,
			MetaRequest metaRequest
	) {

		FindByOrderStatusQuery query = new FindByOrderStatusQuery(value, metaRequest);
		CompletableFuture<List<OrderResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(OrderResponse.class));
		return future.join();
	}

	public List<OrderResponse> findByOrderBuyerName(
			OrderBuyerName value,
			MetaRequest metaRequest
	) {

		FindByOrderBuyerNameQuery query = new FindByOrderBuyerNameQuery(value, metaRequest);
		CompletableFuture<List<OrderResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(OrderResponse.class));
		return future.join();
	}

	public List<OrderResponse> findByOrderAddress(
			OrderAddress value,
			MetaRequest metaRequest
	) {

		FindByOrderAddressQuery query = new FindByOrderAddressQuery(value, metaRequest);
		CompletableFuture<List<OrderResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(OrderResponse.class));
		return future.join();
	}

	public List<OrderResponse> findByOrderNotes(
			OrderNotes value,
			MetaRequest metaRequest
	) {

		FindByOrderNotesQuery query = new FindByOrderNotesQuery(value, metaRequest);
		CompletableFuture<List<OrderResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(OrderResponse.class));
		return future.join();
	}

	public List<OrderResponse> findByOrderMessage(
			OrderMessage value,
			MetaRequest metaRequest
	) {

		FindByOrderMessageQuery query = new FindByOrderMessageQuery(value, metaRequest);
		CompletableFuture<List<OrderResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(OrderResponse.class));
		return future.join();
	}

	public List<OrderResponse> findByOrderTypeOrder(
			OrderTypeOrder value,
			MetaRequest metaRequest
	) {

		FindByOrderTypeOrderQuery query = new FindByOrderTypeOrderQuery(value, metaRequest);
		CompletableFuture<List<OrderResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(OrderResponse.class));
		return future.join();
	}

	public List<OrderResponse> findByOrderPaymentMethod(
			OrderPaymentMethod value,
			MetaRequest metaRequest
	) {

		FindByOrderPaymentMethodQuery query = new FindByOrderPaymentMethodQuery(value, metaRequest);
		CompletableFuture<List<OrderResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(OrderResponse.class));
		return future.join();
	}

	public List<OrderResponse> findByOrderDeliveryMethod(
			OrderDeliveryMethod value,
			MetaRequest metaRequest
	) {

		FindByOrderDeliveryMethodQuery query = new FindByOrderDeliveryMethodQuery(value, metaRequest);
		CompletableFuture<List<OrderResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(OrderResponse.class));
		return future.join();
	}

	public List<OrderResponse> findByOrderAmountCents(
			OrderAmountCents value,
			MetaRequest metaRequest
	) {

		FindByOrderAmountCentsQuery query = new FindByOrderAmountCentsQuery(value, metaRequest);
		CompletableFuture<List<OrderResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(OrderResponse.class));
		return future.join();
	}

	public List<OrderResponse> findByOrderQuantity(
			OrderQuantity value,
			MetaRequest metaRequest
	) {

		FindByOrderQuantityQuery query = new FindByOrderQuantityQuery(value, metaRequest);
		CompletableFuture<List<OrderResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(OrderResponse.class));
		return future.join();
	}

	public List<OrderResponse> findByOrderDateCommand(
			OrderDateCommand value,
			MetaRequest metaRequest
	) {

		FindByOrderDateCommandQuery query = new FindByOrderDateCommandQuery(value, metaRequest);
		CompletableFuture<List<OrderResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(OrderResponse.class));
		return future.join();
	}

	public List<OrderResponse> findByOrderCreatedBy(
			OrderCreatedBy value,
			MetaRequest metaRequest
	) {

		FindByOrderCreatedByQuery query = new FindByOrderCreatedByQuery(value, metaRequest);
		CompletableFuture<List<OrderResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(OrderResponse.class));
		return future.join();
	}

	public List<OrderResponse> findByOrderTenant(
			OrderTenant value,
			MetaRequest metaRequest
	) {

		FindByOrderTenantQuery query = new FindByOrderTenantQuery(value, metaRequest);
		CompletableFuture<List<OrderResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(OrderResponse.class));
		return future.join();
	}

}
