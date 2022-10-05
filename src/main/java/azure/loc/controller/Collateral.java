package azure.loc.controller;

import azure.loc.dto.CollateralDTO;
import azure.loc.processor.CollateralProcessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/getCollateralDetails")
public class Collateral {

    @Autowired
    private CollateralProcessor collateralProcessor;

    @GetMapping("/fetch")
    public ResponseEntity<String> getCollateral (){
        System.out.println(">>>>Success");
        return new ResponseEntity<>("good", HttpStatus.OK);
    }

    @GetMapping
    public List<CollateralDTO> getCollateralByCode(@RequestParam("code") String code) throws JsonProcessingException {
        return collateralProcessor.getCollateralListByCode(code);
    }
}
