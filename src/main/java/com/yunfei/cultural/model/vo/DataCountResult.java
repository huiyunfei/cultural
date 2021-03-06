package com.yunfei.cultural.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by hui.yunfei@qq.com on 2019/10/12
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataCountResult {

    //职业
    private List<Cell> professList;

    //机构
    private List<Cell> organList;

    //人物
    private List<Cell> culturalList;

    //新增数据
    private List<CellNew> culturaNewList;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Cell{

        private String label;

        private Integer num;
    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class CellNew{

        private String label;

        private Integer numDay=0;

        private Integer numWeek=0;

        private Integer numMonth=0;
    }
}






