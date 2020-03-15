package com.alphasense.petshop.tests.steps;

import com.alphasense.petshop.tests.testcontext.TestContext;

import java.util.List;
import java.util.Map;

public final class StepUtils {

    public StepUtils() {

    }

    /**
     * Saves values of templateDataList element from feature's steps into context
     *
     * @param testContext      context of the test
     * @param templateDataList DataList from feature's steps
     */
    public static void putParamsIntoContext(TestContext testContext, List<Map<String, String>> templateDataList) {
        Map<String, String> row = templateDataList.get(0);
        for (String key : row.keySet()) {
            testContext.addParam(key, row.get(key));
        }
    }

}
