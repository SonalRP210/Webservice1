package azure.loc.service.impl;

import azure.loc.dto.GoodsDTO;
import azure.loc.exception.ResourceNotFoundException;
import azure.loc.service.GoodService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static azure.loc.remote.ServiceHelper.getGoodsListByCountryCode;

@Service
public class GoodServiceImpl implements GoodService {
    @Override
    public List<GoodsDTO> getGoodsListByCode(String code) throws ResourceNotFoundException, JsonProcessingException {
        return getGoodsListByCountryCode(code);
    }
}
