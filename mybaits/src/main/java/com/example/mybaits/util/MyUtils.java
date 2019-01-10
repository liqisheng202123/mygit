package com.example.mybaits.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyUtils {


        /**
         * 处理emoji表情
         * @param source
         * @return
         */
        public static String filterEmoji(String source) {
            if(source != null)
            {
                Pattern emoji = Pattern.compile ("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]",Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE ) ;
                Matcher emojiMatcher = emoji.matcher(source);
                if ( emojiMatcher.find())
                {
                    source = emojiMatcher.replaceAll("*");
                    return source ;
                }
                return source;
            }
            return source;
        }
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
