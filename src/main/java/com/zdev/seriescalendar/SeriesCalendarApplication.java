package com.zdev.seriescalendar;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class SeriesCalendarApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SeriesCalendarApplication.class, args);
		String encoded = new BCryptPasswordEncoder().encode("admin");
		System.out.println(encoded);
		
	}
	


}
