package com.gjxaiou.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author GJXAIOU
 * @create 2019-10-19-14:30
 */
public class CodeUtil {
    public static boolean checkVerifyCode(HttpServletRequest request) {
        // 从 session 中得到实际的验证码
        String verifyCodeExpected = (String) request.getSession().getAttribute(
                com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        // 输入的验证码
        String verifyCodeActual = HttpServletRequestUtil.getString(request,
                "verifyCodeActual");
        if (verifyCodeActual == null
                || !verifyCodeActual.equalsIgnoreCase(verifyCodeExpected)) {
            return false;
        }
        return true;
    }
}
