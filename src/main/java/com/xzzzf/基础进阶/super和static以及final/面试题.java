package com.xzzzf.基础进阶.super和static以及final;

public class 面试题 {
    public static void main(String[] args) {
        // 猜猜打印的内容
        Zi zi = new Zi();

        // ● 初始化Fu的int a
        // ● 调用Fu的构造方法，执行printA()
        // ● 调用Zi的printA()：打印 zi.a = 0（因为zi的a还没初始化，默认0）
        // ● 初始化Zi的int a
        // ● 调用Zi的构造方法，执行printA()
        // ● 调用Zi的printA()：打印zi.a = 20
    }

    static class Fu {
        int a = 10;

        public void printA() {
            System.out.println("Fu PrintA:" + a);
        }

        public Fu() {
            printA();
        }
    }

    static class Zi extends Fu {
        int a = 20;

        @Override
        public void printA() {
            System.out.println("Zi PrintA:" + a);
        }

        public Zi() {
            printA();
        }
    }
}
