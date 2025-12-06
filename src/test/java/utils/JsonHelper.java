package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JSON Helper
 * Utility class for JSON serialization and deserialization
 */
public class JsonHelper {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Convert object to JSON string(JSON Serialization)
     */
    public static String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);//It converts a Java object into its corresponding JSON string representation.a core function used in the Jackson library for JSON Serialization.
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to convert object to JSON", e);
        }
    }

    /**
     * Convert JSON string to object(JSON Deserialization)
     */
    public static <T> T fromJson(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);//It converts a JSON data source (like a string, file, or stream) back into a corresponding Java object. core function used in the Jackson library for JSON Deserialization.
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to parse JSON to object", e);
        }
    }

    /**
     * Pretty print JSON string
     */
    public static String toPrettyJson(Object object) {
        try {
            return objectMapper.writerWithDefaultPrettyPrinter()//This is the key formatting instruction. It configures the writer to output JSON with:1, Line breaks between key-value pairs and objects/arrays.2, Indentation (usually 2 to 4 spaces) for nested structures.
            		.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to convert object to pretty JSON", e);
        }
    }
}
