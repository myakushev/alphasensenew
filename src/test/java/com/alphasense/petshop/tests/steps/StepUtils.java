package com.alphasense.petshop.tests.steps;

import com.alphasense.petshop.tests.testcontext.TestContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    /**
     * Substitutes params patterns in map value with their value from params map.
     * Parameter - string which matches pattern: ${(.*)}.
     * E.g. ${id} will be replaced with params.get(id)
     *
     * @param map       map which contains values with params placeholders
     * @param paramsMap parameters map with params for substitution
     * @return test data as String
     */
    public static Map<String, String> substituteParamsInMap(Map<String, String> map, Map<String, String> paramsMap) {
        Map<String, String> returnMap = new HashMap<>();

        for (String s : map.keySet()) {
            returnMap.put(s, substituteParams(map.get(s), paramsMap));
        }
        return returnMap;
    }

    /**
     * Substitutes params patterns in string with their value from map.
     * Parameter - string which matches pattern: ${(.*)}.
     * E.g. ${id} will be replaced with params.get(id)
     *
     * @param input     string with params
     * @param paramsMap parameters map with params for substitution
     * @return test data as String
     * @throws IllegalStateException if parameter is not present in map
     */
    private static String substituteParams(String input, Map<String, String> paramsMap) {
        List<String> paramsNames = extractGroupMatches(input);
        for (String paramName : paramsNames) {
            if (!paramsMap.containsKey(paramName)) {
                throw new IllegalStateException(
                        String.format("Failed to substitute param in '%s'" +
                                        "Key '%s' not found in params map. Keys in map: %s", input
                                , paramName, paramsMap.keySet()));
            }
            input = input.replace(String.format("${%s}", paramName), paramsMap.get(paramName));
        }
        return input;
    }

    /**
     * Extracts all group matches from string.
     *
     * @param input string for extracting group matches
     * @return list of matches
     */
    public static List<String> extractGroupMatches(String input) {
        List<String> matches = new ArrayList<>();
        Pattern p = Pattern.compile("\\$\\{(?<param>[^\\}]*)\\}");
        Matcher m = p.matcher(input);
        while (m.find()) {
            matches.add(m.group("param"));
        }
        return matches;
    }

}
