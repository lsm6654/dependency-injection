package com.jess.di.stereotype;

import java.lang.annotation.*;

/**
 * Created by jess.lee on 2017. 9. 18..
 */

@Target({ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAutowired {
}
