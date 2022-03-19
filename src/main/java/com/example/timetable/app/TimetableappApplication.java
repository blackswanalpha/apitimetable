package com.example.timetable.app;

//import org.bouncycastle.util.Arrays;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.xml.transform.Source;
import java.util.Arrays;

@SpringBootApplication
public class TimetableappApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimetableappApplication.class, args);
	}






	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsconfiguration = new CorsConfiguration();
		corsconfiguration.setAllowCredentials(true);
		corsconfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsconfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsconfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsconfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration ("/**", corsconfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}
}
