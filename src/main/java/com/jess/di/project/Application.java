package com.jess.di.project;


import com.jess.di.MyApplicationContext;
import com.jess.di.project.service.OtherService;
import com.jess.di.project.service.TestClass;

/**
 * Created by jess.lee on 2017. 9. 15..
 */
public class Application {

    public static void main(String[] args) {
        MyApplicationContext myContext = new MyApplicationContext();

        try {
            myContext.initialize("com.jess.di.project");

            OtherService otherService = (OtherService) myContext.getBean("otherService").orElseThrow(NullPointerException::new);
            System.out.println(otherService.getOtherService());

            TestClass testClass = (TestClass) myContext.getBean("testClass").orElseThrow(NullPointerException::new);
            System.out.println(testClass.testMethod());
            System.out.println(testClass.test2Method());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
