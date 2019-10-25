package com.yunfei.cultural.mapper;

import com.yunfei.cultural.model.vo.DataCountResult;

import java.util.List;

public interface QueryMapper {

    List<DataCountResult.Cell> countToday();

    List<DataCountResult.Cell> countWeek();

    List<DataCountResult.Cell> countMonth();

    List<DataCountResult.Cell> countCultural();
}