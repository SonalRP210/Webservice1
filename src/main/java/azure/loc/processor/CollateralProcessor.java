package azure.loc.processor;

import azure.loc.dto.CollateralDTO;
import azure.loc.exception.ResourceNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CollateralProcessor {

    List<CollateralDTO> getCollateralListByCode(String code) throws ResourceNotFoundException, JsonProcessingException;
}
