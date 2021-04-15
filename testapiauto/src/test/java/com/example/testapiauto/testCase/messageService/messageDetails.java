package com.example.testapiauto.testCase.messageService;

import com.example.testapiauto.modules.testCase.common.Assertion.AssertionImp.ResponseAssertionImp;
import com.example.testapiauto.modules.testCase.utils.AssertUtil;
import com.example.testapiauto.modules.testCase.utils.HttpClient;
import com.example.testapiauto.testCase.case1;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author yuxiang
 * @version 1.0
 * @date 2021/4/14 16:52
 */



@Epic("消息服务")
@Feature("消息详情")
public class messageDetails {
    private static final Logger logger = LogManager.getLogger(case1.class);
    ResponseAssertionImp responseAssertionImp = new ResponseAssertionImp();

    String testUrl = "http://101.132.96.141:31367";


    @Story("查看消息详情")
    @Test(description = "正常查看，输入正确ID")
    public void case_1(){
        String expect = "success";
        String url = testUrl+"/openApi/v1/message/id?id=145";
        logger.info("请求url："+url);
        String response = HttpClient.doGet(url);
        logger.info("响应结果："+response);
        String msg = AssertUtil.asert(response,"$.msg");
        Assert.assertEquals(msg,expect);
        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
        logger.info("断言结果："+assertutil);
    }

    @Story("查看消息详情")
    @Test(description = "异常查看，输入错误ID")
    public void case_2(){
        String expect = "400";
        String url = testUrl+"/openApi/v1/message/id?id=9*";
        logger.info("请求url："+url);
        String response = HttpClient.doGet(url);
        logger.info("响应结果："+response);
        String msg = AssertUtil.asert(response,"$.status");
        Assert.assertEquals(msg,expect);
        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
        logger.info("断言结果："+assertutil);
    }

    @Story("查看消息详情")
    @Test(description = "异常查看，输入不存在ID")
    public void case_3(){
        String expect = "business exception";
        String url = testUrl+"/openApi/v1/message/id?id=9099";
        logger.info("请求url："+url);
        String response = HttpClient.doGet(url);
        logger.info("响应结果："+response);
        String msg = AssertUtil.asert(response,"$.msg");
        Assert.assertEquals(msg,expect);
        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
        logger.info("断言结果："+assertutil);
    }

    @Story("查看消息详情")
    @Test(description = "异常查看，不输入ID")
    public void case_4(){
        String expect = "business exception";
        String url = testUrl+"/openApi/v1/message/id?id=";
        logger.info("请求url："+url);
        String response = HttpClient.doGet(url);
        logger.info("响应结果："+response);
        String msg = AssertUtil.asert(response,"$.msg");
        Assert.assertEquals(msg,expect);
        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
        logger.info("断言结果："+assertutil);
    }

    @Story("查看消息详情")
    @Test(description = "异常查看，输入null")
    public void case_5(){
        String expect = "400";
        String url = testUrl+"/openApi/v1/message/id?id=null1";
        logger.info("请求url："+url);
        String response = HttpClient.doGet(url);
        logger.info("响应结果："+response);
        String msg = AssertUtil.asert(response,"$.status");
        Assert.assertEquals(msg,expect);
        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
        logger.info("断言结果："+assertutil);
    }
}
