package com.ies.jobportal.dao.converters;

import org.springframework.core.convert.converter.Converter;

import com.ies.jobportal.dao.entity.InterviewEntity;
import com.ies.jobportal.pojo.Interview;

public class InterviewToEntityConverter implements Converter<Interview, InterviewEntity> {

	@Override
	public InterviewEntity convert(Interview interview) {
		InterviewEntity interviewEntity = InterviewEntity.builder().interviewId(interview.getInterviewId())
				.roundStatus(interview.getRoundStatus()).roundStatus(interview.getRoundStatus())
				.round(interview.getRound()).roundOverallRating(interview.getRoundOverallRating())
				.roundComments(interview.getRoundComments()).scheduledDate(interview.getScheduledDate()).build();
		
		return interviewEntity;
	}
}
