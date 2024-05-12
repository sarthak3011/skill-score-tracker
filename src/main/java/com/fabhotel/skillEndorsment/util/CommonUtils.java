package com.fabhotel.skillEndorsment.util;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@UtilityClass
@Slf4j
public class CommonUtils {

    public String generateUUID() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    public String generateUUID(String name) {
        String formattedName = name.toLowerCase().replaceAll("\\s+", "");
        // Generate a UUID based on the formatted name
        UUID uuid = UUID.randomUUID();
        // Convert the UUID to a string
        String uuidString = uuid.toString().substring(0, 8);
        // Remove any hyphens from the generated UUID
        uuidString = uuidString.replaceAll("-", "");
        // Return the generated UUID
        return formattedName + "-" + uuidString;
    }
}
