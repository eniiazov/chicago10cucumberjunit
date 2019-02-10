package apitests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class CMstudent {

    @Test
    public void studentList(){
        Response response = RestAssured.get("http://cybertekchicago.com/student/87");
        System.out.println(response.statusCode());
        System.out.println(response.asString());
    }

    @Test
    public void singleStudent(){
        Response response = RestAssured.get("http://cybertekchicago.com/student/2");
        System.out.println(response.statusCode());
        System.out.println(response.asString());
        JsonPath jp = response.jsonPath();
        int b =  jp.get("batch");
        System.out.println(b);
        String fn = jp.get("firstName");
        System.out.println(fn);
        String email = jp.get("contact.emailAddress");
        System.out.println(email);
        String street = jp.get("company.address.street");
        System.out.println(street);
    }

    @Test
    public void instructorAll(){
        Response response = RestAssured.get("http://cybertekchicago.com/instructor/all");
        System.out.println(response.asString());
        JsonPath jp = response.jsonPath();
        List<String> subjects = jp.get("subject");
        System.out.println(subjects.size());
        for(String subject: subjects){
            System.out.println(subject.isEmpty());
        }
    }


}
