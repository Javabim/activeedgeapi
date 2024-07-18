package com.activeedge.activeedge_exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ActiveedgeExerciseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActiveedgeExerciseApplication.class, args);
	}

}
