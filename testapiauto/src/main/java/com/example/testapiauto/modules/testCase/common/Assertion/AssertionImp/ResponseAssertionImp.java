package com.example.testapiauto.modules.testCase.common.Assertion.AssertionImp;

import com.example.testapiauto.modules.testCase.common.Assertion.AssertionInterface.ResponseAssertion;
import com.example.testapiauto.modules.testCase.utils.AssertUtil;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Map;


/**
 * @ClassName: ResponseAssertionImp
 * @Description: TODO
 * @author: 假斯文
 * @date: 2021年03月30日 17:15
 * @Version 1.0
 */

@Component
public class ResponseAssertionImp implements ResponseAssertion {
    private String result = "";
    private AssertUtil assertUtil = new AssertUtil();
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public String assertEqualsString(String response, String expectString) {
        if (response.trim().equals(expectString.trim())) {
            result = "断言通过" + "\n实际结果：" + response + "，预期结果：" + expectString;
//            logger.info("******" + result + "******");
        } else {
            result = "断言失败" + "\n实际结果：" + response + "，预期结果：" + expectString;
//            logger.info("******" + result + "******");
        }
        return result;
    }


    @Override
    public String assertEqualsJson(String response, Map<String, String> pathAsserts) {
        AssertUtil assertUtil = new AssertUtil();
        StringBuffer stringBuffer = new StringBuffer();
        String act = "";
        if (response.trim().equals("") || response.trim() == null) {
            result = "响应信息为空";
        } else {
            for (Map.Entry<String, String> entry : pathAsserts.entrySet()) {
                act = assertUtil.asert(response, entry.getKey());
                if (act.equals(entry.getValue())) {
                    stringBuffer.append("断言成功：" + "\njsonpath：" + entry.getKey() + "\n实际结果：" + act + "\n预期结果：" + entry.getValue() + "\n\n");
                } else {
                    stringBuffer.append("断言失败：" + "\njsonpath：" + entry.getKey() + "\n实际结果：" + act + "\n预期结果：" + entry.getValue() + "\n\n");
                }
            }
        }
        result = stringBuffer.toString();

        return result;
    }

    @Override
    public String assertEqualsSql(String response, String[] sql) {
        return null;
    }
    //    public static String assertEquals(String response,String expect,String jsonPath){
//        try{
//            JSONObject jsonObject = JSONObject.parseObject(response);
//            String act = JSONPath.eval(jsonObject,jsonPath).toString();
//            if(act.equals(expect)){
//                return "PASS";
//            }
//            else{
//                return "FAIL";
//            }
//        }catch (Exception e){
//            return "JSON转换有误，请检查接口响应是否有问题"+"\n"+e.getMessage();
//        }
//
//    }

}
