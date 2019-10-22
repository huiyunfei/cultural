package com.yunfei.cultural.model.vo;

import lombok.Data;

import java.util.Date;

/**
 * Created by hui.yunfei@qq.com on 2019/10/12
 */
@Data
public class CulturalOrganResult {
    private Integer id;

    private String name;

    //简介
    private String resume;

    //成立时间
    private String setUpTime;

    //隶属
    private String possessBy;

    //任职人员
    private String incumbent;

    //性质
    private String nature;

    private String picUrl;

    private Date createTime;

    private Date updateTime;


}
