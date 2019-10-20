package com.yunfei.cultural.mapper;

import com.yunfei.cultural.entity.TCulturalFamousHt;
import com.yunfei.cultural.model.dto.CulturalFamousHtParams;
import com.yunfei.cultural.model.vo.CulturalFamousHtResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TCulturalFamousHtMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(TCulturalFamousHt record);

    TCulturalFamousHt selectByPrimaryKey(Integer id);

    void saveOrUpdateBitch(@Param("list") List<TCulturalFamousHt> culturalFamousHtArrayList);

    List<CulturalFamousHtResult> selectByParams(CulturalFamousHtParams params);
}