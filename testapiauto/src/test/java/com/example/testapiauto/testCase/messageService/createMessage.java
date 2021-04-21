package com.example.testapiauto.testCase.messageService;

import com.alibaba.fastjson.JSONObject;
import com.example.testapiauto.app.serviceImp.myAssertImp;
import com.example.testapiauto.modules.testCase.common.Assertion.AssertionImp.ResponseAssertionImp;
import com.example.testapiauto.modules.testCase.utils.HttpClient;
import com.example.testapiauto.yuxiang.random;
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
 * @date 2021/4/15 10:23
 */

@Epic("发送消息")
@Feature("发送")
public class createMessage {

    private static final Logger logger = LogManager.getLogger(createMessage.class);
    ResponseAssertionImp responseAssertionImp = new ResponseAssertionImp();
    String testUrl = resultsUtils.TestUrl;
    String Token = resultsUtils.token;
    myAssertImp myassertimp = new myAssertImp();
    String random_26 = random.getRandom(26);


    @Story("发送消息，消息类型为1")
    @Test(description = "正常发送")
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
        String url = testUrl + "/openApi/message/v1/1/send";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{ \"sendId\": \"575941366129650\",\"sendName\": \"测试007\",\"roleId\": \"\",\"receiverIds\":[6129640,234324]," +
                "\"templateId\":\"32\",\"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"}";
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
//        String url = testUrl+"/openApi/message/v1/1/send";
//        logger.info("请求url："+url);
//        Map<String,Object> headers = new HashMap<>();
//        headers.put("Content-Type","application/json");
//        String body ="{\n" +
//                "  \"sendId\": \"57594136\",\n" +
//                "  \"sendName\": \"zhangsan\",\n" +
//                "  \"roleId\": \"\",\n" +
//                "  \"receiverIds\":[6129640,234324],\n" +
//                "  \"templateId\":\"32\",\n" +
//                "   \"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"\n" +
//                "}";
//        logger.info("请求参数："+body);
//        String response = HttpClient.doPost_Json(body,url,headers);
//        logger.info("响应结果："+response);
//        String msg = AssertUtil.asert(response,"$.msg");
//        Assert.assertEquals(msg,expect);
//        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
//        logger.info("断言结果："+assertutil);
    }

    @Story("发送消息，消息类型为1")
    @Test(description = "发送失败，sendId为空")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_2() {
        Object[] expect = new Object[2];
        expect[0] = "20002";
        expect[1] = "business exception";
        String url = testUrl + "/openApi/message/v1/1/send";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{ \"sendId\": \"\",\"sendName\": \"测试007\",\"roleId\": \"\",\"receiverIds\":[6129640,234324]," +
                "\"templateId\":\"32\",\"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"}";
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
//        String url = testUrl+"/openApi/message/v1/1/send";
//        logger.info("请求url："+url);
//        Map<String,Object> headers = new HashMap<>();
//        headers.put("Content-Type","application/json");
//        String body ="{\n" +
//                "  \"sendId\": \"\",\n" +
//                "  \"sendName\": \"zhangsan\",\n" +
//                "  \"roleId\": \"\",\n" +
//                "  \"receiverIds\":[6129640,234324],\n" +
//                "  \"templateId\":\"32\",\n" +
//                "   \"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"\n" +
//                "}";
//        logger.info("请求参数："+body);
//        String response = HttpClient.doPost_Json(body,url,headers);
//        logger.info("响应结果："+response);
//        String msg = AssertUtil.asert(response,"$.msg");
//        Assert.assertEquals(msg,expect);
//        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
//        logger.info("断言结果："+assertutil);
    }

    @Story("发送消息，消息类型为1")
    @Test(description = "发送失败，sendId长度为26")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_28() {
        Object[] expect = new Object[2];
        expect[0] = "20002";
        expect[1] = "business exception";
        String url = testUrl + "/openApi/message/v1/1/send";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{ \"sendId\": 45645624314583487545645236,\"sendName\": \"测试007\",\"roleId\": \"\",\"receiverIds\":[6129640,234324],\"templateId\":\"32\"," +
                "\"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"}";
        logger.info("请求参数:" + body);
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
//        String url = testUrl+"/openApi/message/v1/1/send";
//        logger.info("请求url："+url);
//        Map<String,Object> headers = new HashMap<>();
//        headers.put("Content-Type","application/json");
//        String body ="{\n" +
//                "  \"sendId\": \"az\",\n" +
//                "  \"sendName\": \"zhangsan\",\n" +
//                "  \"roleId\": \"\",\n" +
//                "  \"receiverIds\":[6129640,234324],\n" +
//                "  \"templateId\":\"32\",\n" +
//                "   \"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"\n" +
//                "}";
//        logger.info("请求参数："+body);
//        String response = HttpClient.doPost_Json(body,url,headers);
//        logger.info("响应结果："+response);
//        String msg = AssertUtil.asert(response,"$.msg");
//        Assert.assertEquals(msg,expect);
//        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
//        logger.info("断言结果："+assertutil);
    }

    @Story("发送消息，消息类型为1")
    @Test(description = "发送失败，sendId不存在")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_3() {
        Object[] expect = new Object[2];
        expect[0] = "20002";
        expect[1] = "business exception";
        String url = testUrl + "/openApi/message/v1/1/send";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{ \"sendId\": \"95\",\"sendName\": \"测试007\",\"roleId\": \"\",\"receiverIds\":[6129640,234324]," +
                "\"templateId\":\"32\",\"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"}";
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


    @Story("发送消息，消息类型为1")
    @Test(description = "发送失败，sendName为空")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_4() {
        Object[] expect = new Object[2];
        expect[0] = "20002";
        expect[1] = "business exception";
        String url = testUrl + "/openApi/message/v1/1/send";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{ \"sendId\": 575941366129650,\"sendName\": \"\",\"roleId\": \"\",\"receiverIds\":[6129640,234324],\"templateId\":\"32\"," +
                "\"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"}";
        logger.info("请求参数:" + body);
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
//        String url = testUrl+"/openApi/message/v1/1/send";
//        logger.info("请求url："+url);
//        Map<String,Object> headers = new HashMap<>();
//        headers.put("Content-Type","application/json");
//        String body ="{\n" +
//                "  \"sendId\": \"57594136\",\n" +
//                "  \"sendName\": \"\",\n" +
//                "  \"roleId\": \"\",\n" +
//                "  \"receiverIds\":[6129640,234324],\n" +
//                "  \"templateId\":\"32\",\n" +
//                "   \"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"\n" +
//                "}";
//        logger.info("请求参数："+body);
//        String response = HttpClient.doPost_Json(body,url,headers);
//        logger.info("响应结果："+response);
//        String msg = AssertUtil.asert(response,"$.msg");
//        Assert.assertEquals(msg,expect);
//        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
//        logger.info("断言结果："+assertutil);
    }

    @Story("发送消息，消息类型为1")
    @Test(description = "发送失败，不存在的sendName")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_5() {
        Object[] expect = new Object[2];
        expect[0] = "20002";
        expect[1] = "business exception";
        String url = testUrl + "/openApi/message/v1/1/send";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{ \"sendId\": 575941366129650,\"sendName\": \"sadga\",\"roleId\": \"\",\"receiverIds\":[6129640,234324]," +
                "\"templateId\":\"32\"," +
                "\"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"}";
        logger.info("请求参数:" + body);
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
//        String url = testUrl+"/openApi/message/v1/1/send";
//        logger.info("请求url："+url);
//        Map<String,Object> headers = new HashMap<>();
//        headers.put("Content-Type","application/json");
//        String body ="{\n" +
//                "  \"sendId\": \"57594136\",\n" +
//                "  \"sendName\": \"533254\",\n" +
//                "  \"roleId\": \"\",\n" +
//                "  \"receiverIds\":[6129640,234324],\n" +
//                "  \"templateId\":\"32\",\n" +
//                "   \"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"\n" +
//                "}";
//        logger.info("请求参数："+body);
//        String response = HttpClient.doPost_Json(body,url,headers);
//        logger.info("响应结果："+response);
//        String msg = AssertUtil.asert(response,"$.msg");
//        Assert.assertEquals(msg,expect);
//        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
//        logger.info("断言结果："+assertutil);
    }


    @Story("发送消息，消息类型为1")
    @Test(description = "发送失败,sendName长度为21")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_29() {
        Object[] expect = new Object[2];
        expect[0] = "20002";
        expect[1] = "business exception";
        String url = testUrl + "/openApi/message/v1/1/send";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{ \"sendId\": 575941366129650,\"sendName\": \"sadga5347862145320842\",\"roleId\": \"\",\"receiverIds\":[6129640,234324]," +
                "\"templateId\":\"32\"," +
                "\"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"}";
        logger.info("请求参数:" + body);
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

    @Story("发送消息，消息类型为1")
    @Test(description = "发送失败,sendName数字开头")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_30() {
        Object[] expect = new Object[2];
        expect[0] = "20002";
        expect[1] = "business exception";
        String url = testUrl + "/openApi/message/v1/1/send";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{ \"sendId\": 575941366129650,\"sendName\": \"53478621453sadga0842\",\"roleId\": \"\",\"receiverIds\":[6129640,234324]," +
                "\"templateId\":\"32\"," +
                "\"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"}";
        logger.info("请求参数:" + body);
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

    @Story("发送消息，消息类型为1")
    @Test(description = "发送失败，不存在的roleId")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_6() {
        Object[] expect = new Object[2];
        expect[0] = "20002";
        expect[1] = "business exception";
        String url = testUrl + "/openApi/message/v1/1/send";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{ \"sendId\": 575941366129650,\"sendName\": \"测试007\",\"roleId\": \"64655454\",\"receiverIds\":[6129640,234324]," +
                "\"templateId\":\"32\"," +
                "\"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"}";
        logger.info("请求参数:" + body);
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

//        String expect = "business exception";
//        String url = testUrl+"/openApi/message/v1/1/send";
//        logger.info("请求url："+url);
//        Map<String,Object> headers = new HashMap<>();
//        headers.put("Content-Type","application/json");
//        String body ="{\n" +
//                "  \"sendId\": \"57594136\",\n" +
//                "  \"sendName\": \"533254\",\n" +
//                "  \"roleId\": \"64655454\",\n" +
//                "  \"receiverIds\":[6129640,234324],\n" +
//                "  \"templateId\":\"32\",\n" +
//                "   \"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"\n" +
//                "}";
//        logger.info("请求参数："+body);
//        String response = HttpClient.doPost_Json(body,url,headers);
//        logger.info("响应结果："+response);
//        String msg = AssertUtil.asert(response,"$.msg");
//        Assert.assertEquals(msg,expect);
//        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
//        logger.info("断言结果："+assertutil);
    }


    @Story("发送消息，消息类型为1")
    @Test(description = "发送失败，roleId长度为26")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_31() {
        Object[] expect = new Object[2];
        expect[0] = "20002";
        expect[1] = "business exception";
        String url = testUrl + "/openApi/message/v1/1/send";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{ \"sendId\": 575941366129650,\"sendName\": \"测试007\",\"roleId\": \"13245678952163478564242164\",\"receiverIds\":[6129640," +
                "234324]," +
                "\"templateId\":\"32\"," +
                "\"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"}";
        logger.info("请求参数:" + body);
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

    @Story("发送消息，消息类型为1")
    @Test(description = "发送失败，不存在的receiverIds")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_8() {
        Object[] expect = new Object[2];
        expect[0] = "20002";
        expect[1] = "business exception";
        String url = testUrl + "/openApi/message/v1/1/send";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{ \"sendId\": 575941366129650,\"sendName\": \"测试007\",\"roleId\": \"\",\"receiverIds\":[612966640,2345324]," +
                "\"templateId\":\"32\"," +
                "\"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"}";
        logger.info("请求参数:" + body);
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


    @Story("发送消息，消息类型为1")
    @Test(description = "发送失败，receiverIds为空")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_9() {
        Object[] expect = new Object[2];
        expect[0] = "20002";
        expect[1] = "business exception";
        String url = testUrl + "/openApi/message/v1/1/send";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{ \"sendId\": 575941366129650,\"sendName\": \"测试007\",\"roleId\": \"\",\"receiverIds\":," +
                "\"templateId\":\"32\"," +
                "\"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"}";
        logger.info("请求参数:" + body);
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

//        String expect = "400";
//        String url = testUrl+"/openApi/message/v1/1/send";
//        logger.info("请求url："+url);
//        Map<String,Object> headers = new HashMap<>();
//        headers.put("Content-Type","application/json");
//        String body ="{\n" +
//                "  \"sendId\": \"57594136\",\n" +
//                "  \"sendName\": \"533254\",\n" +
//                "  \"roleId\": \"\",\n" +
//                "  \"receiverIds\":,\n" +
//                "  \"templateId\":\"32\",\n" +
//                "   \"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"\n" +
//                "}";
//        logger.info("请求参数："+body);
//        String response = HttpClient.doPost_Json(body,url,headers);
//        logger.info("响应结果："+response);
//        String msg = AssertUtil.asert(response,"$.status");
//        Assert.assertEquals(msg,expect);
//        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
//        logger.info("断言结果："+assertutil);
    }


    @Story("发送消息，消息类型为1")
    @Test(description = "发送失败，templateId为空")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_10() {
        Object[] expect = new Object[2];
        expect[0] = "20002";
        expect[1] = "business exception";
        String url = testUrl + "/openApi/message/v1/1/send";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{ \"sendId\": 575941366129650,\"sendName\": \"测试007\",\"roleId\": \"\",\"receiverIds\":[6129640,234324]," +
                "\"templateId\":\"\"," +
                "\"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"}";
        logger.info("请求参数:" + body);
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

//        String expect = "business exception";
//        String url = testUrl+"/openApi/message/v1/1/send";
//        logger.info("请求url："+url);
//        Map<String,Object> headers = new HashMap<>();
//        headers.put("Content-Type","application/json");
//        String body ="{\n" +
//                "  \"sendId\": \"57594136\",\n" +
//                "  \"sendName\": \"533254\",\n" +
//                "  \"roleId\": \"\",\n" +
//                "  \"receiverIds\":[6129640,234324],\n" +
//                "  \"templateId\":\"\",\n" +
//                "   \"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"\n" +
//                "}";
//        logger.info("请求参数："+body);
//        String response = HttpClient.doPost_Json(body,url,headers);
//        logger.info("响应结果："+response);
//        String msg = AssertUtil.asert(response,"$.msg");
//        Assert.assertEquals(msg,expect);
//        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
//        logger.info("断言结果："+assertutil);
    }

    @Story("发送消息，消息类型为1")
    @Test(description = "发送失败，不存在的templateId")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_11() {
        Object[] expect = new Object[2];
        expect[0] = "20002";
        expect[1] = "business exception";
        String url = testUrl + "/openApi/message/v1/1/send";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{ \"sendId\": 575941366129650,\"sendName\": \"测试007\",\"roleId\": \"\",\"receiverIds\":[6129640,234324]," +
                "\"templateId\":\"as\"," +
                "\"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"}";
        logger.info("请求参数:" + body);
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

//        String expect = "business exception";
//        String url = testUrl+"/openApi/message/v1/1/send";
//        logger.info("请求url："+url);
//        Map<String,Object> headers = new HashMap<>();
//        headers.put("Content-Type","application/json");
//        String body ="{\n" +
//                "  \"sendId\": \"57594136\",\n" +
//                "  \"sendName\": \"533254\",\n" +
//                "  \"roleId\": \"\",\n" +
//                "  \"receiverIds\":[6129640,234324],\n" +
//                "  \"templateId\":\"5877\",\n" +
//                "   \"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"\n" +
//                "}";
//        logger.info("请求参数："+body);
//        String response = HttpClient.doPost_Json(body,url,headers);
//        logger.info("响应结果："+response);
//        String msg = AssertUtil.asert(response,"$.msg");
//        Assert.assertEquals(msg,expect);
//        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
//        logger.info("断言结果："+assertutil);
    }


    @Story("发送消息，消息类型为1")
    @Test(description = "发送失败，templateId长度为31")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_27() {
        Object[] expect = new Object[2];
        expect[0] = "20002";
        expect[1] = "business exception";
        String url = testUrl + "/openApi/message/v1/1/send";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{ \"sendId\": 575941366129650,\"sendName\": \"测试007\",\"roleId\": \"\",\"receiverIds\":[6129640,234324]," +
                "\"templateId\":\"0000000000000000000000313423532\"," +
                "\"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"}";
        logger.info("请求参数:" + body);
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

//        String expect = "business exception";
//        String url = testUrl+"/openApi/message/v1/1/send";
//        logger.info("请求url："+url);
//        Map<String,Object> headers = new HashMap<>();
//        headers.put("Content-Type","application/json");
//        String body ="{\n" +
//                "  \"sendId\": \"57594136\",\n" +
//                "  \"sendName\": \"533254\",\n" +
//                "  \"roleId\": \"\",\n" +
//                "  \"receiverIds\":[6129640,234324],\n" +
//                "  \"templateId\":\"0000000000000000000000313423532\",\n" +
//                "   \"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"\n" +
//                "}";
//        logger.info("请求参数："+body);
//        String response = HttpClient.doPost_Json(body,url,headers);
//        logger.info("响应结果："+response);
//        String msg = AssertUtil.asert(response,"$.msg");
//        Assert.assertEquals(msg,expect);
//        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
//        logger.info("断言结果："+assertutil);
    }

    @Story("发送消息，消息类型为1")
    @Test(description = "发送失败，不存在的templateParam")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_12() {
        Object[] expect = new Object[2];
        expect[0] = "20002";
        expect[1] = "business exception";
        String url = testUrl + "/openApi/message/v1/1/send";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{ \"sendId\": 575941366129650,\"sendName\": \"测试007\",\"roleId\": \"\",\"receiverIds\":[6129640,234324]," +
                "\"templateId\":\"32\"," +
                "\"templateParam\":\"{\\\"code\\\":\\\"991299\\\"}\"}";
        logger.info("请求参数:" + body);
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
//        String url = testUrl+"/openApi/message/v1/1/send";
//        logger.info("请求url："+url);
//        Map<String,Object> headers = new HashMap<>();
//        headers.put("Content-Type","application/json");
//        String body ="{\n" +
//                "  \"sendId\": \"57594136\",\n" +
//                "  \"sendName\": \"533254\",\n" +
//                "  \"roleId\": \"\",\n" +
//                "  \"receiverIds\":[6129640,234324],\n" +
//                "  \"templateId\":\"32\",\n" +
//                "   \"templateParam\":\"{\\\"code\\\":\\\"999119\\\"}\"\n" +
//                "}";
//        logger.info("请求参数："+body);
//        String response = HttpClient.doPost_Json(body,url,headers);
//        logger.info("响应结果："+response);
//        String msg = AssertUtil.asert(response,"$.msg");
//        Assert.assertEquals(msg,expect);
//        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
//        logger.info("断言结果："+assertutil);
    }


    @Story("发送消息，消息类型为1")
    @Test(description = "发送失败，templateParam为空")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_13() {
        Object[] expect = new Object[2];
        expect[0] = "20002";
        expect[1] = "business exception";
        String url = testUrl + "/openApi/message/v1/1/send";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{ \"sendId\": 575941366129650,\"sendName\": \"测试007\",\"roleId\": \"\",\"receiverIds\":[6129640,234324]," +
                "\"templateId\":\"32\"," +
                "\"templateParam\":\"\"}";
        logger.info("请求参数:" + body);
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

//        String expect = "business exception";
//        String url = testUrl+"/openApi/message/v1/1/send";
//        logger.info("请求url："+url);
//        Map<String,Object> headers = new HashMap<>();
//        headers.put("Content-Type","application/json");
//        String body ="{\n" +
//                "  \"sendId\": \"57594136\",\n" +
//                "  \"sendName\": \"533254\",\n" +
//                "  \"roleId\": \"\",\n" +
//                "  \"receiverIds\":[6129640,234324],\n" +
//                "  \"templateId\":\"5877\",\n" +
//                "   \"templateParam\":\"\"\n" +
//                "}";
//        logger.info("请求参数："+body);
//        String response = HttpClient.doPost_Json(body,url,headers);
//        logger.info("响应结果："+response);
//        String msg = AssertUtil.asert(response,"$.msg");
//        Assert.assertEquals(msg,expect);
//        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
//        logger.info("断言结果："+assertutil);
    }

    /**
     * @param
     * @return 发送消息，消息类型为2
     * @author 假斯文
     * @date 2021/4/20 14:32
     */

    @Story("发送消息，消息类型为2")
    @Test(description = "正常发送")
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
        String url = testUrl + "/openApi/message/v1/2/send";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{ \"sendId\": \"575941366129650\",\"sendName\": \"测试007\",\"roleId\": \"\",\"receiverIds\":[6129640,234324]," +
                "\"templateId\":\"32\",\"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"}";
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
//        String url = testUrl+"/openApi/message/v1/1/send";
//        logger.info("请求url："+url);
//        Map<String,Object> headers = new HashMap<>();
//        headers.put("Content-Type","application/json");
//        String body ="{\n" +
//                "  \"sendId\": \"57594136\",\n" +
//                "  \"sendName\": \"zhangsan\",\n" +
//                "  \"roleId\": \"\",\n" +
//                "  \"receiverIds\":[6129640,234324],\n" +
//                "  \"templateId\":\"32\",\n" +
//                "   \"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"\n" +
//                "}";
//        logger.info("请求参数："+body);
//        String response = HttpClient.doPost_Json(body,url,headers);
//        logger.info("响应结果："+response);
//        String msg = AssertUtil.asert(response,"$.msg");
//        Assert.assertEquals(msg,expect);
//        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
//        logger.info("断言结果："+assertutil);
    }

    @Story("发送消息，消息类型为2")
    @Test(description = "发送失败，sendId为空")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_15() {
        Object[] expect = new Object[2];
        expect[0] = "20002";
        expect[1] = "business exception";
        String url = testUrl + "/openApi/message/v1/2/send";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{ \"sendId\": \"\",\"sendName\": \"测试007\",\"roleId\": \"\",\"receiverIds\":[6129640,234324]," +
                "\"templateId\":\"32\",\"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"}";
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
//        String url = testUrl+"/openApi/message/v1/1/send";
//        logger.info("请求url："+url);
//        Map<String,Object> headers = new HashMap<>();
//        headers.put("Content-Type","application/json");
//        String body ="{\n" +
//                "  \"sendId\": \"\",\n" +
//                "  \"sendName\": \"zhangsan\",\n" +
//                "  \"roleId\": \"\",\n" +
//                "  \"receiverIds\":[6129640,234324],\n" +
//                "  \"templateId\":\"32\",\n" +
//                "   \"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"\n" +
//                "}";
//        logger.info("请求参数："+body);
//        String response = HttpClient.doPost_Json(body,url,headers);
//        logger.info("响应结果："+response);
//        String msg = AssertUtil.asert(response,"$.msg");
//        Assert.assertEquals(msg,expect);
//        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
//        logger.info("断言结果："+assertutil);
    }

    @Story("发送消息，消息类型为2")
    @Test(description = "发送失败，sendId长度为26")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_16() {
        Object[] expect = new Object[2];
        expect[0] = "20002";
        expect[1] = "business exception";
        String url = testUrl + "/openApi/message/v1/2/send";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{ \"sendId\": 45645624314583487545645236,\"sendName\": \"测试007\",\"roleId\": \"\",\"receiverIds\":[6129640,234324],\"templateId\":\"32\"," +
                "\"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"}";
        logger.info("请求参数:" + body);
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
//        String url = testUrl+"/openApi/message/v1/1/send";
//        logger.info("请求url："+url);
//        Map<String,Object> headers = new HashMap<>();
//        headers.put("Content-Type","application/json");
//        String body ="{\n" +
//                "  \"sendId\": \"az\",\n" +
//                "  \"sendName\": \"zhangsan\",\n" +
//                "  \"roleId\": \"\",\n" +
//                "  \"receiverIds\":[6129640,234324],\n" +
//                "  \"templateId\":\"32\",\n" +
//                "   \"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"\n" +
//                "}";
//        logger.info("请求参数："+body);
//        String response = HttpClient.doPost_Json(body,url,headers);
//        logger.info("响应结果："+response);
//        String msg = AssertUtil.asert(response,"$.msg");
//        Assert.assertEquals(msg,expect);
//        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
//        logger.info("断言结果："+assertutil);
    }

    @Story("发送消息，消息类型为2")
    @Test(description = "发送失败，sendId不存在")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_17() {
        Object[] expect = new Object[2];
        expect[0] = "20002";
        expect[1] = "business exception";
        String url = testUrl + "/openApi/message/v1/2/send";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{ \"sendId\": \"95\",\"sendName\": \"测试007\",\"roleId\": \"\",\"receiverIds\":[6129640,234324]," +
                "\"templateId\":\"32\",\"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"}";
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


    @Story("发送消息，消息类型为2")
    @Test(description = "发送失败，sendName为空")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_18() {
        Object[] expect = new Object[2];
        expect[0] = "20002";
        expect[1] = "business exception";
        String url = testUrl + "/openApi/message/v1/2/send";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{ \"sendId\": 575941366129650,\"sendName\": \"\",\"roleId\": \"\",\"receiverIds\":[6129640,234324],\"templateId\":\"32\"," +
                "\"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"}";
        logger.info("请求参数:" + body);
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
//        String url = testUrl+"/openApi/message/v1/1/send";
//        logger.info("请求url："+url);
//        Map<String,Object> headers = new HashMap<>();
//        headers.put("Content-Type","application/json");
//        String body ="{\n" +
//                "  \"sendId\": \"57594136\",\n" +
//                "  \"sendName\": \"\",\n" +
//                "  \"roleId\": \"\",\n" +
//                "  \"receiverIds\":[6129640,234324],\n" +
//                "  \"templateId\":\"32\",\n" +
//                "   \"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"\n" +
//                "}";
//        logger.info("请求参数："+body);
//        String response = HttpClient.doPost_Json(body,url,headers);
//        logger.info("响应结果："+response);
//        String msg = AssertUtil.asert(response,"$.msg");
//        Assert.assertEquals(msg,expect);
//        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
//        logger.info("断言结果："+assertutil);
    }

    @Story("发送消息，消息类型为2")
    @Test(description = "发送失败，不存在的sendName")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_19() {
        Object[] expect = new Object[2];
        expect[0] = "20002";
        expect[1] = "business exception";
        String url = testUrl + "/openApi/message/v1/2/send";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{ \"sendId\": 575941366129650,\"sendName\": \"sadga\",\"roleId\": \"\",\"receiverIds\":[6129640,234324]," +
                "\"templateId\":\"32\"," +
                "\"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"}";
        logger.info("请求参数:" + body);
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
//        String url = testUrl+"/openApi/message/v1/1/send";
//        logger.info("请求url："+url);
//        Map<String,Object> headers = new HashMap<>();
//        headers.put("Content-Type","application/json");
//        String body ="{\n" +
//                "  \"sendId\": \"57594136\",\n" +
//                "  \"sendName\": \"533254\",\n" +
//                "  \"roleId\": \"\",\n" +
//                "  \"receiverIds\":[6129640,234324],\n" +
//                "  \"templateId\":\"32\",\n" +
//                "   \"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"\n" +
//                "}";
//        logger.info("请求参数："+body);
//        String response = HttpClient.doPost_Json(body,url,headers);
//        logger.info("响应结果："+response);
//        String msg = AssertUtil.asert(response,"$.msg");
//        Assert.assertEquals(msg,expect);
//        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
//        logger.info("断言结果："+assertutil);
    }


    @Story("发送消息，消息类型为2")
    @Test(description = "发送失败,sendName长度为21")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_20() {
        Object[] expect = new Object[2];
        expect[0] = "20002";
        expect[1] = "business exception";
        String url = testUrl + "/openApi/message/v1/2/send";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{ \"sendId\": 575941366129650,\"sendName\": \"sadga5347862145320842\",\"roleId\": \"\",\"receiverIds\":[6129640,234324]," +
                "\"templateId\":\"32\"," +
                "\"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"}";
        logger.info("请求参数:" + body);
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

    @Story("发送消息，消息类型为2")
    @Test(description = "发送失败,sendName数字开头")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_21() {
        Object[] expect = new Object[2];
        expect[0] = "20002";
        expect[1] = "business exception";
        String url = testUrl + "/openApi/message/v1/2/send";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{ \"sendId\": 575941366129650,\"sendName\": \"53478621453sadga0842\",\"roleId\": \"\",\"receiverIds\":[6129640,234324]," +
                "\"templateId\":\"32\"," +
                "\"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"}";
        logger.info("请求参数:" + body);
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

    @Story("发送消息，消息类型为2")
    @Test(description = "发送失败，不存在的roleId")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_22() {
        Object[] expect = new Object[2];
        expect[0] = "20002";
        expect[1] = "business exception";
        String url = testUrl + "/openApi/message/v1/2/send";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{ \"sendId\": 575941366129650,\"sendName\": \"测试007\",\"roleId\": \"64655454\",\"receiverIds\":[6129640,234324]," +
                "\"templateId\":\"32\"," +
                "\"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"}";
        logger.info("请求参数:" + body);
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

//        String expect = "business exception";
//        String url = testUrl+"/openApi/message/v1/1/send";
//        logger.info("请求url："+url);
//        Map<String,Object> headers = new HashMap<>();
//        headers.put("Content-Type","application/json");
//        String body ="{\n" +
//                "  \"sendId\": \"57594136\",\n" +
//                "  \"sendName\": \"533254\",\n" +
//                "  \"roleId\": \"64655454\",\n" +
//                "  \"receiverIds\":[6129640,234324],\n" +
//                "  \"templateId\":\"32\",\n" +
//                "   \"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"\n" +
//                "}";
//        logger.info("请求参数："+body);
//        String response = HttpClient.doPost_Json(body,url,headers);
//        logger.info("响应结果："+response);
//        String msg = AssertUtil.asert(response,"$.msg");
//        Assert.assertEquals(msg,expect);
//        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
//        logger.info("断言结果："+assertutil);
    }


    @Story("发送消息，消息类型为2")
    @Test(description = "发送失败，roleId长度为26")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_23() {
        Object[] expect = new Object[2];
        expect[0] = "20002";
        expect[1] = "business exception";
        String url = testUrl + "/openApi/message/v1/2/send";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{ \"sendId\": 575941366129650,\"sendName\": \"测试007\",\"roleId\": \"13245678952163478564242164\",\"receiverIds\":[6129640," +
                "234324]," +
                "\"templateId\":\"32\"," +
                "\"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"}";
        logger.info("请求参数:" + body);
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

    @Story("发送消息，消息类型为2")
    @Test(description = "发送失败，不存在的receiverIds")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_24() {
        Object[] expect = new Object[2];
        expect[0] = "20002";
        expect[1] = "business exception";
        String url = testUrl + "/openApi/message/v1/2/send";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{ \"sendId\": 575941366129650,\"sendName\": \"测试007\",\"roleId\": \"\",\"receiverIds\":[612966640,2345324]," +
                "\"templateId\":\"32\"," +
                "\"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"}";
        logger.info("请求参数:" + body);
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


    @Story("发送消息，消息类型为2")
    @Test(description = "发送失败，receiverIds为空")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_25() {
        Object[] expect = new Object[2];
        expect[0] = "20002";
        expect[1] = "business exception";
        String url = testUrl + "/openApi/message/v1/2/send";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{ \"sendId\": 575941366129650,\"sendName\": \"测试007\",\"roleId\": \"\",\"receiverIds\":," +
                "\"templateId\":\"32\"," +
                "\"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"}";
        logger.info("请求参数:" + body);
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

//        String expect = "400";
//        String url = testUrl+"/openApi/message/v1/1/send";
//        logger.info("请求url："+url);
//        Map<String,Object> headers = new HashMap<>();
//        headers.put("Content-Type","application/json");
//        String body ="{\n" +
//                "  \"sendId\": \"57594136\",\n" +
//                "  \"sendName\": \"533254\",\n" +
//                "  \"roleId\": \"\",\n" +
//                "  \"receiverIds\":,\n" +
//                "  \"templateId\":\"32\",\n" +
//                "   \"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"\n" +
//                "}";
//        logger.info("请求参数："+body);
//        String response = HttpClient.doPost_Json(body,url,headers);
//        logger.info("响应结果："+response);
//        String msg = AssertUtil.asert(response,"$.status");
//        Assert.assertEquals(msg,expect);
//        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
//        logger.info("断言结果："+assertutil);
    }


    @Story("发送消息，消息类型为2")
    @Test(description = "发送失败，templateId为空")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_26() {
        Object[] expect = new Object[2];
        expect[0] = "20002";
        expect[1] = "business exception";
        String url = testUrl + "/openApi/message/v1/2/send";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{ \"sendId\": 575941366129650,\"sendName\": \"测试007\",\"roleId\": \"\",\"receiverIds\":[6129640,234324]," +
                "\"templateId\":\"\"," +
                "\"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"}";
        logger.info("请求参数:" + body);
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

//        String expect = "business exception";
//        String url = testUrl+"/openApi/message/v1/1/send";
//        logger.info("请求url："+url);
//        Map<String,Object> headers = new HashMap<>();
//        headers.put("Content-Type","application/json");
//        String body ="{\n" +
//                "  \"sendId\": \"57594136\",\n" +
//                "  \"sendName\": \"533254\",\n" +
//                "  \"roleId\": \"\",\n" +
//                "  \"receiverIds\":[6129640,234324],\n" +
//                "  \"templateId\":\"\",\n" +
//                "   \"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"\n" +
//                "}";
//        logger.info("请求参数："+body);
//        String response = HttpClient.doPost_Json(body,url,headers);
//        logger.info("响应结果："+response);
//        String msg = AssertUtil.asert(response,"$.msg");
//        Assert.assertEquals(msg,expect);
//        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
//        logger.info("断言结果："+assertutil);
    }

    @Story("发送消息，消息类型为2")
    @Test(description = "发送失败，不存在的templateId")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_32() {
        Object[] expect = new Object[2];
        expect[0] = "20002";
        expect[1] = "business exception";
        String url = testUrl + "/openApi/message/v1/2/send";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{ \"sendId\": 575941366129650,\"sendName\": \"测试007\",\"roleId\": \"\",\"receiverIds\":[6129640,234324]," +
                "\"templateId\":\"as\"," +
                "\"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"}";
        logger.info("请求参数:" + body);
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

//        String expect = "business exception";
//        String url = testUrl+"/openApi/message/v1/1/send";
//        logger.info("请求url："+url);
//        Map<String,Object> headers = new HashMap<>();
//        headers.put("Content-Type","application/json");
//        String body ="{\n" +
//                "  \"sendId\": \"57594136\",\n" +
//                "  \"sendName\": \"533254\",\n" +
//                "  \"roleId\": \"\",\n" +
//                "  \"receiverIds\":[6129640,234324],\n" +
//                "  \"templateId\":\"5877\",\n" +
//                "   \"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"\n" +
//                "}";
//        logger.info("请求参数："+body);
//        String response = HttpClient.doPost_Json(body,url,headers);
//        logger.info("响应结果："+response);
//        String msg = AssertUtil.asert(response,"$.msg");
//        Assert.assertEquals(msg,expect);
//        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
//        logger.info("断言结果："+assertutil);
    }


    @Story("发送消息，消息类型为2")
    @Test(description = "发送失败，templateId长度为31")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_33() {
        Object[] expect = new Object[2];
        expect[0] = "20002";
        expect[1] = "business exception";
        String url = testUrl + "/openApi/message/v1/2/send";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{ \"sendId\": 575941366129650,\"sendName\": \"测试007\",\"roleId\": \"\",\"receiverIds\":[6129640,234324]," +
                "\"templateId\":\"0000000000000000000000313423532\"," +
                "\"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"}";
        logger.info("请求参数:" + body);
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

//        String expect = "business exception";
//        String url = testUrl+"/openApi/message/v1/1/send";
//        logger.info("请求url："+url);
//        Map<String,Object> headers = new HashMap<>();
//        headers.put("Content-Type","application/json");
//        String body ="{\n" +
//                "  \"sendId\": \"57594136\",\n" +
//                "  \"sendName\": \"533254\",\n" +
//                "  \"roleId\": \"\",\n" +
//                "  \"receiverIds\":[6129640,234324],\n" +
//                "  \"templateId\":\"0000000000000000000000313423532\",\n" +
//                "   \"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"\n" +
//                "}";
//        logger.info("请求参数："+body);
//        String response = HttpClient.doPost_Json(body,url,headers);
//        logger.info("响应结果："+response);
//        String msg = AssertUtil.asert(response,"$.msg");
//        Assert.assertEquals(msg,expect);
//        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
//        logger.info("断言结果："+assertutil);
    }

    @Story("发送消息，消息类型为2")
    @Test(description = "发送失败，不存在的templateParam")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_34() {
        Object[] expect = new Object[2];
        expect[0] = "20002";
        expect[1] = "business exception";
        String url = testUrl + "/openApi/message/v1/2/send";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{ \"sendId\": 575941366129650,\"sendName\": \"测试007\",\"roleId\": \"\",\"receiverIds\":[6129640,234324]," +
                "\"templateId\":\"32\"," +
                "\"templateParam\":\"{\\\"code\\\":\\\"991299\\\"}\"}";
        logger.info("请求参数:" + body);
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
//        String url = testUrl+"/openApi/message/v1/1/send";
//        logger.info("请求url："+url);
//        Map<String,Object> headers = new HashMap<>();
//        headers.put("Content-Type","application/json");
//        String body ="{\n" +
//                "  \"sendId\": \"57594136\",\n" +
//                "  \"sendName\": \"533254\",\n" +
//                "  \"roleId\": \"\",\n" +
//                "  \"receiverIds\":[6129640,234324],\n" +
//                "  \"templateId\":\"32\",\n" +
//                "   \"templateParam\":\"{\\\"code\\\":\\\"999119\\\"}\"\n" +
//                "}";
//        logger.info("请求参数："+body);
//        String response = HttpClient.doPost_Json(body,url,headers);
//        logger.info("响应结果："+response);
//        String msg = AssertUtil.asert(response,"$.msg");
//        Assert.assertEquals(msg,expect);
//        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
//        logger.info("断言结果："+assertutil);
    }


    @Story("发送消息，消息类型为2")
    @Test(description = "发送失败，templateParam为空")
    @Description("验证是否能查看")
    @Owner("醉生")
    @Step("输入 url:" + resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址", type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_35() {
        Object[] expect = new Object[2];
        expect[0] = "20002";
        expect[1] = "business exception";
        String url = testUrl + "/openApi/message/v1/2/send";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Token);
        headers.put("Content-Type", "application/json");
        String body = "{ \"sendId\": 575941366129650,\"sendName\": \"测试007\",\"roleId\": \"\",\"receiverIds\":[6129640,234324]," +
                "\"templateId\":\"32\"," +
                "\"templateParam\":\"\"}";
        logger.info("请求参数:" + body);
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

//        String expect = "business exception";
//        String url = testUrl+"/openApi/message/v1/1/send";
//        logger.info("请求url："+url);
//        Map<String,Object> headers = new HashMap<>();
//        headers.put("Content-Type","application/json");
//        String body ="{\n" +
//                "  \"sendId\": \"57594136\",\n" +
//                "  \"sendName\": \"533254\",\n" +
//                "  \"roleId\": \"\",\n" +
//                "  \"receiverIds\":[6129640,234324],\n" +
//                "  \"templateId\":\"5877\",\n" +
//                "   \"templateParam\":\"\"\n" +
//                "}";
//        logger.info("请求参数："+body);
//        String response = HttpClient.doPost_Json(body,url,headers);
//        logger.info("响应结果："+response);
//        String msg = AssertUtil.asert(response,"$.msg");
//        Assert.assertEquals(msg,expect);
//        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
//        logger.info("断言结果："+assertutil);
    }
}