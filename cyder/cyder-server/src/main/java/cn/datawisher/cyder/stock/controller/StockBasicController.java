package cn.datawisher.cyder.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.datawisher.cyder.stock.dto.StockBasicDTO;
import cn.datawisher.cyder.stock.pulldata.PullDataService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Jim Han
 * @since 2023-03-31
 */
@RestController
@RequestMapping("/stock-basic")
public class StockBasicController {

    @Autowired
    private PullDataService pullDataService;

    @PostMapping("/pull-data")
    public void pullData(@RequestBody StockBasicDTO dto) {
        pullDataService.pullStockBasic(dto);
    }
}
