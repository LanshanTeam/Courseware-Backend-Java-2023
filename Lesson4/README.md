## 蓝山工作室2023Java第四节课

经过这几周的学习，相信大家已经对Java的基础知识以及面向对象的内容有了一定的了解。除了这些，我们这节课会介绍一些Java的高级特性。比如异常处理，IO，多线程，反射之类的。接下来让我们开始吧！

![](https://image-9h8.pages.dev/file/f3ed5a24c0aae4234a500.jpg)

#### 1.异常处理

##### 1.1什么是异常

​	程序在运行过程中发生的意外情况，称为异常，如：除数为0、访问下标不存在的数组元素等
异常是一种信号，用于向调用者传递信息，表示程序发生了意外情况

Java中的异常又称：**"例外"**，是一个在程序执行期间发生的时间，他中断正在执行程序的**正常指令**，或者**指令流**，(也就是一串指令)。为了能够及时、有效第处理程序中的运行错误，这个时候必须使用异常类，这可以让程序具有极其可观的**容错性和健壮性**。

在Java中，一个异常的产生，主要有以下三种情况：

- Java内部错误发生异常，Java虚拟机产生的异常
- 编写的程序代码中的错误所产生的的异常，例如`NullPointException`空指针异常、`IndexBoundException`数组越界异常等等
- 通过`throw`语句手动生成的异常，一般用来告知该方法的调用者一些必要信息

------

##### 1.2异常的分类

​	

![](https://image-9h8.pages.dev/file/010faf989b016d9e2b96d.png)

Java按照错误的严重性，从`Throwable` 父类中衍生出`Error`和`Exception`两大派系

* `Error`(错误)

​	程序在执行过程中所遇到的硬件或操作系统的错误。错误对程序而言是致命的，将导致程序无法运行。常见的错误有内存溢出，jvm虚拟机自身的非正常运行，calss文件没有主方法。程序本生是不能处理错误的，只能依靠外界干预。Error是系统内部的错误，由jvm抛出，交给系统来处理。

* `Exception` (异常)

  是程序正常运行中，可以预料的意外情况。比如数据库连接中断，空指针，数组下标越界。异常出现可以导致程序非正常终止，也可以预先检测，被捕获处理掉，使程序继续运行。

  同时异常按照性质，又分为编译异常（可检测）和运行时异常（不可检测）。

  

|       异常类型名称        | 异常类型说明 |
| :-----------------------: | :----------: |
|    ArithmeticException    |   算数异常   |
| IndexOutOfBoundsException | 角标越界异常 |
|    ClassCastException     | 类型转换异常 |
|    NullPointException     |  空指针异常  |
|            ...            |     ...      |

下面看几个常见的异常 

```Java
public class CommonException {
    public static void main(String[] args) {
        //NullPointerException
        Integer a = null;
        System.out.println(a.toString());

        //ArithmeticException
        Double b = 20.23/0;

        //IndexOutOfBoundsException
        List<Integer> list = new ArrayList<>();
        System.out.println(list.get(0));
    }
}

```

------

##### 1.3 自定义异常

​	那肯定有人要问了，这些异常都定义好了，为什么还要自定义异常呢？真麻烦。

![](https://image-9h8.pages.dev/file/8b5156d18efc0678e70c2.png)

其实是这样，如果说我们的代码里抛出了`RuntimeException` 这个异常，那我们怎么去确定到底是哪里出了问题呢，时数据处理的时候出错了，还是类型转化出错了，亦或是引用不存在出错了。这是我们就可以通过自定义异常来让我们能去细化异常，以便进行处理

举个🌰

```Java
public class MeiMiException extends RuntimeException{
    private Double money;

    public MeiMiException(Double money) {
        super("余额不足，还差：" + money);
        this.money = money;
    }

    public static class AccountAdmin {
        private Double balance;

        public AccountAdmin(Double balance) {
            this.balance = balance;
        }

        //存钱的方法
        public void deposit(double money) {
            this.balance += money;
        }

        //取钱的方法
        public void withdraw(double money) throws MeiMiException {
            if (balance >= money) {
                balance -= money;
            } else {
                double needMoney = money - balance;
                throw new MeiMiException(needMoney);
            }
        }
    }

    public static void main(String[] args) {
        AccountAdmin accountAdmin = new AccountAdmin(100.0);
        accountAdmin.deposit(200);//先存二伯块
        try {
            //再取四伯块
            accountAdmin.withdraw(400);
        } catch (MeiMiException e) {
            throw new RuntimeException(e);
        }
    }
}

```

##### 1.4处理异常

* try-catch-finally

  使用 try 和 catch 关键字可以捕获异常。try/catch 代码块放在异常可能发生的地方。try/catch代码块中的代码称为保护代码

  ```Java
  try{
     // 程序代码
  }catch(ExceptionName e1){
    // 程序代码
  }catch(ExceptionName e2){
    // 程序代码
  }catch(ExceptionName e3){
    // 程序代码
  }finally{
    // 程序代码
  }
  
  ```

  Catch 语句包含要捕获异常类型的声明。当保护代码块中发生一个异常时，try 后面的 catch 块就会被检查。

  如果发生的异常包含在 catch 块中，异常会被传递到该 catch 块，这和传递一个参数到方法是一样。

  同时我们还能进行无限套娃，根据不同的异常处理，我们可以一直catch。

  Finally关键字finally 关键字用来创建在 try 代码块后面执行的代码块。无论是否发生异常，finally 代码块中的代码总会被执行。在 finally 代码块中，可以运行清理类型等收尾善后性质的语句。

* throws+异常类型

  在Java中， **throw** 和 **throws** 关键字是用于处理异常的。

  **throw** 关键字用于在代码中抛出异常，而 **throws** 关键字用于在方法声明中指定可能会抛出的异常类型。

  * ###### throw 关键字

    **throw** 关键字用于在当前方法中抛出一个异常。通常情况下，当代码执行到某个条件下无法继续正常执行时，可以使用 **throw** 关键字抛出异常，以告知调用者当前代码的执行状态。它可以在我们自己指定的地方报异常跳出程序，而不一定在错误的地方，这样可以自己进行监控错误，不让JVM处理错误。

  * ###### throws 关键字

    **throws** 关键字用于在方法声明中指定该方法可能抛出的异常。当方法内部抛出指定类型的异常时，该异常会被传递给调用该方法的代码，并在该代码中处理异常。throws用来声明方法在运行过程中可能出现的异常，以便调用者根据不同的异常类型预先定义不同的处理方式。

#### 1.2 🙌IO流🙌

##### 1.2.1什么是IO流

​	I/O 即输入Input/ 输出Output的缩写，其实就是计算机调度把各个存储中（包括内存和外部存储）的数据写入写出的过程；

​	java中用“流（stream）”来抽象表示这么一个写入写出的功能，封装成一个“类”，都放在[http://java.io](https://link.zhihu.com/?target=http%3A//java.io)这个包里面。

​	流是一种抽象概念，它代表了数据的无结构化传递。按照流的方式进行输入输出，数据被当成无结构的字节序或字符序列。从流中取得数据的操作称为提取操作，而向流中添加数据的操作称为插入操作。用来进行输入输出操作的流就称为IO流。换句话说，IO流就是以流的方式进行输入输出

总之，在Java中IO流就是Java程序和操作系统之间通信用的方法。在这里，我们只简单介绍字节流和字符流，这两种也是比较常见，除了这两种，其他的有兴趣的话可以去自行学习。

![](https://image-9h8.pages.dev/file/c048aec3f7acfc60ea8ea.png)

##### 1.2.2 字符流和字节流的区别

* 字节流可用于任何类型的对象，包括二进制对象，而字符流只能处理字符或者字符串； 字节流提供了处理任何类型的IO操作的功能，但它不能直接处理Unicode字符，而字符流就可以。

* 字节流在操作的时候本身是不会用到缓冲区的，是与文件本身直接操作的，所以字节流在操作文件时，即使不关闭资源，文件也能输出；字符流在操作的时候是使用到缓冲区的。如果字符流不调用close或flush方法，则不会输出任何内容。

  那我们要说了，既然只差了一个缓冲区，为什么还要有字符流呢？

  1. 方便处理文本数据：字符流提供了更高级别的字符处理功能，如按行读取、写入等，更方便处理文本数据。
  2. 自动处理字符编码：字符流会自动处理字符编码的细节，可以直接读取和写入字符数据，而不需要手动进行字符编码的转换。
  3. 跨平台兼容性：字符流在处理文本数据时，会根据系统的默认字符编码进行处理，从而提供了跨平台兼容性。

既然这样，下面我们重点针对字节流进行学习

##### 1.2.3 字节流

字节类主要有两个抽象类

* `InputStream`  有几个常见的子类 如 `FileInputStream` `ByteArrayInputStream`
* `OutputStream` 有几个常见的子类 如 `FileOutPutStream` `ByteArrayOutputStream`

举个简单的🌰，我们向D盘的io.txt中输入"Java is the best language!"，再读出来

```Java
package org.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOTest {
    public static void main(String[] args) throws IOException {
        //根据文件夹的名字来创建对象
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\io.txt");
        //往文件里面一个字节一个字节的写入数据
        fileOutputStream.write((int)'J');
        fileOutputStream.write((int)'a');
        fileOutputStream.write((int)'v');
        fileOutputStream.write((int)'a');

        //往文件里面一个字节数组的写入文件
        String s = " is the best language!";
        fileOutputStream.write(s.getBytes());
        fileOutputStream.close();

        //传文件夹的名字来创建对象
        FileInputStream fileInputStream = new FileInputStream("D:\\io.txt");
        int len = 0;
        //一个字节一个字节的读出数据
        while((len = fileInputStream.read()) != -1){
            System.out.println((char)len);
        }
        //关闭流
        fileInputStream.close();

        //通过File对象来创建对象
        fileInputStream = new FileInputStream("D:\\io.txt");

        byte []bytes = new byte[1024];
        //一个字节数组的读出数据
        while ((len = fileInputStream.read(bytes)) != -1){
            for(int i = 0; i< len ; i++){
                System.out.print((char) bytes[i]);
            }
        }
        //关闭流
        fileInputStream.close();
    }
}

```

##### 1.2.4 字符流

字符类主要有两个抽象类

* `Reader`  有几个常见的子类 如 `FileReader` `InputStreamReader`
* `Writer` 有几个常见的子类 如 `FileWriter` `OutputStreamWriter`

关于字符流的具体用法就不再赘述了，跟字节流是大差不差的，感兴趣的话可以自己写写看。

注意一下，处理完后一定要close或者flush 否则不会输出任何内容

------

#### 1.3 多线程😧

##### 1.3.1 什么是线程？

线程是程序执行的时候最小单位，他是进程的一个执行流，是CPU调度和分配资源的基本单位

一个进程可以有很多个线程组成，线程之间共享进程的所有资源，每个线程有自己的堆栈和局部变量

线程有CPU独立调度执行，在多CPU环境下就允许多个线程同时运行。同样多线程也可以实现并发操作，每个请求分配一个线程来处理

生命周期

1.新建: 线程被new出来

2.准备就绪：线程具有执行的资格，即线程调用了start()，没有执行的权利

3.运行：具备执行的资格和具备执行的权利

4.阻塞：没有执行的资格和执行权利

5.销毁: 线程的对象变成垃圾，释放资源。

![](https://image-9h8.pages.dev/file/7c1bfb64191f60f05f703.png)

##### 1.3.2 什么是进程？

进程是资源(CPU、内存等等)分配的最小，或者说基本单位，他是程序执行时的一个实例

程序run的时候系统就会创建一个进程，并为他分配资源，然后吧这个进程放到进程就绪队列，进程调度器选中它的时候，就会为他分配CPU时间，程序真正开始run

在 Java 程序中体现在 main 方法的执行是一个进程，我们在 main 方法中通过 Thread 类来创建多个线程进而运行他们，也就达到多线程的目的。

##### 1.3.3创建线程

关于创建线程一般有三种主要的方法

* 实现Runable接口

  ```java
  package org.example;
  
  
  //创建一个实现了Runnable接口的类
  class MThread implements Runnable {
  
      //实现类去实现Runnable中的抽象方法：run()
      @Override
      public void run() {
          for (int i = 0; i < 100; i++) {
              if (i % 2 == 0) {
                  System.out.println(Thread.currentThread().getName() + ":" + i);
              }
          }
      }
  }
  
  public class RunnableTest{
      public static void main(String[] args) {
          //创建实现类的对象
          MThread mThread = new MThread();
  
          //将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
          Thread t1 = new Thread(mThread);
          t1.setName("线程1");
  
          //通过Thread类的对象调用start():① 启动线程 ②调用当前线程的run()-->调用了Runnable类型的target的run()
          t1.start();
  
          //再启动一个线程，遍历100以内的偶数
          Thread t2 = new Thread(mThread);
          t2.setName("线程2");
          t2.start();
      }
  }
  
  ```

  

* 实现Callable接口

```java
package org.example;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//创建一个实现Callable的实现类
class NumThread implements Callable {
    //实现call方法，将此线程需要执行的操作声明在call()中
    @Override
    public Object call() throws Exception {
        int sum = 0;
        //把100以内的偶数相加
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}

public class CallableTest {
    public static void main(String[] args) {
        //创建Callable接口实现类的对象
        NumThread numThread = new NumThread();

        //将此Callable接口实现类的对象作为传递到FutureTask构造器中，创建FutureTask的对象
        FutureTask futureTask = new FutureTask(numThread);

        //将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start()
        new Thread(futureTask).start();

        try {
            //获取Callable中call方法的返回值
            //get()返回值即为FutureTask构造器参数Callable实现类重写的call()的返回值。
            Object sum = futureTask.get();
            System.out.println("总和为：" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

```



* 使用匿名类

  ```java
  package org.example;
  
  public class AnonyTest {
      public static void main(String[] args) {
          Thread thread = new Thread(new Runnable() {
              @Override
              public void run() {
                  // 线程需要执行的任务代码
                  System.out.println("子线程开始启动....");
                  for (int i = 0; i < 30; i++) {
                      System.out.println("run i:" + i);
                  }
              }
          });
          thread.start();
      }
  }
  
  ```

  

除了这三种，我们其实还有一种方式，就是使用线程池了，这也是比较重要的一部分。

------

##### 1.3.4线程池

创建若干个可执行的线程放入一个池（容器）中，有任务需要处理时，会提交到线程池中的任务队列，处理完之后线程并不会被销毁，而是仍然在线程池中等待下一个任务。

线程池的优点：
**降低资源消耗**，复用已创建的线程来降低创建和销毁线程的消耗。
**提高响应速度**，任务到达时，可以不需要等待线程的创建立即执行。
**提高线程的可管理性**，使用线程池能够统一的分配、调优和监控。

##### 创建一个线程池对象

Java中线程池的核心实现类是`ThreadPoolExecutor`，可以通过该类地构造方法来构造一个线程池，我们先来看下`ThreadPoolExecutor`的整个继承体系

![](https://image-9h8.pages.dev/file/8e97db106488228e2f146.png)

现在进行一个`ThreadPoolExecutor`的创建

```java
ExecutorService pools = new ThreadPoolExecutor(
             3,//corePoolSize
             5,//maximumPoolSize
             8,//keepAliveTime
             TimeUnit.SECONDS,
             new ArrayBlockingQueue<>(6),
             Executors.defaultThreadFactory(),
             new ThreadPoolExecutor.AbortPolicy());
```

以上参数分别为：

corePoolSize，核心线程数量，决定是否创建新的线程来处理到来的任务
maximumPoolSize，最大线程数量，线程池中允许创建线程地最大数量
keepAliveTime，线程空闲时存活的时间
unit，空闲存活时间单位
workQueue，任务队列，用于存放已提交的任务
threadFactory，线程工厂，用于创建线程执行任务
handler，拒绝策略，当线程池处于饱和时，使用某种策略来拒绝任务提交

接下来我们可以启动一个线程池，将两个线程丢进去运行一下。

```java
import java.util.concurrent.*;

public class poolTest {
    public static void main(String[] args) {
        ExecutorService pools = new ThreadPoolExecutor(
                3, 5, 8,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(6),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        pools.execute(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println(Thread.currentThread() + "开炮" +  i + "次");
            }
        });

        pools.execute(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println(Thread.currentThread() + "熄火" + i + "次");
            }
        });
    }
}

```

------

接下来的是**线程安全问题**，线程不安全导致数据泄露，可能会被抓进去的😧😧

![](https://image-9h8.pages.dev/file/cb10d0f0666e3ed7a34c1.jpg)

什么是线程安全问题：多个线程同时共共享一个资源，并对他进行修改

######  什么会导致线程安全问题呢：

* 抢占式执行
* 多个线程同时修改了同一个变量
* 非原子性操作
* 内存可见性问题
* **指令重排序**：编译器优化的本质是调整代码的执行顺序，在单线程下没问题，但在多线程下容易出现混乱，从而造成线程安全问题。 

在这里我们以第五种情况举一个例子

```java
public class TreadSecurity {
    static class Counter{
        private int count = 0;
        public int increment() {
            return ++this.count;
        }

        public int getCount() {
            return count;
        }
    }

    private static final int ans = 50000;

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();
        Thread thread1 = new Thread(() -> {
            for(int i = 0;i<ans;i++){
                counter.increment();
            }
        });
        Thread thread2 = new Thread(() -> {
            for(int j = 0;j<ans;j++){
                counter.increment();
            }
        });
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("最终结果：" + counter.getCount());
    }
}
```

最终结果会比ans*2小很多，因为线程调度的顺序是随机的，造成线程间自增的指令集交叉，导致运行时出现两次自增但值只自增一次的情况，所以得到的结果会偏小。

------

**解决方法**

我们的核心思想是让多个线程依次进行处理，因此我们可以在多线程之间使用一些关键字来解决：

* `synchronized` 自动锁，锁的创建和释放都是自动的
* `lock` 手动指定锁的创建和释放
* `volatile` 关键字

**synchronized** 基本用法

1.修饰普通方法：

```Java
public synchronized int increment() {
            return ++this.count;
        }
```

2.修饰静态方法

```Java
private static int count = 0;
synchronized public static int increment() {
   return ++count;
}
```

3.修饰代码块

```Java
public int increment() {
            synchronized (this){
                return ++this.count;
            }
        }
```

在规范上：

* 建议使用**共享资源**作为锁对象：

- 对于实例方法建议使用**this**作为锁对象
- 对于静态方法建议使用**字节码（类名：class）**对象作为锁对象

**synchronized 特性：**

**1. 互斥**。synchronized 会起到互斥效果, 某个线程执行到某个对象的 synchronized 中时, 其他线程如果也执行到同⼀个对象 synchronized 就会 **阻塞等待。**

- **进入** synchronized 修饰的代码块, 相当于 **加锁，**
- **退出** synchronized 修饰的代码块, 相当于 **解锁。**

**2. 刷新内存。** synchronized 的⼯作过程: 

1. 获得互斥锁
2. 从主内存拷贝变量的最新副本到⼯作的内存
3. 执行代码
4. 将更改后的共享变量的值刷新到主内存
5. 释放互斥锁

所以 synchronized 也能保证内存可见性.

**3. 可重入。** synchronized 同步块对同⼀条线程来说是可重入的，不会出现自己把自己锁死的问题。

同一个线程在持有锁的情况下，可以再次获取该锁而不会被阻塞。换句话说，一个线程可以多次进入同步代码块或方法，而不会被自己持有的锁所阻塞。

剩下的两种方式感兴趣的话可以自己去研究，这里就不做过多阐述了。

------

#### 1.4反射

##### 1.4.1什么是反射

Java 的**反射机制**是指在运行状态中，对于任意一个类都能够知道这个类所有的属性和方法； 并且对于任意一个对象，都能够调用它的任意一个方法；这种动态获取信息以及动态调用对象方法的功能成为Java语言的反射机制。

简单解释一下就是：

- 我们编译时知道类或对象的具体信息，此时直接对类和对象进行操作即可，无需使用反射（reflection）
- 如果编译不知道类或对象的具体信息，此时应该如何做呢？这时就要用到 **反射** 来实现。比如类的名称放在XML文件中，属性和属性值放在XML文件中，需要在运行时读取XML文件，动态获取类的信息

举个栗子

```Java
public class ReflectionTest {

    public static void main(String[] args) throws Exception{
        Student student = new Student();
        student.doHomework("Java");

        Class cla = Class.forName("org.example.entity.Student");//得到
        Method method = cla.getMethod("doHomework",String.class);
        Constructor constructor = cla.getConstructor();
        Object object = constructor.newInstance();
        method.invoke(object,"睡觉");
    }
}
```

##### 1.4.2相关API

**反射创造对象：**

```Java
Class.forName("全类名");
类名.class;
对象.getClass();
```

**反射获取构造方法：** Class类中用于获取构造方法的方法

| 方法名                                                       | 描述                           |
| ------------------------------------------------------------ | ------------------------------ |
| Constructor<?>[] getConstructors()                           | 返回所有公共构造方法对象的数组 |
| Constructor<?>[] getDeclaredConstructors()                   | 返回所有构造方法对象的数组     |
| Constructor getConstructor(Class<?>... parameterTypes)       | 返回单个公共构造方法对象       |
| Constructor getDeclaredConstructor(Class<?>... parameterTypes) | 返回单个构造方法对象           |

Constructor类中用于创建对象的方法

| 方法名                            | 描述                        |
| --------------------------------- | --------------------------- |
| T newInstance(Object... initargs) | 根据指定的构造方法创建对象  |
| void setAccessible(boolean flag)  | 设置为true,表示取消访问检查 |

**反射获取成员变量**

| 方法名                              | 描述                           |
| ----------------------------------- | ------------------------------ |
| Field[] getFields()                 | 返回所有公共成员变量对象的数组 |
| Field[] getDeclaredFields()         | 返回所有成员变量对象的数组     |
| Field getField(String name)         | 返回单个公共成员变量对象       |
| Field getDeclaredField(String name) | 返回单个成员变量对象           |
| void set(Object obj, Object value)  | 给指定对象的成员变量赋值       |
| Object get(Object obj)              | 返回指定对象的Field的值        |

**反射获取成员方法并运行** `Object invoke(Object obj,Object ... args)`

------

看了这么多东西，我们肯定已经对反射有一个初步的了解了，但是为什么要有反射这么一个东西呢，接下来说一下它的作用。

![](https://image-9h8.pages.dev/file/a15811bc7929eecc7ee3c.jpg)

##### JDBC 的数据库的连接

在JDBC连接数据库中，一般包括**加载驱动，获得数据库连接**等步骤。而加载驱动，就是引入相关Jar包后，通过**Class.forName()** 即反射技术，加载数据库的驱动程序。

##### Spring 框架的使用

Spring 通过 XML 配置模式装载 Bean，也是反射的一个典型例子。

**装载过程：**

- 将程序内XML 配置文件加载入内存中
- Java类解析xml里面的内容，得到相关字节码信息
- 使用反射机制，得到Class实例
- 动态配置实例的属性，使用

**这样做当然是有好处的：**

不用每次都去new实例了，并且可以修改配置文件，比较灵活。

除了这些好处还有一些不尽如人意的地方

- 性能开销 - 由于反射涉及动态解析的类型，因此无法执行某些 Java 虚拟机优化。 因此，反射操作的性能要比非反射操作的性能要差，应该在性能敏感的应用程序中频繁调用的代码段中避免。
- 破坏封装性 - 反射调用方法时可以忽略权限检查，因此可能会破坏封装性而导致安全问题。
- 内部曝光 - 由于反射允许代码执行在非反射代码中非法的操作，例如访问私有字段和方法，所以反射的使用可能会导致意想不到的副作用，这可能会导致代码功能失常并可能破坏可移植性。 反射代码打破了抽象，因此可能会随着平台的升级而改变行为。

## **作业：**

### Leva1:

复习前两节课内容，自己写一写课件中的代码（无需提交）

## Leva2：

来点算法

1.[爬楼梯](https://leetcode.cn/problems/climbing-stairs/description/)

2.[罗马数字转整数](https://leetcode.cn/problems/roman-to-integer/description/)

