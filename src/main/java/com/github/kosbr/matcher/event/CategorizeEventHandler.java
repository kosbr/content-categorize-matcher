package com.github.kosbr.matcher.event;

import com.github.kosbr.matcher.CategoryMatcher;
import com.github.kosbr.matcher.repository.ExternalEventRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CategorizeEventHandler {

    private final static Logger LOG = LoggerFactory.getLogger(CategorizeEventHandler.class);

    private final CategoryMatcher matcher;

    private final ExternalEventRepository externalEventRepository;

    public void handle(CategorizeEvent categorizeEvent) {
        LOG.info("Handle event " + categorizeEvent);
        CategorizeResultEvent resultEvent = matcher.match(categorizeEvent);
        LOG.info("Handled event " + resultEvent);
        externalEventRepository.sendResultEvent(resultEvent);
    }

}
