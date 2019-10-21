package com.yunfei.cultural.mapper;

import com.yunfei.cultural.entity.TDict;

import java.util.List;

public interface TDictMapper {

    List<TDict> selectAll();

    List<TDict> selectByType(String type);
}