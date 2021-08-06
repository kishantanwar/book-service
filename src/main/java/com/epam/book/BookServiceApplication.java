package com.epam.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
//@SpringBootApplication(scanBasePackages = "com.epam.book")
//@EnableTransactionManagement
//@EnableJpaRepositories(basePackages="com.epam.book.repositories")

@SpringBootApplication
@EnableJpaAuditing
@EnableAspectJAutoProxy(proxyTargetClass=true)
//@EnableEurekaClient
@ComponentScan
public class BookServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}
}
