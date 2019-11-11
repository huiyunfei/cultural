package com.yunfei.cultural.model.vo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Created by hui.yunfei@qq.com on 2019/10/12
 */
@Data
@Builder
public class ListUserResult {

    private List<UserResult> userList;

    private List<RoleResult> roleList;

    @Data
    @Builder
    public static class UserResult{

        private Integer id;

        private String username;

        private String telephone;

        private String phone;

        private String email;

        private String name;

        private Integer status;

        private String roleName;
    }

    @Data
    @Builder
    public static class RoleResult{

        private Integer roleId;

        private String roleName;
    }

}
