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
    }
}
