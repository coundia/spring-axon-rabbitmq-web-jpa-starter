package com.groupe2cs.bizyhub.sales.infrastructure.repository;

	import com.groupe2cs.bizyhub.sales.infrastructure.entity.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SaleRepository extends JpaRepository<Sale, String> {

//@Query("SELECT t FROM Sale t ")
Page<Sale> findAll(Pageable pageable);

//@Query("SELECT t FROM Sale t WHERE t.id = :id")
Optional<Sale> findById(Sale id);


}
