package com.github.kosbr.matcher.event;

import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
public class CategorizeResultEvent {
    private UUID id;

    private boolean success;

    private List<String> categories;

    private String error;
}
