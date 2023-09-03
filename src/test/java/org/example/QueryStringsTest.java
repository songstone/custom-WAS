package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QueryStringsTest {
    @Test
    void createTest() {
        QueryStrings qUeryStrings = new QueryStrings("http://localhost:8080/calculate?operand1=11&operator=*&operand2=55");

        assertThat(qUeryStrings).isNotNull();
    }
}
