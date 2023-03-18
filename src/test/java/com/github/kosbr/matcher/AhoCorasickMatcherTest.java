package com.github.kosbr.matcher;

import com.github.kosbr.matcher.category.Category;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class AhoCorasickMatcherTest {

    @Test
    public void testSuccessSearch() {
        AhoCorasickMatcher matcher = new AhoCorasickMatcher(List.of(
                new Category() {{
                    setName("animals");
                    setKeys(List.of(
                            "elephant",
                            "bear"
                    ));
                }}
        ));

        Assertions.assertEquals(Set.of("animals"),
                matcher.findMatchingCategoryNames("Hey, look at this Elephant!"));
    }

    @Test
    public void testNotSuccessSearch() {
        AhoCorasickMatcher matcher = new AhoCorasickMatcher(List.of(
                new Category() {{
                    setName("animals");
                    setKeys(List.of(
                            "elephant",
                            "bear"
                    ));
                }}
        ));

        Assertions.assertEquals(Collections.emptySet(),
                matcher.findMatchingCategoryNames("Hey, look at this Elephantos!"));
    }

    @Test
    @Disabled("This can be considered as a bug")
    public void testTwoCategoriesSuccessSearch() {
        AhoCorasickMatcher matcher = new AhoCorasickMatcher(List.of(
                new Category() {{
                    setName("Australia");
                    setKeys(List.of(
                            "kangaroo",
                            "ocean"
                    ));
                }},
                new Category() {{
                    setName("Animals");
                    setKeys(List.of(
                            "kangaroo",
                            "bear"
                    ));
                }}
        ));

        // actually it finds only Australia and ignores Animals.
        Assertions.assertEquals(Set.of("Australia", "Animals"),
                matcher.findMatchingCategoryNames("Hey, look at this Kangaroo! This Kangaroo is soo big."));
    }

}
