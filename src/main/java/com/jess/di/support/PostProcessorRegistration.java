package com.jess.di.support;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by jess.lee on 2017. 9. 19..
 */
public class PostProcessorRegistration {

    public static void registerBeans(MyBeanFactory beanFactory) {

        Map<String, MyBeanDefinition> beanDefinitions = beanFactory.getBeanDefinitions();

        for (String key : beanDefinitions.keySet()) {

            MyBeanDefinition beanDefinition = beanDefinitions.get(key);
            beanFactory.initializeBean(beanDefinition);
        }


        autowiringBeans(beanFactory);
    }

    private static void autowiringBeans(MyBeanFactory beanFactory) {

        Map<String, MyBeanDefinition> beanDefinitions = beanFactory.getBeanDefinitions();

        List<Object> objects = new ArrayList<>();
        for (String key : beanDefinitions.keySet()) {

            MyBeanDefinition beanDefinition = beanDefinitions.get(key);
            for(Field field : beanDefinition.getAutowireFields()) {

                Class<?> type = field.getType();
                Object o = beanFactory.getMergedBeanDefinitionss().get(type);

                try {
                    field.setAccessible(true);
                    field.set(beanDefinition.getBean(), o);
                } catch (IllegalAccessException e) {
                    System.out.println("bean initialization failed");
                    e.printStackTrace();
                }
            }

            Object o = beanFactory.getMergedBeanDefinitionss().get(beanDefinition.getClazz());
            objects.add(o);
        }

        beanFactory.setSingletonObjects(objects);
    }


}
