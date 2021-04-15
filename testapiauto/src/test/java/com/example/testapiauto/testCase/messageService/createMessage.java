package com.example.testapiauto.testCase.messageService;

import com.example.testapiauto.modules.testCase.common.Assertion.AssertionImp.ResponseAssertionImp;
import com.example.testapiauto.modules.testCase.utils.AssertUtil;
import com.example.testapiauto.modules.testCase.utils.HttpClient;
import com.example.testapiauto.testCase.case1;
import io.qameta.allure.Story;
import okhttp3.Response;
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
public class createMessage {

    private static final Logger logger = LogManager.getLogger(case1.class);
    ResponseAssertionImp responseAssertionImp = new ResponseAssertionImp();

    String testUrl = new messageDetails().testUrl;


    @Story("发送消息，消息类型为1")
    @Test(description = "正常发送")
    public void case_1(){
        String expect = "success";
        String url = testUrl+"/openApi/message/v1/1/send";
        logger.info("请求url："+url);
        Map<String,Object> headers = new HashMap<>();
        headers.put("Content-Type","application/json");
        String body ="{\n" +
                "  \"sendId\": \"57594136\",\n" +
                "  \"sendName\": \"zhangsan\",\n" +
                "  \"roleId\": \"\",\n" +
                "  \"receiverIds\":[6129640,234324],\n" +
                "  \"templateId\":\"32\",\n" +
                "   \"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"\n" +
                "}";
        logger.info("请求参数："+body);
        String response = HttpClient.doPost_Json(body,url,headers);
        logger.info("响应结果："+response);
        String msg = AssertUtil.asert(response,"$.msg");
        Assert.assertEquals(msg,expect);
        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
        logger.info("断言结果："+assertutil);
    }

    @Story("发送消息，消息类型为1")
    @Test(description = "发送失败，sendId为空")
    public void case_2(){
        String expect = "success";
        String url = testUrl+"/openApi/message/v1/1/send";
        logger.info("请求url："+url);
        Map<String,Object> headers = new HashMap<>();
        headers.put("Content-Type","application/json");
        String body ="{\n" +
                "  \"sendId\": \"\",\n" +
                "  \"sendName\": \"zhangsan\",\n" +
                "  \"roleId\": \"\",\n" +
                "  \"receiverIds\":[6129640,234324],\n" +
                "  \"templateId\":\"32\",\n" +
                "   \"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"\n" +
                "}";
        logger.info("请求参数："+body);
        String response = HttpClient.doPost_Json(body,url,headers);
        logger.info("响应结果："+response);
        String msg = AssertUtil.asert(response,"$.msg");
        Assert.assertEquals(msg,expect);
        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
        logger.info("断言结果："+assertutil);
    }

    @Story("发送消息，消息类型为1")
    @Test(description = "发送失败，sendId不存在")
    public void case_3(){
        String expect = "success";
        String url = testUrl+"/openApi/message/v1/1/send";
        logger.info("请求url："+url);
        Map<String,Object> headers = new HashMap<>();
        headers.put("Content-Type","application/json");
        String body ="{\n" +
                "  \"sendId\": \"az\",\n" +
                "  \"sendName\": \"zhangsan\",\n" +
                "  \"roleId\": \"\",\n" +
                "  \"receiverIds\":[6129640,234324],\n" +
                "  \"templateId\":\"32\",\n" +
                "   \"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"\n" +
                "}";
        logger.info("请求参数："+body);
        String response = HttpClient.doPost_Json(body,url,headers);
        logger.info("响应结果："+response);
        String msg = AssertUtil.asert(response,"$.msg");
        Assert.assertEquals(msg,expect);
        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
        logger.info("断言结果："+assertutil);
    }


    @Story("发送消息，消息类型为1")
    @Test(description = "发送失败，sendName为空")
    public void case_4(){
        String expect = "success";
        String url = testUrl+"/openApi/message/v1/1/send";
        logger.info("请求url："+url);
        Map<String,Object> headers = new HashMap<>();
        headers.put("Content-Type","application/json");
        String body ="{\n" +
                "  \"sendId\": \"57594136\",\n" +
                "  \"sendName\": \"\",\n" +
                "  \"roleId\": \"\",\n" +
                "  \"receiverIds\":[6129640,234324],\n" +
                "  \"templateId\":\"32\",\n" +
                "   \"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"\n" +
                "}";
        logger.info("请求参数："+body);
        String response = HttpClient.doPost_Json(body,url,headers);
        logger.info("响应结果："+response);
        String msg = AssertUtil.asert(response,"$.msg");
        Assert.assertEquals(msg,expect);
        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
        logger.info("断言结果："+assertutil);
    }

    @Story("发送消息，消息类型为1")
    @Test(description = "发送失败，不存在的sendName")
    public void case_5(){
        String expect = "success";
        String url = testUrl+"/openApi/message/v1/1/send";
        logger.info("请求url："+url);
        Map<String,Object> headers = new HashMap<>();
        headers.put("Content-Type","application/json");
        String body ="{\n" +
                "  \"sendId\": \"57594136\",\n" +
                "  \"sendName\": \"533254\",\n" +
                "  \"roleId\": \"\",\n" +
                "  \"receiverIds\":[6129640,234324],\n" +
                "  \"templateId\":\"32\",\n" +
                "   \"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"\n" +
                "}";
        logger.info("请求参数："+body);
        String response = HttpClient.doPost_Json(body,url,headers);
        logger.info("响应结果："+response);
        String msg = AssertUtil.asert(response,"$.msg");
        Assert.assertEquals(msg,expect);
        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
        logger.info("断言结果："+assertutil);
    }


    @Story("发送消息，消息类型为1")
    @Test(description = "发送失败，不存在的roleId")
    public void case_6(){
        String expect = "business exception";
        String url = testUrl+"/openApi/message/v1/1/send";
        logger.info("请求url："+url);
        Map<String,Object> headers = new HashMap<>();
        headers.put("Content-Type","application/json");
        String body ="{\n" +
                "  \"sendId\": \"57594136\",\n" +
                "  \"sendName\": \"533254\",\n" +
                "  \"roleId\": \"64655454\",\n" +
                "  \"receiverIds\":[6129640,234324],\n" +
                "  \"templateId\":\"32\",\n" +
                "   \"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"\n" +
                "}";
        logger.info("请求参数："+body);
        String response = HttpClient.doPost_Json(body,url,headers);
        logger.info("响应结果："+response);
        String msg = AssertUtil.asert(response,"$.msg");
        Assert.assertEquals(msg,expect);
        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
        logger.info("断言结果："+assertutil);
    }


    @Story("发送消息，消息类型为1")
    @Test(description = "发送失败，不存在的roleId")
    public void case_7(){
        String expect = "business exception";
        String url = testUrl+"/openApi/message/v1/1/send";
        logger.info("请求url："+url);
        Map<String,Object> headers = new HashMap<>();
        headers.put("Content-Type","application/json");
        String body ="{\n" +
                "  \"sendId\": \"57594136\",\n" +
                "  \"sendName\": \"533254\",\n" +
                "  \"roleId\": \"64655454\",\n" +
                "  \"receiverIds\":[6129640,234324],\n" +
                "  \"templateId\":\"32\",\n" +
                "   \"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"\n" +
                "}";
        logger.info("请求参数："+body);
        String response = HttpClient.doPost_Json(body,url,headers);
        logger.info("响应结果："+response);
        String msg = AssertUtil.asert(response,"$.msg");
        Assert.assertEquals(msg,expect);
        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
        logger.info("断言结果："+assertutil);
    }

    @Story("发送消息，消息类型为1")
    @Test(description = "发送失败，不存在的receiverIds")
    public void case_8(){
        String expect = "success";
        String url = testUrl+"/openApi/message/v1/1/send";
        logger.info("请求url："+url);
        Map<String,Object> headers = new HashMap<>();
        headers.put("Content-Type","application/json");
        String body ="{\n" +
                "  \"sendId\": \"57594136\",\n" +
                "  \"sendName\": \"533254\",\n" +
                "  \"roleId\": \"\",\n" +
                "  \"receiverIds\":[61292640,2343124],\n" +
                "  \"templateId\":\"32\",\n" +
                "   \"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"\n" +
                "}";
        logger.info("请求参数："+body);
        String response = HttpClient.doPost_Json(body,url,headers);
        logger.info("响应结果："+response);
        String msg = AssertUtil.asert(response,"$.msg");
        Assert.assertEquals(msg,expect);
        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
        logger.info("断言结果："+assertutil);
    }


    @Story("发送消息，消息类型为1")
    @Test(description = "发送失败，receiverIds为空")
    public void case_9(){
        String expect = "400";
        String url = testUrl+"/openApi/message/v1/1/send";
        logger.info("请求url："+url);
        Map<String,Object> headers = new HashMap<>();
        headers.put("Content-Type","application/json");
        String body ="{\n" +
                "  \"sendId\": \"57594136\",\n" +
                "  \"sendName\": \"533254\",\n" +
                "  \"roleId\": \"\",\n" +
                "  \"receiverIds\":,\n" +
                "  \"templateId\":\"32\",\n" +
                "   \"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"\n" +
                "}";
        logger.info("请求参数："+body);
        String response = HttpClient.doPost_Json(body,url,headers);
        logger.info("响应结果："+response);
        String msg = AssertUtil.asert(response,"$.status");
        Assert.assertEquals(msg,expect);
        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
        logger.info("断言结果："+assertutil);
    }


    @Story("发送消息，消息类型为1")
    @Test(description = "发送失败，templateId为空")
    public void case_10(){
        String expect = "business exception";
        String url = testUrl+"/openApi/message/v1/1/send";
        logger.info("请求url："+url);
        Map<String,Object> headers = new HashMap<>();
        headers.put("Content-Type","application/json");
        String body ="{\n" +
                "  \"sendId\": \"57594136\",\n" +
                "  \"sendName\": \"533254\",\n" +
                "  \"roleId\": \"\",\n" +
                "  \"receiverIds\":[6129640,234324],\n" +
                "  \"templateId\":\"\",\n" +
                "   \"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"\n" +
                "}";
        logger.info("请求参数："+body);
        String response = HttpClient.doPost_Json(body,url,headers);
        logger.info("响应结果："+response);
        String msg = AssertUtil.asert(response,"$.msg");
        Assert.assertEquals(msg,expect);
        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
        logger.info("断言结果："+assertutil);
    }

    @Story("发送消息，消息类型为1")
    @Test(description = "发送失败，不存在的templateId")
    public void case_11(){
        String expect = "business exception";
        String url = testUrl+"/openApi/message/v1/1/send";
        logger.info("请求url："+url);
        Map<String,Object> headers = new HashMap<>();
        headers.put("Content-Type","application/json");
        String body ="{\n" +
                "  \"sendId\": \"57594136\",\n" +
                "  \"sendName\": \"533254\",\n" +
                "  \"roleId\": \"\",\n" +
                "  \"receiverIds\":[6129640,234324],\n" +
                "  \"templateId\":\"5877\",\n" +
                "   \"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"\n" +
                "}";
        logger.info("请求参数："+body);
        String response = HttpClient.doPost_Json(body,url,headers);
        logger.info("响应结果："+response);
        String msg = AssertUtil.asert(response,"$.msg");
        Assert.assertEquals(msg,expect);
        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
        logger.info("断言结果："+assertutil);
    }

    @Story("发送消息，消息类型为1")
    @Test(description = "发送失败，不存在的templateParam")
    public void case_12(){
        String expect = "success";
        String url = testUrl+"/openApi/message/v1/1/send";
        logger.info("请求url："+url);
        Map<String,Object> headers = new HashMap<>();
        headers.put("Content-Type","application/json");
        String body ="{\n" +
                "  \"sendId\": \"57594136\",\n" +
                "  \"sendName\": \"533254\",\n" +
                "  \"roleId\": \"\",\n" +
                "  \"receiverIds\":[6129640,234324],\n" +
                "  \"templateId\":\"32\",\n" +
                "   \"templateParam\":\"{\\\"code\\\":\\\"999119\\\"}\"\n" +
                "}";
        logger.info("请求参数："+body);
        String response = HttpClient.doPost_Json(body,url,headers);
        logger.info("响应结果："+response);
        String msg = AssertUtil.asert(response,"$.msg");
        Assert.assertEquals(msg,expect);
        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
        logger.info("断言结果："+assertutil);
    }


    @Story("发送消息，消息类型为1")
    @Test(description = "发送失败，templateParam为空")
    public void case_13(){
        String expect = "business exception";
        String url = testUrl+"/openApi/message/v1/1/send";
        logger.info("请求url："+url);
        Map<String,Object> headers = new HashMap<>();
        headers.put("Content-Type","application/json");
        String body ="{\n" +
                "  \"sendId\": \"57594136\",\n" +
                "  \"sendName\": \"533254\",\n" +
                "  \"roleId\": \"\",\n" +
                "  \"receiverIds\":[6129640,234324],\n" +
                "  \"templateId\":\"5877\",\n" +
                "   \"templateParam\":\"\"\n" +
                "}";
        logger.info("请求参数："+body);
        String response = HttpClient.doPost_Json(body,url,headers);
        logger.info("响应结果："+response);
        String msg = AssertUtil.asert(response,"$.msg");
        Assert.assertEquals(msg,expect);
        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
        logger.info("断言结果："+assertutil);
    }

    @Story("发送消息，消息类型为2")
    @Test(description = "正常发送")
    public void case_14(){
        String expect = "success";
        String url = testUrl+"/openApi/message/v1/2/send";
        logger.info("请求url："+url);
        Map<String,Object> headers = new HashMap<>();
        headers.put("Content-Type","application/json");
        String body ="{\n" +
                "  \"sendId\": \"57594136\",\n" +
                "  \"sendName\": \"zhangsan\",\n" +
                "  \"roleId\": \"\",\n" +
                "  \"receiverIds\":[6129640,234324],\n" +
                "  \"templateId\":\"32\",\n" +
                "   \"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"\n" +
                "}";
        logger.info("请求参数："+body);
        String response = HttpClient.doPost_Json(body,url,headers);
        logger.info("响应结果："+response);
        String msg = AssertUtil.asert(response,"$.msg");
        Assert.assertEquals(msg,expect);
        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
        logger.info("断言结果："+assertutil);
    }

    @Story("发送消息，消息类型为2")
    @Test(description = "发送失败，sendId为空")
    public void case_15(){
        String expect = "success";
        String url = testUrl+"/openApi/message/v1/2/send";
        logger.info("请求url："+url);
        Map<String,Object> headers = new HashMap<>();
        headers.put("Content-Type","application/json");
        String body ="{\n" +
                "  \"sendId\": \"\",\n" +
                "  \"sendName\": \"zhangsan\",\n" +
                "  \"roleId\": \"\",\n" +
                "  \"receiverIds\":[6129640,234324],\n" +
                "  \"templateId\":\"32\",\n" +
                "   \"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"\n" +
                "}";
        logger.info("请求参数："+body);
        String response = HttpClient.doPost_Json(body,url,headers);
        logger.info("响应结果："+response);
        String msg = AssertUtil.asert(response,"$.msg");
        Assert.assertEquals(msg,expect);
        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
        logger.info("断言结果："+assertutil);
    }

    @Story("发送消息，消息类型为2")
    @Test(description = "发送失败，sendId不存在")
    public void case_16(){
        String expect = "success";
        String url = testUrl+"/openApi/message/v1/2/send";
        logger.info("请求url："+url);
        Map<String,Object> headers = new HashMap<>();
        headers.put("Content-Type","application/json");
        String body ="{\n" +
                "  \"sendId\": \"az\",\n" +
                "  \"sendName\": \"zhangsan\",\n" +
                "  \"roleId\": \"\",\n" +
                "  \"receiverIds\":[6129640,234324],\n" +
                "  \"templateId\":\"32\",\n" +
                "   \"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"\n" +
                "}";
        logger.info("请求参数："+body);
        String response = HttpClient.doPost_Json(body,url,headers);
        logger.info("响应结果："+response);
        String msg = AssertUtil.asert(response,"$.msg");
        Assert.assertEquals(msg,expect);
        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
        logger.info("断言结果："+assertutil);
    }


    @Story("发送消息，消息类型为2")
    @Test(description = "发送失败，sendName为空")
    public void case_17(){
        String expect = "success";
        String url = testUrl+"/openApi/message/v1/2/send";
        logger.info("请求url："+url);
        Map<String,Object> headers = new HashMap<>();
        headers.put("Content-Type","application/json");
        String body ="{\n" +
                "  \"sendId\": \"57594136\",\n" +
                "  \"sendName\": \"\",\n" +
                "  \"roleId\": \"\",\n" +
                "  \"receiverIds\":[6129640,234324],\n" +
                "  \"templateId\":\"32\",\n" +
                "   \"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"\n" +
                "}";
        logger.info("请求参数："+body);
        String response = HttpClient.doPost_Json(body,url,headers);
        logger.info("响应结果："+response);
        String msg = AssertUtil.asert(response,"$.msg");
        Assert.assertEquals(msg,expect);
        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
        logger.info("断言结果："+assertutil);
    }

    @Story("发送消息，消息类型为2")
    @Test(description = "发送失败，不存在的sendName")
    public void case_18(){
        String expect = "success";
        String url = testUrl+"/openApi/message/v1/2/send";
        logger.info("请求url："+url);
        Map<String,Object> headers = new HashMap<>();
        headers.put("Content-Type","application/json");
        String body ="{\n" +
                "  \"sendId\": \"57594136\",\n" +
                "  \"sendName\": \"533254\",\n" +
                "  \"roleId\": \"\",\n" +
                "  \"receiverIds\":[6129640,234324],\n" +
                "  \"templateId\":\"32\",\n" +
                "   \"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"\n" +
                "}";
        logger.info("请求参数："+body);
        String response = HttpClient.doPost_Json(body,url,headers);
        logger.info("响应结果："+response);
        String msg = AssertUtil.asert(response,"$.msg");
        Assert.assertEquals(msg,expect);
        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
        logger.info("断言结果："+assertutil);
    }


    @Story("发送消息，消息类型为2")
    @Test(description = "发送失败，不存在的roleId")
    public void case_19(){
        String expect = "business exception";
        String url = testUrl+"/openApi/message/v1/2/send";
        logger.info("请求url："+url);
        Map<String,Object> headers = new HashMap<>();
        headers.put("Content-Type","application/json");
        String body ="{\n" +
                "  \"sendId\": \"57594136\",\n" +
                "  \"sendName\": \"533254\",\n" +
                "  \"roleId\": \"64655454\",\n" +
                "  \"receiverIds\":[6129640,234324],\n" +
                "  \"templateId\":\"32\",\n" +
                "   \"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"\n" +
                "}";
        logger.info("请求参数："+body);
        String response = HttpClient.doPost_Json(body,url,headers);
        logger.info("响应结果："+response);
        String msg = AssertUtil.asert(response,"$.msg");
        Assert.assertEquals(msg,expect);
        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
        logger.info("断言结果："+assertutil);
    }


    @Story("发送消息，消息类型为2")
    @Test(description = "发送失败，不存在的roleId")
    public void case_20(){
        String expect = "business exception";
        String url = testUrl+"/openApi/message/v1/2/send";
        logger.info("请求url："+url);
        Map<String,Object> headers = new HashMap<>();
        headers.put("Content-Type","application/json");
        String body ="{\n" +
                "  \"sendId\": \"57594136\",\n" +
                "  \"sendName\": \"533254\",\n" +
                "  \"roleId\": \"64655454\",\n" +
                "  \"receiverIds\":[6129640,234324],\n" +
                "  \"templateId\":\"32\",\n" +
                "   \"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"\n" +
                "}";
        logger.info("请求参数："+body);
        String response = HttpClient.doPost_Json(body,url,headers);
        logger.info("响应结果："+response);
        String msg = AssertUtil.asert(response,"$.msg");
        Assert.assertEquals(msg,expect);
        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
        logger.info("断言结果："+assertutil);
    }

    @Story("发送消息，消息类型为2")
    @Test(description = "发送失败，不存在的receiverIds")
    public void case_21(){
        String expect = "success";
        String url = testUrl+"/openApi/message/v1/2/send";
        logger.info("请求url："+url);
        Map<String,Object> headers = new HashMap<>();
        headers.put("Content-Type","application/json");
        String body ="{\n" +
                "  \"sendId\": \"57594136\",\n" +
                "  \"sendName\": \"533254\",\n" +
                "  \"roleId\": \"\",\n" +
                "  \"receiverIds\":[61292640,2343124],\n" +
                "  \"templateId\":\"32\",\n" +
                "   \"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"\n" +
                "}";
        logger.info("请求参数："+body);
        String response = HttpClient.doPost_Json(body,url,headers);
        logger.info("响应结果："+response);
        String msg = AssertUtil.asert(response,"$.msg");
        Assert.assertEquals(msg,expect);
        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
        logger.info("断言结果："+assertutil);
    }


    @Story("发送消息，消息类型为2")
    @Test(description = "发送失败，receiverIds为空")
    public void case_22(){
        String expect = "400";
        String url = testUrl+"/openApi/message/v1/2/send";
        logger.info("请求url："+url);
        Map<String,Object> headers = new HashMap<>();
        headers.put("Content-Type","application/json");
        String body ="{\n" +
                "  \"sendId\": \"57594136\",\n" +
                "  \"sendName\": \"533254\",\n" +
                "  \"roleId\": \"\",\n" +
                "  \"receiverIds\":,\n" +
                "  \"templateId\":\"32\",\n" +
                "   \"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"\n" +
                "}";
        logger.info("请求参数："+body);
        String response = HttpClient.doPost_Json(body,url,headers);
        logger.info("响应结果："+response);
        String msg = AssertUtil.asert(response,"$.status");
        Assert.assertEquals(msg,expect);
        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
        logger.info("断言结果："+assertutil);
    }


    @Story("发送消息，消息类型为2")
    @Test(description = "发送失败，templateId为空")
    public void case_23(){
        String expect = "business exception";
        String url = testUrl+"/openApi/message/v1/2/send";
        logger.info("请求url："+url);
        Map<String,Object> headers = new HashMap<>();
        headers.put("Content-Type","application/json");
        String body ="{\n" +
                "  \"sendId\": \"57594136\",\n" +
                "  \"sendName\": \"533254\",\n" +
                "  \"roleId\": \"\",\n" +
                "  \"receiverIds\":[6129640,234324],\n" +
                "  \"templateId\":\"\",\n" +
                "   \"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"\n" +
                "}";
        logger.info("请求参数："+body);
        String response = HttpClient.doPost_Json(body,url,headers);
        logger.info("响应结果："+response);
        String msg = AssertUtil.asert(response,"$.msg");
        Assert.assertEquals(msg,expect);
        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
        logger.info("断言结果："+assertutil);
    }

    @Story("发送消息，消息类型为2")
    @Test(description = "发送失败，不存在的templateId")
    public void case_24(){
        String expect = "business exception";
        String url = testUrl+"/openApi/message/v1/2/send";
        logger.info("请求url："+url);
        Map<String,Object> headers = new HashMap<>();
        headers.put("Content-Type","application/json");
        String body ="{\n" +
                "  \"sendId\": \"57594136\",\n" +
                "  \"sendName\": \"533254\",\n" +
                "  \"roleId\": \"\",\n" +
                "  \"receiverIds\":[6129640,234324],\n" +
                "  \"templateId\":\"5877\",\n" +
                "   \"templateParam\":\"{\\\"code\\\":\\\"9999\\\"}\"\n" +
                "}";
        logger.info("请求参数："+body);
        String response = HttpClient.doPost_Json(body,url,headers);
        logger.info("响应结果："+response);
        String msg = AssertUtil.asert(response,"$.msg");
        Assert.assertEquals(msg,expect);
        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
        logger.info("断言结果："+assertutil);
    }

    @Story("发送消息，消息类型为2")
    @Test(description = "发送失败，不存在的templateParam")
    public void case_25(){
        String expect = "success";
        String url = testUrl+"/openApi/message/v1/2/send";
        logger.info("请求url："+url);
        Map<String,Object> headers = new HashMap<>();
        headers.put("Content-Type","application/json");
        String body ="{\n" +
                "  \"sendId\": \"57594136\",\n" +
                "  \"sendName\": \"533254\",\n" +
                "  \"roleId\": \"\",\n" +
                "  \"receiverIds\":[6129640,234324],\n" +
                "  \"templateId\":\"32\",\n" +
                "   \"templateParam\":\"{\\\"code\\\":\\\"999119\\\"}\"\n" +
                "}";
        logger.info("请求参数："+body);
        String response = HttpClient.doPost_Json(body,url,headers);
        logger.info("响应结果："+response);
        String msg = AssertUtil.asert(response,"$.msg");
        Assert.assertEquals(msg,expect);
        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
        logger.info("断言结果："+assertutil);
    }


    @Story("发送消息，消息类型为1")
    @Test(description = "发送失败，templateParam为空")
    public void case_26(){
        String expect = "business exception";
        String url = testUrl+"/openApi/message/v1/2/send";
        logger.info("请求url："+url);
        Map<String,Object> headers = new HashMap<>();
        headers.put("Content-Type","application/json");
        String body ="{\n" +
                "  \"sendId\": \"57594136\",\n" +
                "  \"sendName\": \"533254\",\n" +
                "  \"roleId\": \"\",\n" +
                "  \"receiverIds\":[6129640,234324],\n" +
                "  \"templateId\":\"5877\",\n" +
                "   \"templateParam\":\"\"\n" +
                "}";
        logger.info("请求参数："+body);
        String response = HttpClient.doPost_Json(body,url,headers);
        logger.info("响应结果："+response);
        String msg = AssertUtil.asert(response,"$.msg");
        Assert.assertEquals(msg,expect);
        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
        logger.info("断言结果："+assertutil);
    }
}
