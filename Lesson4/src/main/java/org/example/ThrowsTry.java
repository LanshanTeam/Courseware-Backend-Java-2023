package org.example;

import java.util.ArrayList;
import java.util.List;

public class ThrowsTry {
    public static void withDraw() throws ArithmeticException, IndexOutOfBoundsException{
        Double b = 20.23/0;

        List<Integer> list = new ArrayList<>();
        System.out.println(list.get(0));
    }

    public static void main(String[] args) {
        withDraw();
    }
}
