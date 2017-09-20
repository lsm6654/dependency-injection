package com.jess.di.support;

import com.google.common.reflect.ClassPath;

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

        List<String> resources = ClassPath.from(this).getResources().stream().filter(clazz -> clazz.toString().startsWith(classPath)).map(resource -> resource.toString()).collect(toList());

        return resources;
    }

}
