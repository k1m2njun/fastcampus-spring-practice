package com.fastcampus.springpractice.controller;

import com.fastcampus.springpractice.service.SortService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // ResponseBody 포함되어 있음
public class MainController {

    private final SortService sortService;

    public MainController(SortService sortService) {
        this.sortService = sortService;
    } // 생성자 주입.
    // 의존성이 컨트롤러에 생성자 단에서 노출된다. 주입 받는다.

    @GetMapping("/")
    public String hello(@RequestParam List<String> list) {
        return sortService.doSort(list).toString();
    }
}
