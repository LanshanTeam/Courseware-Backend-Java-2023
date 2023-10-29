public class Xunhuan {
    public static void main(String[] args) {
        // for (int i = 10; i > 5; i--) {
        //     System.out.println(i);
        //     // 输出10,9,8,7,6
        // }
        // for (int i = 0; i < 10; i++) {
        //     System.out.println("i=" + i);
        // }
        // // while循环
        // int i = 1;
        // while (i != 5) {
        //     i++;
        //     System.out.println(i);
        // }
        // int i1 = 1;
        // while (i1 <= 100){
        //     i1++;
        //     System.out.println("i1=" + i1);
        //     if(i1 == 10) {
        //         break;
        //     }
        // }
        // for (int i = 0; i < 100; i++) {
        //     if(i==5) {
        //         break;
        //     }
        //     System.out.println("i=" + i);
        // }
        // // do-while
        // do{
        //     System.out.println("hello,hello");
        // }while (false);
        // continue跳出本次循环,执行下一次循环
        // break就是全部跳出
        for (int i = 0; i < 10; i++) {
            if(i == 4) {
                continue;
            }
            System.out.println("i=" + i);
        }
        // 增强for循环
        String[] sectionList = {"前端","后端Java","后端Go","产品及运营","  UI  ","运维"};
        for (String section : sectionList) {
            System.out.println(section);
        }
    }
}
