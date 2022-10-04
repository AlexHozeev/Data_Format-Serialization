import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class SerializerTest {

    private final List<Phone> phones = Arrays.asList(
            new Phone("Apple", 170, 7, 999),
            new Phone("ZTE", 172, 7, 666),
            new Phone("Xiaomi", 130, 6, 333)
    );

    private final File path = new File("phone.xml");

    @Test
    public void serialize() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper.writeValueAsString(phones);
        xmlMapper.writeValue(path, phones);
        System.out.println(xml);
    }

    @Test
    public void deserialize() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        CollectionType javaType = xmlMapper.getTypeFactory()
                .constructCollectionType(List.class, Phone.class);
        List<Phone> phones1 = xmlMapper.readValue(path, javaType);
        System.out.println(phones1.get(0));
    }

}
