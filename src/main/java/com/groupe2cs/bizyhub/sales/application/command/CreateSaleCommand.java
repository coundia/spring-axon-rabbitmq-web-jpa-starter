package com.groupe2cs.bizyhub.sales.application.command;

import com.groupe2cs.bizyhub.sales.domain.valueObject.*;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import java.util.Date;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateSaleCommand implements Serializable {
@TargetAggregateIdentifier
private SaleId id;
private SaleQuantity quantity;
private SaleTotal_price total_price;

  private SaleFacture facture;

public CreateSaleCommand(
 
   SaleQuantity quantity , 
   SaleTotal_price total_price  
, SaleFacture facture
){
this.id = SaleId.create(UUID.randomUUID().toString());
 
  this.quantity = quantity ; 
  this.total_price = total_price ; 
  this.facture = facture ;

}


}
