package com.yunfei.cultural.model.vo;

import lombok.Data;

import java.util.Date;

/**
 * Created by hui.yunfei@qq.com on 2019/10/12
 */
@Data
public class CulturalItemResult {
    private Integer id;

    private String name;

    //主办单位
    private String organizer;

    //活动时间
    private String time;

    private String areaCode;

    //简介
    private String resume;

    private String picUrl;

    private Date createTime;

    private Date updateTime;


}
