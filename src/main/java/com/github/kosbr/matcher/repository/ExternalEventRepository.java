package com.github.kosbr.matcher.repository;

import com.github.kosbr.matcher.event.CategorizeResultEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class ExternalEventRepository {

    private final StreamBridge streamBridge;

    @Value("${configuration.result-exchange}")
    private String resultExchange;

    public ExternalEventRepository(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    public void sendResultEvent(CategorizeResultEvent event) {
        streamBridge.send(resultExchange, MessageBuilder.withPayload(event).build());
    }

}
