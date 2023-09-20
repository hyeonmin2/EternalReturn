package com.project.eternal.user;

import com.project.eternal.user.data.NickNameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@PropertySource("classpath:api.properties")
public class UserService {
    private final String apiKey;
    private final String apiUrl;

    @Autowired
    public UserService(@Value("${API_KEY}") String apiKey, @Value("${API_URL}") String apiUrl) {
        this.apiKey = apiKey;
        this.apiUrl = apiUrl;
    }

    public Long getUserId(String nickName) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-key", apiKey);

        Map<String, Object> params = new HashMap<>();
        params.put("query", nickName);

        ResponseEntity<NickNameResponse> responseEntity = new RestTemplate().exchange(
                apiUrl + "/v1/user/nickname?query={query}",
                HttpMethod.GET,
                new HttpEntity<>(headers),
                NickNameResponse.class,
                params
        );

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
             NickNameResponse response = responseEntity.getBody();
             if(response != null)
                 return response.getUser().getUserNum();
        }
        throw new RuntimeException("API 호출이 실패했습니다.");
    }
}
