package org.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOTest {
    public static void main(String[] args) throws IOException {
        //根据文件夹的名字来创建对象
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\io.txt");
        //往文件里面一个字节一个字节的写入数据
        fileOutputStream.write((int)'J');
        fileOutputStream.write((int)'a');
        fileOutputStream.write((int)'v');
        fileOutputStream.write((int)'a');

        //往文件里面一个字节数组的写入文件
        String s = " is the best language!";
        fileOutputStream.write(s.getBytes());
        fileOutputStream.close();

        //传文件夹的名字来创建对象
        FileInputStream fileInputStream = new FileInputStream("D:\\io.txt");
        int len = 0;
        //一个字节一个字节的读出数据
        while((len = fileInputStream.read()) != -1){
            System.out.println((char)len);
        }
        //关闭流
        fileInputStream.close();

        //通过File对象来创建对象
        fileInputStream = new FileInputStream("D:\\io.txt");

        byte []bytes = new byte[1024];
        //一个字节数组的读出数据
        while ((len = fileInputStream.read(bytes)) != -1){
            for(int i = 0; i< len ; i++){
                System.out.print((char) bytes[i]);
            }
        }
        //关闭流
        fileInputStream.close();
    }
}
