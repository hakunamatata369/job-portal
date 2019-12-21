package com.ies.jobportal.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ies.jobportal.dao.entity.JobEntity;
import com.ies.jobportal.enums.Status;

@Repository
public interface JobRepository extends JpaRepository<JobEntity, Long>{

	@Query(value = "select * from job j where j.company_id =:companyId " , nativeQuery = true)
	List<JobEntity> findByCompany(@Param("companyId") Long companyId);
	
	@Modifying
	@Query(value = "UPDATE job SET status = :status,updated_date = :date WHERE job_id = :jobId " , nativeQuery = true)
	int deleteJob(@Param("jobId") Long jobId, @Param("status") Status status,
			@Param("date") LocalDateTime date);
}