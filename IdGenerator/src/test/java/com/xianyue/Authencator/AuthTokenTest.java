package com.xianyue.Authencator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthTokenTest {

    @Test
    void creat() {
        AuthToken authToken = AuthToken.creat("baidu.com", "wechat", "123456", System.currentTimeMillis());
        System.out.println(authToken);
    }

    @Test
    void getToken() {
        AuthToken authToken = AuthToken.creat("baidu.com", "wechat", "123456", System.currentTimeMillis());
        System.out.println(authToken.getToken());
    }

    @Test
    void isExpired() {
        AuthToken authToken = AuthToken.creat("baidu.com", "wechat", "123456", System.currentTimeMillis());
        System.out.println(authToken.isExpired());;
    }

    @Test
    void match() {
        long now = System.currentTimeMillis();
        AuthToken authToken1 = AuthToken.creat("baidu.com", "wechat", "123456", now);
        AuthToken authToken2 = AuthToken.creat("baidu.com", "wechat", "123456", now);
        System.out.println(authToken1.match(authToken2));
    }
}