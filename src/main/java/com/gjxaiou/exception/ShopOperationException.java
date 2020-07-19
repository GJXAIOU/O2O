package com.gjxaiou.exception;

/**
 * 稍微对 RuntimeException 进行微弱的封装，就是报错的时候可以看到 ShopOperationException 从而知道是什么方法报错
 * **必须继承的是 RuntimeException，因为如果是 Exception 就不会回滚。**
 * @author GJXAIOU
 * @create 2019-11-02-10:19
 */
public class ShopOperationException extends RuntimeException {
    // 因为需要序列化，所以要加这个
    private static final long serialVersionUID = 7923277044845362315L;

    public ShopOperationException(String msg) {
        super(msg);
    }
}
