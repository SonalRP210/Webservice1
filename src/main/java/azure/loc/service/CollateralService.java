package azure.loc.service;

import azure.loc.dto.CollateralDTO;
import azure.loc.exception.ResourceNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CollateralService {

    List<CollateralDTO> getCollateralListByCode(String code) throws ResourceNotFoundException, JsonProcessingException;

    String getCollateralResponse();
}
