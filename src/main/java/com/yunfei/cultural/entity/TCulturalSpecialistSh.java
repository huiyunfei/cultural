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
public class TCulturalSpecialistSh {

    private Integer id;


    private String name;


    private String areaCode;


    private Integer sex;


    private Integer age;


    private String professionCode;


    private String representativeWorks;

    private String resume;


    private String lifetime;


    private String job;


    private String headUrl;

    private Date createTime;


    private Date updateTime;

}