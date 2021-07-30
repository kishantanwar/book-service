package com.epam.book.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RefreshScope
@RestController
@RequestMapping("/health")
@Api(value = "Health Api Check")
public class HealthCheckController {

	@Value("${health.check.message}")
	private String healthCheckMesssage;

	@GetMapping
	public String healthCheck() {
		return healthCheckMesssage;
	}
}