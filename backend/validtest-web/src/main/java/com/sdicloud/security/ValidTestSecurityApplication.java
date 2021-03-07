package com.sdicloud.security;

import com.validtest.shared.domain.Service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(
		includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class),
		value = {"com.validtest"}
)
@EnableJpaRepositories(value = "com.validtest")
@EntityScan(value = "com.validtest")
public class ValidTestSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ValidTestSecurityApplication.class, args);
	}

}
