package com.bob.order.utils;

import java.util.Random;

/**
 * @Auther: toudaizhi
 * @Date: 2019-04-16 14:17
 * @Description:
 */
public class KeyUtil {

    /**
     * 生成唯一主键
     * @return
     */
    public static synchronized String getUniqueKey(String key){

        Random random = new Random();
        Integer number = random.nextInt(900000)+100000;

        return key + System.currentTimeMillis() + String.valueOf(number);
    }
}
