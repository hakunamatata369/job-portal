package com.ies.jobportal.response;

import java.util.ArrayList;
import java.util.List;

import com.ies.jobportal.pojo.Job;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class JobResponse {

	private List<Job> jobList;
	
	public JobResponse() {
		jobList = new ArrayList<Job>();
	}
	
	public void addJob(Job job){
		jobList.add(job);
	}
}
