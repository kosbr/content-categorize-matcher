package com.github.kosbr.matcher.event;

import java.util.List;
import java.util.UUID;
import lombok.Data;

/**
 * This event is sent by this service.
 * This is the final result of categorization task.
 */
@Data
public class CategorizeResultEvent {
    private UUID id;

    // success = false means error happened.
    private boolean success;

    private List<String> categories;

    private String error;
}
