package org.example;

import org.example.entity.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectionTest {

    public static void main(String[] args) throws Exception{
        Student student = new Student();
        student.doHomework("Java");

        Class cla = Class.forName("org.example.entity.Student");
        Method method = cla.getMethod("doHomework",String.class);
        Constructor constructor = cla.getConstructor();
        Object object = constructor.newInstance();
        method.invoke(object,"睡觉");
    }
}
