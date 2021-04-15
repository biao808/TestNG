package com.example.testapiauto.testCase.messageService;

import com.example.testapiauto.modules.testCase.common.Assertion.AssertionImp.ResponseAssertionImp;
import com.example.testapiauto.modules.testCase.utils.AssertUtil;
import com.example.testapiauto.modules.testCase.utils.HttpClient;
import com.example.testapiauto.testCase.case1;
import io.qameta.allure.Story;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author yuxiang
 * @version 1.0
 * @date 2021/4/15 13:49
 */
public class messageList {

    private static final Logger logger = LogManager.getLogger(case1.class);
    ResponseAssertionImp responseAssertionImp = new ResponseAssertionImp();

    String testUrl = new messageDetails().testUrl;


    @Story("消息列表")
    @Test(description = "正常查看消息列表")
    public void case_1(){
        String expect = "success";
        String url = testUrl+"/openApi/v1/message/10000";
        logger.info("请求url："+url);
        String response = HttpClient.doGet(url);
        logger.info("响应结果："+response);
        String msg = AssertUtil.asert(response,"$.msg");
        Assert.assertEquals(msg,expect);
//        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
        logger.info("断言结果："+responseAssertionImp.assertEqualsString(msg,expect));
    }
}
