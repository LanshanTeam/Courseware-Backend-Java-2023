public class ArithmeticOperator {
    public static void main(String[] args) {
        // // 演示算术运算符
        int a = 100;
        int b = 200;
        int c = 300;
        double d = 400;
        System.out.println("a+b=" + (a+b));
        System.out.println("a-b=" + (a-b));
        System.out.println("a * b=" + a*b);
        System.out.println("a / b=" + a/b);
        System.out.println(10/3);
        // // 取模, A%B
        System.out.println(20 % 6);
        // 自增(++),自减(--)
        int a1 = 1;
        a1++;
        // 前缀自增
        int a2 = 20;
        System.out.println(a2++);
        // 后缀自减
        int b2 = 100;
        System.out.println(b2--);
        System.out.println(b2);
    }
}
