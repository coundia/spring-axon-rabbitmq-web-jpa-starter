package com.groupe2cs.bizyhub.products.infrastructure.entity;

import com.groupe2cs.bizyhub.products.domain.valueObject.*;
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
@Table(name = "products")
public class Product {

	@Id
	//@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private Double price;

}
