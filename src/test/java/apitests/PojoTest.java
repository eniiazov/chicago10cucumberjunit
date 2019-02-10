package apitests;

import apiModels.Instructor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

public class PojoTest {

    @Test
    public void testPojo() throws Exception{
        Instructor in = new Instructor();
        in.setBatch(10);
        in.setFirstName("James");
        in.setLastName("Milner");
        in.setId(7);
        in.setSubject("Intro to Soccer");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(in);
        System.out.println(json);

        Instructor instr2 = mapper.readValue(json, Instructor.class);
        System.out.println(instr2.getFirstName());
    }
}
