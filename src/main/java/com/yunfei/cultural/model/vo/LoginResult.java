package com.yunfei.cultural.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by hui.yunfei@qq.com on 2019/10/12
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResult {

    private Integer id;

    private String email;

    private String name;

    private String token;

    private String headUrl;

    private String phone;

    private Boolean sex;
}
