//package stub;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.trade.finance.loc.dto.GoodsDTO;
//import com.trade.finance.loc.utilities.Utility;
//import org.apache.commons.lang.SerializationUtils;
//
//import java.io.IOException;
//import java.net.URISyntaxException;
//import java.net.URL;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//
//public class TestDataHelper {
//    private static GoodsDTO goodsDTO;
//
//    public static GoodsDTO createGoodsDTOWithDummyData(){
//        return (GoodsDTO) SerializationUtils.clone(goodsDTO);
//    }
//
//    static {
//        try {
//            String json;
//            json = readFileFromResources("GoodsDTO.json");
//            goodsDTO = getJsonConvertToObject(json, GoodsDTO.class);
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static String readFileFromResources(String fileName) throws URISyntaxException, IOException {
//        URL resource = TestDataHelper.class.getClassLoader().getResource(fileName);
//        byte[] bytes = Files.readAllBytes(Paths.get(resource.toURI()));
//        return new String(bytes);
//    }
//
//    private static <T> T getJsonConvertToObject(String json, Class<T> toClass){
//        try{
//            return Utility.convertJsonToObject(json, toClass);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//}
