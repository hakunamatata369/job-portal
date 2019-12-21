package com.ies.jobportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.ies.jobportal.config.AuthGetInfoByToken;
import com.ies.jobportal.dao.CompanyRepository;
import com.ies.jobportal.dao.JobRepository;
import com.ies.jobportal.dao.UserRepository;
import com.ies.jobportal.dao.entity.CompanyEntity;
import com.ies.jobportal.dao.entity.JobEntity;
import com.ies.jobportal.dao.entity.UserEntity;
import com.ies.jobportal.exceptions.CompanyException;
import com.ies.jobportal.exceptions.JobException;
import com.ies.jobportal.exceptions.JobIdNotFoundException;
import com.ies.jobportal.exceptions.UserException;
import com.ies.jobportal.pojo.Company;
import com.ies.jobportal.pojo.Job;
import com.ies.jobportal.pojo.User;
import com.ies.jobportal.pojo.UserInfo;
import com.ies.jobportal.request.JobRequest;
import com.ies.jobportal.response.JobResponse;

@Service
public class JobServiceImpl implements JobService {

	@Autowired
	private JobRepository jobRepository;
	
	@Autowired
	private CompanyRepository CompanyRepository;
	
	@Autowired
	private UserRepository UserRepository;

	@Autowired
	private ConversionService conversionService;
	
	@Autowired
	private AuthGetInfoByToken getUserInfo;
	
	@Override
	public JobResponse findJobsByCompany(String token) {
		UserInfo tokenInfo = getUserInfo.getTokenInfo(token);
		
		List<JobEntity> jobEntities = jobRepository.findByCompany(tokenInfo.getCompanyId());
		JobResponse response = new JobResponse();
		
		for(JobEntity jobEntity : jobEntities) {
			Job job = conversionService.convert(jobEntity, Job.class);
			job.setHiringManager(conversionService.convert(jobEntity.getHiringManager(), User.class));
			job.setRecruiter(conversionService.convert(jobEntity.getRecruiter(), User.class));
			job.setCompany(conversionService.convert(jobEntity.getCompany(), Company.class));
			response.addJob(job);
		}
		return response;
	}

	@Override
	public JobResponse createOrUpdateJob(JobRequest request, String token) throws JobException, UserException, CompanyException {
		if (null == request || null == request.getJob() )
			throw new JobException("Job can't be null");
		
		if( request.getJob().getCompany() == null)
			throw new CompanyException();
		
		if( request.getJob().getRecruiter() == null)
			throw new UserException("Recruiter not found");
		
		JobEntity jobEntity = conversionService.convert(request.getJob(), JobEntity.class);
		jobEntity.setCompany(conversionService.convert(request.getJob().getCompany(),CompanyEntity.class));
		jobEntity.setRecruiter(conversionService.convert(request.getJob().getRecruiter(), UserEntity.class));
		
		JobEntity retrievedJobEntity = jobRepository
				.saveAndFlush(jobEntity);

		Job job = conversionService.convert(retrievedJobEntity, Job.class);

		JobResponse response = new JobResponse();
		response.addJob(job);
		return response;
	}

	@Override
	public JobResponse deleteJob(Long jobId) throws JobException, JobIdNotFoundException {
		if (null == jobId)
			throw new JobException("Job id can't be null");

		if (!jobRepository.existsById(jobId))
			throw new JobIdNotFoundException("No Job Exists to delete");

		jobRepository.deleteById(jobId);//;deleteJob(jobId, Status.DELETED, LocalDateTime.now());

		JobResponse response = new JobResponse();
		return response;
	}

	@Override
	public JobResponse getJobById(Long jobId) {
		JobEntity retrievedJobEntity = jobRepository.getOne(jobId);
		Job job = conversionService.convert(retrievedJobEntity, Job.class);
		
		JobResponse response = new JobResponse();
		response.addJob(job);
		
		return response;
	}

	@Override
	public JobResponse test() {
		CompanyEntity c1 = CompanyRepository.getOne(2L);
		
		UserEntity hiringManager = UserRepository.getOne(4L);
		
		UserEntity recruiter = UserRepository.getOne(4L);
		
		for(int i=4;i<=100;i++){
			JobEntity jobEntity = new JobEntity();
			jobEntity.setCompany(c1);
			jobEntity.setHiringManager(hiringManager);
			jobEntity.setExperience(5);
			jobEntity.setJobTitle("Engineer"+i);
			jobEntity.setJobDescription("Description for engineer"+i);
			jobEntity.setJobLocation("Hyderabad");
			jobEntity.setRecruiter(recruiter);
			jobEntity.setJobStatus("NEW");
			jobRepository
			.saveAndFlush(jobEntity);

		}
		return null;
	}

}
