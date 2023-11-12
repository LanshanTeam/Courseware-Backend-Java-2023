package org.example;

import java.util.ArrayList;
import java.util.List;

public class CommonException {
    public static void main(String[] args) {
        //NullPointerException
        Integer a = null;
        System.out.println(a.toString());

        //ArithmeticException
        Double b = 20.23/0;

        //IndexOutOfBoundsException
        List<Integer> list = new ArrayList<>();
        System.out.println(list.get(0));
    }
}
