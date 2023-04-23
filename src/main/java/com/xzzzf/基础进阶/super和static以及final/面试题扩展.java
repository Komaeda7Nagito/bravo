package com.xzzzf.基础进阶.super和static以及final;

public class 面试题扩展 {
    public static void main(String[] args) {
        Zi zi = new Zi();
        // ● main方法执行 Zi zi = new Zi()
        // ● 初始化FU_STATIC_A
        // ● 初始化ZI_STATIC_A
        // ● 执行Zi构造器
        //   ○ 初始化Fu
        //     ■ 初始化Fu的int a
        //     ■ 调用Fu的构造器
        //     ■ 调用printA()，实际调用Zi的printA()
        //   ○ 初始化Zi的int a
        //   ○ 调用Zi的构造器
        //   ○ 调用printA()，实际调用Zi的printA()

        // 总得来说，分为几个阶段：
        // ● 类加载
        //   ○ 先加载父类
        //     ■ 初始化static修饰的字段
        //   ○ 后加载子类
        //     ■ 初始化static修饰的字段
        // ● 对象初始化
        //   ○ 先初始化父“对象”
        //     ■ 初始化父“对象”普通字段
        //     ■ 调用父“对象”构造器
        //   ○ 再初始化子对象
        //     ■ 初始化子对象普通字段
        //     ■ 调用子对象构造器
    }

    static class Fu {
        // 新增static变量
        static int FU_STATIC_A = 10;
        int a = 10;

        public void printA() {
            System.out.println("Fu PrintA:" + a);
        }

        public Fu() {
            printA();
        }
    }

    static class Zi extends Fu {
        // 新增static变量
        static int ZI_STATIC_A = 20;
        int a = 20;

        @Override
        public void printA() {
            System.out.println("Zi PrintA:" + a);
        }

        public Zi() {
            // 为了方便观察，显式调用super()
            super();
            printA();
        }
    }
}
