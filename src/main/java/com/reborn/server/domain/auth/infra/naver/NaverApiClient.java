package com.reborn.server.domain.auth.infra.naver;

import com.reborn.server.domain.auth.domain.oauth.OauthApiClient;
import com.reborn.server.domain.auth.domain.oauth.OauthInfoResponse;
import com.reborn.server.domain.auth.domain.oauth.OauthProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class NaverApiClient implements OauthApiClient {

    @Value("${oauth.naver.url.api}")
    private String apiUrl;

    private final RestTemplate restTemplate;

    @Override
    public OauthProvider oauthProvider() {
        return OauthProvider.NAVER;
    }

    @Override
    public OauthInfoResponse requestOauthInfo(String accessToken){
//        String url = apiUrl + "/user/me";
        String url = apiUrl + "/v1/nid/me";
        System.out.println(accessToken);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setBearerAuth(accessToken);
        HttpEntity<?> request = new HttpEntity<>(httpHeaders);
        return restTemplate.postForObject(url, request, NaverInfoResponse.class);
    }
}
