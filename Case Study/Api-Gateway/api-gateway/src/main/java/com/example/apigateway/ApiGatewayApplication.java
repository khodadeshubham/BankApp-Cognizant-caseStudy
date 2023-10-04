package com.example.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
//	
//	    @Bean
//	    public CorsWebFilter corsWebFilter() {
//	        CorsConfiguration corsConfig = new CorsConfiguration();
//	        corsConfig.addAllowedOrigin("http://localhost:3000/"); // Replace with your React app's origin
//	        corsConfig.addAllowedHeader("*");
//	        corsConfig.addAllowedMethod(HttpMethod.GET);
//	        corsConfig.addAllowedMethod(HttpMethod.POST);
//	        corsConfig.addAllowedMethod(HttpMethod.PUT);
//	        corsConfig.addAllowedMethod(HttpMethod.DELETE);
//
//	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//	        source.registerCorsConfiguration("/**", corsConfig);
//
//	        return new CorsWebFilter(source);
//	    }

}
