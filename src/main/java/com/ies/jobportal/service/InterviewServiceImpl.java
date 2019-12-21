package com.ies.jobportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.ies.jobportal.config.AuthGetInfoByToken;
import com.ies.jobportal.dao.InterviewRepository;
import com.ies.jobportal.dao.entity.InterviewEntity;
import com.ies.jobportal.dao.entity.JobEntity;
import com.ies.jobportal.dao.entity.UserEntity;
import com.ies.jobportal.exceptions.InterviewException;
import com.ies.jobportal.exceptions.InterviewIdNotFoundException;
import com.ies.jobportal.pojo.Candidate;
import com.ies.jobportal.pojo.Interview;
import com.ies.jobportal.pojo.Job;
import com.ies.jobportal.pojo.User;
import com.ies.jobportal.pojo.UserInfo;
import com.ies.jobportal.request.InterviewRequest;
import com.ies.jobportal.response.InterviewResponse;

@Service
public class InterviewServiceImpl implements InterviewService {

	@Autowired
	private InterviewRepository interviewRepository;

	@Autowired
	private ConversionService conversionService;

	@Autowired
	private AuthGetInfoByToken getUserInfo;
	
	@Override
	public InterviewResponse findAllInterviews(String token) throws InterviewException {
		UserInfo tokenInfo = getUserInfo.getTokenInfo(token);
		
		List<InterviewEntity> interviewEntities = interviewRepository
				.findInterviewsByUserId(tokenInfo.getUserId());
		
		InterviewResponse response = new InterviewResponse();
		for(InterviewEntity interviewEntity : interviewEntities) {
			Interview interview = conversionService.convert(interviewEntity, Interview.class);
			interview.setCandidate(conversionService.convert(interviewEntity.getCandidate(), Candidate.class));
			interview.setJob(conversionService.convert(interviewEntity.getJob(), Job.class));
			interview.setInterviewer(conversionService.convert(interviewEntity.getInterviewer(), User.class));
			response.addInterview(interview);
		}
		
		return response;
	}

	@Override
	public InterviewResponse createOrUpdateInterview(InterviewRequest request) throws InterviewException {
		
		if (null == request || null == request.getInterview())
			throw new InterviewException("Interview details can't be null");
		
		if( request.getInterview().getJob() == null || request.getInterview().getJob().getJobId() == null)
			throw new InterviewException("Job details cant be empty");
		
		InterviewEntity interviewEntity = conversionService.convert(request.getInterview(), InterviewEntity.class);
		interviewEntity.setJob(conversionService.convert(request.getInterview().getJob(), JobEntity.class));
		interviewEntity.setInterviewer(conversionService.convert(request.getInterview().getInterviewer(), UserEntity.class));
		
		InterviewEntity retrievedInterviewEntity = interviewRepository.saveAndFlush(interviewEntity);	
		Interview interview = conversionService.convert(retrievedInterviewEntity, Interview.class);
		
		InterviewResponse response = new InterviewResponse();
		response.addInterview(interview);
		
		return response;
	}


	@Override
	public InterviewResponse deleteInterview(Long interviewId) throws InterviewException, InterviewIdNotFoundException {
		
		if (null == interviewId)
			throw new InterviewException("Interview details can't be null");
		
		if (!interviewRepository.existsById(interviewId))
			throw new InterviewIdNotFoundException();
		
		InterviewResponse response = new InterviewResponse();
		response.setMessage("Interview Removed");
		return response;
	}

	@Override
	public InterviewResponse getInterviewById(Long interviewId) {
		InterviewEntity retrievedInterviewEntity = interviewRepository.getOne(interviewId);	
		Interview interview = conversionService.convert(retrievedInterviewEntity, Interview.class);
		
		InterviewResponse response = new InterviewResponse();
		response.addInterview(interview);
		return response;
	}

}
