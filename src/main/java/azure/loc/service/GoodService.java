package azure.loc.service;

import azure.loc.dto.GoodsDTO;
import azure.loc.exception.ResourceNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GoodService {

    List<GoodsDTO> getGoodsListByCode(String code) throws ResourceNotFoundException, JsonProcessingException;
}
