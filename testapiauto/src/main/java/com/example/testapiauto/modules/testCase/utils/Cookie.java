package com.example.testapiauto.modules.testCase.utils;

import com.alibaba.fastjson.JSONObject;
import com.example.testapiauto.app.serviceImp.myAssertImp;
import com.example.testapiauto.modules.testCase.common.UrlEncodeing;
import com.example.testapiauto.yuxiang.resultsUtils;
import okhttp3.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class Cookie {

    private static final Logger logger = LogManager.getLogger(Cookie.class);
    static String Tokens = resultsUtils.token;
    static myAssertImp myassertimp = new myAssertImp();


    public static final String TestUrl = resultsUtils.TestUrl;
    //正式环境url
    public static String FormalUrl = "http://www.baidu.com";
    //测试环境url
//    public static String TestUrl = "http://yunxiao.multi.com";
    //测试环境账号密码
    public static final String userName = "itestAli";
    public static final String password = "pGs+7tRWUx8XkcCNJchPX6gWG5EB1dFyyq6TXIQmdaie9wkRl3wQh9fPhNGo5Aip8NRql0CJ9HXgusgxSowC0wCijf8wQvv8xkpcD8Kax8T3" +
            "+hYjjWa1MkRnN1Qqg57Zca1iBYylqVHysZ14Ymxhy6up93IppAAxVJNThx+oEKg=";

     /**
      *
      * @param
      * @author 假斯文
      * @date 2021/4/19 15:04
      * @return  测试环境cookie
      */
    public static String TestEnvCookie(){
        String TestUrl = Cookie.TestUrl;
        String url = TestUrl+"/openApi/v1/message/id?id=145";
        StringBuffer sb = new StringBuffer();
        url = UrlEncodeing.GetRealUrl(url);
        Response response =  doGet(url);
        //获取响应信息中的头信息
        Headers headers = response.headers();
        //获取SET-Cookie的值
        List<String>cookies = headers.values("SET-Cookie");
        //遍历Cookies当中的值
        for (String cookie : cookies){
            sb.append(cookie.replace("Path=/","Path=/:"));
        }
        return sb.toString();
    }

     /**
      *
      * @param
      * @author 假斯文
      * @date 2021/4/19 15:05
      * @return 获取测试环境token
      */

     public static String testEnvToken(){
         String url = TestUrl+"/api/mix/custom/doLogin";
         Map body = new HashMap();
         body.put("username",userName);
         body.put("password",password);
         StringBuffer sb = new StringBuffer();
         url = UrlEncodeing.GetRealUrl(url);
         Response response =  doPost(url,body);
         //获取响应信息中的头信息
         Headers headers = response.headers();
         //获取SET-Cookie的值
         List<String>cookies = headers.values("SET-Cookie");
         //遍历Cookies当中的值
         for (String cookie : cookies){
             sb.append(cookie.replace("Path=/","Path=/:"));
         }
         return sb.toString();
     }

    public static String TestEnvAuthentication(){
        Object[] expect = new Object[2];
        expect[0] = "20000";
        expect[1] = "success";
        String url = TestUrl + "/openApi/v1/message/update/145";
        logger.info("请求url：" + url);
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", Tokens);
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

        return act.getString("code");
    }


    public static Response doPost(String url,Map<String,Object> body) {
        FormBody formBody = SetBody(body);
        Response response = null;
        OkHttpClient okHttpClient = new OkHttpClient();
        //声明一个Request    请求类
        Request.Builder builder = new Request.Builder();
        builder.post(formBody);
        builder.url(url);
        Request request = builder
                .build();
        try {
            response = okHttpClient.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

        public static Response doGet(String url) {
            Response result = null;
            //声明一个okhttp3的请求客户端类
            OkHttpClient okHttpClient = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            //声明一个Response
            try {
                 result = okHttpClient.newCall(request).execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;

        }


//        Response response = null;
//        //声明一个Okhttp3的请求客户端类
//        OkHttpClient okHttpClient = new OkHttpClient();
//        //声明一个Request
//        Request request = new Request.Builder()
//                .url(url)
//                .build();
//        //声明一个Response
//        try {
//            response = okHttpClient.newCall(request).execute();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return response;

//    }

//    public static String doPost_form_urlencoded(Map<String, Object> body, String url, Map<String, Object> headers) {
//        FormBody body1 = SetBody(body);
//        //       RequestBody bodyparam = RequestBody.create(FORM, body);
//        Headers headers1 = SetHeaders(headers);
//        Response response = null;
//        //声明一个result   结果
//        String result = "";
//        OkHttpClient okHttpClient = new OkHttpClient();
//        //声明一个Request    请求类
//        Request.Builder builder = new Request.Builder();
//        builder.post(body1);
//        builder.url(url);
//        builder.headers(headers1);
//        Request request = builder
//                .build();
//        try {
//            response = okHttpClient.newCall(request).execute();
//            result = response.body().string();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return result;
//    }


    private static FormBody SetBody(Map<String, Object> body) {
        FormBody body1 = null;
        FormBody.Builder bodyBuild = new FormBody.Builder();
        if (body != null) {
            Iterator<String> iterator = body.keySet().iterator();
            String Key = "";
            while (iterator.hasNext()) {
                Key = iterator.next().toString();
                bodyBuild.add(Key, body.get(Key).toString());
//                System.out.println("Key==" + Key + "===Value==" + body.get(Key).toString());
            }
        }
        return body1 = bodyBuild.build();
    }


    private static Headers SetHeaders(Map<String, Object> headers) {
        Headers headers1 = null;
        Headers.Builder headerBulid = new Headers.Builder();
        if (headers != null) {
            Iterator<String> iterator = headers.keySet().iterator();
            String key = "";
            while (iterator.hasNext()) {
                key = iterator.next().toString();
                headerBulid.add(key, headers.get(key).toString());
//                System.out.println("key:"+key+"====value:"+headers.get(key).toString());
            }
        }
        return headers1 = headerBulid.build();
    }

    public static RequestBody buildBody(String body) {
        MediaType HJSON = MediaType.parse("application/json; charset=utf-8");
        return RequestBody.create(HJSON, body);
    }






}

