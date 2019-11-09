package com.yunfei.cultural.entity;

import java.util.Date;

/**
 * @Description: 职业
 * @Author: HuiYunfei
 * @Date: 2019/11/9
 */
public class TProfession {
    private Integer id;

    private Integer parentId;

    private String professionName;

    private String professionCode;

    private Date createTime;

    private Date updateTime;

    private Integer professionLevel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName == null ? null : professionName.trim();
    }

    public String getProfessionCode() {
        return professionCode;
    }

    public void setProfessionCode(String professionCode) {
        this.professionCode = professionCode == null ? null : professionCode.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getProfessionLevel() {
        return professionLevel;
    }

    public void setProfessionLevel(Integer professionLevel) {
        this.professionLevel = professionLevel;
    }
}