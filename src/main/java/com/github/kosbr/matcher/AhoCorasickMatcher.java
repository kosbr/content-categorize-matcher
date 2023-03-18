package com.github.kosbr.matcher;

import com.github.kosbr.matcher.category.Category;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.ahocorasick.trie.PayloadEmit;
import org.ahocorasick.trie.PayloadTrie;

public class AhoCorasickMatcher {

    private PayloadTrie<String> trie;

    public AhoCorasickMatcher(List<Category> categories) {
        buildTrieIndex(categories);
    }


    private void buildTrieIndex(List<Category> categories) {
        PayloadTrie.PayloadTrieBuilder<String> trieBuilder = PayloadTrie.<String>builder()
                .ignoreCase()
                .onlyWholeWords();
        categories.forEach(category -> {
            category.getKeys().forEach(key -> trieBuilder.addKeyword(key, category.getName()));
        });
        trie = trieBuilder.build();
    }

    public Set<String> findMatchingCategoryNames(String text) {
        Collection<PayloadEmit<String>> emits = trie.parseText(text);
        return emits.stream()
                .map(PayloadEmit::getPayload)
                .collect(Collectors.toSet());
    }

}
