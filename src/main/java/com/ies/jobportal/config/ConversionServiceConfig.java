package com.ies.jobportal.config;

import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterRegistry;

@Configuration
public class ConversionServiceConfig {

	@Autowired
	private Set<Converter> converters;

	@Autowired
	private ConversionService conversionService;

	@PostConstruct
	void initConverters() {
		ConverterRegistry registry = (ConverterRegistry) conversionService;
		converters.stream().forEach(converter -> {
			registry.addConverter(converter);
		});
	}
}