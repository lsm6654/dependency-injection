package com.jess.app;


import com.jess.app.di.MyApplicationContext;
import com.jess.app.service.OtherService;
import com.jess.app.service.TestClass;

/**
 * Created by jess.lee on 2017. 9. 15..
 */
public class Application {

    public static void main(String[] args) {

        MyApplicationContext myContext = new MyApplicationContext();

        try {
            myContext.initialize("com.jess.app.service");

            OtherService otherService = (OtherService) myContext.getBean("otherService").orElseThrow(NullPointerException::new);
            TestClass testClass = (TestClass) myContext.getBean("testClass").orElseThrow(NullPointerException::new);


            System.out.println(otherService.getOtherService());
            System.out.println(testClass.testMethod());
            System.out.println(testClass.test2Method());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
