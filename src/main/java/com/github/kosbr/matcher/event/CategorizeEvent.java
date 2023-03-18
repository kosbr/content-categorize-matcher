package com.github.kosbr.matcher.event;

import java.util.UUID;
import lombok.Data;

/**
 * This event is consumed by this service.
 * It tells us that we must get contents of this task in redis and categorize it.
 */
@Data
public class CategorizeEvent {

    private UUID id;

}
