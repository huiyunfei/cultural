package com.yunfei.cultural.model.vo;

import lombok.Data;

/**
 * Created by hui.yunfei@qq.com on 2019/10/12
 */
@Data
public class CulturalPeopleTwResult {

    private Integer id;
    //姓名
    private String name;
    //职业
    private String professionName;

    private String area;

    private String sex;

    private Integer age;

    //代表作品
    private String representativeWorks;

    //简介
    private String resume;

    //生涯
    private String lifetime;

    //职务
    private String job;

    //头像
    private String headUrl;


}
