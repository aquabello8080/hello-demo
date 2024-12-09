/*
 * Copyright 2023 NHN (https://nhn.com) and others.
 * © NHN Corp. All rights reserved.
 */
package com.example.demo.exception;

import com.example.demo.DemoApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

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
 * @since 1.0
 *
 * HTTP Status code
 * 2XX -> OK
 * 4XX -> Client
 * 5XX -> Server
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
