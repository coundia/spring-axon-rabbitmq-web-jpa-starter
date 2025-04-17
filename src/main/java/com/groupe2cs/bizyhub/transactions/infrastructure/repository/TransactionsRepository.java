package com.groupe2cs.bizyhub.transactions.infrastructure.repository;

	import com.groupe2cs.bizyhub.transactions.infrastructure.entity.Transactions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, String> {

	@Query("SELECT t FROM Transactions t ")
	Page<Transactions> findAll(Pageable pageable);

	@Query("SELECT t FROM Transactions t WHERE t.id = :id")
	Optional<Transactions> findById(Transactions id);
	@Query("SELECT t FROM Transactions t WHERE t.reference = :reference")
	List<Transactions> findByReference(String reference);

	@Query("SELECT t FROM Transactions t WHERE t.amount = :amount")
	List<Transactions> findByAmount(Double amount);


}
