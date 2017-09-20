package com.jess.di.support;

import com.jess.di.annotation.MyAutowired;
import com.jess.di.stereotype.MyComponent;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by jess.lee on 2017. 9. 15..
 */

public class MyBeanFactory {

    private Map<String, MyBeanDefinition> beanDefinitions = new ConcurrentHashMap<>(64);
    private Map<Type, Object> mergedBeanDefinitionss = new ConcurrentHashMap<>(64);
    private List<Object> singletonObjects = new ArrayList<>();
    private List<String> beanNames = new ArrayList<>();

    public void setResources(List<String> resources) {

        for(String resource : resources) {
            setResources(resource);
        }
    }

    private void setResources(String resource) {

        MyBeanDefinition beanDefinition = new MyBeanDefinition();

        Class clazz = null;
        try {
            clazz = Class.forName(resource);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if(isNotCandidate(clazz)) {
            return;
        }

        int autowiredCnt = 0;
        List<Field> autowiredFields = new ArrayList<>();
        for(Field field : clazz.getDeclaredFields()) {
            if (field.getAnnotation(MyAutowired.class) != null) {
                autowiredCnt++;
                autowiredFields.add(field);
            }
        }

        String beanName = getBeanNameStrategy(clazz);

        beanNames.add(beanName);
        beanDefinition.setAutowiredMode(autowiredCnt);
        beanDefinition.setClazz(clazz);
        beanDefinition.setAutowireFields(autowiredFields);
        beanDefinitions.put(beanName, beanDefinition);
    }

    private boolean isNotCandidate(Class clazz) {
        if(clazz.isInterface()) {
            return true;
        }

        if(!clazz.isAnnotationPresent(MyComponent.class)){
            return true;
        }

        return false;
    }

    // -> utils?
    private String getBeanNameStrategy(Class clazz) {

        String clazzName =clazz.getSimpleName();
        String s1 = clazzName.substring(0, 1).toLowerCase();

        return s1 + clazzName.substring(1);
    }

    public void initializeBean(MyBeanDefinition beanDefinition) {

        //고려 안함 beanDefinition.getInitMethod(); beanDefinition.getDestroyMethod();

        Object instance = null;
        try {
            instance = beanDefinition.getClazz().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        //다수 타입에 대해서는 qualify 없음... 그냥 override
        mergedBeanDefinitionss.put(beanDefinition.getClazz(), instance);
        beanDefinition.setBean(instance);
    }

    public Optional<Object> getBean(String beanName) {
        return singletonObjects.stream().filter( item -> getBeanNameStrategy(item.getClass()).equals(beanName)).findFirst();
    }

    public Map<String, MyBeanDefinition> getBeanDefinitions() {
        return beanDefinitions;
    }

    public void setBeanDefinitions(Map<String, MyBeanDefinition> beanDefinitions) {
        this.beanDefinitions = beanDefinitions;
    }

    public Map<Type, Object> getMergedBeanDefinitionss() {
        return mergedBeanDefinitionss;
    }

    public void setMergedBeanDefinitionss(Map<Type, Object> mergedBeanDefinitionss) {
        this.mergedBeanDefinitionss = mergedBeanDefinitionss;
    }

    public List<Object> getSingletonObjects() {
        return singletonObjects;
    }

    public void setSingletonObjects(List<Object> singletonObjects) {
        this.singletonObjects = singletonObjects;
    }

    public List<String> getBeanNames() {
        return beanNames;
    }

    public void setBeanNames(List<String> beanNames) {
        this.beanNames = beanNames;
    }

}
