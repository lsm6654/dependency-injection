package com.jess.app.di;

import com.jess.app.di.support.MyBeanFactory;
import com.jess.app.di.support.MyClassLoader;
import com.jess.app.di.support.PostProcessorRegistration;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * Created by jess.lee on 2017. 9. 15..
 */
public class MyApplicationContext {

    private MyBeanFactory beanFactory = new MyBeanFactory();

    public void initialize(String basePackage) throws IOException {

        parse();

        invokeBeanFactoryPostProcessors(basePackage);

        finishBeanFactoryInitialization(beanFactory);

    }

    private void finishBeanFactoryInitialization(MyBeanFactory beanFactory) {

        PostProcessorRegistration.registerBeans(beanFactory);
    }

    private void invokeBeanFactoryPostProcessors(String basePackage) throws IOException {

        MyClassLoader classLoader = new MyClassLoader();

        List<String> resources = classLoader.findAllResources(basePackage);
        beanFactory.setResources(resources);
    }


    public void parse() {
        //TODO : 옵션 기능이 추가된다면, 파싱하여 빈 생성시 고려해야 함
    }


    public Optional<Object> getBean(String beanName) {
        return beanFactory.getBean(beanName);
    }
}
