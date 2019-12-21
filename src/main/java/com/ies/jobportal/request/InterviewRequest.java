package com.ies.jobportal.request;

import com.ies.jobportal.pojo.Interview;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InterviewRequest  extends BaseRequest {
	private static final long serialVersionUID = 1L;
	private Interview interview;
}
