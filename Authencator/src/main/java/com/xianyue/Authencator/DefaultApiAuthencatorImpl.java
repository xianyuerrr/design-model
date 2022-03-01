package com.xianyue.Authencator;

public class DefaultApiAuthencatorImpl implements ApiAuthencator{
    private CredentialStorage credentialStorage;

    public DefaultApiAuthencatorImpl() {}

    public DefaultApiAuthencatorImpl(CredentialStorage credentialStorage) {
        this.credentialStorage = credentialStorage;
    }

    @Override
    public void auth(String url) {
        ApiRequest apiRequest = ApiRequest.creatFromFullUrl(url);
        auth(apiRequest);
    }

    @Override
    public void auth(ApiRequest apiRequest) {
        String token = apiRequest.getToken();
        long timestamp = apiRequest.getTimestamp();

        AuthToken clientAuthToken = new AuthToken(token, timestamp);
        if (clientAuthToken.isExpired()) {
            throw new RuntimeException("Token is expired.");
        }

        String baseUrl = apiRequest.getBaseUrl();
        String appId = apiRequest.getAppId();

        String password = credentialStorage.getPasswordByAppId(appId);
        AuthToken serverAuthToken = AuthToken.creat(baseUrl, appId, password, timestamp);
        if (!serverAuthToken.match(clientAuthToken)) {
            throw new RuntimeException("Token verification failed.");
        }

    }
}
