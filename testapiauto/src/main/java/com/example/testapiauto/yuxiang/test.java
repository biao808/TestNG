package com.example.testapiauto.yuxiang;

import com.example.testapiauto.modules.testCase.utils.Cookie;

/**
 * TODO
 *
 * @author yuxiang
 * @version 1.0
 * @date 2021/4/20 13:42
 */
public class test {

    public static void main(String[] args) {
        String TOKEN = Cookie.TestEnvAuthentication();
        System.out.println(TOKEN);
    }
}
