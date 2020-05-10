package com.yanwen.file;

import java.util.Scanner;

/**
 *
 * @ClassName: ScannerDemo
 * @Description:
 * @Author: YYY
 * @Date: 2020/5/10 8:19 下午
 **/
public class ScannerDemo {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("请输入年龄:");
        if(scanner.hasNextInt()) {
            int age=scanner.nextInt();
                System.out.println("你的年龄：" + age);
        }else {
           System.out.println("请确保输入的是整数");
       }
        scanner.close();
    }
}
