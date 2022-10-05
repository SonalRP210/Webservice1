package azure.loc.utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.logging.log4j.util.Strings;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Properties;

@Component
public class ExcelToJsonConverter {

    public String convert(byte content[], Properties headerProperties) throws IOException {
        Workbook workbook = new HSSFWorkbook(new ByteArrayInputStream(content));
        Sheet sheet = workbook.getSheetAt(0);
        if(sheet.getPhysicalNumberOfRows() == 0){
            return Strings.EMPTY;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode jsonArray = objectMapper.createArrayNode();
        ObjectNode json = null;
        for(Row row : sheet){
            if(row.getRowNum() == 0){       //header rwo needs to skip
                continue;
            }
            json = objectMapper.createObjectNode();
            for(Cell cell : row){
                json.put(headerProperties.getProperty(String.valueOf(cell.getColumnIndex())), cell.getStringCellValue());
            }
            jsonArray.add(json);
        }
        return jsonArray.toPrettyString();
    }
}
