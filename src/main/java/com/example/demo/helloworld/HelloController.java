/*
 * Copyright 2023 NHN (https://nhn.com) and others.
 * © NHN Corp. All rights reserved.
 */
package com.example.demo.helloworld;

import com.example.demo.DemoApplication;
import com.example.demo.config.ServerProperties;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>자세한 기능을 적어주세요
 *
 * <p><b>Example:</b> 사용법을 간단히 적어주세요</p>
 *
 * <pre class="code">
 *  Demo demo = new Demo();
 *  demo.print("Hello Nhn");
 * </pre>
 *
 * @author ys.ko
 * @see DemoApplication
 * @since 1.0
 */
@RestController
@RequestMapping("/")
@Slf4j
public class HelloController {

    @Autowired
    private ServerProperties serverProperties;

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!!!!!!@@";
    }

    @GetMapping("/ip")
    public String ip(HttpServletRequest request) {
        String clientIp = null;
        boolean isIpInHeader = false;
        List<String> headerList = new ArrayList<>();
        headerList.add("X-Forwarded-For");
        headerList.add("HTTP_CLIENT_IP");
        headerList.add("HTTP_X_FORWARDED_FOR");
        headerList.add("HTTP_X_FORWARDED");
        headerList.add("HTTP_FORWARDED_FOR");
        headerList.add("HTTP_FORWARDED");
        headerList.add("Proxy-Client-IP");
        headerList.add("WL-Proxy-Client-IP");
        headerList.add("HTTP_VIA");
        headerList.add("IPV4_ADR");
        headerList.add("IPV6_ADR");

        for (String header : headerList) {
            clientIp = request.getHeader(header);
            if (StringUtils.hasText(clientIp) && !clientIp.equals("unknown")) {
                isIpInHeader = true;
                break;
            }
        }

        if (!isIpInHeader) {
            clientIp = request.getRemoteAddr();
        }

        return clientIp;
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean() {

        System.out.println("serverProperties = " + serverProperties.getContextPath());
        System.out.println("serverProperties = " + serverProperties.getPort());
        return new HelloWorldBean("Hello World");

    }

    @GetMapping("/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldBean (@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World Bean, %s ", name));
    }

    @Getter
    private static class HelloWorldBean {
        private final String message;

        public HelloWorldBean(String message) {
            this.message = message;
        }
    }
}
