package com.jess.di.project.service;

import com.jess.di.annotation.MyAutowired;
import com.jess.di.stereotype.MyComponent;

/**
 * Created by jess.lee on 2017. 9. 18..
 */
@MyComponent
public class OtherService {

    @MyAutowired
    private MemberService memberService;

    public String getOtherService() {

        String member = memberService.getMember();

        return member + " nice to meet you";
    }

    public String sayHello() {
        return "hello~!";
    }
}
