package com.gjxaiou.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author GJXAIOU
 * @create 2019-10-29-22:23
 */
@Getter
@Setter
@ToString
public class WeChatAuth {
    private Long weChatAuthId;
    private String openId;
    private Date createTime;
    private PersonInfo personInfo;

    public Long getWeChatAuthId() {
        return weChatAuthId;
    }

    public void setWeChatAuthId(Long weChatAuthId) {
        this.weChatAuthId = weChatAuthId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }

    @Override
    public String toString() {
        return "WeChatAuth{" +
                "weChatAuthId=" + weChatAuthId +
                ", openId='" + openId + '\'' +
                ", createTime=" + createTime +
                ", personInfo=" + personInfo +
                '}';
    }
}
