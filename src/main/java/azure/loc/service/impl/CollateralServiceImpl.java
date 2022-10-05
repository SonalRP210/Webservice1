package azure.loc.service.impl;

import azure.loc.config.WebClientConfig;
import azure.loc.dto.CollateralDTO;
import azure.loc.exception.ResourceNotFoundException;
import azure.loc.service.CollateralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class CollateralServiceImpl implements CollateralService {

    /*@Autowired
    private WebClient webClient;*/

    @Autowired
    private WebClientConfig webClientConfig;

    @Override
    public List<CollateralDTO> getCollateralListByCode(String code) throws ResourceNotFoundException{
        return null;
    }

    @Override
    public String getCollateralResponse() {
        return webClientConfig.webClient1().get()
                .uri("http://localhost:8082/getCollateralDetails/fetch")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }


}
