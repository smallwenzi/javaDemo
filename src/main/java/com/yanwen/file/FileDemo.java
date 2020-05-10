package com.yanwen.file;

import java.io.*;

/**
 *
 * @ClassName: FileDemo
 * @Description:
 * @Author: YYY
 * @Date: 2020/5/9 10:29 下午
 **/
public class FileDemo {
    public static void main(String[] args) throws IOException {
     BufferedReader bufferedReader=new BufferedReader
             (new InputStreamReader(System.in));
        System.out.print("请输入年龄:");
        String str=bufferedReader.readLine();
        if(str.matches("\\d{1,3}")) {
            System.out.println("用户输入：" + Integer.parseInt(str));
        }else{
            System.out.println("请确保输入的是整数" + str);
        }
    }
}
