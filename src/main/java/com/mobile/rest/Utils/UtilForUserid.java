package com.mobile.rest.Utils;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class UtilForUserid {

	private final Random Random=new SecureRandom();
	
	private final String Alphabet="01234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz";
	
	public String generate(int length)
	{
		return generateRandom(length);
	}
	public String generateRandom(int length)
	{
		StringBuffer result=new StringBuffer();
		for(int i=0;i<length;i++)
		{
			result.append(Alphabet.charAt(Random.nextInt(Alphabet.length())));
		}
		return result.toString();
	}
}
