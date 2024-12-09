/*
 * Copyright 2023 NHN (https://nhn.com) and others.
 * © NHN Corp. All rights reserved.
 */
package com.example.demo.User;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

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
 * @see com.example.demo.DemoApplication
 * @since 1.0
 */
@Data
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private Date joinDate;
}
