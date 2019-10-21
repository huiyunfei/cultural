package com.yunfei.cultural.mapper;

import com.yunfei.cultural.entity.TCulturalOrgan;

import java.util.List;

public interface TCulturalOrganMapper {

    void saveOrUpdateBitch(List<TCulturalOrgan> culturalOrganList);
}