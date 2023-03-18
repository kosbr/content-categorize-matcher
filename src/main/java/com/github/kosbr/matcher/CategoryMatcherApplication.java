package com.github.kosbr.matcher;

import com.github.kosbr.matcher.category.ApplicationProps;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.github.kosbr.matcher")
@EnableConfigurationProperties(value = ApplicationProps.class)
public class CategoryMatcherApplication {
}
