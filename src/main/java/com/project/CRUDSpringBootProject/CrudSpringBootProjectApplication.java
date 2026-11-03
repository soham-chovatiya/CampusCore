package com.project.CRUDSpringBootProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class} /* ignore all dependencies file path  */)
public class CrudSpringBootProjectApplication {

	public static void main(String[] args) {

        SpringApplication.run(CrudSpringBootProjectApplication.class, args);
        System.out.println("Hello World");

    }
}
