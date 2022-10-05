package azure.loc.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface DataMigrationService {

    void processDataAndSaveToDB(MultipartFile files) throws IOException;
}
