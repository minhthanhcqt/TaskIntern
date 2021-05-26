package com.hahalolo.api.and.mongodb.component;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GetOTPCode {
	@Value("${number.numberOTP}")
	private int numbercode;
	
	
	public String newCodeOTP() {
		Random rndmmethod = new Random();

		String otpcode = new String();

		for (int i = 0; i <numbercode ; i++) {
			otpcode+= String.valueOf(rndmmethod.nextInt(10));
		}
		return otpcode;
	}

}
