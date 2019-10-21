package com.yunfei.cultural.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TCulturalItem {

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