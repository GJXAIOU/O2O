package com.gjxaiou.web.superadmin;

import com.gjxaiou.entity.Area;
import com.gjxaiou.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 超级管理员拥有整个区域权限
 *
 * @author GJXAIOU
 * @create 2019-10-31-16:17
 */
// 下面两注释分别表示该方法交由 Spring 管理，同时访问路径为 XXX
@Controller
@RequestMapping("/superadmin")
public class AreaController {
    Logger logger = LoggerFactory.getLogger(AreaController.class);
    // 将Service 层实体类交由 Spring 进行管理，使用到 areaService 时候将其实现类自动注入
    @Autowired
    private AreaService areaService;


    /**
     * 这里含义是使用 SpringMVC 作用域进行传值，这里使用的是 Map 集合（其他方式见总结笔记），本质上是将 Map 集合放入 Request 作用域
     * 然后 Spring 会将 map 集合通过 BindingAwareModelMap 类进行实例化；
     * 因为这是 Controller 返回值满足 key-value 格式，即返回值为对象或者 map 格式，使用 @ResponseBody 会使其恒不跳转，
     * 同时会自动将响应头设置为： application/json;charaSet=utf-8,且转换后的内容以输出流的形式返回到客户端；
     *
     * @return Map
     */
    @ResponseBody
    @RequestMapping(value = "/listarea", method = RequestMethod.GET)
    public Map<String, Object> listArea() {
        logger.info("====listArea() start======");
        long startTime = System.currentTimeMillis();
        // 1.存放 Controller 层方法的返回值，前端页面从这里取值
        Map<String, Object> modelMap = new HashMap<String, Object>();

        // 2.存放 Service 层方法返回的区域列表
        List<Area> list = new ArrayList<>();

        try {
            list = areaService.getAreaList();
            // 3.rows key 里面存放店铺列表，total 中存放店铺数量。和前端取值的 SUIMobile key 匹配
            modelMap.put("rows", list);
            modelMap.put("total", list.size());
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString() + "=> 获取区域列表失败，详见 AreaController.java");
        }
        long endTime = System.currentTimeMillis();
        logger.debug("[cost: {}ms]", endTime - startTime);
        logger.info("====listArea() end======");
        return modelMap;
    }
}
