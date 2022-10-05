package azure.loc.service.impl;

import azure.loc.dto.CollateralDTO;
import azure.loc.exception.ResourceNotFoundException;
import azure.loc.service.CollateralService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CollateralServiceImpl implements CollateralService {
    @Override
    public List<CollateralDTO> getCollateralListByCode(String code) throws ResourceNotFoundException{
        return null;
    }
}
