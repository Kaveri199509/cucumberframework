package org.example;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;
import java.util.Objects;

public class RestObjects {
    private static Response response;
    public static Response postData(String baseUrl,String pathUrl, Map<String, String> headerValues, String bodyValue){
        RequestSpecification request = setBaseUrl(baseUrl);
        if(headerValues!=null && !headerValues.isEmpty()) {
            for (Map.Entry<String, String> mp : headerValues.entrySet()) {
                request.header(mp.getKey(), mp.getValue());
            }
        }
        response = request.body(bodyValue)
                .post(pathUrl);
        return response;
    }

    public static Response getData(String baseUrl,String pathUrl, Map<String, String> headerValues){
        RequestSpecification request = setBaseUrl(baseUrl);
        if(headerValues!=null && !headerValues.isEmpty()) {
            for (Map.Entry<String, String> mp : headerValues.entrySet()) {
                request.header(mp.getKey(), mp.getValue());
            }
        }
        response = request.get(pathUrl);
        return response;
    }

    public static Response deleteData(String baseUrl,String pathUrl, Map<String, String> headerValues){
        RequestSpecification request = setBaseUrl(baseUrl);
        if(headerValues!=null && !headerValues.isEmpty()) {
        for(Map.Entry<String,String> mp: headerValues.entrySet()){
            request.header(mp.getKey(),mp.getValue());
            }
        }
        response = request.delete(pathUrl);
        return response;
    }

    public static Response patchData(String baseUrl,String pathUrl, Map<String, String> headerValues, Objects bodyValue ) {
        RequestSpecification request = setBaseUrl(baseUrl);
        for (Map.Entry<String, String> mp : headerValues.entrySet()) {
            request.header(mp.getKey(), mp.getValue());
        }

        response = request.body(bodyValue)
                .patch(pathUrl);
        return response;
    }

    public static Response putData(String baseUrl,String pathUrl, Map<String, String> headerValues, String bodyValue){
        RequestSpecification request = setBaseUrl(baseUrl);
        if(headerValues!=null && !headerValues.isEmpty()) {
            for (Map.Entry<String, String> mp : headerValues.entrySet()) {
                request.header(mp.getKey(), mp.getValue());
            }
        }
        response = request.body(bodyValue)
                .put(pathUrl);
        return response;
    }

  public static RequestSpecification setBaseUrl(String baseUrl){
      RestAssured.baseURI = baseUrl;
     return RestAssured.given();
  }
}
