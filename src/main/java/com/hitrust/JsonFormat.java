package com.hitrust;

import org.json.JSONObject;

public class JsonFormat {
    public String jsonValidata(String json, String format) {
        try {
            JSONObject JSONObject = new JSONObject(json);
        } catch (Exception e) {
            return "Please Entry Json";
        }

        String[] formatParts = format.replaceAll("[\\[\\]]", "").split(", ");
        for (String formatPart : formatParts) {
            String[] parts = formatPart.split(":");
            String key = parts[0].trim();
            String expectedType = parts[1].trim();

            // Check if the key exists in the JSON object
            if (!jsonObject.has(key)) {
                return "Key '" + key + "' is missing.";
            }

            // Validate the type
            Object value = jsonObject.get(key);
            if (!isValidType(value, expectedType)) {
                return "Type error: '" + key + "' must be " + expectedType;
            }
        }

        return "";
    }
}