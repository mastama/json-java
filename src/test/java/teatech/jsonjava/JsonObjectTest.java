package teatech.jsonjava;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class JsonObjectTest {

    @Test
    void createJson() throws JsonProcessingException {
        Map<String, Object> person = Map.of(
                "firstName", "Singgih",
                "lastName", "Pratama",
                "age", 27,
                "address", Map.of(
                        "city", "Depok",
                        "country", "Indonesia",
                        "street", "jalanin aja dulu"
                ),
                "email","sp.mastama@gmail.com"
        );

        ObjectMapper objectMapper = new ObjectMapper();
        //parsing
        String json = objectMapper.writeValueAsString(person);
        System.out.println(json);
    }
}
