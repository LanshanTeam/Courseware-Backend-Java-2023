package org.lesson2;


class Application{

    /**
     * main 方法
     */
    public static void main(String[] args) {

        //Dog为抽象类，无法实例化,放开下方注释，编译器会报错
//        //调用无参构造方法
//        Dog myFirstDog = new Dog();
//
//        //调用全参构造方法
//        Dog mySecondDog = new Dog("旺财", 3, "黑白相间");

        //Husky为Dog的子类，可以实例化
        Husky husky = new Husky();


        husky.eat();

        int a = 1;
        int b = 2;
        double c = 1.1;
        double d = 2.2;
        int e = 3;
        Calculator calculator = new Calculator();
        System.out.println(calculator.add(a, b));
        System.out.println(calculator.add(c, d));
        System.out.println(calculator.add(a, b, e));

    }

    /**
     * return 关键字的使用
     */
    public void printNumbers() {
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                return; // 当 i 等于 5 时，直接返回，跳出方法体
            }
            System.out.println(i);
        }
    }

}