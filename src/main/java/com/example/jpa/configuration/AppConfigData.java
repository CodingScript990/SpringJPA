package com.example.jpa.configuration;

import lombok.RequiredArgsConstructor;

// Data Object
public class AppConfigData {

    // connectionUrl 을 사용하기 위한 작업 => Member Field
    private String connectionUrl;

    // AppConfigData Constructor => connectionUrl
    public AppConfigData(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }

}
