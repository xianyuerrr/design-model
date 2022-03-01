package com.xianyue.Authencator;

public interface ApiAuthencator {
    void auth(String url);
    void auth(ApiRequest apiRequest);
}
