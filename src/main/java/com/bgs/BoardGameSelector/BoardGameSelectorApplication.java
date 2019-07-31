package com.bgs.BoardGameSelector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@SpringBootApplication
public class BoardGameSelectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardGameSelectorApplication.class, args);
	}

}
