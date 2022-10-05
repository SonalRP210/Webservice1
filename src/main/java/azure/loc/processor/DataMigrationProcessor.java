package azure.loc.processor;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
public interface DataMigrationProcessor {

    /**
     * @param files
     * @throws IOException
     */
    void loadData(MultipartFile[] files) throws IOException;
}
