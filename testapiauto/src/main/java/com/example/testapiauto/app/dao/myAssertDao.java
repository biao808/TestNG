package com.example.testapiauto.app.dao;

import com.alibaba.fastjson.JSONObject;

/**
 * TODO
 *
 * @author yuxiang
 * @version 1.0
 * @date 2021/4/20 8:54
 */
public interface myAssertDao {
    public boolean AssertAll(String expect, String act);
    public boolean AssertByJsonPath(Object[] expects, JSONObject json, String[] jsonPaths);
    public boolean AssertBySql(String expect, String sql);
}
