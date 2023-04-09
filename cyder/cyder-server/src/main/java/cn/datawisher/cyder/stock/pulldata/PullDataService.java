package cn.datawisher.cyder.stock.pulldata;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cn.datawisher.cyder.stock.dto.RequestDTO;
import cn.datawisher.cyder.stock.dto.ResponseDTO;
import cn.datawisher.cyder.stock.dto.StockBasicDTO;
import cn.datawisher.cyder.stock.entity.StockBasic;
import cn.datawisher.cyder.stock.service.IStockBasicService;
import cn.hutool.core.exceptions.UtilException;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PullDataService {

    @Value("${tushare.api.url}")
    private String tushareApiUrl;
    @Value("${tushare.api.token}")
    private String tushareApiToken;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private IStockBasicService stockBasicService;

    public void pullStockBasic(StockBasicDTO stockBasicDTO) {

        RequestDTO<StockBasicDTO> request = new RequestDTO<>(stockBasicDTO);
        request.setApiName("stock_basic");
        request.setToken(tushareApiToken);
        request.setFields("ts_code,symbol,name,area,industry,fullname,enname,cnspell,market,exchange,curr_type,list_status,list_date,delist_date,is_hs");

        try {
            ResponseEntity<ResponseDTO> response = restTemplate.postForEntity(tushareApiUrl, request, ResponseDTO.class);
            ResponseDTO body = response.getBody();
            String[] fields = body.getData().getFields();
            Set<String[]> items = body.getData().getItems();
            List<StockBasic> stockBasics = new LinkedList<>();
            for (String[] item : items) {
                StockBasic stockBasic = new StockBasic();
                for (int i = 0; i < fields.length; i++) {
                    String fieldName = StrUtil.upperFirst(StrUtil.toCamelCase(fields[i]));
//                    log.info(JSONObject.toJSONString(stockBasic));
                    ReflectUtil.invoke(stockBasic, "set" + fieldName, Optional.ofNullable(item[i]).orElse(""));
                }
                stockBasics.add(stockBasic);
            }

            stockBasicService.saveBatch(stockBasics);
        } catch (UtilException e) {
            throw new RuntimeException(e);
        }
    }
}
