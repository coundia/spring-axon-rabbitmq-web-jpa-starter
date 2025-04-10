package com.groupe2cs.bizyhub.sales.infrastructure.entity;

import com.groupe2cs.bizyhub.sales.domain.valueObject.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sales")
public class Sale {

	@Id
	//@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Column(nullable = false)
	private Integer quantity;
	@Column(nullable = false)
	private Double total_price;

}
