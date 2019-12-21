package com.ies.jobportal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ies.jobportal.dao.entity.InterviewEntity;

@Repository
public interface InterviewRepository extends JpaRepository<InterviewEntity, Long>{

	@Query(value = "select * from interview i where i.interviewer in ( select user_id from member where user_id =:userId) " , nativeQuery = true)
	List<InterviewEntity> findInterviewsByUserId(@Param("userId") Long userId);
}
