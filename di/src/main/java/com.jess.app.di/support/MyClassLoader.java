package com.jess.app.di.support;

import com.jess.app.di.stereotype.MyComponent;
import org.reflections.Reflections;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by jess.lee on 2017. 9. 15..
 */
public class MyClassLoader extends ClassLoader {

    @Override
    public Class<?> findClass(String name) {
        byte[] bt = loadClassData(name);
        return defineClass(name, bt, 0, bt.length);
    }

    private byte[] loadClassData(String className) {

        //read class
        InputStream is = getClass().getClassLoader().getResourceAsStream(className.replace(".", "/") + ".class");
        ByteArrayOutputStream byteSt = new ByteArrayOutputStream();

        //write into byte
        int len = 0;
        try {
            while ((len = is.read()) != -1) {
                byteSt.write(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //convert into byte array
        return byteSt.toByteArray();
    }

    public List<String> findAllResources(String classPath) throws IOException {

        //TODO : 나중에 classLoader 공부할겸 리소스 불러오는 것도 구현해보자
        List<String> resources = new Reflections(classPath).getTypesAnnotatedWith(MyComponent.class).stream().map(clazz -> clazz.getTypeName()).collect(toList());


        return resources;
    }

}
