package com.github.kosbr.matcher;

import com.github.kosbr.matcher.category.ApplicationProps;
import com.github.kosbr.matcher.event.CategorizeEvent;
import com.github.kosbr.matcher.event.CategorizeResultEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class CategoryMatcher {

    private final static Logger LOG = LoggerFactory.getLogger(CategoryMatcher.class);

    @Autowired
    private ApplicationProps applicationProps;

    private final RedisTemplate<String, String> redisTemplate;

    public CategoryMatcher(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public CategorizeResultEvent handle(CategorizeEvent categorizeEvent) {
        String text = redisTemplate.opsForValue().get(categorizeEvent.getId());
        LOG.info(text);
        LOG.info(applicationProps.getCategories().get(0).toString());
        CategorizeResultEvent resultEvent = new CategorizeResultEvent();
        resultEvent.setId(categorizeEvent.getId());
        resultEvent.setSuccess(false);
        resultEvent.setError("Not implemented");
        return resultEvent;
    }
}
