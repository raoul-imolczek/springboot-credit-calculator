package eu.eisti.p2k19.fintech.springboot.demoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages={"eu.eisti.p2k19.fintech.springboot"})
@EntityScan(basePackages={"eu.eisti.p2k19.fintech.springboot"})
@EnableJpaRepositories(basePackages={"eu.eisti.p2k19.fintech.springboot"})
@SpringBootApplication
public class DemoappApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoappApplication.class, args);
	}
}
