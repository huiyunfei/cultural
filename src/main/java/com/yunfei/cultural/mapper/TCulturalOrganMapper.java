package com.yunfei.cultural.mapper;

import com.yunfei.cultural.entity.TCulturalOrgan;
import com.yunfei.cultural.model.vo.CulturalOrganResult;

import java.util.List;
import java.util.Map;

public interface TCulturalOrganMapper {

    void saveOrUpdateBitch(List<TCulturalOrgan> culturalOrganList);

    List<CulturalOrganResult> selectByParams(Map pramsMap);

    CulturalOrganResult selectById(Integer id);
}