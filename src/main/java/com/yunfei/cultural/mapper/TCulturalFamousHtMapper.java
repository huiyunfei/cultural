package com.yunfei.cultural.mapper;

import com.yunfei.cultural.entity.TCulturalFamousHt;
import com.yunfei.cultural.model.vo.CulturalFamousHtResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TCulturalFamousHtMapper {


    void saveOrUpdateBitch(@Param("list") List<TCulturalFamousHt> culturalFamousHtArrayList);

    List<CulturalFamousHtResult> selectByParams(Map params);

    CulturalFamousHtResult selectById(Integer id);
}