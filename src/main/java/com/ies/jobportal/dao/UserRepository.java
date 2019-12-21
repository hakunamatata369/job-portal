package com.ies.jobportal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ies.jobportal.dao.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long>{

	@Query(value = "select * from member m where m.company_id =:companyId " , nativeQuery = true)
	List<UserEntity> findByCompany(@Param("companyId") Long companyId);
}
