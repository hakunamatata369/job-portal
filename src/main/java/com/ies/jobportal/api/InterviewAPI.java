package com.ies.jobportal.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ies.jobportal.exceptions.InterviewException;
import com.ies.jobportal.exceptions.InterviewIdNotFoundException;
import com.ies.jobportal.request.InterviewRequest;
import com.ies.jobportal.response.InterviewResponse;
import com.ies.jobportal.service.InterviewService;

@RestController
@RequestMapping("/interviews")
public class InterviewAPI {

	@Autowired
	private InterviewService interviewService;
	
	@GetMapping
	public ResponseEntity<InterviewResponse> findAllInterviews(/*@RequestHeader(name = "auth-token") String token*/) throws InterviewException {
		InterviewResponse response =  interviewService.findAllInterviews("token");
		return ResponseEntity.ok(response);
	}
	
	@PostMapping
	public ResponseEntity<InterviewResponse> createOrUpdateInterview(@RequestBody InterviewRequest request) throws InterviewException {
		
		InterviewResponse response = interviewService.createOrUpdateInterview(request);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/{jobId}")
	public ResponseEntity<InterviewResponse> getInterviewById(@PathVariable("id") Long interviewId) throws InterviewException, InterviewIdNotFoundException {
		InterviewResponse response = interviewService.getInterviewById(interviewId);
		return ResponseEntity.ok(response);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<InterviewResponse> deleteInterview(@PathVariable("id") Long interviewId) throws InterviewException, InterviewIdNotFoundException {
		InterviewResponse response = interviewService.deleteInterview(interviewId);
		return ResponseEntity.ok(response);
	}
}
