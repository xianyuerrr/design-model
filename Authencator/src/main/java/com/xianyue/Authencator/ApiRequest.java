package com.xianyue.Authencator;

import java.util.HashMap;
import java.util.Map;

public class ApiRequest {
    private final String baseUrl;
    private final String token;
    private final String appId;
    private final long timestamp;

    public static ApiRequest creatFromFullUrl(String url) {
        if (url == null || "".equals(url)) {
            return null;
        }
        int idx = url.indexOf("?");
        String baseUrl = url.substring(0, idx);
        String paramsStr = url.substring(idx+1);
        Map<String, String> params = new HashMap<>();
        for (String param : paramsStr.split("&")) {
            int splitIdx = param.indexOf("=");
            String key = param.substring(0, splitIdx);
            String val = param.substring(splitIdx+1);
            params.put(key, val);
        }
        String token = params.getOrDefault("token", "");
        String appId = params.getOrDefault("appId", "");
        long timestamp = Long.parseLong(params.getOrDefault("timestamp", ""));
        return new ApiRequest(baseUrl, token, appId, timestamp);
    }

    public ApiRequest(String baseUrl, String token, String appId, long timestamp) {
        this.baseUrl = baseUrl;
        this.token = token;
        this.appId = appId;
        this.timestamp = timestamp;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getToken() {
        return token;
    }

    public String getAppId() {
        return appId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "ApiRequest{" +
                "baseUrl='" + baseUrl + '\'' +
                ", token='" + token + '\'' +
                ", appId='" + appId + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
