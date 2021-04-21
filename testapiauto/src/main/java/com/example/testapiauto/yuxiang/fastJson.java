package com.example.testapiauto.yuxiang;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * TODO
 *
 * @author yuxiang
 * @version 1.0
 * @date 2021/4/16 17:11
 */
public class fastJson {

    private static final Logger logger = LogManager.getLogger(fastJson.class);

//    @Override
    public boolean AssertByJsonPath(Object[] expects, JSONObject json, String[] jsonPaths) {
        int expLength = expects.length;
        int jsonPathLength = jsonPaths.length;
        boolean flag = true;

        if(expLength == jsonPathLength){
            try{
                for(int i=0;i<jsonPaths.length;i++){
                    Object obj = JSONPath.eval(json,jsonPaths[i]);
                    if(obj == expects[i] || obj.toString().equals(expects[i])){
                        logger.info("第"+(i+1)+"个断言成功：实际结果 "+obj.toString()+",预期结果："+expects[i]);
                    }else {
                        logger.info("第"+(i+1)+"个断言失败：实际结果 "+obj.toString()+",预期结果："+expects[i]);
                        flag = false;
                    }
                }
            }catch (Exception e){
                logger.info("请检查JSONPath表达式规范");
                e.printStackTrace();
            }
        }else{
            logger.info("预期结果集和实际结果集长度不一致");
            return false;
        }
        return flag;
    }

//    @Override
    public boolean AssertBySql(String expect, String sql) {
        return false;
    }


//    测试代码
//    public static void main(String[] args) {
//        Object[] obj = new Object[3];
//        obj[0] = 2;
//        obj[1] = "aaa";
//        obj[2] = true;
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("code",1);
//        jsonObject.put("data1","aaa");
//        jsonObject.put("data2",true);
//        String[] exp = new String[3];
//        exp[0] = "$.code";
//        exp[1] = "$.data1";
//        exp[2] = "$.data2";
//        EsLinkAssertImpl imp = new EsLinkAssertImpl();
//        imp.AssertByJsonPath(obj,jsonObject,exp);
//
//    }
}


