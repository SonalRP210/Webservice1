package azure.loc.service.impl;

import azure.loc.entity.Goods;
import azure.loc.exception.DataMigrationException;
//import azure.loc.exception.ExceptionHandler;
import azure.loc.exception.TechnicalException;
import azure.loc.loader.DataLoader;
//import azure.loc.repository.GoodsRepository;
import azure.loc.service.DataMigrationService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

import static azure.loc.contants.Constants.GOODS_FILE_NAME;
import static azure.loc.contants.Constants.GOODS_PROPERTIES;
import static azure.loc.contants.ErrorMessages.DATA_LOAD_ERROR;
import static azure.loc.contants.ErrorMessages.INVALID_FILE_NAME;

@Log4j2
@Service
public class DataMigrationServiceImpl implements DataMigrationService {

    @Autowired
    private DataLoader dataLoader;

//    @Autowired
//    private GoodsRepository goodsRepository;

//    @Autowired
//    private ExceptionHandler exceptionHandler;

    @Override
    @Transactional
    public void processDataAndSaveToDB(MultipartFile file) throws IOException {
        boolean isError = false;
        switch(file.getOriginalFilename()){
            case GOODS_FILE_NAME:
                List<Goods> goodsList = Arrays.asList(dataLoader.getEntityToLoad(GOODS_PROPERTIES, file, Goods[].class));
                for(Goods good : goodsList){
                    try{
                        //goodsRepository.save(good);
                    }catch(RuntimeException exception){
                        isError = true;
                        //exceptionHandler.logException(good, GOODS_FILE_NAME, exception);
                    }
                }
                break;
            default:
                throw new TechnicalException(MessageFormat.format(INVALID_FILE_NAME, file.getOriginalFilename()));
        }
        if(isError){
            throw new DataMigrationException(DATA_LOAD_ERROR);
        }
    }
}
