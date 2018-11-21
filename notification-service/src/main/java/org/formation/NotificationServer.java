package org.formation;

import java.util.Properties;
import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;


/**
 * Run as a micro-service, registering with the Discovery Server (Eureka).
 * <p>
 * Note that the configuration for this application is imported from
 * {@link DocumentsConfiguration}. This is a deliberate separation of concerns.
 * 
 * @author Paul Chapman
 */
@SpringBootApplication
@EnableEurekaClient
public class NotificationServer {


	protected Logger logger = Logger.getLogger(NotificationServer.class.getName());

	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
	public static void main(String[] args) {

		SpringApplication.run(NotificationServer.class, args);
		
	}
	
	@Bean
	public JavaMailSender getJavaMailSender() {
	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//	    mailSender.setHost("smtp.plbformation.com");
//	    mailSender.setPort(587);
	    
	    mailSender.setHost("localhost");
	    mailSender.setPort(26);
	     
	    mailSender.setUsername("stageojen@plbformation.com");
	    mailSender.setPassword("stageojen");
	     
	    Properties props = mailSender.getJavaMailProperties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.debug", "true");
	     
	    return mailSender;
	}
}
