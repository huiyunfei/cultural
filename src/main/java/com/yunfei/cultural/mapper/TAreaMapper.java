package com.yunfei.cultural.mapper;

import com.yunfei.cultural.entity.TArea;

public interface TAreaMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_area
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_area
     *
     * @mbg.generated
     */
    int insert(TArea record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_area
     *
     * @mbg.generated
     */
    int insertSelective(TArea record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_area
     *
     * @mbg.generated
     */
    TArea selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_area
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TArea record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_area
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TArea record);
}