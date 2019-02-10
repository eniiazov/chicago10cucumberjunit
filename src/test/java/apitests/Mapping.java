package apitests;

import apiModels.Instructor;
import apiModels.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.io.IOException;

public class Mapping {

    @Test
    public void pojoMapping() throws IOException {
        String json = "{\"id\":3,\"firstName\":\"Wooden\",\"lastName\":\"Spoon\",\"batch\":10,\"subject\":\"Corporate World\",\"location\":\"Chicago\"}";
        ObjectMapper mapper = new ObjectMapper();
        Instructor instructor = mapper.readValue(json, Instructor.class);
        System.out.println(instructor.getFirstName());
    }

    @Test
    public void objectToJson() throws JsonProcessingException {
        Instructor instructor = new Instructor();
        instructor.setSubject("Intro to CS101");
        instructor.setId(34);
        instructor.setFirstName("Howard");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(instructor);
        System.out.println(json);
    }

    @Test
    public void singleStudentHit() throws IOException {
        Response response = RestAssured.get("http://cybertekchicago.com/student/87");
        System.out.println(response.asString());
        ObjectMapper mapper = new ObjectMapper();
        Student student = mapper.readValue(response.asString(), Student.class);
        System.out.println(student.getFirstName());
        System.out.println(student.getContact().getEmailAddress());
    }




}
