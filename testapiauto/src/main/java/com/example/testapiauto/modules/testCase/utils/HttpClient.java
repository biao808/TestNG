package com.example.testapiauto.modules.testCase.utils;

import com.alibaba.fastjson.JSONObject;
import okhttp3.*;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 *@program:testapiauto
 *@author: 假斯文
 *@Time: 2021/3/18  17:35
 **/
public class HttpClient {
    public static final MediaType HJSON = MediaType.parse("application/json");
    public static final MediaType FORM = MediaType.parse("application/x-www-form-urlencoded");


    /***
     * @author 假斯文
     * @date 2021/3/19 10:45
     * @param
     * @return 纯url请求方法
     ***/
    public static String doGet(String url) {
        String result = "";
        //声明一个okhttp3的请求客户端类
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        //声明一个Response
        try {
            Response response = okHttpClient.newCall(request).execute();
            result = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;

    }

    /**
     *
     * @param
     * @author 假斯文
     * @date 2021/4/14 16:59
     * @return  get请求 不传headers
     */
    public static String doGet_body(String url,Map<String,Object>body){
        FormBody body1 = SetBody(body);
        String result = "";
        //声明一个okhttp3的请求客户端类
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .post(body1)
                .build();
        //声明一个Response
        try {
            Response response = okHttpClient.newCall(request).execute();
            result = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /***
    * @author 假斯文
    * @date 2021/3/19 17:03
    * @param
    * @return url和headers的get请求方式 headers为Map类型
    ***/

    public static String doGet_header(String url, Map<String,Object> headers){
        Headers headers1 = SetHeaders(headers);
        //声明一个Response
        Response response = null;
        //声明一个Result 结果
        String result = "";
        //声明一个Request 请求类
        OkHttpClient okHttpClient = new OkHttpClient();
        Request.Builder builder = new Request.Builder();
            builder.url(url);
            builder.headers(headers1);
         Request request = builder
                 .build();
         try {
             response = okHttpClient.newCall(request).execute();
             result = response.body().string();
         }catch (IOException e){
             e.printStackTrace();
         }
         return result;
    }

    /***
     * @author 假斯文
     * @date 2021/3/19 10:44
     * @param
     * @return post请求，headers是Map类型  url和body是String类型
     ***/
    public static String doPost(String url, Map<String, Object> headers, String body) {
        //声明一个RequestBody
        RequestBody bodyParams = RequestBody.create(HJSON, body);
        //声明一个OKhttpclient
        OkHttpClient okHttpClient = new OkHttpClient();
        //声明一个Headers
        Headers headers1 = SetHeaders(headers);
        //声明一个Result
        String result = "";
        //声明一个Response
        Response response = null;
        //声明一个request
        Request request = new Request.Builder()
                .url(url)
                .headers(headers1)
                .post(bodyParams)
                .build();
        try {
            response = okHttpClient.newCall(request).execute();
            result = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

     /**
      *
      * @param
      * @author 假斯文
      * @date 2021/4/15 14:27
      * @return  post请求，headers是Map类型  url是String类型
      */
     public static String doPost_headers(String url, Map<String, Object> headers) {
         //声明一个OKhttpclient
         OkHttpClient okHttpClient = new OkHttpClient();
         //声明一个Headers
         Headers headers1 = SetHeaders(headers);
         //声明一个Result
         String result = "";
         //声明一个Response
         Response response = null;
         //声明一个request
         Request request = new Request.Builder()
                 .url(url)
                 .headers(headers1)
                 .build();
         try {
             response = okHttpClient.newCall(request).execute();
             result = response.body().string();
         } catch (IOException e) {
             e.printStackTrace();
         }
         return result;
     }


    /***
     * @author 假斯文
     * @date 2021/3/19 15:47
     * @param
     * @return post请求，headers是Map类型  url和body是String类型 body是表单类型进行传参
     ***/

    public static String doPost_from(String url, String body, Map<String, Object> headers) {
        String result = "";
        MultipartBody.Builder multipartBody = new MultipartBody.Builder().setType(MultipartBody.FORM);
        JSONObject bodyjson = JSONObject.parseObject(body);
        if (body != null || body.trim() != "") {
            for (Map.Entry entry : bodyjson.entrySet()) {
                multipartBody.addFormDataPart(entry.getKey().toString(), entry.getValue().toString());
            }
        }
        Headers headers1 = SetHeaders(headers);
        Response response = null;
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .post(multipartBody.build())
                .headers(headers1)
                .build();
        try {
            response = okHttpClient.newCall(request).execute();
            result = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }



    /*** 
     * @author 假斯文
     * @date 2021/3/19 16:13
     * @param
     * @return  post请求，headers和body是Map类型  url是String类型 body是表单类型进行传参
     ***/

    public static String doPost_from_urlencode(String url, Map<String, Object> body, Map<String, Object> headers) {
        FormBody body1 = SetBody(body);
        Headers headers1 = SetHeaders(headers);
        //声明一个response
        Response response = null;
        //声明一个result 结果
        String result = "";
        //声明一个OKhttpclient  请求类
        OkHttpClient okHttpClient = new OkHttpClient();
        //声明一个Requst
        Request.Builder builder = new Request.Builder();
        builder.url(url);
        builder.post(body1);
        builder.headers(headers1);
        Request request = builder
                .build();
        try {
            response = okHttpClient.newCall(request).execute();
            result = response.body().string();
        }catch (IOException e){
            e.printStackTrace();
        }
        return result;
    }




    /***
    * @author 假斯文
    * @date 2021/3/19 17:17
    * @param
    * @return
    ***/
    public static String doPost_Type(RequestBody body, String url, String contentType) {
        Response response = null;
        String result = "";
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .post(body)
                .url(url)
                .header("Content-Type", contentType)
                .build();
        try {
            response = okHttpClient.newCall(request).execute();
            result = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return "出现异常" + e.getMessage();

        }
        return result;
    }


     /**
      *
      * @param
      * @author 假斯文
      * @date 2021/4/15 11:13
      * @return  支持POST类型为application/json的方式
      */

     public static String doPost_Json(String body, String url, Map<String,Object> headers){
         RequestBody bodyparam = RequestBody.create(HJSON,body);
         Headers headers1 = SetHeaders(headers);
         Response response=null;
         String result="";
         OkHttpClient okHttpClient = new OkHttpClient();
         Request request = new Request.Builder()
                 .post(bodyparam)
                 .url(url)
                 .headers(headers1)
                 .build();
         try{
             response = okHttpClient.newCall(request).execute();
             result = response.body().string();
         }catch (IOException e){
             e.printStackTrace();
         }
         return result;
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
            }
        }
        return headers1 = headerBulid.build();
    }

    private static FormBody SetBody(Map<String,Object>body){
        FormBody body1 = null;
        FormBody.Builder bodyBulid = new  FormBody.Builder();
        if (body != null){
            Iterator<String> iterator =body.keySet().iterator();
            String Key = "";
            while (iterator.hasNext()){
                Key = iterator.next().toString();
            }
        }
        return body1 = bodyBulid.build();
    }
}
