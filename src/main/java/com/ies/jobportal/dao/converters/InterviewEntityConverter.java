package com.ies.jobportal.dao.converters;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ies.jobportal.dao.entity.InterviewEntity;
import com.ies.jobportal.pojo.Interview;

@Component
@ConfigurationPropertiesBinding
public class InterviewEntityConverter implements Converter<InterviewEntity, Interview> {

	@Override
	public Interview convert(InterviewEntity interviewEntity) {
		Interview interview = Interview.builder().interviewId(interviewEntity.getInterviewId())
				.roundStatus(interviewEntity.getRoundStatus()).roundStatus(interviewEntity.getRoundStatus())
				.round(interviewEntity.getRound()).roundOverallRating(interviewEntity.getRoundOverallRating())
				.roundComments(interviewEntity.getRoundComments()).scheduledDate(interviewEntity.getScheduledDate())
				.build();
		return interview;
	}

}
