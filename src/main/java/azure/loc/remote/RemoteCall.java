package azure.loc.remote;

import azure.loc.exception.ResourceNotFoundException;
import azure.loc.utilities.UriBuilderFunctionalInterface;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.text.MessageFormat;
import java.util.List;

//make remote calls to other APIs of other microservice
@Log4j2
@Component
public class RemoteCall {

    public static List getDataFromRemoteCall(WebClientWrapper webClientWrapper, String baseURL, String urlEndPoint, String paramName1, String paramValue1, String paramName2, String paramValue2){
        List dataList = null;
        UriBuilderFunctionalInterface uriBuilderFunctionalInterface = getUriBuilderForFetchingSpecificRecords(urlEndPoint, baseURL, paramName1, paramValue1, paramName2, paramValue2);
        try {
            dataList = getResponseFromRemoteCall(uriBuilderFunctionalInterface, List.class, webClientWrapper);
        } catch (Exception e) {
            String message = "";
            if(paramName1 != null && paramName2 != null){
                message = MessageFormat.format("", urlEndPoint.substring(1), paramName1, paramValue1);
            } else {
                message = MessageFormat.format("", urlEndPoint.substring(1), paramName1, paramValue1, paramName2, paramValue2);
            }
            throw new ResourceNotFoundException(message + e.getMessage());
        }
        return dataList;
    }

    private static UriBuilderFunctionalInterface getUriBuilderForFetchingSpecificRecords(String urlEndPoint, String goodsDataBaseURL, String paramName1, String paramValue1, String paramName2, String paramValue2){
        if(paramName1 == null && paramName2 == null){
            return () -> new DefaultUriBuilderFactory(goodsDataBaseURL)
                    .builder()
                    .path(urlEndPoint)
                    .build();
        }if(paramName2 == null){
            return () -> new DefaultUriBuilderFactory(goodsDataBaseURL)
                    .builder()
                    .path(urlEndPoint)
                    .queryParam(paramName1, paramValue1)
                    .build();
        }else{
            return () -> new DefaultUriBuilderFactory(goodsDataBaseURL)
                    .builder()
                    .path(urlEndPoint)
                    .queryParam(paramName1, paramValue1)
                    .queryParam(paramName2, paramValue2)
                    .build();
        }
    }

    private static <T> T getResponseFromRemoteCall(UriBuilderFunctionalInterface uriBuilderFunctionalInterface, Class<T> toObject, WebClientWrapper webClientWrapper) throws Exception {
        return webClientWrapper.get(MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON, uriBuilderFunctionalInterface, toObject);
    }
}
