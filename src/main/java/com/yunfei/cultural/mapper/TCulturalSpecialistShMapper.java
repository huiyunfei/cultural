package com.yunfei.cultural.mapper;

import com.yunfei.cultural.entity.TCulturalSpecialistSh;

import java.util.List;

public interface TCulturalSpecialistShMapper {

    int deleteByPrimaryKey(Integer id);


    int insert(TCulturalSpecialistSh record);


    int insertSelective(TCulturalSpecialistSh record);


    TCulturalSpecialistSh selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(TCulturalSpecialistSh record);


    int updateByPrimaryKey(TCulturalSpecialistSh record);

    void saveOrUpdateBitch(List<TCulturalSpecialistSh> culturalSpecialistShList);
}