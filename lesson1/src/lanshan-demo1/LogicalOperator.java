public class LogicalOperator {
    public static void main(String[] args) {
        boolean b1 = true;
        boolean b2 = false;
        boolean b3 = true;
        boolean b4 = false;
        // 逻辑与 &&
        boolean b5 = b1 && b2;
        boolean b6 = b1 && b3;
        System.out.println("b6=" + b6);
        System.out.println("b5=" + b5);
        // 逻辑或 ||
        boolean b7 = b1 || b2;
        System.out.println("b7=" + b7);
        // 逻辑非 !
        b4 = !b4;
        System.out.println("b4=" + b4);
    }
}
