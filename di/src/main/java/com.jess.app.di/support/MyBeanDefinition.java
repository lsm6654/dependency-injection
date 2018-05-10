package com.jess.app.di.support;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by jess.lee on 2017. 9. 15..
 */
public class MyBeanDefinition implements BeanDefinition {
    private Class clazz;
    private Object bean;
    private List<Field> autowireFields;
    private int autowiredMode = 0;
    private String initMethod;
    private String destroyMethod;
    private String beanName;

    public int getAutowiredMode() {
        return autowiredMode;
    }

    public void setAutowiredMode(int autowiredMode) {
        this.autowiredMode = autowiredMode;
    }

    public String getInitMethod() {
        return initMethod;
    }

    public void setInitMethod(String initMethod) {
        this.initMethod = initMethod;
    }

    public String getDestroyMethod() {
        return destroyMethod;
    }

    public void setDestroyMethod(String destroyMethod) {
        this.destroyMethod = destroyMethod;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public List<Field> getAutowireFields() {
        return autowireFields;
    }

    public void setAutowireFields(List<Field> autowireFields) {
        this.autowireFields = autowireFields;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }
}
