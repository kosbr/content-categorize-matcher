package com.github.kosbr.matcher.configuration;

import com.github.kosbr.matcher.CategoryMatcher;
import com.github.kosbr.matcher.event.CategorizeEvent;
import java.util.function.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

@Configuration
public class ConsumerConfiguration {

    @Autowired
    private CategoryMatcher matcher;

    @Bean
    public Consumer<Message<CategorizeEvent>> matcherChannelStreamFunction() {
        return categorizeEventMessage -> matcher.handle(categorizeEventMessage.getPayload());
    }

}
