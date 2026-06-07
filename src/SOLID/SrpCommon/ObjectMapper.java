package SOLID.SrpCommon;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// com.fasterxml.jackson.databind.ObjectMapper yerine kullandığımız deneysel bir sınıf.
public class ObjectMapper {

    public <T> T readValue(String json, Class<T> clazz) throws IOException {
        Map<String, Object> fields = parseJson(json);

        T instance;
        try {
            instance = clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new IOException("No-arg constructor not found for " + clazz.getName(), e);
        }

        for (Map.Entry<String, Object> entry : fields.entrySet()) {
            String fieldName = entry.getKey();
            Object value = entry.getValue();
            
            String setterName = "set"
                    + Character.toUpperCase(fieldName.charAt(0))
                    + fieldName.substring(1);
            try {
                if (value instanceof Boolean) {
                    try {
                        Method setter = clazz.getMethod(setterName, boolean.class);
                        setter.invoke(instance, value);
                        continue;
                    } catch (NoSuchMethodException ignored) {}
                }

                Method setter = clazz.getMethod(setterName, String.class);
                setter.invoke(instance, value.toString());
            } catch (NoSuchMethodException e) {
            } catch (Exception e) {
                throw new IOException("Failed to set field '" + fieldName + "'", e);
            }
        }

        return instance;
    }

    private Map<String, Object> parseJson(String json) throws IOException {
        if (json == null || json.isBlank()) {
            throw new IOException("JSON input is null or empty");
        }

        Map<String, Object> result = new HashMap<>();
        
        // String values: "key": "value"
        Pattern stringPattern = Pattern.compile("\"([^\"]+)\"\\s*:\\s*\"([^\"]*)\"");
        Matcher stringMatcher = stringPattern.matcher(json);
        while (stringMatcher.find()) {
            result.put(stringMatcher.group(1), stringMatcher.group(2));
        }
        
        // Boolean values: "key": true/false
        Pattern boolPattern = Pattern.compile("\"([^\"]+)\"\\s*:\\s*(true|false)");
        Matcher boolMatcher = boolPattern.matcher(json);
        while (boolMatcher.find()) {
            result.put(boolMatcher.group(1), Boolean.parseBoolean(boolMatcher.group(2)));
        }

        return result;
    }
}
