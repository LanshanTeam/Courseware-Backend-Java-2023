public class IfDemo {
    public static void main(String[] args) {
        // // if
        // if(false){
        //     System.out.println("执行1逻辑");
        // }
        // // if-else
        // if(10>20){
        //     System.out.println("1逻辑");
        // }else {
        //     System.out.println("2逻辑");
        // }
        // if-else else-if
        if (false){
            System.out.println(1);
        } else if (false) {
            System.out.println(2);
        }else if (true) {
            System.out.println(3);
        }
        // switch
        char a = 'O';
        switch (a){
            case 'B':
                System.out.println("a=B");
                break;
            case 'A':
                System.out.println("a=A");
                break;
            case 'C':
                System.out.println("a=C");
                break;
            default:
                System.out.println("输出default");
        }

    }
}
