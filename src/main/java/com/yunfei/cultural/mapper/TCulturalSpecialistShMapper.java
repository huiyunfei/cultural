package com.yunfei.cultural.mapper;

import com.yunfei.cultural.entity.TCulturalSpecialistSh;
import com.yunfei.cultural.model.vo.CulturalSpecialistShResult;

import java.util.List;
import java.util.Map;

public interface TCulturalSpecialistShMapper {



    void saveOrUpdateBitch(List<TCulturalSpecialistSh> culturalSpecialistShList);

    List<CulturalSpecialistShResult> selectByParams(Map pramsMap);

    CulturalSpecialistShResult selectById(Integer id);
}