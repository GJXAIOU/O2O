package com.gjxaiou.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

import java.util.HashMap;
import java.util.Map;

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

    /**
     * 生成二维码的图片流
     *
     * @param content  二位码图片内容
     * @param response
     * @return
     */
    public static BitMatrix generateQRCodeStream(String content, HttpServletResponse response) {
        //给响应头添加头部信息，主要是告诉浏览器返回的是图片流
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/png");

        //设置图片的文字编码以及内边框距
        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");//设置二维码的编码
        hints.put(EncodeHintType.MARGIN, 0);//设置二维码内边框距

        BitMatrix bitMatrix;
        try {
            //参数顺序分别为：编码内容，编码类型，生成图片的宽度，生成图片的高度，设置参数
            bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, 300, 300,
                    hints);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return bitMatrix;
    }
}
