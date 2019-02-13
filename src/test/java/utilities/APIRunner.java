package utilities;

import apiModels.CustomResponse;
import apiModels.RequestBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.IOException;

public class APIRunner {

    private static CustomResponse cr;

    public static CustomResponse getCr(){
        return cr;
    }

    public static void runGET(String uri){
        Response response = RestAssured.get(uri);
        System.out.println("STATUS: " + response.statusCode());
        System.out.println(response.asString());
        ObjectMapper mapper = new ObjectMapper();
        try {
            cr = mapper.readValue(response.asString(), CustomResponse.class);
        } catch (IOException e) {
            System.out.println("JSON COULDN'T MAP PROPERLY");
        }
        cr.setJsonResponse(response.asString());
    }

    public static void runPOST(RequestBody body, String uri){
        Response response = RestAssured.given().contentType(ContentType.JSON).
                body(body).when().post(uri);
        System.out.println("STATUS: " + response.statusCode());
        System.out.println(response.asString());
        ObjectMapper mapper = new ObjectMapper();
        try {
            cr = mapper.readValue(response.asString(), CustomResponse.class);
        } catch (IOException e) {
            System.out.println("JSON COULDN'T MAP PROPERLY");
        }
    }



    public static CustomResponse getResponse(){
        if(cr == null){
            System.out.println("Please run API first");
            throw new RuntimeException();
        }
        return cr;
    }
}
