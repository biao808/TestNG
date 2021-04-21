package com.example.testapiauto.testCase.messageService;

import com.alibaba.fastjson.JSONObject;
import com.example.testapiauto.app.serviceImp.myAssertImp;
import com.example.testapiauto.modules.testCase.common.Assertion.AssertionImp.ResponseAssertionImp;
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
 * @date 2021/4/16 14:08
 */

@Epic("条件查询消息")
@Feature("查询")
public class conditionalQueryMessage {

    private static final Logger logger = LogManager.getLogger(conditionalQueryMessage.class);
    ResponseAssertionImp responseAssertionImp = new ResponseAssertionImp();
    String testUrl = resultsUtils.TestUrl;
    String Token = resultsUtils.token;
    myAssertImp myassertimp = new myAssertImp();


    /**
     * @param
     * @return
     * @author 假斯文
     * @date 2021/4/16 15:36
     */

    @Story("条件查询消息，消息类型为1")
    @Test(description = "正常查看")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_1() {
        Object[] expect = new Object[2];
        expect[0] = "20000";
        expect[1] = "success";
        String url = testUrl + "/openApi/v1/message/1/search";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{\"size\": 10,\"current\": 1,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
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


//        String expect = "success";
//        String url = testUrl+"/openApi/v1/message/1/search";
//        logger.info("请求url："+url);
//        Map<String,Object> headers = new HashMap<>();
//        headers.put("Content-Type","application/json");
//        String body = "{\"size\": 10,\"current\": 1,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
//        String response = HttpClient.doPost_Json(body,url,headers);
//        logger.info("响应结果："+response);
//        String msg = AssertUtil.asert(response,"$.msg");
//        Assert.assertEquals(msg,expect);
//        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
//        logger.info("断言结果："+assertutil);
    }

    @Story("条件查询消息，消息类型为1")
    @Test(description = "正常查看，size为100")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_2() {
        Object[] expect = new Object[2];
        expect[0] = "20000";
        expect[1] = "success";
        String url = testUrl + "/openApi/v1/message/1/search";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{\"size\": 100,\"current\": 1,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
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

//        String expect = "success";
//        String url = testUrl + "/openApi/v1/message/1/search";
//        logger.info("请求url：" + url);
//        Map<String, Object> headers = new HashMap<>();
//        headers.put("Content-Type", "application/json");
//        String body = "{\"size\": 100,\"current\": 1,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
//        String response = HttpClient.doPost_Json(body, url, headers);
//        logger.info("响应结果：" + response);
//        String msg = AssertUtil.asert(response, "$.msg");
//        Assert.assertEquals(msg, expect);
//        String assertutil = responseAssertionImp.assertEqualsString(msg, expect);
//        logger.info("断言结果：" + assertutil);
    }

    @Story("条件查询消息，消息类型为1")
    @Test(description = "异常查看，size为空")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_3() {
        Object[] expect = new Object[2];
        expect[0] = "400";
        expect[1] = "Bad Request";
        String url = testUrl + "/openApi/v1/message/1/search";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{\"size\": ,\"current\": 1,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
        String response = HttpClient.doPost_Json(body, url, headers);
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
//        String expect2 = "400";
//        String url = testUrl + "/openApi/v1/message/1/search";
//        logger.info("请求url：" + url);
//        Map<String, Object> headers = new HashMap<>();
//        headers.put("Content-Type", "application/json");
//        String body = "{\"size\": ,\"current\": 1,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
//        String response = HttpClient.doPost_Json(body, url, headers);
//        logger.info("响应结果：" + response);
//        String error = AssertUtil.asert(response, "$.error");
//        String status = AssertUtil.asert(response,"$.status");
//        Assert.assertEquals(error, expect);
//        Assert.assertEquals(status,expect2);
//        String assertutil = responseAssertionImp.assertEqualsString(error, expect);
//        String assertutil1 = responseAssertionImp.assertEqualsString(status,expect2);
//        logger.info("断言结果：" + assertutil + "," +assertutil1);
    }


    @Story("条件查询消息，消息类型为1")
    @Test(description = "异常查看，current为空")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_4() {
        Object[] expect = new Object[2];
        expect[0] = "400";
        expect[1] = "Bad Request";
        String url = testUrl + "/openApi/v1/message/1/search";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{\"size\": 10,\"current\": ,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
        String response = HttpClient.doPost_Json(body, url, headers);
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

    }
//        String expect = "Bad Request";
//        String expect2 = "400";
//        String url = testUrl + "/openApi/v1/message/1/search";
//        logger.info("请求url：" + url);
//        Map<String, Object> headers = new HashMap<>();
//        headers.put("Content-Type", "application/json");
//        String body = "{\"size\": 10,\"current\": ,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
//        String response = HttpClient.doPost_Json(body, url, headers);
//        logger.info("响应结果：" + response);
//        String error = AssertUtil.asert(response, "$.error");
//        String status = AssertUtil.asert(response,"$.status");
//        Assert.assertEquals(error, expect);
//        Assert.assertEquals(status,expect2);
//        String assertutil = responseAssertionImp.assertEqualsString(error, expect);
//        String assertutil1 = responseAssertionImp.assertEqualsString(status,expect2);
//        logger.info("断言结果：" + assertutil + "," +assertutil1);
//    }


    @Story("条件查询消息，消息类型为1")
    @Test(description = "异常查看，current不存在")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_5() {
        Object[] expect = new Object[2];
        expect[0] = "400";
        expect[1] = "Bad Request";
        String url = testUrl + "/openApi/v1/message/1/search";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{\"size\": 10,\"current\": jj,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
        String response = HttpClient.doPost_Json(body, url, headers);
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
//        String expect2 = "400";
//        String url = testUrl + "/openApi/v1/message/1/search";
//        logger.info("请求url：" + url);
//        Map<String, Object> headers = new HashMap<>();
//        headers.put("Content-Type", "application/json");
//        String body = "{\"size\": 10,\"current\": jj,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
//        String response = HttpClient.doPost_Json(body, url, headers);
//        logger.info("响应结果：" + response);
//        String error = AssertUtil.asert(response, "$.error");
//        String status = AssertUtil.asert(response,"$.status");
//        Assert.assertEquals(error, expect);
//        Assert.assertEquals(status,expect2);
//        String assertutil = responseAssertionImp.assertEqualsString(error, expect);
//        String assertutil1 = responseAssertionImp.assertEqualsString(status,expect2);
//        logger.info("断言结果：" + assertutil + "," +assertutil1);
    }

    @Story("条件查询消息，消息类型为1")
    @Test(description = "异常查看，title不存在")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_6() {
        Object[] expect = new Object[2];
        expect[0] = "400";
        expect[1] = "Bad Request";
        String url = testUrl + "/openApi/v1/message/1/search";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{\"size\": 10,\"current\": 1,\"title\":\"sa\" \"消息asdasd头\",\"proposer\":\"\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
        String response = HttpClient.doPost_Json(body, url, headers);
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
//        String url = testUrl + "/openApi/v1/message/1/search";
//        logger.info("请求url：" + url);
//        Map<String, Object> headers = new HashMap<>();
//        headers.put("Content-Type", "application/json");
//        String body = "{\"size\": 10,\"current\": 1,\"title\": \"消息asdasd头\",\"proposer\":\"\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
//        String response = HttpClient.doPost_Json(body, url, headers);
//        logger.info("响应结果：" + response);
//        String msg = AssertUtil.asert(response, "$.msg");
//        Assert.assertEquals(msg, expect);
//        String assertutil = responseAssertionImp.assertEqualsString(msg, expect);
//        logger.info("断言结果：" + assertutil);
    }

    @Story("条件查询消息，消息类型为1")
    @Test(description = "异常查看，title为空")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_7() {
        Object[] expect = new Object[2];
        expect[0] = "400";
        expect[1] = "Bad Request";
        String url = testUrl + "/openApi/v1/message/1/search";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{\"size\": 10,\"current\": 1,\"title\":,\"proposer\":\"\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
        String response = HttpClient.doPost_Json(body, url, headers);
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
//        String url = testUrl + "/openApi/v1/message/1/search";
//        logger.info("请求url：" + url);
//        Map<String, Object> headers = new HashMap<>();
//        headers.put("Content-Type", "application/json");
//        String body = "{\"size\": 10,\"current\": 1,\"title\":,\"proposer\":\"\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
//        String response = HttpClient.doPost_Json(body, url, headers);
//        logger.info("响应结果：" + response);
//        String status = AssertUtil.asert(response, "$.status");
//        String error = AssertUtil.asert(response, "$.error");
//        Assert.assertEquals(status, expect1);
//        Assert.assertEquals(error, expect);
//        String assertutil = responseAssertionImp.assertEqualsString(status, expect1);
//        String assertutil1 = responseAssertionImp.assertEqualsString(error, expect);
//        logger.info("断言结果：" + assertutil + ","+assertutil1);
    }


    @Story("条件查询消息，消息类型为1")
    @Test(description = "异常查看，proposer不存在")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_8() {
        Object[] expect = new Object[2];
        expect[0] = "400";
        expect[1] = "Bad Request";
        String url = testUrl + "/openApi/v1/message/1/search";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{\"size\": 10,\"current\": 1,\"title\": \"消息头\",\"proposer\":\"53333\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
        String response = HttpClient.doPost_Json(body, url, headers);
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
//        String url = testUrl + "/openApi/v1/message/1/search";
//        logger.info("请求url：" + url);
//        Map<String, Object> headers = new HashMap<>();
//        headers.put("Content-Type", "application/json");
//        String body = "{\"size\": 10,\"current\": 1,\"title\": \"消息头\",\"proposer\":\"53333\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
//        String response = HttpClient.doPost_Json(body, url, headers);
//        logger.info("响应结果：" + response);
//        String code = AssertUtil.asert(response, "$.code");
//        String msg = AssertUtil.asert(response, "$.msg");
//        Assert.assertEquals(code, expect1);
//        Assert.assertEquals(msg, expect);
//        String assertutil = responseAssertionImp.assertEqualsString(code, expect1);
//        String assertutil1 = responseAssertionImp.assertEqualsString(msg, expect);
//        logger.info("断言结果：" + assertutil + ","+assertutil1);
    }


    @Story("条件查询消息，消息类型为1")
    @Test(description = "正常查看，readStatus为1")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_10() {
        Object[] expect = new Object[2];
        expect[0] = "20000";
        expect[1] = "success";
        String url = testUrl + "/openApi/v1/message/1/search";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{\"size\": 10,\"current\": 1,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":1,\"receiverId\":\"5344123121\"}";
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

//        String expect = "success";
//        String expect1 = "20000";
//        String url = testUrl + "/openApi/v1/message/1/search";
//        logger.info("请求url：" + url);
//        Map<String, Object> headers = new HashMap<>();
//        headers.put("Content-Type", "application/json");
//        String body = "{\"size\": 10,\"current\": 1,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":1,\"receiverId\":\"5344123121\"}";
//        String response = HttpClient.doPost_Json(body, url, headers);
//        logger.info("响应结果：" + response);
//        String code = AssertUtil.asert(response, "$.code");
//        String msg = AssertUtil.asert(response, "$.msg");
//        Assert.assertEquals(code, expect1);
//        Assert.assertEquals(msg, expect);
//        String assertutil = responseAssertionImp.assertEqualsString(code, expect1);
//        String assertutil1 = responseAssertionImp.assertEqualsString(msg, expect);
//        logger.info("断言结果：" + assertutil + ","+assertutil1);
    }

    @Story("条件查询消息，消息类型为1")
    @Test(description = "异常查看，readStatus不存在")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_11() {
        Object[] expect = new Object[2];
        expect[0] = "400";
        expect[1] = "Bad Request";
        String url = testUrl + "/openApi/v1/message/1/search";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{\"size\": 10,\"current\": 1,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":3,\"receiverId\":\"5344123121\"}";
        String response = HttpClient.doPost_Json(body, url, headers);
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
//        String url = testUrl + "/openApi/v1/message/1/search";
//        logger.info("请求url：" + url);
//        Map<String, Object> headers = new HashMap<>();
//        headers.put("Content-Type", "application/json");
//        String body = "{\"size\": 10,\"current\": 1,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":3,\"receiverId\":\"5344123121\"}";
//        String response = HttpClient.doPost_Json(body, url, headers);
//        logger.info("响应结果：" + response);
//        String code = AssertUtil.asert(response, "$.code");
//        String msg = AssertUtil.asert(response, "$.msg");
//        Assert.assertEquals(code, expect1);
//        Assert.assertEquals(msg, expect);
//        String assertutil = responseAssertionImp.assertEqualsString(code, expect1);
//        String assertutil1 = responseAssertionImp.assertEqualsString(msg, expect);
//        logger.info("断言结果：" + assertutil + ","+assertutil1);
    }

    @Story("条件查询消息，消息类型为1")
    @Test(description = "异常查看，receiverId不存在")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_12() {
        Object[] expect = new Object[2];
        expect[0] = "400";
        expect[1] = "Bad Request";
        String url = testUrl + "/openApi/v1/message/1/search";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{\"size\": 10,\"current\": 1,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":1,\"receiverId\":\"5344123121#\"}";
        String response = HttpClient.doPost_Json(body, url, headers);
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
    }

    @Story("条件查询消息，消息类型为1")
    @Test(description = "异常查看，receiverId为空")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_13() {
        Object[] expect = new Object[2];
        expect[0] = "20000";
        expect[1] = "success";
        String url = testUrl + "/openApi/v1/message/1/search";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{\"size\": 10,\"current\": 1,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":1,\"receiverId\":\"\"}";
        String response = HttpClient.doPost_Json(body, url, headers);
        logger.info("响应结果：" + response);
        JSONObject act = JSONObject.parseObject(response);
        act.getString("code");
        act.get("msg");
        String[] JsonPach = new String[2];
        JsonPach[0] = "$.code";
        JsonPach[1] = "$.msg";
        boolean ResponseAssert = myassertimp.AssertByJsonPath(expect, act, JsonPach);
        logger.info("响应断言：" + ResponseAssert);
        Assert.assertEquals(expect[0], act.getString("code"));

//        String expect = "success";
//        String expect1 = "20000";
//        String url = testUrl + "/openApi/v1/message/1/search";
//        logger.info("请求url：" + url);
//        Map<String, Object> headers = new HashMap<>();
//        headers.put("Content-Type", "application/json");
//        String body = "{\"size\": 10,\"current\": 1,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":0,\"receiverId\":\"\"}";
//        String response = HttpClient.doPost_Json(body, url, headers);
//        logger.info("响应结果：" + response);
//        String code = AssertUtil.asert(response, "$.code");
//        logger.info("实际结果：code,"+code);
//        String msg = AssertUtil.asert(response, "$.msg");
//        logger.info("实际结果：msg,"+msg);
//        Assert.assertEquals(code, expect1);
//        Assert.assertEquals(msg, expect);
//        String assertutil = responseAssertionImp.assertEqualsString(code, expect1);
//        String assertutil1 = responseAssertionImp.assertEqualsString(msg, expect);
//        logger.info("断言结果：" + assertutil + ","+assertutil1);
    }

    /**
     * @param
     * @return
     * @author 假斯文
     * @date 2021/4/16 15:29
     */

    @Story("条件查询消息，消息类型为2")
    @Test(description = "正常查看")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_14() {
        Object[] expect = new Object[2];
        expect[0] = "20000";
        expect[1] = "success";
        String url = testUrl + "/openApi/v1/message/2/search";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{\"size\": 10,\"current\": 1,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
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


//        String expect = "success";
//        String url = testUrl+"/openApi/v1/message/1/search";
//        logger.info("请求url："+url);
//        Map<String,Object> headers = new HashMap<>();
//        headers.put("Content-Type","application/json");
//        String body = "{\"size\": 10,\"current\": 1,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
//        String response = HttpClient.doPost_Json(body,url,headers);
//        logger.info("响应结果："+response);
//        String msg = AssertUtil.asert(response,"$.msg");
//        Assert.assertEquals(msg,expect);
//        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
//        logger.info("断言结果："+assertutil);
    }

    @Story("条件查询消息，消息类型为2")
    @Test(description = "正常查看，size为100")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_15() {
        Object[] expect = new Object[2];
        expect[0] = "20000";
        expect[1] = "success";
        String url = testUrl + "/openApi/v1/message/2/search";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{\"size\": 100,\"current\": 1,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
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

//        String expect = "success";
//        String url = testUrl + "/openApi/v1/message/1/search";
//        logger.info("请求url：" + url);
//        Map<String, Object> headers = new HashMap<>();
//        headers.put("Content-Type", "application/json");
//        String body = "{\"size\": 100,\"current\": 1,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
//        String response = HttpClient.doPost_Json(body, url, headers);
//        logger.info("响应结果：" + response);
//        String msg = AssertUtil.asert(response, "$.msg");
//        Assert.assertEquals(msg, expect);
//        String assertutil = responseAssertionImp.assertEqualsString(msg, expect);
//        logger.info("断言结果：" + assertutil);
    }

    @Story("条件查询消息，消息类型为2")
    @Test(description = "异常查看，size为空")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_16() {
        Object[] expect = new Object[2];
        expect[0] = "400";
        expect[1] = "Bad Request";
        String url = testUrl + "/openApi/v1/message/2/search";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{\"size\": ,\"current\": 1,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
        String response = HttpClient.doPost_Json(body, url, headers);
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
//        String expect2 = "400";
//        String url = testUrl + "/openApi/v1/message/1/search";
//        logger.info("请求url：" + url);
//        Map<String, Object> headers = new HashMap<>();
//        headers.put("Content-Type", "application/json");
//        String body = "{\"size\": ,\"current\": 1,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
//        String response = HttpClient.doPost_Json(body, url, headers);
//        logger.info("响应结果：" + response);
//        String error = AssertUtil.asert(response, "$.error");
//        String status = AssertUtil.asert(response,"$.status");
//        Assert.assertEquals(error, expect);
//        Assert.assertEquals(status,expect2);
//        String assertutil = responseAssertionImp.assertEqualsString(error, expect);
//        String assertutil1 = responseAssertionImp.assertEqualsString(status,expect2);
//        logger.info("断言结果：" + assertutil + "," +assertutil1);
    }


    @Story("条件查询消息，消息类型为2")
    @Test(description = "异常查看，current为空")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_17() {
        Object[] expect = new Object[2];
        expect[0] = "400";
        expect[1] = "Bad Request";
        String url = testUrl + "/openApi/v1/message/2/search";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{\"size\": 10,\"current\": ,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
        String response = HttpClient.doPost_Json(body, url, headers);
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

    }
//        String expect = "Bad Request";
//        String expect2 = "400";
//        String url = testUrl + "/openApi/v1/message/1/search";
//        logger.info("请求url：" + url);
//        Map<String, Object> headers = new HashMap<>();
//        headers.put("Content-Type", "application/json");
//        String body = "{\"size\": 10,\"current\": ,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
//        String response = HttpClient.doPost_Json(body, url, headers);
//        logger.info("响应结果：" + response);
//        String error = AssertUtil.asert(response, "$.error");
//        String status = AssertUtil.asert(response,"$.status");
//        Assert.assertEquals(error, expect);
//        Assert.assertEquals(status,expect2);
//        String assertutil = responseAssertionImp.assertEqualsString(error, expect);
//        String assertutil1 = responseAssertionImp.assertEqualsString(status,expect2);
//        logger.info("断言结果：" + assertutil + "," +assertutil1);
//    }


    @Story("条件查询消息，消息类型为2")
    @Test(description = "异常查看，current不存在")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_18() {
        Object[] expect = new Object[2];
        expect[0] = "400";
        expect[1] = "Bad Request";
        String url = testUrl + "/openApi/v1/message/2/search";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{\"size\": 10,\"current\": jj,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
        String response = HttpClient.doPost_Json(body, url, headers);
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
//        String expect2 = "400";
//        String url = testUrl + "/openApi/v1/message/1/search";
//        logger.info("请求url：" + url);
//        Map<String, Object> headers = new HashMap<>();
//        headers.put("Content-Type", "application/json");
//        String body = "{\"size\": 10,\"current\": jj,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
//        String response = HttpClient.doPost_Json(body, url, headers);
//        logger.info("响应结果：" + response);
//        String error = AssertUtil.asert(response, "$.error");
//        String status = AssertUtil.asert(response,"$.status");
//        Assert.assertEquals(error, expect);
//        Assert.assertEquals(status,expect2);
//        String assertutil = responseAssertionImp.assertEqualsString(error, expect);
//        String assertutil1 = responseAssertionImp.assertEqualsString(status,expect2);
//        logger.info("断言结果：" + assertutil + "," +assertutil1);
    }

    @Story("条件查询消息，消息类型为2")
    @Test(description = "异常查看，title不存在")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_19() {
        Object[] expect = new Object[2];
        expect[0] = "400";
        expect[1] = "Bad Request";
        String url = testUrl + "/openApi/v1/message/2/search";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{\"size\": 10,\"current\": 1,\"title\":\"sa\" \"消息asdasd头\",\"proposer\":\"\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
        String response = HttpClient.doPost_Json(body, url, headers);
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
//        String url = testUrl + "/openApi/v1/message/1/search";
//        logger.info("请求url：" + url);
//        Map<String, Object> headers = new HashMap<>();
//        headers.put("Content-Type", "application/json");
//        String body = "{\"size\": 10,\"current\": 1,\"title\": \"消息asdasd头\",\"proposer\":\"\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
//        String response = HttpClient.doPost_Json(body, url, headers);
//        logger.info("响应结果：" + response);
//        String msg = AssertUtil.asert(response, "$.msg");
//        Assert.assertEquals(msg, expect);
//        String assertutil = responseAssertionImp.assertEqualsString(msg, expect);
//        logger.info("断言结果：" + assertutil);
    }

    @Story("条件查询消息，消息类型为2")
    @Test(description = "异常查看，title为空")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_20() {
        Object[] expect = new Object[2];
        expect[0] = "400";
        expect[1] = "Bad Request";
        String url = testUrl + "/openApi/v1/message/2/search";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{\"size\": 10,\"current\": 1,\"title\":,\"proposer\":\"\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
        String response = HttpClient.doPost_Json(body, url, headers);
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
//        String url = testUrl + "/openApi/v1/message/1/search";
//        logger.info("请求url：" + url);
//        Map<String, Object> headers = new HashMap<>();
//        headers.put("Content-Type", "application/json");
//        String body = "{\"size\": 10,\"current\": 1,\"title\":,\"proposer\":\"\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
//        String response = HttpClient.doPost_Json(body, url, headers);
//        logger.info("响应结果：" + response);
//        String status = AssertUtil.asert(response, "$.status");
//        String error = AssertUtil.asert(response, "$.error");
//        Assert.assertEquals(status, expect1);
//        Assert.assertEquals(error, expect);
//        String assertutil = responseAssertionImp.assertEqualsString(status, expect1);
//        String assertutil1 = responseAssertionImp.assertEqualsString(error, expect);
//        logger.info("断言结果：" + assertutil + ","+assertutil1);
    }


    @Story("条件查询消息，消息类型为2")
    @Test(description = "异常查看，proposer不存在")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_21() {
        Object[] expect = new Object[2];
        expect[0] = "400";
        expect[1] = "Bad Request";
        String url = testUrl + "/openApi/v1/message/2/search";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{\"size\": 10,\"current\": 1,\"title\": \"消息头\",\"proposer\":\"53333\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
        String response = HttpClient.doPost_Json(body, url, headers);
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
//        String url = testUrl + "/openApi/v1/message/1/search";
//        logger.info("请求url：" + url);
//        Map<String, Object> headers = new HashMap<>();
//        headers.put("Content-Type", "application/json");
//        String body = "{\"size\": 10,\"current\": 1,\"title\": \"消息头\",\"proposer\":\"53333\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
//        String response = HttpClient.doPost_Json(body, url, headers);
//        logger.info("响应结果：" + response);
//        String code = AssertUtil.asert(response, "$.code");
//        String msg = AssertUtil.asert(response, "$.msg");
//        Assert.assertEquals(code, expect1);
//        Assert.assertEquals(msg, expect);
//        String assertutil = responseAssertionImp.assertEqualsString(code, expect1);
//        String assertutil1 = responseAssertionImp.assertEqualsString(msg, expect);
//        logger.info("断言结果：" + assertutil + ","+assertutil1);
    }


    @Story("条件查询消息，消息类型为2")
    @Test(description = "正常查看，readStatus为1")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_22() {
        Object[] expect = new Object[2];
        expect[0] = "20000";
        expect[1] = "success";
        String url = testUrl + "/openApi/v1/message/2/search";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{\"size\": 10,\"current\": 1,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":1,\"receiverId\":\"5344123121\"}";
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

//        String expect = "success";
//        String expect1 = "20000";
//        String url = testUrl + "/openApi/v1/message/1/search";
//        logger.info("请求url：" + url);
//        Map<String, Object> headers = new HashMap<>();
//        headers.put("Content-Type", "application/json");
//        String body = "{\"size\": 10,\"current\": 1,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":1,\"receiverId\":\"5344123121\"}";
//        String response = HttpClient.doPost_Json(body, url, headers);
//        logger.info("响应结果：" + response);
//        String code = AssertUtil.asert(response, "$.code");
//        String msg = AssertUtil.asert(response, "$.msg");
//        Assert.assertEquals(code, expect1);
//        Assert.assertEquals(msg, expect);
//        String assertutil = responseAssertionImp.assertEqualsString(code, expect1);
//        String assertutil1 = responseAssertionImp.assertEqualsString(msg, expect);
//        logger.info("断言结果：" + assertutil + ","+assertutil1);
    }

    @Story("条件查询消息，消息类型为2")
    @Test(description = "异常查看，readStatus不存在")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_23() {
        Object[] expect = new Object[2];
        expect[0] = "400";
        expect[1] = "Bad Request";
        String url = testUrl + "/openApi/v1/message/2/search";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{\"size\": 10,\"current\": 1,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":3,\"receiverId\":\"5344123121\"}";
        String response = HttpClient.doPost_Json(body, url, headers);
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
//        String url = testUrl + "/openApi/v1/message/1/search";
//        logger.info("请求url：" + url);
//        Map<String, Object> headers = new HashMap<>();
//        headers.put("Content-Type", "application/json");
//        String body = "{\"size\": 10,\"current\": 1,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":3,\"receiverId\":\"5344123121\"}";
//        String response = HttpClient.doPost_Json(body, url, headers);
//        logger.info("响应结果：" + response);
//        String code = AssertUtil.asert(response, "$.code");
//        String msg = AssertUtil.asert(response, "$.msg");
//        Assert.assertEquals(code, expect1);
//        Assert.assertEquals(msg, expect);
//        String assertutil = responseAssertionImp.assertEqualsString(code, expect1);
//        String assertutil1 = responseAssertionImp.assertEqualsString(msg, expect);
//        logger.info("断言结果：" + assertutil + ","+assertutil1);
    }

    @Story("条件查询消息，消息类型为2")
    @Test(description = "异常查看，receiverId不存在")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_24() {
        Object[] expect = new Object[2];
        expect[0] = "400";
        expect[1] = "Bad Request";
        String url = testUrl + "/openApi/v1/message/2/search";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{\"size\": 10,\"current\": 1,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":1,\"receiverId\":\"5344123121#\"}";
        String response = HttpClient.doPost_Json(body, url, headers);
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
    }

    @Story("条件查询消息，消息类型为2")
    @Test(description = "异常查看，receiverId为空")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_25() {
        Object[] expect = new Object[2];
        expect[0] = "20000";
        expect[1] = "success";
        String url = testUrl + "/openApi/v1/message/2/search";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{\"size\": 10,\"current\": 1,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":1,\"receiverId\":\"\"}";
        String response = HttpClient.doPost_Json(body, url, headers);
        logger.info("响应结果：" + response);
        JSONObject act = JSONObject.parseObject(response);
        act.getString("code");
        act.get("msg");
        String[] JsonPach = new String[2];
        JsonPach[0] = "$.code";
        JsonPach[1] = "$.msg";
        boolean ResponseAssert = myassertimp.AssertByJsonPath(expect, act, JsonPach);
        logger.info("响应断言：" + ResponseAssert);
        Assert.assertEquals(expect[0], act.getString("code"));

//        String expect = "success";
//        String expect1 = "20000";
//        String url = testUrl + "/openApi/v1/message/1/search";
//        logger.info("请求url：" + url);
//        Map<String, Object> headers = new HashMap<>();
//        headers.put("Content-Type", "application/json");
//        String body = "{\"size\": 10,\"current\": 1,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":0,\"receiverId\":\"\"}";
//        String response = HttpClient.doPost_Json(body, url, headers);
//        logger.info("响应结果：" + response);
//        String code = AssertUtil.asert(response, "$.code");
//        logger.info("实际结果：code,"+code);
//        String msg = AssertUtil.asert(response, "$.msg");
//        logger.info("实际结果：msg,"+msg);
//        Assert.assertEquals(code, expect1);
//        Assert.assertEquals(msg, expect);
//        String assertutil = responseAssertionImp.assertEqualsString(code, expect1);
//        String assertutil1 = responseAssertionImp.assertEqualsString(msg, expect);
//        logger.info("断言结果：" + assertutil + ","+assertutil1);
    }

    /**
     * @param
     * @return
     * @author 假斯文
     * @date 2021/4/16 15:33
     */

    @Story("条件查询消息，消息类型为3")
    @Test(description = "正常查看")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_26() {
        Object[] expect = new Object[2];
        expect[0] = "20000";
        expect[1] = "success";
        String url = testUrl + "/openApi/v1/message/3/search";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{\"size\": 10,\"current\": 1,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
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


//        String expect = "success";
//        String url = testUrl+"/openApi/v1/message/1/search";
//        logger.info("请求url："+url);
//        Map<String,Object> headers = new HashMap<>();
//        headers.put("Content-Type","application/json");
//        String body = "{\"size\": 10,\"current\": 1,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
//        String response = HttpClient.doPost_Json(body,url,headers);
//        logger.info("响应结果："+response);
//        String msg = AssertUtil.asert(response,"$.msg");
//        Assert.assertEquals(msg,expect);
//        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
//        logger.info("断言结果："+assertutil);
    }

    @Story("条件查询消息，消息类型为3")
    @Test(description = "正常查看，size为100")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_27() {
        Object[] expect = new Object[2];
        expect[0] = "20000";
        expect[1] = "success";
        String url = testUrl + "/openApi/v1/message/3/search";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{\"size\": 100,\"current\": 1,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
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

//        String expect = "success";
//        String url = testUrl + "/openApi/v1/message/1/search";
//        logger.info("请求url：" + url);
//        Map<String, Object> headers = new HashMap<>();
//        headers.put("Content-Type", "application/json");
//        String body = "{\"size\": 100,\"current\": 1,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
//        String response = HttpClient.doPost_Json(body, url, headers);
//        logger.info("响应结果：" + response);
//        String msg = AssertUtil.asert(response, "$.msg");
//        Assert.assertEquals(msg, expect);
//        String assertutil = responseAssertionImp.assertEqualsString(msg, expect);
//        logger.info("断言结果：" + assertutil);
    }

    @Story("条件查询消息，消息类型为3")
    @Test(description = "异常查看，size为空")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_28() {
        Object[] expect = new Object[2];
        expect[0] = "400";
        expect[1] = "Bad Request";
        String url = testUrl + "/openApi/v1/message/3/search";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{\"size\": ,\"current\": 1,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
        String response = HttpClient.doPost_Json(body, url, headers);
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
//        String expect2 = "400";
//        String url = testUrl + "/openApi/v1/message/1/search";
//        logger.info("请求url：" + url);
//        Map<String, Object> headers = new HashMap<>();
//        headers.put("Content-Type", "application/json");
//        String body = "{\"size\": ,\"current\": 1,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
//        String response = HttpClient.doPost_Json(body, url, headers);
//        logger.info("响应结果：" + response);
//        String error = AssertUtil.asert(response, "$.error");
//        String status = AssertUtil.asert(response,"$.status");
//        Assert.assertEquals(error, expect);
//        Assert.assertEquals(status,expect2);
//        String assertutil = responseAssertionImp.assertEqualsString(error, expect);
//        String assertutil1 = responseAssertionImp.assertEqualsString(status,expect2);
//        logger.info("断言结果：" + assertutil + "," +assertutil1);
    }


    @Story("条件查询消息，消息类型为3")
    @Test(description = "异常查看，current为空")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_29() {
        Object[] expect = new Object[2];
        expect[0] = "400";
        expect[1] = "Bad Request";
        String url = testUrl + "/openApi/v1/message/3/search";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{\"size\": 10,\"current\": ,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
        String response = HttpClient.doPost_Json(body, url, headers);
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

    }
//        String expect = "Bad Request";
//        String expect2 = "400";
//        String url = testUrl + "/openApi/v1/message/1/search";
//        logger.info("请求url：" + url);
//        Map<String, Object> headers = new HashMap<>();
//        headers.put("Content-Type", "application/json");
//        String body = "{\"size\": 10,\"current\": ,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
//        String response = HttpClient.doPost_Json(body, url, headers);
//        logger.info("响应结果：" + response);
//        String error = AssertUtil.asert(response, "$.error");
//        String status = AssertUtil.asert(response,"$.status");
//        Assert.assertEquals(error, expect);
//        Assert.assertEquals(status,expect2);
//        String assertutil = responseAssertionImp.assertEqualsString(error, expect);
//        String assertutil1 = responseAssertionImp.assertEqualsString(status,expect2);
//        logger.info("断言结果：" + assertutil + "," +assertutil1);
//    }


    @Story("条件查询消息，消息类型为3")
    @Test(description = "异常查看，current不存在")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_30() {
        Object[] expect = new Object[2];
        expect[0] = "400";
        expect[1] = "Bad Request";
        String url = testUrl + "/openApi/v1/message/3/search";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{\"size\": 10,\"current\": jj,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
        String response = HttpClient.doPost_Json(body, url, headers);
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
//        String expect2 = "400";
//        String url = testUrl + "/openApi/v1/message/1/search";
//        logger.info("请求url：" + url);
//        Map<String, Object> headers = new HashMap<>();
//        headers.put("Content-Type", "application/json");
//        String body = "{\"size\": 10,\"current\": jj,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
//        String response = HttpClient.doPost_Json(body, url, headers);
//        logger.info("响应结果：" + response);
//        String error = AssertUtil.asert(response, "$.error");
//        String status = AssertUtil.asert(response,"$.status");
//        Assert.assertEquals(error, expect);
//        Assert.assertEquals(status,expect2);
//        String assertutil = responseAssertionImp.assertEqualsString(error, expect);
//        String assertutil1 = responseAssertionImp.assertEqualsString(status,expect2);
//        logger.info("断言结果：" + assertutil + "," +assertutil1);
    }

    @Story("条件查询消息，消息类型为3")
    @Test(description = "异常查看，title不存在")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_31() {
        Object[] expect = new Object[2];
        expect[0] = "400";
        expect[1] = "Bad Request";
        String url = testUrl + "/openApi/v1/message/3/search";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{\"size\": 10,\"current\": 1,\"title\":\"sa\" \"消息asdasd头\",\"proposer\":\"\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
        String response = HttpClient.doPost_Json(body, url, headers);
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
//        String url = testUrl + "/openApi/v1/message/1/search";
//        logger.info("请求url：" + url);
//        Map<String, Object> headers = new HashMap<>();
//        headers.put("Content-Type", "application/json");
//        String body = "{\"size\": 10,\"current\": 1,\"title\": \"消息asdasd头\",\"proposer\":\"\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
//        String response = HttpClient.doPost_Json(body, url, headers);
//        logger.info("响应结果：" + response);
//        String msg = AssertUtil.asert(response, "$.msg");
//        Assert.assertEquals(msg, expect);
//        String assertutil = responseAssertionImp.assertEqualsString(msg, expect);
//        logger.info("断言结果：" + assertutil);
    }

    @Story("条件查询消息，消息类型为3")
    @Test(description = "异常查看，title为空")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_32() {
        Object[] expect = new Object[2];
        expect[0] = "400";
        expect[1] = "Bad Request";
        String url = testUrl + "/openApi/v1/message/3/search";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{\"size\": 10,\"current\": 1,\"title\":,\"proposer\":\"\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
        String response = HttpClient.doPost_Json(body, url, headers);
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
//        String url = testUrl + "/openApi/v1/message/1/search";
//        logger.info("请求url：" + url);
//        Map<String, Object> headers = new HashMap<>();
//        headers.put("Content-Type", "application/json");
//        String body = "{\"size\": 10,\"current\": 1,\"title\":,\"proposer\":\"\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
//        String response = HttpClient.doPost_Json(body, url, headers);
//        logger.info("响应结果：" + response);
//        String status = AssertUtil.asert(response, "$.status");
//        String error = AssertUtil.asert(response, "$.error");
//        Assert.assertEquals(status, expect1);
//        Assert.assertEquals(error, expect);
//        String assertutil = responseAssertionImp.assertEqualsString(status, expect1);
//        String assertutil1 = responseAssertionImp.assertEqualsString(error, expect);
//        logger.info("断言结果：" + assertutil + ","+assertutil1);
    }


    @Story("条件查询消息，消息类型为3")
    @Test(description = "异常查看，proposer不存在")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_33() {
        Object[] expect = new Object[2];
        expect[0] = "400";
        expect[1] = "Bad Request";
        String url = testUrl + "/openApi/v1/message/3/search";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{\"size\": 10,\"current\": 1,\"title\": \"消息头\",\"proposer\":\"53333\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
        String response = HttpClient.doPost_Json(body, url, headers);
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
//        String url = testUrl + "/openApi/v1/message/1/search";
//        logger.info("请求url：" + url);
//        Map<String, Object> headers = new HashMap<>();
//        headers.put("Content-Type", "application/json");
//        String body = "{\"size\": 10,\"current\": 1,\"title\": \"消息头\",\"proposer\":\"53333\",\"readStatus\":0,\"receiverId\":\"5344123121\"}";
//        String response = HttpClient.doPost_Json(body, url, headers);
//        logger.info("响应结果：" + response);
//        String code = AssertUtil.asert(response, "$.code");
//        String msg = AssertUtil.asert(response, "$.msg");
//        Assert.assertEquals(code, expect1);
//        Assert.assertEquals(msg, expect);
//        String assertutil = responseAssertionImp.assertEqualsString(code, expect1);
//        String assertutil1 = responseAssertionImp.assertEqualsString(msg, expect);
//        logger.info("断言结果：" + assertutil + ","+assertutil1);
    }


    @Story("条件查询消息，消息类型为3")
    @Test(description = "正常查看，readStatus为1")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_34() {
        Object[] expect = new Object[2];
        expect[0] = "20000";
        expect[1] = "success";
        String url = testUrl + "/openApi/v1/message/3/search";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{\"size\": 10,\"current\": 1,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":1,\"receiverId\":\"5344123121\"}";
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

//        String expect = "success";
//        String expect1 = "20000";
//        String url = testUrl + "/openApi/v1/message/1/search";
//        logger.info("请求url：" + url);
//        Map<String, Object> headers = new HashMap<>();
//        headers.put("Content-Type", "application/json");
//        String body = "{\"size\": 10,\"current\": 1,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":1,\"receiverId\":\"5344123121\"}";
//        String response = HttpClient.doPost_Json(body, url, headers);
//        logger.info("响应结果：" + response);
//        String code = AssertUtil.asert(response, "$.code");
//        String msg = AssertUtil.asert(response, "$.msg");
//        Assert.assertEquals(code, expect1);
//        Assert.assertEquals(msg, expect);
//        String assertutil = responseAssertionImp.assertEqualsString(code, expect1);
//        String assertutil1 = responseAssertionImp.assertEqualsString(msg, expect);
//        logger.info("断言结果：" + assertutil + ","+assertutil1);
    }

    @Story("条件查询消息，消息类型为3")
    @Test(description = "异常查看，readStatus不存在")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_35() {
        Object[] expect = new Object[2];
        expect[0] = "400";
        expect[1] = "Bad Request";
        String url = testUrl + "/openApi/v1/message/3/search";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{\"size\": 10,\"current\": 1,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":3,\"receiverId\":\"5344123121\"}";
        String response = HttpClient.doPost_Json(body, url, headers);
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
//        String url = testUrl + "/openApi/v1/message/1/search";
//        logger.info("请求url：" + url);
//        Map<String, Object> headers = new HashMap<>();
//        headers.put("Content-Type", "application/json");
//        String body = "{\"size\": 10,\"current\": 1,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":3,\"receiverId\":\"5344123121\"}";
//        String response = HttpClient.doPost_Json(body, url, headers);
//        logger.info("响应结果：" + response);
//        String code = AssertUtil.asert(response, "$.code");
//        String msg = AssertUtil.asert(response, "$.msg");
//        Assert.assertEquals(code, expect1);
//        Assert.assertEquals(msg, expect);
//        String assertutil = responseAssertionImp.assertEqualsString(code, expect1);
//        String assertutil1 = responseAssertionImp.assertEqualsString(msg, expect);
//        logger.info("断言结果：" + assertutil + ","+assertutil1);
    }

    @Story("条件查询消息，消息类型为3")
    @Test(description = "异常查看，receiverId不存在")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_36() {
        Object[] expect = new Object[2];
        expect[0] = "400";
        expect[1] = "Bad Request";
        String url = testUrl + "/openApi/v1/message/3/search";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{\"size\": 10,\"current\": 1,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":1,\"receiverId\":\"5344123121#\"}";
        String response = HttpClient.doPost_Json(body, url, headers);
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
    }

    @Story("条件查询消息，消息类型为3")
    @Test(description = "异常查看，receiverId为空")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_37() {
        Object[] expect = new Object[2];
        expect[0] = "20000";
        expect[1] = "success";
        String url = testUrl + "/openApi/v1/message/3/search";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{\"size\": 10,\"current\": 1,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":1,\"receiverId\":\"\"}";
        String response = HttpClient.doPost_Json(body, url, headers);
        logger.info("响应结果：" + response);
        JSONObject act = JSONObject.parseObject(response);
        act.getString("code");
        act.get("msg");
        String[] JsonPach = new String[2];
        JsonPach[0] = "$.code";
        JsonPach[1] = "$.msg";
        boolean ResponseAssert = myassertimp.AssertByJsonPath(expect, act, JsonPach);
        logger.info("响应断言：" + ResponseAssert);
        Assert.assertEquals(expect[0], act.getString("code"));

//        String expect = "success";
//        String expect1 = "20000";
//        String url = testUrl + "/openApi/v1/message/1/search";
//        logger.info("请求url：" + url);
//        Map<String, Object> headers = new HashMap<>();
//        headers.put("Content-Type", "application/json");
//        String body = "{\"size\": 10,\"current\": 1,\"title\": \"消息头\",\"proposer\":\"\",\"readStatus\":0,\"receiverId\":\"\"}";
//        String response = HttpClient.doPost_Json(body, url, headers);
//        logger.info("响应结果：" + response);
//        String code = AssertUtil.asert(response, "$.code");
//        logger.info("实际结果：code,"+code);
//        String msg = AssertUtil.asert(response, "$.msg");
//        logger.info("实际结果：msg,"+msg);
//        Assert.assertEquals(code, expect1);
//        Assert.assertEquals(msg, expect);
//        String assertutil = responseAssertionImp.assertEqualsString(code, expect1);
//        String assertutil1 = responseAssertionImp.assertEqualsString(msg, expect);
//        logger.info("断言结果：" + assertutil + ","+assertutil1);
    }
}