package com.jess.app.service;

import com.jess.app.di.annotation.MyAutowired;
import com.jess.app.di.stereotype.MyComponent;

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
