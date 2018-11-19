package com.example.mybaits.util;

import java.util.List;

public class MyUtils {


    public static List<Integer> sub(List<Integer> list ,int aaa){
        if (list.size() > aaa){

        }else {
        }
        return null;

    }

    public static void main(String[] args) throws InterruptedException {
//        String aaaa = "adsf";
//        System.out.println(aaaa.substring(0,3));

        ThreadTest t1 = new ThreadTest("A");
        ThreadTest t2 = new ThreadTest("B");
        t1.start();
        t1.join();
        t2.start();

        t2.join();
        System.out.println("main");

    }

    static class ThreadTest extends Thread{
        private String name ;
        public ThreadTest(){}
        public ThreadTest(String name){
            this.name = name;
        }
        @Override
        public void run(){
            for (int i = 0; i < 400 ;i++) {
                System.out.print(i);
            }
            System.out.println(this.name);
        }
    }
}
