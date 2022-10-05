package azure.loc.loader;

import azure.loc.utilities.ExcelToJsonConverter;
import azure.loc.utilities.HeaderProperties;
import azure.loc.utilities.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Properties;

@Component
public class DataLoader {

    @Autowired
    private HeaderProperties headerProperties;

    @Autowired
    private ExcelToJsonConverter excelToJsonConverter;

    /**
     * This method will load the data in java object and return to the caller
     * @param propertyFileName File holding information about the metadata(header information)
     * @param fileToLoad the excel file that needs to be loaded
     * @param toClass the class to be returned after reading the excel data
     * @param <T> Generic class that needs to be returned
     * @return T Generic class that needs to be returned
     * @throws IOException Exception while performing file upload
     */
    public <T> T getEntityToLoad(String propertyFileName, MultipartFile fileToLoad, Class<T> toClass) throws IOException{
        Properties properties = headerProperties.getHeaderProperties(propertyFileName);
        byte[] content = fileToLoad.getBytes();
        String json = excelToJsonConverter.convert(content, properties);
        return Utility.convertJsonToObject(json, toClass);
    }
}
