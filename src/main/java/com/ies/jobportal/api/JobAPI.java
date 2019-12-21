package com.ies.jobportal.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ies.jobportal.exceptions.CompanyException;
import com.ies.jobportal.exceptions.JobException;
import com.ies.jobportal.exceptions.JobIdNotFoundException;
import com.ies.jobportal.exceptions.UserException;
import com.ies.jobportal.pojo.Job;
import com.ies.jobportal.request.JobRequest;
import com.ies.jobportal.response.JobResponse;
import com.ies.jobportal.service.JobService;

@RestController
@RequestMapping("/jobs")
public class JobAPI {
	
	@Autowired
	private JobService jobService;
	
	@GetMapping
	public ResponseEntity<List<Job>> findAllJobs(/*@RequestHeader(name = "auth-token") String token*/) throws JobException {
		JobResponse response = jobService.findJobsByCompany("token");
		return ResponseEntity.ok(response.getJobList());
	}
	
	@GetMapping("/test")
	public ResponseEntity<JobResponse> test() throws JobException, JobIdNotFoundException {
		JobResponse response = jobService.test();
		return ResponseEntity.ok(response);

	}
	
	@PostMapping
	public ResponseEntity<JobResponse> createOrUpdateJob(@RequestHeader(name = "auth-token") String token,@RequestBody JobRequest jobRequest) throws JobException, UserException, CompanyException {
		
		JobResponse response = jobService.createOrUpdateJob(jobRequest,token);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/{jobId}")
	public ResponseEntity<JobResponse> getJobById(@PathVariable("jobId") Long jobId) throws JobException, JobIdNotFoundException {
		JobResponse response = jobService.getJobById(jobId);
		return ResponseEntity.ok(response);

	}

	@DeleteMapping("/{jobId}")
	public ResponseEntity<JobResponse> deleteJob(@PathVariable("jobId") Long jobId) throws JobException, JobIdNotFoundException {
		JobResponse response = jobService.deleteJob(jobId);
		return ResponseEntity.ok(response);
	}
}
