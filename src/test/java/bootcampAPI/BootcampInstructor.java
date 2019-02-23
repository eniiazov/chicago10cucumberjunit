package bootcampAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BootcampInstructor {

    private String firstName;
    private String lastName;
    private String subject;
    private int batch;
}
