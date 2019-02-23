package apitests;

import bootcampAPI.BootcampInstructor;
import bootcampAPI.BootcampResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class InstructorsList {

    @Test
    public void insList(){
        Response r = RestAssured.get("http://cybertekchicago.com/instructor/all");
        System.out.println(r.statusCode());
        Assert.assertEquals(200, r.statusCode());
        String json = r.asString();
        System.out.println(json);
        JsonPath path = r.jsonPath();
        String name =path.get("instructors[12].firstName");
        System.out.println(name);
    }

    @Test
    public void pojoInstructors() throws IOException {
        Response r = RestAssured.get("http://cybertekchicago.com/instructor/all");
        System.out.println(r.statusCode());
        ObjectMapper mapper = new ObjectMapper();
        BootcampResponse response = mapper.readValue(r.asString(), BootcampResponse.class);
        int size = response.getInstructors().size();
        System.out.println(size);
        List<BootcampInstructor> instructorList = response.getInstructors();
        for(BootcampInstructor i: instructorList){
            if(i.getSubject() == null){
                System.out.println(i.getFirstName() + " " + i.getLastName());
            }
        }
        System.out.println("----------- BATCH VALIDATION --------");
        for(BootcampInstructor i: instructorList){
            if(i.getBatch() < 7 || i.getBatch() > 10){
                System.out.println(i.getFirstName() + " " + i.getLastName());
            }
        }
        System.out.println("---------------TASK 3 +====-------------");
        for(BootcampInstructor i: instructorList){
            if(i.getFirstName().trim().contains(" ") || i.getLastName().trim().contains(" ")){
                System.out.println(i.getFirstName() + " " + i.getLastName());
            }
        }
    }

    @Test
    public void studentList() throws IOException {
        Response r = RestAssured.get("http://cybertekchicago.com/student/all");
        System.out.println(r.statusCode());
        ObjectMapper mapper = new ObjectMapper();
        BootcampResponse response = mapper.readValue(r.asString(), BootcampResponse.class);
        for(BootcampInstructor s: response.getStudents()){
            if(s.getBatch() < 7 || s.getBatch() > 10){
                System.out.println(s.getFirstName() + " " + s.getLastName());
            }
        }

    }
}
