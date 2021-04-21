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
 * @date 2021/4/14 16:52
 */



@Epic("消息服务")
@Feature("消息详情")
public class messageDetails {
    private static final Logger logger = LogManager.getLogger(messageDetails.class);

    ResponseAssertionImp responseAssertionImp = new ResponseAssertionImp();
    myAssertImp myassertimp = new myAssertImp();
    String testUrl = resultsUtils.TestUrl;
    String raandom_31 = random.getRandom(31);
    String Token = resultsUtils.token;
    public static String msg1 = null;

        /**
         *
         * @param
         * @author 假斯文
         * @date 2021/4/19 17:01
         * @return 获取签名
         */


//     @Story("获取签名")
//     @Test(description = "获取签名")
//     @Owner("醉生")
//     @Description("描述")
//     @Step("输入 url:"+resultsUtils.TestUrl)
//     @Link(resultsUtils.TestUrl)
//     @Link(name = "测试地址",type = "接口测试")
//     @Severity(SeverityLevel.NORMAL)
//     public void case_0(){
//         String expect = "success";
//         String url = testUrl+"/api/gateway/workbench/usercenter/getSign";
//         logger.info("请求url："+url);
//         Map<String,Object> headers = new HashMap<>();
//         String body = "";
//         String response = HttpClient.doPost_Json(url);
//         logger.info("响应结果："+response);
//         msg1 = AssertUtil.asert(response,"$.msg");
//         Assert.assertEquals(msg1,expect);
//         String responseAssert = responseAssertionImp.assertEqualsString(msg1,expect);
//         logger.info("断言结果："+responseAssert);
//         JSONObject josn = JSON.parseObject(response);
//         System.out.println(josn.getString("code"));
//    //        Map tmap = JSONObject.parseObject(response,Map.class);
//    //        System.out.println(tmap);



//
// }


    @Story("查看消息详情")
    @Test(description = "正常查看，输入正确ID")
    @Owner("醉生")
    @Description("描述")
    @Step("输入 url:"+resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址",type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_1(){
        Object[] expect = new Object[2];
        expect[0] = "20000";
        expect[1] = "success";
        String url = testUrl+"/openApi/v1/message/id/145";
        logger.info("请求url："+url);
        Map<String,Object> headers = new HashMap<>();
        headers.put("Authorization",Token);
        String response = HttpClient.doGet_header(url,headers);
        logger.info("响应结果："+response);
        JSONObject act = JSONObject.parseObject(response);
        act.get("code");
        act.get("msg");
        String[] JsonPach = new  String[2];
        JsonPach[0] = "$.code";
        JsonPach[1] = "$.msg";
        boolean ResponseAssert = myassertimp.AssertByJsonPath(expect,act,JsonPach);
        logger.info("响应断言："+ResponseAssert);
        Assert.assertEquals(expect[0],act.getString("code"));
//        logger.info(acc);
//        logger.info("响应结果："+response);
//        myassertimp.AssertByJsonPath()
//        msg1 = AssertUtil.asert(response,"$.msg");
//        Assert.assertEquals(msg1,expect);
//        String responseAssert = responseAssertionImp.assertEqualsString(msg1,expect);
//        logger.info("断言结果："+responseAssert);
//        JSONObject josn = JSON.parseObject(response);
//        System.out.println(josn.getString("code"));
//        Map tmap = JSONObject.parseObject(response,Map.class);
//        System.out.println(tmap);



    }

    @Story("查看消息详情")
    @Test(description = "异常查看，输入错误ID")
    @Owner("醉生")
    @Description("描述")
    @Step("输入 url:"+resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址",type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_2(){
        Object[] expect = new Object[2];
        expect[0] = "20002";
        expect[1] = "business exception";
        String url = testUrl+"/openApi/v1/message/id/1*";
        logger.info("请求url："+url);
        Map<String,Object> headers = new HashMap<>();
        headers.put("Authorization",Token);
        String response = HttpClient.doGet_header(url,headers);
        logger.info("响应结果："+response);
        JSONObject act = JSONObject.parseObject(response);
        act.get("code");
        act.get("msg");
        String[] JsonPach = new  String[2];
        JsonPach[0] = "$.code";
        JsonPach[1] = "$.msg";
        boolean ResponseAssert = myassertimp.AssertByJsonPath(expect,act,JsonPach);
        logger.info("响应断言："+ResponseAssert);
        Assert.assertEquals(expect[0],act.getString("code"));
//        String expect = "400";
//        String url = testUrl+"/openApi/v1/message/id/9*";
//        logger.info("请求url："+url);
//        String response = HttpClient.doGet(url);
//        logger.info("响应结果："+response);
//        String msg = AssertUtil.asert(response,"$.status");
//        Assert.assertEquals(msg,expect);
//        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
//        logger.info("断言结果："+assertutil);
    }

    @Story("查看消息详情")
    @Test(description = "异常查看，输入不存在ID")
    @Owner("醉生")
    @Description("描述")
    @Step("输入 url:"+resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址",type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_3(){
        Object[] expect = new Object[2];
        expect[0] = "20002";
        expect[1] = "business exception";
        String url = testUrl+"/openApi/v1/message/id/14553";
        logger.info("请求url："+url);
        Map<String,Object> headers = new HashMap<>();
        headers.put("Authorization",Token);
        String response = HttpClient.doGet_header(url,headers);
        logger.info("响应结果："+response);
        JSONObject act = JSONObject.parseObject(response);
        act.get("code");
        act.get("msg");
        String[] JsonPach = new  String[2];
        JsonPach[0] = "$.code";
        JsonPach[1] = "$.msg";
        boolean ResponseAssert = myassertimp.AssertByJsonPath(expect,act,JsonPach);
        logger.info("响应断言："+ResponseAssert);
        Assert.assertEquals(expect[0],act.getString("code"));

//        String expect = "business exception";
//        String url = testUrl+"/openApi/v1/message/id/9099";
//        logger.info("请求url："+url);
//        String response = HttpClient.doGet(url);
//        logger.info("响应结果："+response);
//        String msg = AssertUtil.asert(response,"$.msg");
//        Assert.assertEquals(msg,expect);
//        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
//        logger.info("断言结果："+assertutil);
    }

    @Story("查看消息详情")
    @Test(description = "异常查看，不输入ID")
    @Owner("醉生")
    @Description("描述")
    @Step("输入 url:"+resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址",type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_4(){
        Object[] expect = new Object[2];
        expect[0] = "404";
        expect[1] = "Not Found";
        String url = testUrl+"/openApi/v1/message/id/";
        logger.info("请求url："+url);
        Map<String,Object> headers = new HashMap<>();
        headers.put("Authorization",Token);
        String response = HttpClient.doGet_header(url,headers);
        logger.info("响应结果："+response);
        JSONObject act = JSONObject.parseObject(response);
        act.get("status");
        act.get("error");
        String[] JsonPach = new  String[2];
        JsonPach[0] = "$.status";
        JsonPach[1] = "$.error";
        boolean ResponseAssert = myassertimp.AssertByJsonPath(expect,act,JsonPach);
        logger.info("响应断言："+ResponseAssert);
        Assert.assertEquals(expect[0],act.getString("status"));

//        String expect = "business exception";
//        String url = testUrl+"/openApi/v1/message/id/";
//        logger.info("请求url："+url);
//        String response = HttpClient.doGet(url);
//        logger.info("响应结果："+response);
//        String msg = AssertUtil.asert(response,"$.msg");
//        Assert.assertEquals(msg,expect);
//        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
//        logger.info("断言结果："+assertutil);
    }

    @Story("查看消息详情")
    @Test(description = "异常查看，输入null")
    @Owner("醉生")
    @Description("描述")
    @Step("输入 url:"+resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址",type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_5(){
        Object[] expect = new Object[2];
        expect[0] = "20002";
        expect[1] = "business exception";
        String url = testUrl+"/openApi/v1/message/id/null";
        logger.info("请求url："+url);
        Map<String,Object> headers = new HashMap<>();
        headers.put("Authorization",Token);
        String response = HttpClient.doGet_header(url,headers);
        logger.info("响应结果："+response);
        JSONObject act = JSONObject.parseObject(response);
        act.get("code");
        act.get("msg");
        String[] JsonPach = new  String[2];
        JsonPach[0] = "$.code";
        JsonPach[1] = "$.msg";
        boolean ResponseAssert = myassertimp.AssertByJsonPath(expect,act,JsonPach);
        logger.info("响应断言："+ResponseAssert);
        Assert.assertEquals(expect[0],act.getString("code"));

//        String expect = "400";
//        String url = testUrl+"/openApi/v1/message/id/null1";
//        logger.info("请求url："+url);
//        String response = HttpClient.doGet(url);
//        logger.info("响应结果："+response);
//        String msg = AssertUtil.asert(response,"$.status");
//        Assert.assertEquals(msg,expect);
//        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
//        logger.info("断言结果："+assertutil);
    }

    @Story("查看消息详情")
    @Test(description = "异常查看，长度为31")
    @Owner("醉生")
    @Description("描述")
    @Step("输入 url:"+resultsUtils.TestUrl)
    @Link(resultsUtils.TestUrl)
    @Link(name = "测试地址",type = "接口测试")
    @Severity(SeverityLevel.NORMAL)
    public void case_6(){
        Object[] expect = new Object[2];
        expect[0] = "20002";
        expect[1] = "business exception";
        String url = testUrl+"/openApi/v1/message/id/"+raandom_31;
        logger.info("请求url："+url);
        Map<String,Object> headers = new HashMap<>();
        headers.put("Authorization",Token);
        String response = HttpClient.doGet_header(url,headers);
        logger.info("响应结果："+response);
        JSONObject act = JSONObject.parseObject(response);
        act.get("code");
        act.get("msg");
        String[] JsonPach = new  String[2];
        JsonPach[0] = "$.code";
        JsonPach[1] = "$.msg";
        boolean ResponseAssert = myassertimp.AssertByJsonPath(expect,act,JsonPach);
        logger.info("响应断言："+ResponseAssert);
        Assert.assertEquals(expect[0],act.getString("code"));

//        String expect = "400";
//        String url = testUrl+"/openApi/v1/message/id/"+raandom_31;
//        logger.info("请求url："+url);
//        String response = HttpClient.doGet(url);
//        logger.info("响应结果："+response);
//        String msg = AssertUtil.asert(response,"$.status");
//        Assert.assertEquals(msg,expect);
//        String assertutil = responseAssertionImp.assertEqualsString(msg,expect);
//        logger.info("断言结果："+assertutil);
    }
}
