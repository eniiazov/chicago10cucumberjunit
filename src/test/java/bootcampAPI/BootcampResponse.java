package bootcampAPI;

import lombok.Data;

import java.util.List;

@Data
public class BootcampResponse {

    private List<BootcampInstructor> instructors;
    private List<BootcampInstructor> students;

}
