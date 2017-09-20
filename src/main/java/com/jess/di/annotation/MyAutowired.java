package com.jess.di.annotation;

import java.lang.annotation.*;

/**
 * Created by jess.lee on 2017. 9. 18..
 */

@Target({ElementType.FIELD/*, ElementType.CONSTRUCTOR,  ElementType.METHOD, ElementType.ANNOTATION_TYPE*/})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAutowired {
}
