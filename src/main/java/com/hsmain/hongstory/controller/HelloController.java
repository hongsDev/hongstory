package com.hsmain.hongstory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "Hello!");
        System.out.println("TEST");
        return "Hello";
    }


    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value="name", required=false) String name, Model model){
        model.addAttribute("name", name);
        System.out.println("LHEJSLDJFLKJSLK");

        return "hello-static";
    }

    @GetMapping("hello-string")
    @ResponseBody//html을 http에서 헤더와 바디 중 리스폰스 응답 바디에 이 데이터를 직접 넣어주겠다.
    public String helloString(@RequestParam("name") String name){

        return "hello " + name;
    }



    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){

        Hello hello = new Hello();
        hello.setName(name);

        return hello;
    }


    static class Hello{
        private String name;
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}
