package org.learn;

import java.util.Properties;

import javax.mail.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		System.setProperty("java.net.useSystemProxies", "true");
		SpringApplication.run(Application.class, args);
	}
	
	@Bean("emailSession")
	public Session emailSession() {
		Properties properties = new Properties();
		properties.put("mail.starttls.enable", true);
		properties.put("mail.imap.starttls.enable", true);
		properties.put("mail.imap.ssl.enable", true);

		return Session.getDefaultInstance(properties);
	}
	
}