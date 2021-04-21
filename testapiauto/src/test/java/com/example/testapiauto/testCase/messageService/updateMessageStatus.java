package com.example.testapiauto.testCase.messageService;

import com.alibaba.fastjson.JSONObject;
import com.example.testapiauto.app.serviceImp.myAssertImp;
import com.example.testapiauto.modules.testCase.utils.HttpClient;
import com.example.testapiauto.yuxiang.resultsUtils;
import io.qameta.allure.*;
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
 * @date 2021/4/15 14:20
 */

@Epic("更新消息状态")
@Feature("更新")
public class updateMessageStatus {

    private static final Logger logger = LogManager.getLogger(updateMessageStatus.class);
    String testUrl = resultsUtils.TestUrl;
    String Token = resultsUtils.token;
    myAssertImp myassertimp = new myAssertImp();


    @Story("更新消息状态")
    @Test(description = "正常查看，正确id")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:"+resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址",type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_1(){
        Object[] expect = new Object[2];
        expect[0] = "20000";
        expect[1] = "success";
        String url = testUrl + "/openApi/v1/message/update/145";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type","application/x-www-form-urlencoded");
        String body = "";
        String response = HttpClient.doPost_Json(body,url, headers);
        logger.info("响应结果：" + response);
        JSONObject act = JSONObject.parseObject(response);
        act.get("code");
        act.get("msg");
        String[] JsonPach = new String[2];
        JsonPach[0] = "$.code";
        JsonPach[1] = "$.msg";
        boolean ResponseAssert = myassertimp.AssertByJsonPath(expect, act, JsonPach);
        logger.info("响应断言：" + ResponseAssert);
        Assert.assertEquals(expect[0], act.getString("code"));

//        String expect = "success";
//        String url = testUrl+"/openApi/v1/message/update/145";
//        logger.info("请求url："+url);
//        String body = "";
//        Map<String, Object> headers = new HashMap<>();
//        headers.put("Content-Type","application/x-www-form-urlencoded");
//        String response = HttpClient.doPost_Json(body,url,headers);
//        logger.info("响应结果："+response);
//        String msg = AssertUtil.asert(response,"$.msg");
//        Assert.assertEquals(msg,expect);
//        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
//        logger.info("断言结果："+assertutil);
    }

    @Story("更新消息状态")
    @Test(description = "异常查看，错误id")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:"+resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址",type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_2(){
        Object[] expect = new Object[2];
        expect[0] = "20002";
        expect[1] = "business exception";
        String url = testUrl + "/openApi/v1/message/update/jsw";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type","application/x-www-form-urlencoded");
        String body = "";
        String response = HttpClient.doPost_Json(body,url, headers);
        logger.info("响应结果：" + response);
        JSONObject act = JSONObject.parseObject(response);
        act.get("code");
        act.get("msg");
        String[] JsonPach = new String[2];
        JsonPach[0] = "$.code";
        JsonPach[1] = "$.msg";
        boolean ResponseAssert = myassertimp.AssertByJsonPath(expect, act, JsonPach);
        logger.info("响应断言：" + ResponseAssert);
        Assert.assertEquals(expect[0], act.getString("code"));

//        String expect = "Bad Request";
//        String expect1 = "400";
//        String url = testUrl+"/openApi/v1/message/update/jsw";
//        logger.info("请求url："+url);
//        String body = "";
//        Map<String, Object> headers = new HashMap<>();
//        headers.put("Content-Type","application/x-www-form-urlencoded");
//        String response = HttpClient.doPost_Json(body,url,headers);
//        logger.info("响应结果："+response);
//        String error = AssertUtil.asert(response,"$.error");
//        String status = AssertUtil.asert(response,"$.status");
//        Assert.assertEquals(error,expect);
//        Assert.assertEquals(status,expect1);
//        String assertutil = responseAssertionImp.assertEqualsString(error,expect);
//        String assertutil1 = responseAssertionImp.assertEqualsString(status,expect1);
//        logger.info("断言结果："+assertutil+"\n"+assertutil1);
    }

    @Story("更新消息状态")
    @Test(description = "异常查看，不存在id")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:"+resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址",type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_3(){
        Object[] expect = new Object[2];
        expect[0] = "20002";
        expect[1] = "business exception";
        String url = testUrl + "/openApi/v1/message/update/9999";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type","application/x-www-form-urlencoded");
        String body = "";
        String response = HttpClient.doPost_Json(body,url, headers);
        logger.info("响应结果：" + response);
        JSONObject act = JSONObject.parseObject(response);
        act.get("code");
        act.get("msg");
        String[] JsonPach = new String[2];
        JsonPach[0] = "$.code";
        JsonPach[1] = "$.msg";
        boolean ResponseAssert = myassertimp.AssertByJsonPath(expect, act, JsonPach);
        logger.info("响应断言：" + ResponseAssert);
        Assert.assertEquals(expect[0], act.getString("code"));

//        String expect = "business exception";
//        String expect1 = "20002";
//        String url = testUrl+"/openApi/v1/message/update/999";
//        logger.info("请求url："+url);
//        String body = "";
//        Map<String, Object> headers = new HashMap<>();
//        headers.put("Content-Type","application/x-www-form-urlencoded");
//        String response = HttpClient.doPost_Json(body,url,headers);
//        logger.info("响应结果："+response);
//        String msg = AssertUtil.asert(response,"$.msg");
//        String code = AssertUtil.asert(response,"$.code");
//        Assert.assertEquals(msg,expect);
//        Assert.assertEquals(code,expect1);
//        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
//        String assertutil1 = responseAssertionImp.assertEqualsString(code,expect1);
//        logger.info("断言结果："+assertutil+"\n"+assertutil1);
    }
}
