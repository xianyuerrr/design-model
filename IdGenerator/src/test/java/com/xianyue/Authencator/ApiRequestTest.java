package com.xianyue.Authencator;

import org.junit.jupiter.api.Test;

class ApiRequestTest {

    @Test
    void creatFromFullUrl() {
        String s = "baidu.com?token=1&appId=2&timestamp=3";
        ApiRequest apiRequest = ApiRequest.creatFromFullUrl(s);
        System.out.println(apiRequest);
    }

}