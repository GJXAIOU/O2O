package com.gjxaiou.util;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * @Description: 继承PropertyPlaceholderConfigurer，重写convertProperty
 *
 */
public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
	// 需要加密的字段数组
	private String[] encryptPropNames = { "jdbc.Master.username", "jdbc.Master.password", "jdbc" +
			".Slave.username", "jdbc.Slave.password","redis.hostname" };

	/**
	 * 对关键的属性进行转换
	 */
	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		// 判断是否加密
		if (isEncryptProp(propertyName)) {
			// 解密
			String decryptValue = DESUtil.getDecryptString(propertyValue);
			return decryptValue;
		} else {
			return propertyValue;
		}
	}

	/**
	 * 判断该属性是否加密
	 * 
	 * @param propertyName
	 * @return
	 */
	private boolean isEncryptProp(String propertyName) {
		for (String encryptpropertyName : encryptPropNames) {
			if (encryptpropertyName.equals(propertyName)){
				return true;
			}
		}
		return false;
	}
}