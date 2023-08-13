package teatech.jsonjava;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

public class JavaBeanTest  {

    @Test
    void createJsonFromObject() throws JsonProcessingException {
        // instance object person
        Person person = new Person();
        person.setId("1");
        person.setName("Singgih");
        person.setHobbies(List.of("Coding", "Reading", "Dreaming"));

        //instance object Address
        Address address = new Address();
        address.setCountry("Indonesia");
        address.setCity("Depok");
        address.setStreet("Perjalanan ini sungguh sanagat mengasikkan");
        //
        person.setAddress(address);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonPerson = objectMapper.writeValueAsString(person);
        System.out.println(jsonPerson);
    }

    @Test
    void readObjectFromJson() throws JsonProcessingException {
        String json = """
                {
                    "id": "1",
                    "name": "Singgih",
                    "hobbies": [
                        "Coding",
                        "Reading",
                        "Dreaming"
                    ],
                    "address": {
                        "country": "Indonesia",
                        "city": "Depok",
                        "street": "Perjalanan ini sungguh sangat mengasikkan"
                    }
                }
                """;

        ObjectMapper objectMapper = new ObjectMapper();
        Person person = objectMapper.readValue(json, Person.class);

        Assertions.assertEquals("1", person.getId());
        Assertions.assertEquals("Singgih", person.getName());
        Assertions.assertEquals(List.of("Coding", "Reading", "Dreaming"), person.getHobbies());
        Assertions.assertEquals("Indonesia", person.getAddress().getCountry());
        Assertions.assertEquals("Depok", person.getAddress().getCity());
        Assertions.assertEquals("Perjalanan ini sungguh sangat mengasikkan", person.getAddress().getStreet());
    }
}
