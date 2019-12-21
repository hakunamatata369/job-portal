package com.ies.jobportal.service;

import com.ies.jobportal.exceptions.InterviewException;
import com.ies.jobportal.exceptions.InterviewIdNotFoundException;
import com.ies.jobportal.request.InterviewRequest;
import com.ies.jobportal.response.InterviewResponse;

public interface InterviewService {

	InterviewResponse findAllInterviews(String token) throws InterviewException;

	InterviewResponse createOrUpdateInterview(InterviewRequest request) throws InterviewException;

	InterviewResponse deleteInterview(Long interviewId) throws InterviewException, InterviewIdNotFoundException;

	InterviewResponse getInterviewById(Long jobId);
}
