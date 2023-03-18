package com.github.kosbr.matcher;

import com.github.kosbr.matcher.category.ApplicationProps;
import com.github.kosbr.matcher.event.CategorizeEvent;
import com.github.kosbr.matcher.event.CategorizeResultEvent;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class CategoryMatcherHelper {

    private final static Logger LOG = LoggerFactory.getLogger(CategoryMatcherHelper.class);

    private final ApplicationProps categoryProps;

    private final RedisTemplate<String, String> redisTemplate;

    private AhoCorasickMatcher ahoCorasickMatcher;

    public CategoryMatcherHelper(ApplicationProps categoryProps, RedisTemplate<String, String> redisTemplate) {
        this.categoryProps = categoryProps;
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    public void initAhoCorasickMatcher() {
        ahoCorasickMatcher = new AhoCorasickMatcher(categoryProps.getCategories());
    }


    public CategorizeResultEvent match(CategorizeEvent categorizeEvent) {
        LOG.info("Event received " + categorizeEvent);
        String text = redisTemplate.opsForValue().get(categorizeEvent.getId().toString());
        Set<String> matchingCategoryNames = ahoCorasickMatcher.findMatchingCategoryNames(text);
        LOG.info(String.format("Found %s categories for task %s", matchingCategoryNames.size(),
                categorizeEvent.getId()));
        CategorizeResultEvent resultEvent = new CategorizeResultEvent();
        resultEvent.setId(categorizeEvent.getId());
        resultEvent.setSuccess(true);
        resultEvent.setCategories(matchingCategoryNames.stream().toList());
        return resultEvent;
    }
}
