package com.gjxaiou.dto;


import com.gjxaiou.entity.PersonInfo;
import com.gjxaiou.enums.OperationStatusEnum;
import com.gjxaiou.enums.PersonInfoStateEnum;

import java.util.List;

/**
 * @Description: 用户信息返回信息
 *
 */
public class PersonInfoExecution {
	// 结果状态
	private int state;

	// 状态标识
	private String stateInfo;

	private int count;

	private PersonInfo localAuth;

	private List<PersonInfo> localAuthList;

	public PersonInfoExecution() {
	}

	// 失败的构造器
	public PersonInfoExecution(PersonInfoStateEnum stateEnum) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
	}

	// 成功的构造器
	public PersonInfoExecution(OperationStatusEnum stateEnum) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
	}

	// 成功的构造器
	public PersonInfoExecution(OperationStatusEnum stateEnum, PersonInfo localAuth) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.localAuth = localAuth;
	}

	// 成功的构造器
	public PersonInfoExecution(OperationStatusEnum stateEnum, List<PersonInfo> localAuthList) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.localAuthList = localAuthList;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public PersonInfo getPersonInfo() {
		return localAuth;
	}

	public void setPersonInfo(PersonInfo localAuth) {
		this.localAuth = localAuth;
	}

	public List<PersonInfo> getPersonInfoList() {
		return localAuthList;
	}

	public void setPersonInfoList(List<PersonInfo> localAuthList) {
		this.localAuthList = localAuthList;
	}

}
