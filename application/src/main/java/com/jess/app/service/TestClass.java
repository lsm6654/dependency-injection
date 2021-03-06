package com.jess.app.service;

import com.jess.app.di.annotation.MyAutowired;
import com.jess.app.di.stereotype.MyComponent;

/**
 * Created by jess.lee on 2017. 9. 20..
 */
@MyComponent
public class TestClass {

    @MyAutowired
    private MemberService service1;

    @MyAutowired
    private OtherService service2;

    public String testMethod() {

        return service1.getMember() + " " + service2.sayHello();
    }

    public String test2Method() {

        return service1.getMember() + service2.getOtherService();
    }

}
