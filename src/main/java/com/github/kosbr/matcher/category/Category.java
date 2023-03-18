package com.github.kosbr.matcher.category;

import java.util.List;
import lombok.Data;

@Data
public class Category {

    private String name;

    /**
     * Each key can be a word or a phrase
     */
    private List<String> keys;
}
