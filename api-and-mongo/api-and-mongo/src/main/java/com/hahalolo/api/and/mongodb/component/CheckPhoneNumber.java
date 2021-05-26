package com.hahalolo.api.and.mongodb.component;

import org.springframework.stereotype.Component;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber.CountryCodeSource;

@Component 
public class CheckPhoneNumber {
	
	public Boolean checkIsValidNumber(String codeCountry, String phoneNumber)
	{
		PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
			PhoneNumber phone;
			try {
				phone = phoneNumberUtil.parse("+"+phoneNumber, 
					      CountryCodeSource.UNSPECIFIED.name());
				return phoneNumberUtil.isValidNumberForRegion(phone,codeCountry);
			} catch (NumberParseException e) {
				e.printStackTrace();
			}
			return false;
	}
}
