package cn.datawisher.cyder.stock.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *
 * </p>
 *
 * @author Jim Han
 * @since 2023-03-31
 */
@Getter
@Setter
@TableName("stock_basic")
public class StockBasic implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * TS代码
     */
    private String tsCode;

    /**
     * 股票代码
     */
    @TableId
    private String symbol;

    /**
     * 股票名称
     */
    private String name;

    /**
     * 地域
     */
    private String area;

    /**
     * 所属行业
     */
    private String industry;

    /**
     * 股票全称
     */
    private String fullname;

    /**
     * 英文全称
     */
    private String enname;

    /**
     * 拼音缩写
     */
    private String cnspell;

    /**
     * 市场类型
     */
    private String market;

    /**
     * 交易所代码
     */
    private String exchange;

    /**
     * 交易货币
     */
    private String currType;

    /**
     * 上市状态（L上市 D退市 P暂停上市）
     */
    private String listStatus;

    /**
     * 上市日期
     */
    private String listDate;

    /**
     * 退市日期
     */
    private String delistDate;

    /**
     * 是否沪深港通标的（N否 H沪股通 S深股通）
     */
    private String isHs;
}
