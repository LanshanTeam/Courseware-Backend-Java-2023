package com.exmple.common.util;

import java.util.Random;

public class RandomNumberGenerator {
    public static int generateSixDigitNumber() {
        Random rand = new Random();
        // 生成100000到999999之间的随机数
        return rand.nextInt(900000) + 100000;
    }
    public static int generateRandomNumber() {
        Random rand = new Random();
        // 生成0到1000之间的随机数
        return rand.nextInt(1001);
    }
}
