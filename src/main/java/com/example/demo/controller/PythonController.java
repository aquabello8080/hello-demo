/*
 * Copyright 2023 NHN (https://nhn.com) and others.
 * © NHN Corp. All rights reserved.
 */
package com.example.demo.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>자세한 기능을 적어주세요</p>
 *
 * @author ys.ko
 * @since 1.0
 */

@RestController
public class PythonController {

    private final static  String PATH = "/tmp/";

    @GetMapping("hello-demo")
    @ResponseBody
    public String helloDemo() {
        return "Hello, Demo!";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("/naver")
    @ResponseBody
    public String naver() throws IOException, InterruptedException, IOException {
        System.out.println("naver Exec~~ ");

        ProcessBuilder builder;
        BufferedReader br;

        String arg1 = "/Users/nhn/Documents/50_study/python/naver.py";
        builder = new ProcessBuilder("python3",arg1); //python3 error

        builder.redirectErrorStream(true);
        Process process = builder.start();

        // 자식 프로세스가 종료될 때까지 기다림
        int exitval = process.waitFor();

        // 서브 프로세스가 출력하는 내용을 받기 위해
        br = new BufferedReader(new InputStreamReader(process.getInputStream(),"UTF-8"));

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(">>>  " + line);
        }

        //비정상종료
        if(exitval !=0){
            System.out.println("비정상종료");
        }

        return "naver";
    }

    @GetMapping("/zapier")
    @ResponseBody
    public String zapier() {
        System.out.println("zapier Exec~~ ");

        String fileNm = "zapier.sh";
        ProcessBuilder pb = new ProcessBuilder(PATH + fileNm);

        try {
            // Run script
            Process process = pb.start();

            // Read output
            StringBuilder output = new StringBuilder();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line);
            }

            System.out.println(output.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "zapier";
    }
}
