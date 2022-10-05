package azure.loc.processor;

import azure.loc.dto.GoodsDTO;
import azure.loc.exception.ResourceNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GoodsProcessor {

    List<GoodsDTO> getGoodsListByCode(String code) throws ResourceNotFoundException, JsonProcessingException;
}
