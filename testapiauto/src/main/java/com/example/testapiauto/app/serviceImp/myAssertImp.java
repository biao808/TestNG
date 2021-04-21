package com.example.testapiauto.app.serviceImp;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.example.testapiauto.app.dao.myAssertDao;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public  class myAssertImp implements myAssertDao {

    private static final Logger logger = LogManager.getLogger(myAssertImp.class);


    public boolean assertAll1(Object expect, Object act){
        if (expect.toString().trim().equals(act.toString())){
            return true;
        }else {
            return false;
        }
    }

    public boolean assertJson(String excpet,String actString, String jsonPatch){
        try {
            JSONObject actJson = JSONObject.parseObject(actString);
            Object vaule= JSONPath.eval(actJson,jsonPatch);
            if (vaule.toString().equals(excpet)){
                return true;
            }

        }catch (Exception e){
            System.out.println("输入的格式不正确，Json转换异常");
            e.printStackTrace();
        }

        return false;
    }


    @Override
    public boolean AssertAll(String expect, String act) {
        return false;
    }

    /**
      *
      * @param
      * @author 假斯文
      * @date 2021/4/20 8:57
      * @return
      */

     @Override
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
                 return false;
             }
         }else{
             logger.info("预期结果集和实际结果集长度不一致");
             return false;
         }
         return flag;
     }

    @Override
    public boolean AssertBySql(String expect, String sql) {
        return false;
    }


    //测试代码
    public static void main(String[] args) {
        Object[] obj = new Object[3];
        obj[0] = 2;
        obj[1] = "aaa";
        obj[2] = true;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",1);
        jsonObject.put("data1","aaa");
        jsonObject.put("data2",true);
        String[] exp = new String[3];
        exp[0] = "$.code";
        exp[1] = "$.data1";
        exp[2] = "$.data2";
        myAssertImp imp = new myAssertImp();
        imp.AssertByJsonPath(obj,jsonObject,exp);
    }



//    public static void main(String[] args) {
//        myAssertImp myAssert = new myAssertImp();
//        String a = "{\n" +
//                "\"code\":\"0\",\n" +
//                "\"name\":\"jsw\",\n" +
//                "\"age\":18,\n" +
//                "\"msg\":\"查询成功\"\n" +
//                "}";
////        boolean result = myAssert.assertJson("0",a,"$.code");
////        System.out.println(result);
//        JSONObject ao = JSONObject.parseObject(a);
////        System.out.println(ao.get("code"));
////        ao.put("height",170);
////        System.out.println(ao.toString());
//        ao.put("name","lisi");
//        System.out.println(ao.toString());
//        for (Map.Entry<String,Object> entry : ao.entrySet()){
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//        }
//    }
}
