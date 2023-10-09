package utility;

import constants.LogImplementation;
import dataBaseOperation.exception.GlobalException;
import io.cucumber.messages.internal.com.fasterxml.jackson.databind.JsonNode;
import io.cucumber.messages.internal.com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.binary.Base64;

import java.io.IOException;
import java.util.List;
import java.util.Map;
public class JsonFormatterTotalRoleApi {
    JsonFormatterTotalRoleApi(){}
    static List<Map<String, Object>> jsonData;
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
             jsonData = getJsonData(body);
            return jsonData;
        } catch (Exception e) {
            LogImplementation.error(String.valueOf(e));
        }
        return jsonData;
    }

    public static List<Map<String, Object>> getJsonData(String json) {
        List<Map<String, Object>> listHashMap;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(json);             // Extract the "data" array
            JsonNode totalRole = jsonNode.get("data");
            String extractedJson = objectMapper.writeValueAsString(totalRole);
            System.out.println("extractedJson = " + extractedJson);
            listHashMap = objectMapper.readValue(extractedJson, List.class);
            int roleSize = listHashMap.size();
            System.out.println("roleSize = " + roleSize);
            System.out.println("listHashMap = " + listHashMap);

        } catch (RuntimeException | IOException ex) {
            throw new GlobalException("Error");
        }
        return listHashMap;
    }
}
