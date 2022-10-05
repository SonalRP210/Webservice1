package azure.loc.utilities;

import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Properties;

@Component
public class HeaderProperties {

    public Properties getHeaderProperties(String fileName) throws IOException {
        byte[] content = HeaderProperties.class.getClassLoader().getResourceAsStream(fileName).readAllBytes();
        Properties properties = new Properties();
        properties.load(new ByteArrayInputStream(content));
        return properties;
    }
}
