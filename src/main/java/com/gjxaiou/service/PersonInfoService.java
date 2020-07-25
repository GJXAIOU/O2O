package com.gjxaiou.service;

import com.gjxaiou.dto.PersonInfoExecution;
import com.gjxaiou.entity.PersonInfo;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author ASUS
 * @Date 2019/12/1 19:34
 */
public interface PersonInfoService {
    /**
     * 根据用户Id获取personInfo信息
     *
     * @param userId
     * @return
     */
    PersonInfo getPersonInfoById(Long userId);

    /**
     * 根据查询条件分页返回用户信息列表
     *
     * @param personInfoCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    PersonInfoExecution getPersonInfoList(PersonInfo personInfoCondition, int pageIndex,
                                          int pageSize);

    /**
     * 根据传入的PersonInfo修改对应的用户信息
     *
     * @param pi
     * @return
     */
    PersonInfoExecution modifyPersonInfo(PersonInfo pi);
}
