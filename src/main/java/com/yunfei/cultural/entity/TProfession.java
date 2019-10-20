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
public class TProfession {

    private Integer id;


    private Integer parentId;


    private String professionName;


    private String professionCode;


    private Date createTime;


    private Date updateTime;


}