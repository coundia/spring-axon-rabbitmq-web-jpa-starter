package com.groupe2cs.bizyhub.customers.infrastructure.repository;

	import com.groupe2cs.bizyhub.customers.infrastructure.entity.Customer;
	import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
	import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import java.time.*;
import java.util.*;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

	@Query("SELECT e FROM Customer e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC limit 1 ")
	Optional<Customer> findByIdAndCreatedById(String id, String createdById);
	@Query("SELECT e FROM Customer e WHERE e.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	List<Customer> findByIdAndTenantId(String id, String tenantId);

    @Query("SELECT e FROM Customer e WHERE e.createdBy.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<Customer> findByCreatedById(String createdById, Pageable pageable);

	@Query("SELECT e FROM Customer e WHERE e.tenant.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<Customer> findAllByTenantId(String tenantId, Pageable pageable);

        @Query("SELECT e FROM Customer e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Customer> findByRemoteIdAndCreatedById(String remoteId, String createdById);
        @Query("SELECT e FROM Customer e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Customer> findByRemoteIdAndTenantName(String remoteId, String tenantName);

        @Query("SELECT e FROM Customer e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Customer> findByRemoteIdAndTenantId(String remoteId, String tenantId);
        @Query("SELECT e FROM Customer e WHERE LOWER(e.code) LIKE LOWER(CONCAT('%', :code, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Customer> findByCodeAndCreatedById(String code, String createdById);
        @Query("SELECT e FROM Customer e WHERE LOWER(e.code) LIKE LOWER(CONCAT('%', :code, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Customer> findByCodeAndTenantName(String code, String tenantName);

        @Query("SELECT e FROM Customer e WHERE LOWER(e.code) LIKE LOWER(CONCAT('%', :code, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Customer> findByCodeAndTenantId(String code, String tenantId);
        @Query("SELECT e FROM Customer e WHERE LOWER(e.firstName) LIKE LOWER(CONCAT('%', :firstName, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Customer> findByFirstNameAndCreatedById(String firstName, String createdById);
        @Query("SELECT e FROM Customer e WHERE LOWER(e.firstName) LIKE LOWER(CONCAT('%', :firstName, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Customer> findByFirstNameAndTenantName(String firstName, String tenantName);

        @Query("SELECT e FROM Customer e WHERE LOWER(e.firstName) LIKE LOWER(CONCAT('%', :firstName, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Customer> findByFirstNameAndTenantId(String firstName, String tenantId);
        @Query("SELECT e FROM Customer e WHERE LOWER(e.lastName) LIKE LOWER(CONCAT('%', :lastName, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Customer> findByLastNameAndCreatedById(String lastName, String createdById);
        @Query("SELECT e FROM Customer e WHERE LOWER(e.lastName) LIKE LOWER(CONCAT('%', :lastName, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Customer> findByLastNameAndTenantName(String lastName, String tenantName);

        @Query("SELECT e FROM Customer e WHERE LOWER(e.lastName) LIKE LOWER(CONCAT('%', :lastName, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Customer> findByLastNameAndTenantId(String lastName, String tenantId);
        @Query("SELECT e FROM Customer e WHERE LOWER(e.fullName) LIKE LOWER(CONCAT('%', :fullName, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Customer> findByFullNameAndCreatedById(String fullName, String createdById);
        @Query("SELECT e FROM Customer e WHERE LOWER(e.fullName) LIKE LOWER(CONCAT('%', :fullName, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Customer> findByFullNameAndTenantName(String fullName, String tenantName);

        @Query("SELECT e FROM Customer e WHERE LOWER(e.fullName) LIKE LOWER(CONCAT('%', :fullName, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Customer> findByFullNameAndTenantId(String fullName, String tenantId);
        @Query("SELECT e FROM Customer e WHERE e.balance = :balance AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Customer> findByBalanceAndCreatedById(Double balance, String createdById);
        @Query("SELECT e FROM Customer e WHERE e.balance = :balance AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Customer> findByBalanceAndTenantName(Double balance, String tenantName);

        @Query("SELECT e FROM Customer e WHERE e.balance = :balance AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Customer> findByBalanceAndTenantId(Double balance, String tenantId);
        @Query("SELECT e FROM Customer e WHERE e.balanceDebt = :balanceDebt AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Customer> findByBalanceDebtAndCreatedById(Double balanceDebt, String createdById);
        @Query("SELECT e FROM Customer e WHERE e.balanceDebt = :balanceDebt AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Customer> findByBalanceDebtAndTenantName(Double balanceDebt, String tenantName);

        @Query("SELECT e FROM Customer e WHERE e.balanceDebt = :balanceDebt AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Customer> findByBalanceDebtAndTenantId(Double balanceDebt, String tenantId);
        @Query("SELECT e FROM Customer e WHERE LOWER(e.phone) LIKE LOWER(CONCAT('%', :phone, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Customer> findByPhoneAndCreatedById(String phone, String createdById);
        @Query("SELECT e FROM Customer e WHERE LOWER(e.phone) LIKE LOWER(CONCAT('%', :phone, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Customer> findByPhoneAndTenantName(String phone, String tenantName);

        @Query("SELECT e FROM Customer e WHERE LOWER(e.phone) LIKE LOWER(CONCAT('%', :phone, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Customer> findByPhoneAndTenantId(String phone, String tenantId);
        @Query("SELECT e FROM Customer e WHERE LOWER(e.email) LIKE LOWER(CONCAT('%', :email, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Customer> findByEmailAndCreatedById(String email, String createdById);
        @Query("SELECT e FROM Customer e WHERE LOWER(e.email) LIKE LOWER(CONCAT('%', :email, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Customer> findByEmailAndTenantName(String email, String tenantName);

        @Query("SELECT e FROM Customer e WHERE LOWER(e.email) LIKE LOWER(CONCAT('%', :email, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Customer> findByEmailAndTenantId(String email, String tenantId);
        @Query("SELECT e FROM Customer e WHERE LOWER(e.notes) LIKE LOWER(CONCAT('%', :notes, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Customer> findByNotesAndCreatedById(String notes, String createdById);
        @Query("SELECT e FROM Customer e WHERE LOWER(e.notes) LIKE LOWER(CONCAT('%', :notes, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Customer> findByNotesAndTenantName(String notes, String tenantName);

        @Query("SELECT e FROM Customer e WHERE LOWER(e.notes) LIKE LOWER(CONCAT('%', :notes, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Customer> findByNotesAndTenantId(String notes, String tenantId);
        @Query("SELECT e FROM Customer e WHERE LOWER(e.status) LIKE LOWER(CONCAT('%', :status, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Customer> findByStatusAndCreatedById(String status, String createdById);
        @Query("SELECT e FROM Customer e WHERE LOWER(e.status) LIKE LOWER(CONCAT('%', :status, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Customer> findByStatusAndTenantName(String status, String tenantName);

        @Query("SELECT e FROM Customer e WHERE LOWER(e.status) LIKE LOWER(CONCAT('%', :status, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Customer> findByStatusAndTenantId(String status, String tenantId);
        @Query("SELECT e FROM Customer e WHERE LOWER(e.company.id) LIKE LOWER(CONCAT('%', :company, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Customer> findByCompanyIdAndCreatedById(String company, String createdById);
        @Query("SELECT e FROM Customer e WHERE LOWER(e.company.id) LIKE LOWER(CONCAT('%', :company, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Customer> findByCompanyIdAndTenantName(String company, String tenantName);

        @Query("SELECT e FROM Customer e WHERE LOWER(e.company.id) LIKE LOWER(CONCAT('%', :company, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Customer> findByCompanyIdAndTenantId(String company, String tenantId);
        @Query("SELECT e FROM Customer e WHERE LOWER(e.addressLine1) LIKE LOWER(CONCAT('%', :addressLine1, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Customer> findByAddressLine1AndCreatedById(String addressLine1, String createdById);
        @Query("SELECT e FROM Customer e WHERE LOWER(e.addressLine1) LIKE LOWER(CONCAT('%', :addressLine1, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Customer> findByAddressLine1AndTenantName(String addressLine1, String tenantName);

        @Query("SELECT e FROM Customer e WHERE LOWER(e.addressLine1) LIKE LOWER(CONCAT('%', :addressLine1, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Customer> findByAddressLine1AndTenantId(String addressLine1, String tenantId);
        @Query("SELECT e FROM Customer e WHERE LOWER(e.addressLine2) LIKE LOWER(CONCAT('%', :addressLine2, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Customer> findByAddressLine2AndCreatedById(String addressLine2, String createdById);
        @Query("SELECT e FROM Customer e WHERE LOWER(e.addressLine2) LIKE LOWER(CONCAT('%', :addressLine2, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Customer> findByAddressLine2AndTenantName(String addressLine2, String tenantName);

        @Query("SELECT e FROM Customer e WHERE LOWER(e.addressLine2) LIKE LOWER(CONCAT('%', :addressLine2, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Customer> findByAddressLine2AndTenantId(String addressLine2, String tenantId);
        @Query("SELECT e FROM Customer e WHERE LOWER(e.city) LIKE LOWER(CONCAT('%', :city, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Customer> findByCityAndCreatedById(String city, String createdById);
        @Query("SELECT e FROM Customer e WHERE LOWER(e.city) LIKE LOWER(CONCAT('%', :city, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Customer> findByCityAndTenantName(String city, String tenantName);

        @Query("SELECT e FROM Customer e WHERE LOWER(e.city) LIKE LOWER(CONCAT('%', :city, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Customer> findByCityAndTenantId(String city, String tenantId);
        @Query("SELECT e FROM Customer e WHERE LOWER(e.region) LIKE LOWER(CONCAT('%', :region, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Customer> findByRegionAndCreatedById(String region, String createdById);
        @Query("SELECT e FROM Customer e WHERE LOWER(e.region) LIKE LOWER(CONCAT('%', :region, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Customer> findByRegionAndTenantName(String region, String tenantName);

        @Query("SELECT e FROM Customer e WHERE LOWER(e.region) LIKE LOWER(CONCAT('%', :region, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Customer> findByRegionAndTenantId(String region, String tenantId);
        @Query("SELECT e FROM Customer e WHERE LOWER(e.country) LIKE LOWER(CONCAT('%', :country, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Customer> findByCountryAndCreatedById(String country, String createdById);
        @Query("SELECT e FROM Customer e WHERE LOWER(e.country) LIKE LOWER(CONCAT('%', :country, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Customer> findByCountryAndTenantName(String country, String tenantName);

        @Query("SELECT e FROM Customer e WHERE LOWER(e.country) LIKE LOWER(CONCAT('%', :country, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Customer> findByCountryAndTenantId(String country, String tenantId);
        @Query("SELECT e FROM Customer e WHERE LOWER(e.postalCode) LIKE LOWER(CONCAT('%', :postalCode, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Customer> findByPostalCodeAndCreatedById(String postalCode, String createdById);
        @Query("SELECT e FROM Customer e WHERE LOWER(e.postalCode) LIKE LOWER(CONCAT('%', :postalCode, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Customer> findByPostalCodeAndTenantName(String postalCode, String tenantName);

        @Query("SELECT e FROM Customer e WHERE LOWER(e.postalCode) LIKE LOWER(CONCAT('%', :postalCode, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Customer> findByPostalCodeAndTenantId(String postalCode, String tenantId);
        @Query("""
        SELECT e FROM Customer e
        WHERE e.syncAt >= :#{#syncAt.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.createdBy.id = :createdById
        ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
        """)
         List<Customer> findBySyncAtAndCreatedById(java.time.Instant syncAt, String createdById);

         @Query("""
        SELECT e FROM Customer e
        WHERE e.syncAt >= :#{#syncAt.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.tenant.id = :tenantId
        ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
        """)
         List<Customer> findBySyncAtAndTenantId(java.time.Instant syncAt, String tenantId);


        @Query("SELECT e FROM Customer e WHERE e.isActive = :isActive AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Customer> findByIsActiveAndCreatedById(Boolean isActive, String createdById);
        @Query("SELECT e FROM Customer e WHERE e.isActive = :isActive AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Customer> findByIsActiveAndTenantName(Boolean isActive, String tenantName);

        @Query("SELECT e FROM Customer e WHERE e.isActive = :isActive AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Customer> findByIsActiveAndTenantId(Boolean isActive, String tenantId);
        @Query("SELECT e FROM Customer e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Customer> findByCreatedByIdAndCreatedById(String createdBy, String createdById);
        @Query("SELECT e FROM Customer e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Customer> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

        @Query("SELECT e FROM Customer e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Customer> findByCreatedByIdAndTenantId(String createdBy, String tenantId);
        @Query("SELECT e FROM Customer e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Customer> findByTenantIdAndCreatedById(String tenant, String createdById);
        @Query("SELECT e FROM Customer e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Customer> findByTenantIdAndTenantName(String tenant, String tenantName);

        @Query("SELECT e FROM Customer e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Customer> findByTenantIdAndTenantId(String tenant, String tenantId);




}
