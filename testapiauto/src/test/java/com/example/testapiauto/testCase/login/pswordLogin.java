package com.example.testapiauto.testCase.login;

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
 * @date 2021/4/20 16:18
 */

@Epic("用户中心账号密码登录接口")
@Feature("登录")
public class pswordLogin {

    private static final Logger logger = LogManager.getLogger(pswordLogin.class);
    String testUrl = resultsUtils.TestUrl;
    String Time = resultsUtils.Time;
    String UserName = resultsUtils.UserName;
    String PassWord = resultsUtils.PasWord;
    myAssertImp myassertimp = new myAssertImp();


    @Story("密码登录")
    @Test(description = "正常登录，正确的账号密码")
    @Description("验证是否能登录")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_1() {
        Object[] expect = new Object[2];
        expect[0] = "20000";
        expect[1] = "success";
        String url = testUrl + "/anonApi/uaa/v1/login?channelCode=11&_=" + Time;
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        String body = "{\"username\":\""+UserName+"\" " +","+"\"password\":\""+PassWord+"\""+"}";
        logger.info("请求参数：" + body);
        String response = HttpClient.doPost_Json(body, url, headers);
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
    }

    @Story("密码登录")
    @Test(description = "错误登录，错误的账号正确的密码")
    @Description("验证是否能登录")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_2() {
        Object[] expect = new Object[2];
        expect[0] = "20002";
        expect[1] = "business exception";
        String url = testUrl + "/anonApi/uaa/v1/login?channelCode=11&_=" + Time;
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        String body = "{\"username\":\""+UserName+"55"+"\" " +","+"\"password\":\""+PassWord+"\""+"}";
        logger.info("请求参数：" + body);
        String response = HttpClient.doPost_Json(body, url, headers);
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
    }

    @Story("密码登录")
    @Test(description = "错误登录，不存在的账号正确的密码")
    @Description("验证是否能登录")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_3() {
        Object[] expect = new Object[2];
        expect[0] = "20002";
        expect[1] = "business exception";
        String url = testUrl + "/anonApi/uaa/v1/login?channelCode=11&_=" + Time;
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        String body = "{\"username\":\""+UserName+"asd"+"\" " +","+"\"password\":\""+PassWord+"\""+"}";
        logger.info("请求参数：" + body);
        String response = HttpClient.doPost_Json(body, url, headers);
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
    }

    @Story("密码登录")
    @Test(description = "错误登录，中文的账号正确的密码")
    @Description("验证是否能登录")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_4() {
        Object[] expect = new Object[2];
        expect[0] = "20002";
        expect[1] = "business exception";
        String url = testUrl + "/anonApi/uaa/v1/login?channelCode=11&_=" + Time;
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        String body = "{\"username\":\""+UserName+"中文"+"\" " +","+"\"password\":\""+PassWord+"\""+"}";
        logger.info("请求参数：" + body);
        String response = HttpClient.doPost_Json(body, url, headers);
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
    }

    @Story("密码登录")
    @Test(description = "错误登录，空的账号正确的密码")
    @Description("验证是否能登录")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_5() {
        Object[] expect = new Object[2];
        expect[0] = "20002";
        expect[1] = "business exception";
        String url = testUrl + "/anonApi/uaa/v1/login?channelCode=11&_=" + Time;
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        String body = "{\"username\":\""+"\" " +","+"\"password\":\""+PassWord+"\""+"}";
        logger.info("请求参数：" + body);
        String response = HttpClient.doPost_Json(body, url, headers);
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
    }

    @Story("密码登录")
    @Test(description = "错误登录，正确的账号错误的密码")
    @Description("验证是否能登录")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_6() {
        Object[] expect = new Object[2];
        expect[0] = "20002";
        expect[1] = "business exception";
        String url = testUrl + "/anonApi/uaa/v1/login?channelCode=11&_=" + Time;
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        String body = "{\"username\":\""+UserName+"\" " +","+"\"password\":\""+PassWord+"123"+"\""+"}";
        logger.info("请求参数：" + body);
        String response = HttpClient.doPost_Json(body, url, headers);
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
    }

    @Story("密码登录")
    @Test(description = "错误登录，正确的账号空的密码")
    @Description("验证是否能登录")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_7() {
        Object[] expect = new Object[2];
        expect[0] = "20002";
        expect[1] = "business exception";
        String url = testUrl + "/anonApi/uaa/v1/login?channelCode=11&_=" + Time;
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        String body = "{\"username\":\""+UserName+"\" " +","+"\"password\":\""+"\""+"}";
        logger.info("请求参数：" + body);
        String response = HttpClient.doPost_Json(body, url, headers);
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
    }

}
