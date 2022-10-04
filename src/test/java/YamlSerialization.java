import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class YamlSerialization {

    private final List<Phone> phones = Arrays.asList(
            new Phone("Apple", 170, 7, 999),
            new Phone("ZTE", 172, 7, 666),
            new Phone("Xiaomi", 130, 6, 333)
    );

    private final File path = new File("phone.yaml");

    @Test
    public void serialize() throws IOException {
        ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());
        yamlMapper.writeValue(path, phones);
    }

    @Test
    public void deserialize() throws IOException {
        ObjectMapper yamlMapper = new YAMLMapper();
        Phone[] phones1 = yamlMapper.readValue(path, Phone[].class);
        System.out.println(Arrays.toString(phones1));
    }
}

