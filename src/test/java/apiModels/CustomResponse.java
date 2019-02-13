package apiModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Data
public class CustomResponse {

    private String firstName;
    private String lastName;
    private Contact contact;
    private List<Instructor> instructors;
    private List<Student> students;
    private Company company;
    private String jsonResponse;

}
