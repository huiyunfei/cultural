package com.yunfei.cultural.mapper;

import com.yunfei.cultural.entity.TCulturalItem;

import java.util.List;

public interface TCulturalItemMapper {

    void saveOrUpdateBitch(List<TCulturalItem> culturalItemList);
}