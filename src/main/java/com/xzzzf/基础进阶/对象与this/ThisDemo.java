package com.xzzzf.基础进阶.对象与this;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

public class ThisDemo {

    public static void main(String[] args) {
        // 问题一：可以new Son().setSonName("").setFatherName()，却不能new Son().setFatherName("").setSonName()，为什么？
        // new Son().setFatherName("").setSonName();
        /**
         * 首先用了@Accessors注解，所以set,get方法返回的就是该对象，
         *         那么setSonName返回的是子类
         *         setFatherName返回的是父类，那么答案显而易见了，父类里面不能用子类的方法。
         */


        // 问题二：无论怎么调整setter顺序，返回值始终是Father类型，为什么？
        Father father = new Son().setSonName("").setFatherName("");
        Father father1 = new Son().setFatherName("");

        Son son = new Son().setSonName("");


    }


    @Getter
    @Setter
    @Accessors(chain = true)
    static class Father {
        private String fatherName;
    }

    @Getter
    @Setter
    @Accessors(chain = true)
    static class Son extends Father {
        private String sonName;
    }
}