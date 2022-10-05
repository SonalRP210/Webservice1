package azure.loc.remote;

import azure.loc.dto.GoodsDTO;
import azure.loc.utilities.Utility;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
//@PropertySource("classpath:application.properties")
public class ServiceHelper extends RemoteCall{

    private static final String STATUS = "status";

    @Autowired
    private static WebClientWrapper webClientWrapper;
    //@Value("${baseURL}")
    private static String baseURL;

    @Autowired
    private WebClientWrapper webClientWrapperNonStatic;
    private String baseURLNonStatic = "http://localhost:8083";


    @Autowired
    private synchronized void initStatic(){
        webClientWrapper = this.webClientWrapperNonStatic;
        baseURL = this.baseURLNonStatic;
    }

    public static List<GoodsDTO> getGoodsListByCountryCode(String code) throws JsonProcessingException {
        List<GoodsDTO> goodsResponse = getDataFromRemoteCall(webClientWrapper, baseURL, "/getCount", "code", code, null, null);
        System.out.println(goodsResponse.size());
        return Arrays.asList(Utility.convertJsonToObject(Utility.convertObjectToJson(goodsResponse), GoodsDTO[].class));
    }
}
