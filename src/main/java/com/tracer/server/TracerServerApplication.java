package com.tracer.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
// CHANGE@171102: inherit the class from SpringBootServletInitializer so it can run on WildFly...
public class TracerServerApplication extends SpringBootServletInitializer {
	
	/**
	 * Do customized configurations by overriding the configure function in 
	 * SpringBootServletInitializer.
	 * @param builder constructs the application
	 * @return result of configApp function.
	 */
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return configApp(builder);
    }
	
	/**
	 * Configures through builder; feel free to add more and/or change other 
	 * settings (see Spring's docs).
	 * @param builder constructs the application
	 * @return builder with settings added.
	 */
	private static SpringApplicationBuilder configApp(SpringApplicationBuilder builder) {
        return builder.sources(TracerServerApplication.class);
    }
	
	public static void main(String[] args) {
		// CHANGE@171103: missed a line... (needed to run as an executable).
		configApp(new SpringApplicationBuilder()).run(args);
	}
}
