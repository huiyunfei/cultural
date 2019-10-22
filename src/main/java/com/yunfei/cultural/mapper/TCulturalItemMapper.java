package com.yunfei.cultural.mapper;

import com.yunfei.cultural.entity.TCulturalItem;
import com.yunfei.cultural.model.vo.CulturalItemResult;

import java.util.List;
import java.util.Map;

public interface TCulturalItemMapper {

    void saveOrUpdateBitch(List<TCulturalItem> culturalItemList);

    List<CulturalItemResult> selectByParams(Map pramsMap);

    CulturalItemResult selectById(Integer id);
}