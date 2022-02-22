package com.springboot.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import com.cyberark.annotations.ConjurPropertySource;
import com.cyberark.conjur.sdk.ApiException;

@SpringBootApplication
//@ConjurPropertySource({ "jenkins-app/dbUserName", "jenkins-app/web_password" })

@ConjurPropertySource("jenkins-app/dbUserName")
public class ConjurUser implements CommandLineRunner {

	@Autowired
	Environment env;

	@Value("${secretValue}")
	String value;
	
	

	public static void main(String[] args) throws ApiException {

		SpringApplication.run(ConjurUser.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("By Using Standard Spring annotation --> " + value);
	//	System.out.println("By Using environment value ---> "+env.getProperty("secretValue"));

	}

}