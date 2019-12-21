package com.ies.jobportal.response;

import java.util.ArrayList;
import java.util.List;

import com.ies.jobportal.pojo.Interview;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class InterviewResponse extends BaseResponse {

	private static final long serialVersionUID = 1L;
	private List<Interview> interviewList;
	
	public InterviewResponse() {
		interviewList = new ArrayList<Interview>();
	}
	
	public void addInterview(Interview interview){
		interviewList.add(interview);
	}
}
