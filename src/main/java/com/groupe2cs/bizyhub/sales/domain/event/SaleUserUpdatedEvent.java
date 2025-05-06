package com.groupe2cs.bizyhub.sales.domain.event;

	import com.groupe2cs.bizyhub.sales.domain.valueObject.*;

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
public class SaleUserUpdatedEvent implements Serializable {

	private SaleUserId id;
	private SaleUserSales sales;
	private SaleUserUsers users;
	private SaleUserUsername username;
	private SaleUserEmail email;
	private SaleUserDetails details;
	private SaleUserIsActive isActive;
	private SaleUserUpdatedAt updatedAt;
	private SaleUserReference reference;
	private SaleUserCreatedBy createdBy;
	private SaleUserTenant tenant;



}
