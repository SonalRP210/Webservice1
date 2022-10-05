package azure.loc.processor.impl;

import azure.loc.dto.CollateralDTO;
import azure.loc.exception.ResourceNotFoundException;
import azure.loc.processor.CollateralProcessor;
import azure.loc.service.CollateralService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CollateralProcessorImpl implements CollateralProcessor {

    @Autowired
    private CollateralService collateralService;

    @Override
    public List<CollateralDTO> getCollateralListByCode(String code) throws ResourceNotFoundException, JsonProcessingException {
        return collateralService.getCollateralListByCode(code);
    }
}
