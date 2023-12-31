package com.example.jpa.configuration;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    /**
     * Spring 을 활용하는데 필요한 다양한 "설정"을 담고 있는 용도임
     */

    // Component 에게 connectionUrl 을 사용할 수 있도록 작업해주는 메서드
    @Bean
    public AppConfigData connectionUrl() {
        // 이 메서드의 결과(반환값)을 Bean Object 로 등록
        if (true /* 현재 나의 상황에 따라 다른 URL 을 지급하는 코드임 */)
            return new AppConfigData("main-url");
        else return new AppConfigData("backup-rul");
    }

    // Gson 을 사용하기 위한 메서드
    @Bean
    public Gson gson() {
        return new Gson();
    }
}
