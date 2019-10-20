package com.yunfei.cultural.mapper;

import com.yunfei.cultural.entity.TCulturalFamousHt;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TCulturalFamousHtMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(TCulturalFamousHt record);

    TCulturalFamousHt selectByPrimaryKey(Integer id);

    void saveOrUpdateBitch(@Param("list") List<TCulturalFamousHt> culturalFamousHtArrayList);
}