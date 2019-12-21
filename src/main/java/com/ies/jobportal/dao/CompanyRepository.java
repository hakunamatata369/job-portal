package com.ies.jobportal.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ies.jobportal.dao.entity.CompanyEntity;
import com.ies.jobportal.enums.Status;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Long>{

	List<CompanyEntity> findAll();
	
	@Modifying
	@Query(value = "UPDATE company SET status = :status, updated_date = :date WHERE company_id = :companyId" , nativeQuery=true)
	int deleteCompany(@Param("companyId") Long companyId, @Param("status") Status status,
			@Param("date") LocalDateTime date);
}
