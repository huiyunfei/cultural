package com.yunfei.cultural.mapper;

import com.yunfei.cultural.entity.TProfession;

public interface TProfessionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_profession
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_profession
     *
     * @mbg.generated
     */
    int insert(TProfession record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_profession
     *
     * @mbg.generated
     */
    int insertSelective(TProfession record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_profession
     *
     * @mbg.generated
     */
    TProfession selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_profession
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TProfession record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_profession
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TProfession record);
}