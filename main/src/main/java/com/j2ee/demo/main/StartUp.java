package com.j2ee.demo.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.Console;
import java.util.Scanner;

/**
 * Created by rihai on 6/22/2017.
 */
public class StartUp {
    public static void main(String[] ags) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationcontext.xml"});
        context.start();
        ThreadPoolTest threadPoolTest = (ThreadPoolTest) context.getBean("threadPoolTest");
        threadPoolTest.start();

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println("exit");
        sc.close();
        System.exit(0);
    }

}
