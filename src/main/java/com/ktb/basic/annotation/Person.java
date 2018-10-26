package com.ktb.basic.annotation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by dell on 2018-10-19.
 */
@Deprecated
@MyAnnotation
public class Person {

    public String getInfo() {
        return "这是一个Person类";
    }

    public static void main(String[] args) {

        Person person = new Person();
        Class clz = person.getClass();
        MyAnnotation annotation = (MyAnnotation) clz.getAnnotation(MyAnnotation.class);
        //System.out.println(annotation.value());
        try {
            Method method = clz.getMethod("toString");
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation1 : annotations) {
                System.out.println(annotation1);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class Student extends Person {

  /*  //@Override
    public String getInfo() {
        return "这是一个Student类";
    }*/

    @Deprecated
    @Override
    public String getInfo() {
        return super.getInfo();
    }

 /*   public static void main(String[] args) {
        Person person = new Student();
        System.out.println(person.getInfo());
    }*/
}
