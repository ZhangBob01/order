package com.bob.order.utils;

import com.bob.order.VO.ResultVO;

/**
 * @Auther: toudaizhi
 * @Date: 2019-04-24 14:40
 * @Description:
 */
public class ResultVOUtil {

    public static ResultVO success(Object object){

        ResultVO resultVO = new ResultVO();

        resultVO.setCode(10000);
        resultVO.setMessage("成功");
        resultVO.setData(object);

        return  resultVO;
    }
}
