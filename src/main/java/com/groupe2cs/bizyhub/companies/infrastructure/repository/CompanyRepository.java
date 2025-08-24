package com.groupe2cs.bizyhub.companies.infrastructure.repository;

	import com.groupe2cs.bizyhub.companies.infrastructure.entity.Company;
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
public interface CompanyRepository extends JpaRepository<Company, String> {

	@Query("SELECT e FROM Company e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC limit 1 ")
	Optional<Company> findByIdAndCreatedById(String id, String createdById);
	@Query("SELECT e FROM Company e WHERE e.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	List<Company> findByIdAndTenantId(String id, String tenantId);

    @Query("SELECT e FROM Company e WHERE e.createdBy.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<Company> findByCreatedById(String createdById, Pageable pageable);

	@Query("SELECT e FROM Company e WHERE e.tenant.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<Company> findAllByTenantId(String tenantId, Pageable pageable);

        @Query("SELECT e FROM Company e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Company> findByRemoteIdAndCreatedById(String remoteId, String createdById);
        @Query("SELECT e FROM Company e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Company> findByRemoteIdAndTenantName(String remoteId, String tenantName);

        @Query("SELECT e FROM Company e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Company> findByRemoteIdAndTenantId(String remoteId, String tenantId);
        @Query("SELECT e FROM Company e WHERE LOWER(e.localId) LIKE LOWER(CONCAT('%', :localId, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Company> findByLocalIdAndCreatedById(String localId, String createdById);
        @Query("SELECT e FROM Company e WHERE LOWER(e.localId) LIKE LOWER(CONCAT('%', :localId, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Company> findByLocalIdAndTenantName(String localId, String tenantName);

        @Query("SELECT e FROM Company e WHERE LOWER(e.localId) LIKE LOWER(CONCAT('%', :localId, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Company> findByLocalIdAndTenantId(String localId, String tenantId);
        @Query("SELECT e FROM Company e WHERE LOWER(e.code) LIKE LOWER(CONCAT('%', :code, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Company> findByCodeAndCreatedById(String code, String createdById);
        @Query("SELECT e FROM Company e WHERE LOWER(e.code) LIKE LOWER(CONCAT('%', :code, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Company> findByCodeAndTenantName(String code, String tenantName);

        @Query("SELECT e FROM Company e WHERE LOWER(e.code) LIKE LOWER(CONCAT('%', :code, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Company> findByCodeAndTenantId(String code, String tenantId);
        @Query("SELECT e FROM Company e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Company> findByNameAndCreatedById(String name, String createdById);
        @Query("SELECT e FROM Company e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Company> findByNameAndTenantName(String name, String tenantName);

        @Query("SELECT e FROM Company e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Company> findByNameAndTenantId(String name, String tenantId);
        @Query("SELECT e FROM Company e WHERE LOWER(e.description) LIKE LOWER(CONCAT('%', :description, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Company> findByDescriptionAndCreatedById(String description, String createdById);
        @Query("SELECT e FROM Company e WHERE LOWER(e.description) LIKE LOWER(CONCAT('%', :description, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Company> findByDescriptionAndTenantName(String description, String tenantName);

        @Query("SELECT e FROM Company e WHERE LOWER(e.description) LIKE LOWER(CONCAT('%', :description, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Company> findByDescriptionAndTenantId(String description, String tenantId);
        @Query("SELECT e FROM Company e WHERE LOWER(e.phone) LIKE LOWER(CONCAT('%', :phone, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Company> findByPhoneAndCreatedById(String phone, String createdById);
        @Query("SELECT e FROM Company e WHERE LOWER(e.phone) LIKE LOWER(CONCAT('%', :phone, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Company> findByPhoneAndTenantName(String phone, String tenantName);

        @Query("SELECT e FROM Company e WHERE LOWER(e.phone) LIKE LOWER(CONCAT('%', :phone, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Company> findByPhoneAndTenantId(String phone, String tenantId);
        @Query("SELECT e FROM Company e WHERE LOWER(e.email) LIKE LOWER(CONCAT('%', :email, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Company> findByEmailAndCreatedById(String email, String createdById);
        @Query("SELECT e FROM Company e WHERE LOWER(e.email) LIKE LOWER(CONCAT('%', :email, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Company> findByEmailAndTenantName(String email, String tenantName);

        @Query("SELECT e FROM Company e WHERE LOWER(e.email) LIKE LOWER(CONCAT('%', :email, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Company> findByEmailAndTenantId(String email, String tenantId);
        @Query("SELECT e FROM Company e WHERE LOWER(e.website) LIKE LOWER(CONCAT('%', :website, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Company> findByWebsiteAndCreatedById(String website, String createdById);
        @Query("SELECT e FROM Company e WHERE LOWER(e.website) LIKE LOWER(CONCAT('%', :website, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Company> findByWebsiteAndTenantName(String website, String tenantName);

        @Query("SELECT e FROM Company e WHERE LOWER(e.website) LIKE LOWER(CONCAT('%', :website, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Company> findByWebsiteAndTenantId(String website, String tenantId);
        @Query("SELECT e FROM Company e WHERE LOWER(e.taxId) LIKE LOWER(CONCAT('%', :taxId, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Company> findByTaxIdAndCreatedById(String taxId, String createdById);
        @Query("SELECT e FROM Company e WHERE LOWER(e.taxId) LIKE LOWER(CONCAT('%', :taxId, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Company> findByTaxIdAndTenantName(String taxId, String tenantName);

        @Query("SELECT e FROM Company e WHERE LOWER(e.taxId) LIKE LOWER(CONCAT('%', :taxId, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Company> findByTaxIdAndTenantId(String taxId, String tenantId);
        @Query("SELECT e FROM Company e WHERE LOWER(e.currency) LIKE LOWER(CONCAT('%', :currency, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Company> findByCurrencyAndCreatedById(String currency, String createdById);
        @Query("SELECT e FROM Company e WHERE LOWER(e.currency) LIKE LOWER(CONCAT('%', :currency, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Company> findByCurrencyAndTenantName(String currency, String tenantName);

        @Query("SELECT e FROM Company e WHERE LOWER(e.currency) LIKE LOWER(CONCAT('%', :currency, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Company> findByCurrencyAndTenantId(String currency, String tenantId);
        @Query("SELECT e FROM Company e WHERE LOWER(e.addressLine1) LIKE LOWER(CONCAT('%', :addressLine1, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Company> findByAddressLine1AndCreatedById(String addressLine1, String createdById);
        @Query("SELECT e FROM Company e WHERE LOWER(e.addressLine1) LIKE LOWER(CONCAT('%', :addressLine1, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Company> findByAddressLine1AndTenantName(String addressLine1, String tenantName);

        @Query("SELECT e FROM Company e WHERE LOWER(e.addressLine1) LIKE LOWER(CONCAT('%', :addressLine1, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Company> findByAddressLine1AndTenantId(String addressLine1, String tenantId);
        @Query("SELECT e FROM Company e WHERE LOWER(e.addressLine2) LIKE LOWER(CONCAT('%', :addressLine2, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Company> findByAddressLine2AndCreatedById(String addressLine2, String createdById);
        @Query("SELECT e FROM Company e WHERE LOWER(e.addressLine2) LIKE LOWER(CONCAT('%', :addressLine2, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Company> findByAddressLine2AndTenantName(String addressLine2, String tenantName);

        @Query("SELECT e FROM Company e WHERE LOWER(e.addressLine2) LIKE LOWER(CONCAT('%', :addressLine2, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Company> findByAddressLine2AndTenantId(String addressLine2, String tenantId);
        @Query("SELECT e FROM Company e WHERE LOWER(e.city) LIKE LOWER(CONCAT('%', :city, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Company> findByCityAndCreatedById(String city, String createdById);
        @Query("SELECT e FROM Company e WHERE LOWER(e.city) LIKE LOWER(CONCAT('%', :city, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Company> findByCityAndTenantName(String city, String tenantName);

        @Query("SELECT e FROM Company e WHERE LOWER(e.city) LIKE LOWER(CONCAT('%', :city, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Company> findByCityAndTenantId(String city, String tenantId);
        @Query("SELECT e FROM Company e WHERE LOWER(e.region) LIKE LOWER(CONCAT('%', :region, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Company> findByRegionAndCreatedById(String region, String createdById);
        @Query("SELECT e FROM Company e WHERE LOWER(e.region) LIKE LOWER(CONCAT('%', :region, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Company> findByRegionAndTenantName(String region, String tenantName);

        @Query("SELECT e FROM Company e WHERE LOWER(e.region) LIKE LOWER(CONCAT('%', :region, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Company> findByRegionAndTenantId(String region, String tenantId);
        @Query("SELECT e FROM Company e WHERE LOWER(e.country) LIKE LOWER(CONCAT('%', :country, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Company> findByCountryAndCreatedById(String country, String createdById);
        @Query("SELECT e FROM Company e WHERE LOWER(e.country) LIKE LOWER(CONCAT('%', :country, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Company> findByCountryAndTenantName(String country, String tenantName);

        @Query("SELECT e FROM Company e WHERE LOWER(e.country) LIKE LOWER(CONCAT('%', :country, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Company> findByCountryAndTenantId(String country, String tenantId);
        @Query("SELECT e FROM Company e WHERE LOWER(e.postalCode) LIKE LOWER(CONCAT('%', :postalCode, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Company> findByPostalCodeAndCreatedById(String postalCode, String createdById);
        @Query("SELECT e FROM Company e WHERE LOWER(e.postalCode) LIKE LOWER(CONCAT('%', :postalCode, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Company> findByPostalCodeAndTenantName(String postalCode, String tenantName);

        @Query("SELECT e FROM Company e WHERE LOWER(e.postalCode) LIKE LOWER(CONCAT('%', :postalCode, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Company> findByPostalCodeAndTenantId(String postalCode, String tenantId);
        @Query("SELECT e FROM Company e WHERE e.isActive = :isActive AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Company> findByIsActiveAndCreatedById(Boolean isActive, String createdById);
        @Query("SELECT e FROM Company e WHERE e.isActive = :isActive AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Company> findByIsActiveAndTenantName(Boolean isActive, String tenantName);

        @Query("SELECT e FROM Company e WHERE e.isActive = :isActive AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Company> findByIsActiveAndTenantId(Boolean isActive, String tenantId);
        @Query("""
        SELECT e FROM Company e
        WHERE e.syncAt >= :#{#syncAt.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.createdBy.id = :createdById
        ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
        """)
         List<Company> findBySyncAtAndCreatedById(java.time.Instant syncAt, String createdById);

         @Query("""
        SELECT e FROM Company e
        WHERE e.syncAt >= :#{#syncAt.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.tenant.id = :tenantId
        ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
        """)
         List<Company> findBySyncAtAndTenantId(java.time.Instant syncAt, String tenantId);


        @Query("SELECT e FROM Company e WHERE e.isDefault = :isDefault AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Company> findByIsDefaultAndCreatedById(Boolean isDefault, String createdById);
        @Query("SELECT e FROM Company e WHERE e.isDefault = :isDefault AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Company> findByIsDefaultAndTenantName(Boolean isDefault, String tenantName);

        @Query("SELECT e FROM Company e WHERE e.isDefault = :isDefault AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Company> findByIsDefaultAndTenantId(Boolean isDefault, String tenantId);
        @Query("SELECT e FROM Company e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Company> findByCreatedByIdAndCreatedById(String createdBy, String createdById);
        @Query("SELECT e FROM Company e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Company> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

        @Query("SELECT e FROM Company e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Company> findByCreatedByIdAndTenantId(String createdBy, String tenantId);
        @Query("SELECT e FROM Company e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Company> findByTenantIdAndCreatedById(String tenant, String createdById);
        @Query("SELECT e FROM Company e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Company> findByTenantIdAndTenantName(String tenant, String tenantName);

        @Query("SELECT e FROM Company e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Company> findByTenantIdAndTenantId(String tenant, String tenantId);




}
