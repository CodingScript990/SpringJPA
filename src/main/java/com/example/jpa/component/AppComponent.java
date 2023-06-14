package com.example.jpa.component;

import com.example.jpa.configuration.AppConfigData;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

@Component
public class AppComponent {
    /**
     * Controller, Service, Repository 가 아닌 평범한 Bean Object 를 말함
     * 외부 API 사용, 공유된 기능 개발, 그냥 IoC 등록하고 싶은 Object 를 말함
     */

    // 필요로 하는 설정
    private final AppConfigData configData;
    private final Gson gson;

    // AppComponent Constructor => AppConfigData 를 사용해주기 위한 작업
    public AppComponent(AppConfigData configData, Gson gson) {
        this.configData = configData;
        this.gson = gson;
    }

    // 외부 API 를 사용하는 메서드
    public void useApi() {
        // send request
    }
}
