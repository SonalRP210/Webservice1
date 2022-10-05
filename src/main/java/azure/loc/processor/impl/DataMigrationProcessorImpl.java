package azure.loc.processor.impl;

import azure.loc.exception.TechnicalException;
import azure.loc.processor.DataMigrationProcessor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static azure.loc.contants.ErrorMessages.INVALID_REQUEST;

@Component
@Log4j2
public class DataMigrationProcessorImpl implements DataMigrationProcessor {

    //@Autowired private Data
    /**
     * @param files
     * @throws IOException
     */
    @Override
    public void loadData(MultipartFile[] files) throws IOException {
        if(files == null || files.length == 0){
            throw new TechnicalException(INVALID_REQUEST);
        }
        for(MultipartFile file : files){
            if(file == null || file.isEmpty()){
                throw new TechnicalException(INVALID_REQUEST);
            }
//            try {
//
//            }
        }
    }
}
