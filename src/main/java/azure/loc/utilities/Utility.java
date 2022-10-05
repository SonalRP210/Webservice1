package azure.loc.utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Utility {

    public static <T> T convertJsonToObject(String json, Class<T> toClass) throws JsonProcessingException {
        var mapper = new ObjectMapper();
        return mapper.readValue(json, toClass);
    }

    public static <T> String convertObjectToJson(T object) throws JsonProcessingException {
        var mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

    /*method will return authorization token from request*/
    public static String getAuthorizationToken(){
        return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization");
    }

    public static ZonedDateTime getZonedDateTime(){
        var localDateTime = LocalDateTime.now();
        return ZonedDateTime.of(localDateTime, ZoneId.of("CET"));
    }
}
