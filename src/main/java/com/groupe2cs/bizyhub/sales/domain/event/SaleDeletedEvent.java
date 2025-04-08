package com.groupe2cs.bizyhub.sales.domain.event;

	import com.groupe2cs.bizyhub.sales.domain.valueObject.*;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleDeletedEvent implements Serializable {

	
	
	

private SaleId id;

}
