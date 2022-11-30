package com.datawisher.bee.system.word.example;

import com.deepoove.poi.data.RowRenderData;

import java.util.List;

/**
 * @author h407644
 * @date 2022-11-19
 */
public class DetailData {
    // 货品数据
    private List<RowRenderData> goods;

    // 人工费数据
    private List<RowRenderData> labors;

    public List<RowRenderData> getGoods() {
        return goods;
    }

    public void setGoods(List<RowRenderData> goods) {
        this.goods = goods;
    }

    public List<RowRenderData> getLabors() {
        return labors;
    }

    public void setLabors(List<RowRenderData> labors) {
        this.labors = labors;
    }
}
