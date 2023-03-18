package com.github.kosbr.matcher.category;

import java.util.List;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "application")
public class ApplicationProps {

    private List<Category> categories;
}
