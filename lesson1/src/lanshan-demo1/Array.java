public class Array {
    public static void main(String[] args) {
    //     数组
        // 数组存储的 数据类型 数组名字[ ] = new 数组存储的数据类型[数组长度];
        int arr[] = new int[5];
        arr[0] = 1;
        System.out.println(arr[0]);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        // 二维数组
        int arr2[][] = new int[3][2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println(); // 输出空行（换行）
        }
    }
}
