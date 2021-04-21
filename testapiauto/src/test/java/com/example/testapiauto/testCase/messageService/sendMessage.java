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
 * @date 2021/4/16 16:05
 */

@Epic("发送消息获取指定部门下的角色用户集合")
@Feature("发送")
public class sendMessage {

    private static final Logger logger = LogManager.getLogger(sendMessage.class);
    String testUrl = resultsUtils.TestUrl;
    String Token = resultsUtils.token;
    myAssertImp myassertimp = new myAssertImp();


    @Story("发送消息获取指定部门下的角色用户集合")
    @Test(description = "正常查看，正确orgId和roleId")//orgId=部门id，roleId角色id
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
        String url = testUrl + "/openApi/v1/message/orgRoleRef/2/1000";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type","application/x-www-form-urlencoded");
        String response = HttpClient.doGet_header(url, headers);
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
//        String expect1 = "20000";
//        String url = testUrl+"/openApi/v1/message/orgRoleRef/2/1000";
//        logger.info("请求url："+url);
//        Map<String, Object> headers = new HashMap<>();
//        headers.put("Content-Type","application/x-www-form-urlencoded");
//        String response = HttpClient.doGet_header(url,headers);
//        logger.info("响应结果："+response);
//        String msg = AssertUtil.asert(response,"$.msg");
//        String code = AssertUtil.asert(response,"$.code");
//        Assert.assertEquals(msg,expect);
//        Assert.assertEquals(code,expect1);
//        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
//        String assertutil1 = responseAssertionImp.assertEqualsString(code,expect1);
//        logger.info("断言结果：\n"+assertutil + "\n" + assertutil1);
    }


    @Story("发送消息获取指定部门下的角色用户集合")
    @Test(description = "异常查看，错误orgId和正确roleId")//orgId=部门id，roleId角色id
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:"+resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址",type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_2(){
        Object[] expect = new Object[2];
        expect[0] = "400";
        expect[1] = "Bad Request";
        String url = testUrl + "/openApi/v1/message/orgRoleRef/jw/1000";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type","application/x-www-form-urlencoded");
        String response = HttpClient.doGet_header(url, headers);
        logger.info("响应结果：" + response);
        JSONObject act = JSONObject.parseObject(response);
        act.get("status");
        act.get("error");
        String[] JsonPach = new String[2];
        JsonPach[0] = "$.status";
        JsonPach[1] = "$.error";
        boolean ResponseAssert = myassertimp.AssertByJsonPath(expect, act, JsonPach);
        logger.info("响应断言：" + ResponseAssert);
        Assert.assertEquals(expect[0], act.getString("status"));

//        String expect = "Bad Request";
//        String expect1 = "400";
//        String url = testUrl+"/openApi/v1/message/orgRoleRef/jw/1000";
//        logger.info("请求url："+url);
//        Map<String, Object> headers = new HashMap<>();
//        headers.put("Content-Type","application/x-www-form-urlencoded");
//        String response = HttpClient.doGet_header(url,headers);
//        logger.info("响应结果："+response);
//        String error = AssertUtil.asert(response,"$.error");
//        String status = AssertUtil.asert(response,"$.status");
//        Assert.assertEquals(error,expect);
//        Assert.assertEquals(status,expect1);
//        String assertutil = responseAssertionImp.assertEqualsString(error,expect);
//        String assertutil1 = responseAssertionImp.assertEqualsString(status,expect1);
//        logger.info("断言结果：\n"+assertutil + "\n" + assertutil1);
    }

    @Story("发送消息获取指定部门下的角色用户集合")
    @Test(description = "异常查看，不存在orgId和正确roleId")//orgId=部门id，roleId角色id
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:"+resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址",type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_3(){
        Object[] expect = new Object[2];
        expect[0] = "400";
        expect[1] = "Bad Request";
        String url = testUrl + "/openApi/v1/message/orgRoleRef/9999/1000";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type","application/x-www-form-urlencoded");
        String response = HttpClient.doGet_header(url, headers);
        logger.info("响应结果：" + response);
        JSONObject act = JSONObject.parseObject(response);
        act.get("status");
        act.get("error");
        String[] JsonPach = new String[2];
        JsonPach[0] = "$.status";
        JsonPach[1] = "$.error";
        boolean ResponseAssert = myassertimp.AssertByJsonPath(expect, act, JsonPach);
        logger.info("响应断言：" + ResponseAssert);
        Assert.assertEquals(expect[0], act.getString("status"));

//        String expect = "success";
//        String expect1 = "20000";
//        String url = testUrl+"/openApi/v1/message/orgRoleRef/9999/1000";
//        logger.info("请求url："+url);
//        Map<String, Object> headers = new HashMap<>();
//        headers.put("Content-Type","application/x-www-form-urlencoded");
//        String response = HttpClient.doGet_header(url,headers);
//        logger.info("响应结果："+response);
//        String msg = AssertUtil.asert(response,"$.msg");
//        String code = AssertUtil.asert(response,"$.code");
//        Assert.assertEquals(msg,expect);
//        Assert.assertEquals(code,expect1);
//        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
//        String assertutil1 = responseAssertionImp.assertEqualsString(code,expect1);
//        logger.info("断言结果：\n"+assertutil + "\n" + assertutil1);
    }


    @Story("发送消息获取指定部门下的角色用户集合")
    @Test(description = "异常查看，正确orgId和不存在roleId")//orgId=部门id，roleId角色id
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:"+resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址",type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_4(){
        Object[] expect = new Object[2];
        expect[0] = "400";
        expect[1] = "Bad Request";
        String url = testUrl + "/openApi/v1/message/orgRoleRef/2/100000";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type","application/x-www-form-urlencoded");
        String response = HttpClient.doGet_header(url, headers);
        logger.info("响应结果：" + response);
        JSONObject act = JSONObject.parseObject(response);
        act.get("status");
        act.get("error");
        String[] JsonPach = new String[2];
        JsonPach[0] = "$.status";
        JsonPach[1] = "$.error";
        boolean ResponseAssert = myassertimp.AssertByJsonPath(expect, act, JsonPach);
        logger.info("响应断言：" + ResponseAssert);
        Assert.assertEquals(expect[0], act.getString("status"));

//        String expect = "success";
//        String expect1 = "20000";
//        String url = testUrl+"/openApi/v1/message/orgRoleRef/2/100000";
//        logger.info("请求url："+url);
//        Map<String, Object> headers = new HashMap<>();
//        headers.put("Content-Type","application/x-www-form-urlencoded");
//        String response = HttpClient.doGet_header(url,headers);
//        logger.info("响应结果："+response);
//        String msg = AssertUtil.asert(response,"$.msg");
//        String code = AssertUtil.asert(response,"$.code");
//        Assert.assertEquals(msg,expect);
//        Assert.assertEquals(code,expect1);
//        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
//        String assertutil1 = responseAssertionImp.assertEqualsString(code,expect1);
//        logger.info("断言结果：\n"+assertutil + "\n" + assertutil1);
    }


    @Story("发送消息获取指定部门下的角色用户集合")
    @Test(description = "异常查看，正确orgId和错误roleId")//orgId=部门id，roleId角色id
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:"+resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址",type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_5(){

        Object[] expect = new Object[2];
        expect[0] = "400";
        expect[1] = "Bad Request";
        String url = testUrl + "/openApi/v1/message/orgRoleRef/2/jsw";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type","application/x-www-form-urlencoded");
        String response = HttpClient.doGet_header(url, headers);
        logger.info("响应结果：" + response);
        JSONObject act = JSONObject.parseObject(response);
        act.get("status");
        act.get("error");
        String[] JsonPach = new String[2];
        JsonPach[0] = "$.status";
        JsonPach[1] = "$.error";
        boolean ResponseAssert = myassertimp.AssertByJsonPath(expect, act, JsonPach);
        logger.info("响应断言：" + ResponseAssert);
        Assert.assertEquals(expect[0], act.getString("status"));
//        String expect = "Bad Request";
//        String expect1 = "400";
//        String url = testUrl+"/openApi/v1/message/orgRoleRef/2/jsw";
//        logger.info("请求url："+url);
//        Map<String, Object> headers = new HashMap<>();
//        headers.put("Content-Type","application/x-www-form-urlencoded");
//        String response = HttpClient.doGet_header(url,headers);
//        logger.info("响应结果："+response);
//        String error = AssertUtil.asert(response,"$.error");
//        String status = AssertUtil.asert(response,"$.status");
//        Assert.assertEquals(error,expect);
//        Assert.assertEquals(status,expect1);
//        String assertutil = responseAssertionImp.assertEqualsString(error,expect);
//        String assertutil1 = responseAssertionImp.assertEqualsString(status,expect1);
//        logger.info("断言结果：\n"+assertutil + "\n" + assertutil1);
    }


}
