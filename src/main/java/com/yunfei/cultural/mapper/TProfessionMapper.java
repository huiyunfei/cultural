package com.yunfei.cultural.mapper;

import com.yunfei.cultural.entity.TProfession;
import com.yunfei.cultural.model.vo.DataCountResult;

import java.util.List;

public interface TProfessionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TProfession record);

    int insertSelective(TProfession record);

    TProfession selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TProfession record);

    int updateByPrimaryKey(TProfession record);

    List<DataCountResult.Cell> countGroupByCode();
}