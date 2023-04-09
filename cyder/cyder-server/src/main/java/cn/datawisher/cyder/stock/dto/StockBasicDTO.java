package cn.datawisher.cyder.stock.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class StockBasicDTO {

    /** TS股票代码 */
    @JsonProperty("ts_code")
    private String tsCode;
    /** 名称 */
    @JsonProperty("name")
    private String name;
    /** 交易所 SSE上交所 SZSE深交所 BSE北交所 */
    @JsonProperty("exchange")
    private String exchange;
    /** 市场类别 （主板/创业板/科创板/CDR/北交所） */
    @JsonProperty("market")
    private String market;
    /** 是否沪深港通标的，N否 H沪股通 S深股通 */
    @JsonProperty("is_hs")
    private String isHs;
    /** 上市状态 L上市 D退市 P暂停上市，默认是L */
    @JsonProperty("list_status")
    private String listStatus;
    /** 单次返回数据长度 */
    @JsonProperty("limit")
    private Integer limit;
    /** 请求数据的开始位移量 */
    @JsonProperty("offset")
    private Integer offset;

}
