package com.example.testapiauto.modules.testCase.common.Assertion.AssertionInterface;

import java.util.Map;

public interface ResponseAssertion {
    String assertEqualsString(String response,String expectString);

    String assertEqualsJson(String response, Map<String,String> pathAsserts);

    String assertEqualsSql(String response,String[] sql);
}
