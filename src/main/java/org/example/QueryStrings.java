package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueryStrings {

    private List<QueryString> queryStrings = new ArrayList<>();

    public QueryStrings(String queryStringLine) {
        String[] queryStringTokens = queryStringLine.split("&");
        Arrays.stream(queryStringTokens)
            .forEach(queryString -> {
                String[] keyAndValue = queryString.split("=");
                if (keyAndValue.length != 2) {
                    throw new IllegalArgumentException("잘못된 QueryString 입니다.");
                }
                queryStrings.add(new QueryString(keyAndValue[0], keyAndValue[1]));
            });
    }

    public String getValue(String key) {
        return this.queryStrings.stream()
            .filter(queryString -> queryString.isExist(key))
            .map(QueryString::getValue)
            .findAny()
            .orElse(null);
    }
}
