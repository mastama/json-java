package teatech.jsonjava;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Objects;

public class MapObjectTest {

    @Test
    void readJsonFromMap() throws JsonProcessingException {
        String json = """
                {
                    "email": "sp.mastama@gmail.com",
                    "address": {
                        "street": "jalanin aja dulu",
                        "city": "Depok",
                        "country": "Indonesia"
                    },
                    "firstName": "Singgih",
                    "lastName": "Pratama",
                    "age": 27
                }
                """;

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Objects> person = objectMapper.readValue(json, new TypeReference<>() {
        });

        Assertions.assertEquals("Singgih", person.get("firstName"));
        Assertions.assertEquals("Depok", person.get("city"));
    }
}
