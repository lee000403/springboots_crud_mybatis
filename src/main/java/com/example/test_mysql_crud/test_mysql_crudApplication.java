package com.example.test_mysql_crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan 
@SpringBootApplication
public class test_mysql_crudApplication {

	public static void main(String[] args) {
		SpringApplication.run(test_mysql_crudApplication.class, args);
	}

}
