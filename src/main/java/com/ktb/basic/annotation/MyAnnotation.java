package com.ktb.basic.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by dell on 2018-10-19.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    public String value() default "xiaohu";
}
