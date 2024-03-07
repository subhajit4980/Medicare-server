package com.subhajit.Medicare;

import org.jetbrains.annotations.NotNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.Properties;


@SpringBootApplication
public class MedicareApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MedicareApplication.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(@NotNull SpringApplicationBuilder builder) {
		return builder.sources(MedicareApplication.class).properties(getProperties());
	}

	static Properties getProperties() {
		Properties props = new Properties();
		props.put("spring.config.location", new String[]{"classpath:/application.properties", "file:${catalina.home}/openkm.properties"});
		return props;
	}
}
