package com.gjxaiou.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author GJXAIOU
 * @create 2019-10-29-22:21
 */
@Getter
@Setter
@ToString
public class LocalAuth {
    // 主键 ID
    private Long localAuthId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    private Date createTime;
    /**
     * 最后一次更新时间
     */
    private Date lastEditTime;
    /**
     * 个人信息，关系为一一对应 =》一个账号对应一个用户
     */
    private PersonInfo personInfo;

    public Long getLocalAuthId() {
        return localAuthId;
    }

    public void setLocalAuthId(Long localAuthId) {
        this.localAuthId = localAuthId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }
}
