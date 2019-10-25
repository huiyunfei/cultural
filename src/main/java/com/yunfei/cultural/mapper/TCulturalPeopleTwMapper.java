package com.yunfei.cultural.mapper;

import com.yunfei.cultural.entity.TCulturalPeopleTw;
import com.yunfei.cultural.model.vo.CulturalPeopleTwResult;

import java.util.List;
import java.util.Map;

public interface TCulturalPeopleTwMapper {


    void saveOrUpdateBitch(List<TCulturalPeopleTw> culturalPeopleTwList);

    List<CulturalPeopleTwResult> selectByParams(Map pramsMap);

    CulturalPeopleTwResult selectById(Integer id);

    Integer countAll();
}