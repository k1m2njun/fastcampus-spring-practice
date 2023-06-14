package com.fastcampus.springpractice;

import com.fastcampus.springpractice.config.Config;
import com.fastcampus.springpractice.logic.BubbleSort;
import com.fastcampus.springpractice.logic.Sort;
import com.fastcampus.springpractice.service.SortService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class); // 해당 Config 등록.
        SortService sortService = context.getBean(SortService.class); // 스프링 컨텍스트에서 빈을 꺼내옴

        System.out.println("[result] " + sortService.doSort(Arrays.asList(args)));
        // 스프링 컨테이너를 띄우고 나서는 new 없이 구현체를 가져와서 서비스를 메인 프로그램에서 제공한다.
    }
}