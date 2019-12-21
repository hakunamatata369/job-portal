package com.ies.jobportal.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Message {

	private String message;
	 private String code;
	 private Integer status;
	 
	 public Message(String message,String code, Integer status){
		  this.message=message;
		  this.code=code;
		  this.status=status;
	 }
}
