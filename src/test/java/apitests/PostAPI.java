package apitests;

import apiModels.CustomResponse;
import apiModels.Instructor;
import apiModels.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.APIRunner;

import java.io.IOException;

public class PostAPI {

    @Test
    public void postInstructor(){
        Instructor instructor = new Instructor();
        instructor.setLastName("Doe");
        instructor.setFirstName("New John");
        instructor.setSubject("Advanced Machine Learning");
        instructor.setBatch(10);

        Response response = RestAssured.given().contentType(ContentType.JSON).
                body(instructor).when().post("http://cybertekchicago.com/instructor/create");
        System.out.println(response.statusCode());
        System.out.println(response.asString());
    }

    @Test
    public void customSingleStudent() throws IOException {
        Response response = RestAssured.get("http://cybertekchicago.com/student/87");
        ObjectMapper mapper = new ObjectMapper();
        CustomResponse cr = mapper.readValue(response.asString(), CustomResponse.class);
        System.out.println(cr.getFirstName());
        System.out.println(cr.getContact().getEmailAddress());
    }

    @Test
    public void listOfInstructors()throws IOException{
        Response response = RestAssured.get("http://cybertekchicago.com/instructor/all");
        System.out.println(response.statusCode());
        ObjectMapper mapper = new ObjectMapper();
        CustomResponse cr = mapper.readValue(response.asString(), CustomResponse.class);
        System.out.println(cr.getInstructors().get(0).getSubject());

        for(Instructor instructor: cr.getInstructors()){
            if (instructor.getSubject() == null){
                System.out.println("First name: " + instructor.getFirstName() + " Last name: " + instructor.getLastName());
                System.out.println("-------------");
            }
        }
    }

    @Test
    public void studentLocation() throws IOException {
        Response response = RestAssured.get("http://cybertekchicago.com/student/all");
        ObjectMapper mapper = new ObjectMapper();
        CustomResponse cr = mapper.readValue(response.asString(), CustomResponse.class);
        System.out.println(cr.getStudents().size());
        int couter = 0;
        for(Student student: cr.getStudents()){
            if(student.getCompany().getAddress().getCity().equalsIgnoreCase("Chicago")){
                System.out.println(student.getFirstName());
                couter++;
            }
        }
        System.out.println("Total: " + couter);

    }

    @Test
    public void utilTest(){
        APIRunner.runGET("http://cybertekchicago.com/student/88");
        String companyLocation = APIRunner.getResponse().getCompany().getAddress().getCity();
        System.out.println(companyLocation);
    }

    @Test
    public void batch7(){
        APIRunner.runGET("http://cybertekchicago.com/student/all");
        int counter = 0;
        for(Student student: APIRunner.getResponse().getStudents()){
            if (student.getBatch() == 7){
                System.out.println(student.getFirstName());
                counter++;
            }
        }
        System.out.println("Total batch 7: "  + counter);
    }


}









