package com.example.api_test.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Controller
public class UserController {

    /**
     * 캐싱?
     */
    @GetMapping
    @Cacheable(value = "homeCache", key = "'home'")
    @Async
    public CompletableFuture<String> index(Model model) {
        return CompletableFuture.completedFuture("index");
    }

//    @GetMapping("/")
//    public String index(Model model) {
//        return "index";
//    }

    @GetMapping("/form")
    public String form(Model model) {
        return "form";
    }

    @GetMapping("/person-view")
    public String personView(Model model) {
        return "person-view";
    }

    @GetMapping("/insert-form")
    public String insertForm(Model model) {
        return "insert-form";
    }

    @GetMapping("/update-form")
    public String updateForm(Model model) {
        return "update-form";
    }

    @GetMapping("/delete-form")
    public String deleteForm(Model model) {
        return "delete-form";
    }

    /**
     * Order 관련 URL
     */
    @GetMapping("/order")
    public String order(Model model) {
        return "order";
    }

    @GetMapping("/large-json")
    @ResponseBody
    public List<Map<String, Object>> getLargeJson() {
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", i);
            map.put("name", "User_" + i);
            map.put("description", "이건 매우 긴 설명입니다. 데이터를 반복해서 길게 만들어서 gzip 압축 테스트를 해보겠습니다. ".repeat(5));
            list.add(map);
        }
        return list;
    }

    @GetMapping("/stream")
    @ResponseBody
    public ResponseEntity<StreamingResponseBody> streamData() {

        StreamingResponseBody stream = outputStream -> {
            // 스트리밍 데이터 처리
            for (int i = 0; i < 1000; i++) {
                outputStream.write(("Data " + i + "\n").getBytes());
                outputStream.flush();  //바로 전송
                //Thread.sleep(100);
            }
        };

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);

        return ResponseEntity.ok()
                .headers(headers)
                .body(stream);
    }


    @GetMapping("/test")
    public String test(Model model) {
        return "test";
    }

    @GetMapping("/test-large")
    @ResponseBody
    public List<Map<String, Object>> getLargeJson2() {
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", i);
            map.put("name", "User_" + i);
            map.put("description", "이건 매우 긴 설명입니다. 데이터를 반복해서 길게 만들어서 gzip 압축 테스트를 해보겠습니다. ".repeat(5));
            list.add(map);
        }
        return list;
    }

}
