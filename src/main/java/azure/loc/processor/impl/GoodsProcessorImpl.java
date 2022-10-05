package azure.loc.processor.impl;

import azure.loc.dto.GoodsDTO;
import azure.loc.exception.ResourceNotFoundException;
import azure.loc.processor.GoodsProcessor;
import azure.loc.service.GoodService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GoodsProcessorImpl implements GoodsProcessor {

    @Autowired
    private GoodService goodService;

    @Override
    public List<GoodsDTO> getGoodsListByCode(String code) throws ResourceNotFoundException, JsonProcessingException {
        return goodService.getGoodsListByCode(code);
    }
}
