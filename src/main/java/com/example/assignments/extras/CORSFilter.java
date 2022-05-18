package com.example.assignments.extras;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

@Configuration
public class CORSFilter implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry)
             {
        corsRegistry.addMapping("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .exposedHeaders("Authorization");
    }

}

