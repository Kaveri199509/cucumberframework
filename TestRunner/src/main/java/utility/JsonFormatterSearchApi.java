package utility;

import com.fasterxml.jackson.core.JsonParseException;
import constants.LogImplementation;
import io.cucumber.messages.internal.com.fasterxml.jackson.databind.JsonMappingException;
import io.cucumber.messages.internal.com.fasterxml.jackson.databind.JsonNode;
import io.cucumber.messages.internal.com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.binary.Base64;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JsonFormatterSearchApi {
    public static List<Map<String, Object>> getJwtData(String bearerToken) {
        try {
            String[] split_string = bearerToken.split("\\.");
            String base64EncodedHeader = split_string[0];
            String base64EncodedBody = split_string[1];

            System.out.println("***** JWT Header *****");
            Base64 base64Url = new Base64(true);
            String header = new String(base64Url.decode(base64EncodedHeader));
            System.out.println("JWT Header : " + header);

            System.out.println("***** JWT Body *****");
            String body = new String(base64Url.decode(base64EncodedBody));
            System.out.println("JWT Body : " + body);
            List<Map<String, Object>> jsonData = getJsonData(body);
            return jsonData;
        } catch (Exception e) {
            LogImplementation.error(String.valueOf(e));
        }
        return null;
    }

    public static List<Map<String, Object>> getJsonData(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(json);             // Extract the "role_permission" array
            JsonNode rolePermissionNode = jsonNode.get("rbacData");
            String extractedJson = objectMapper.writeValueAsString(rolePermissionNode);
            System.out.println("extractedJson = " + extractedJson);
            LinkedHashMap<String, Object> linkedHashMap = objectMapper.readValue(extractedJson, LinkedHashMap.class);

            // Print the LinkedHashMap
            System.out.println("linkedHashMap : " + linkedHashMap);
            List<Map<String, Object>> attendanceData = (List<Map<String, Object>>) linkedHashMap.get("role_permission");
            for (Map<String, Object> attendance : attendanceData) {
                for (Map.Entry<String, Object> entry : attendance.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    System.out.println(key + ": " + value);
                }
                System.out.println();
            }
            System.out.println();
            return attendanceData;
        } catch (JsonMappingException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
