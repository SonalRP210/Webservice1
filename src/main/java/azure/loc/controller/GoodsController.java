package azure.loc.controller;

import azure.loc.dto.GoodsDTO;
import azure.loc.processor.GoodsProcessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@Log4j2
@RequestMapping
@RestController
public class GoodsController {

    @Autowired
    private GoodsProcessor goodsProcessor;

    @GetMapping(value = "/getCount", params = "code")
    public List<GoodsDTO> getCount(@RequestParam(value = "code") String code) throws JsonProcessingException {
        return goodsProcessor.getGoodsListByCode(code);
    }
}
