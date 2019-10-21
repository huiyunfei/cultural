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
public class TCulturalOrgan {

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