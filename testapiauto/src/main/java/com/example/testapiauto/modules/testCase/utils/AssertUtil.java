package com.example.testapiauto.modules.testCase.utils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import org.apache.log4j.*;


/**
 * @ClassName: AssertUtil
 * @Description: TODO
 * @author: 假斯文
 * @date: 2021年03月19日 17:19
 * @Version 1.0
 */

public class AssertUtil {
    public static String asert(String response,String jsonpath){
        String result = "";
        try {
            JSONObject jsonObject = JSONObject.parseObject(response);
            result = JSONPath.eval(jsonObject,jsonpath).toString();
        }catch (Exception e){
            result = "转换JSON失败";
            e.printStackTrace();
        }
        return result;
    }
}