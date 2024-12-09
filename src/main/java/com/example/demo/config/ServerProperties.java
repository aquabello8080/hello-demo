/*
 * Copyright 2023 NHN (https://nhn.com) and others.
 * © NHN Corp. All rights reserved.
 */
package com.example.demo.config;

import org.springframework.stereotype.Component;

/**
 * <p>자세한 기능을 적어주세요</p>
 *
 * @author ys.ko
 * @since 1.0
 */
@MyConfigurationProperties(prefix = "nhn")
public class ServerProperties {
    private String contextPath;
    private int port;

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
