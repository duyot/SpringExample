package com.vivas.wiringbean;

import com.vivas.wiringbean.auto.Billboard;
import com.vivas.wiringbean.auto.CDPlayer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by duyot on 8/16/2016.
 */
public class Test {
    public static void main(String[] args) {
        Long a = 0L;
        long b = 0l;

        System.out.println(a == 0L);
        System.out.println(a == 0);
        System.out.println(a == b);


        System.out.println(a.equals(0L));
        System.out.println(a.equals(0 ));
        System.out.println(a.equals(b ));
    }
}
