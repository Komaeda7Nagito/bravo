1. static 和 final 通常组合使用
   ```java
    class XxxService {
    // 当我们需要一个 静态常量 时，可以这样写
    private static final int a = 1;
    
    // 省略...
    }

    public final class ConnectionUtils {

    private ConnectionUtils() {}

    // 全局只要一个tl对象，而且final不允许改变
    private static final ThreadLocal<Connection> tl = new ThreadLocal<>();

    private static final BasicDataSource DATA_SOURCE = new BasicDataSource();

    // 对于static final修饰的DATA_SOURCE，希望做一些较为复杂的赋值工作，可以挪到静态代码块
    static {
        DATA_SOURCE.setDriverClassName("com.mysql.jdbc.Driver");
        DATA_SOURCE.setUrl("jdbc:mysql://localhost:3306/demo");
        DATA_SOURCE.setUsername("root");
        DATA_SOURCE.setPassword("123456");
        }
    }
    ```
2. 单独使用`final` 无非就是 `final`表示“不能更改”，`static`表示“属于类”。
      ```java
      public final class EnumUtil { // 工具类，没必要继承（当然，这玩意可写可不写）
    
      }
   
      public void method() {
        final long userId = 1L; // 不希望这个值被后面的语句覆盖（也是可写可不写）
        // ...
      }
      // 如果你有需求，不希望子类覆盖某个方法，要么用private，要么用final，取决于你要不要暴露这个方法
      ```
3. `static` 有一个特殊的用法，用来修饰内部类
      ```java
      public class OuterClass {
        // ...
        public static class InnerClass {
          // ...
        }
      }
      ```
   这里`static` 修饰的内部类，可以直接通过外部类访问，不需要创建外部类对象
      ```java
      OuterClass.InnerClass innerClass = new OuterClass.InnerClass();
      // 原本的写法
      OuterClass outerClass = new OuterClass();
      OuterClass.InnerClass innerClass = outerClass.new InnerClass();
      ```