package org.lesson2;

public abstract class Dog {
    //名字
    private String name;
    //年龄
    private int age;
    //颜色
    private String color;

    //吃
    void eat() {
        System.out.println("吃");
    }

    //跑
    void run() {
        System.out.println("跑");
    }

    //睡
    void sleep(){
        System.out.println("睡");
    }
    //无参构造方法
    public Dog() {}

    //全参构造方法
    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    //所有属性的getter和setter方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }



}
