package com.springboot.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import com.cyberark.annotations.ConjurPropertySource;
import com.cyberark.conjur.sdk.ApiException;

@SpringBootApplication
//@ConjurPropertySource(value={"jenkins-app", "jenkins-app"})

@ConjurPropertySource("jenkins-app")
public class ConjurUser implements CommandLineRunner {

	private static Logger logger = LoggerFactory.getLogger(ConjurPropertySource.class);

	@Autowired
	Environment env;

	@Value("${secretValue}")
	String value;
	
	@Value("${secretVal}")
	String pass;
	

	public static void main(String[] args) throws ApiException {

		SpringApplication.run(ConjurUser.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("By Using Standard Spring annotation --> " + value +" "+pass);
	//	logger.info("By Using environment value ---> "+env.getProperty("secretValue"));

	}

}