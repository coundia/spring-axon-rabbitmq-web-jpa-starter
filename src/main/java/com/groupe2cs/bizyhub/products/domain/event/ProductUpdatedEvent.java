package com.groupe2cs.bizyhub.products.domain.event;

	import com.groupe2cs.bizyhub.products.domain.valueObject.*;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.*;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductUpdatedEvent implements Serializable {

    private ProductId id;
    private ProductRemoteId remoteId;
    private ProductLocalId localId;
    private ProductCode code;
    private ProductName name;
    private ProductDescription description;
    private ProductStatus status;
    private ProductIsPublic isPublic;
    private ProductHasSold hasSold;
    private ProductHasPrice hasPrice;
    private ProductLevel level;
    private ProductQuantity quantity;
    private ProductBarcode barcode;
    private ProductCompany company;
    private ProductUnit unit;
    private ProductSyncAt syncAt;
    private ProductCategory category;
    private ProductAccount account;
    private ProductDefaultPrice defaultPrice;
    private ProductStatuses statuses;
    private ProductPurchasePrice purchasePrice;
    private ProductCreatedBy createdBy;
    private ProductTenant tenant;



}
