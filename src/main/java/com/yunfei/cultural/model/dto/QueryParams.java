package com.yunfei.cultural.model.dto;

import lombok.Data;

/**
 * Created by hui.yunfei@qq.com on 2019/10/12
 */
@Data
public class QueryParams {

    private Integer queryType;

    private String keyword;

    private Integer id;

    private Integer pageNo;
}

