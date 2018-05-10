package com.jess.app.di.stereotype;

import java.lang.annotation.*;

/**
 * Created by jess.lee on 2017. 9. 15..
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyComponent {
}
