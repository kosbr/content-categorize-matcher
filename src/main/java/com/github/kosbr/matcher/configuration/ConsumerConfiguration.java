package com.github.kosbr.matcher.configuration;

import com.github.kosbr.matcher.event.CategorizeEvent;
import com.github.kosbr.matcher.event.CategorizeEventHandler;
import java.util.function.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

@Configuration
public class ConsumerConfiguration {

    @Autowired
    private CategorizeEventHandler handler;

    @Bean
    public Consumer<Message<CategorizeEvent>> matcherChannelStreamFunction() {
        return categorizeEventMessage -> handler.handle(categorizeEventMessage.getPayload());
    }

}
