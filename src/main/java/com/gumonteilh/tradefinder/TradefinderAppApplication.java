package com.gumonteilh.tradefinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class TradefinderAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradefinderAppApplication.class, args);
	}

}
