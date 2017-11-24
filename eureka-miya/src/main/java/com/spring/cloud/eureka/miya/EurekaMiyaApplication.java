package com.spring.cloud.eureka.miya;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaMiyaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaMiyaApplication.class, args);
	}

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@RequestMapping(value = "miya")
	public String miya() {
		return restTemplate.getForObject("http://SERVICE-HI/info", String.class);
	}

	@RequestMapping(value = "/info")
	public String info() {
		return "miya info";
	}
}
