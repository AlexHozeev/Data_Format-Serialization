import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class JsonSerializerTest {


    private final List<Phone> phones = Arrays.asList(
            new Phone("Apple", 170, 7, 999),
            new Phone("ZTE", 172, 7, 666),
            new Phone("Xiaomi", 130, 6, 333)
    );

    private final File path = new File("phone.json");

    @Test
    public void serialize() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        String s = jsonMapper.writeValueAsString(phones);
        jsonMapper.writeValue(path, phones);
        System.out.println(s);
    }

    @Test
    public void deserialize() throws IOException {
        JsonMapper jsonMapper = new JsonMapper();
        CollectionType javaType = jsonMapper.getTypeFactory()
                .constructCollectionType(List.class, Phone.class);
        List<Phone> phones1 = jsonMapper.readValue(path, javaType);
        phones1.forEach(System.out::println);
    }

}

