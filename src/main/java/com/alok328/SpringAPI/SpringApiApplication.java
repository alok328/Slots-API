package com.alok328.SpringAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@SpringBootApplication
public class SpringApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringApiApplication.class, args);

		LocalDateTime s1 = LocalDateTime.of(LocalDate.of(2020, 8, 23), LocalTime.of(8,0));
		LocalDateTime e1 = LocalDateTime.of(LocalDate.of(2020, 8, 23), LocalTime.of(9,30));
		LocalDateTime s2 = LocalDateTime.of(LocalDate.of(2020, 8, 24), LocalTime.of(9,0));
		LocalDateTime e2 = LocalDateTime.of(LocalDate.of(2020, 8, 24), LocalTime.of(11,0));
		System.out.println(s1.isBefore(e2) && s2.isBefore(e1));

	}

}
