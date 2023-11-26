# 蓝山工作室2023Java第五节课：集合框架、泛型、基础总结
这节课的内容是Java中集合的讲解及泛型。这节课之后Java的基础部分也快结束了，所需要的常用语法也给大家介绍的差不多了，所以这节课讲完之后会对前面的部分作一个小小的总结。希望大家继续努力

![](https://pic.imgdb.cn/item/6562b59ec458853aef750078.jpg)
## 集合框架
集合与数组一样，都是存储数据的容器。下面是两者的对比。
- 数组使用前需要声明其容纳的元素的类型，但集合不需要。
- 数组是静态的，即数组创建后具有固定的大小（长度），但集合的长度是可变的，集合存在一个扩容机制。
- 数组只能存储相同类型的元素，但是集合可以存储不同类型的元素。
##  1.集合框架体系
  ![图片](https://pic.imgdb.cn/item/6562b5e0c458853aef75be99.jpg)

  集合体系分成了接口、具体类、算法。

  接口：在上两节课的学习中，大家学习了Java面向对象的思想。这里定义的接口就代表着集合的抽象数据类型，例如例如 Collection、List、Set、Map 等。之所以定义了多个接口，是为了以不同的方式操作集合对象。

  实现类：实现类就是接口的具体实现，比如说ArrayList就是List接口的实现类，HashSet就是Set接口的实现类，我们在使用集合的时候，就是使用这些实现类进行操作。

  算法：在Java中，还存在着一些操作集合的方法，例如搜索和排序，学习这些方法也利于我们更好的操作集合。
  Java 集合框架提供了一套性能优良，使用方便的接口和类，java集合框架位于java.util包中， 所以当使用集合框架的时候需要进行导包。

![图片](https://pic.imgdb.cn/item/6562b604c458853aef7626b4.jpg)

这里常用的是Set和List，而Queue用到的地方不多

### 1.1Set
Set代表无序不可重复集合，只能根据元素本身来访问
#### HashSet
HashSet是一个无序的、可重复的集合。HashSet中的元素是唯一的，不允许有重复的元素存在。HashSet提供了add、remove、contains等操作，可以用于添加、删除和查找元素。  HashSet的主要特点如下：

1.  可以存储任意类型的对象，包括自定义类。
2.  元素是唯一的，不允许有重复的元素存在。如果向HashSet中添加重复的元素，那么该元素只会被存储一次。
3.  HashSet中的元素是无序的，不保持元素的插入顺序。
4.  HashSet是通过哈希表实现的，因此添加、删除和查找元素的平均时间复杂度为O(1)。
5.  HashSet不保证元素的顺序，因此在遍历HashSet时，元素的顺序可能会发生变化。
    HashSet的常用方法如下：
1.  add(Object obj)：向HashSet中添加一个元素。
2.  remove(Object obj)：从HashSet中移除一个元素。
3.  contains(Object obj)：判断HashSet中是否包含一个元素。
4.  size()：返回HashSet中元素的个数。
5.  clear()：清空HashSet中的所有元素
```java
package set;

import java.util.*;

/**
* @Author 70ash
* @Date 2023/11/23 23:04
* @Description:
  */
  public class HashSetDemo {
  public static void main(String[] args) {
  HashSet<String> set = new HashSet<>();
  // 添加元素
  set.add("apple");
  set.add("banana");
  set.add("orange");
  // 删除元素
  set.remove("banana");
  // 查看是否包含元素 contains()
  System.out.println(set.contains("apple")); // 输出：true
  System.out.println(set.contains("banana")); // 输出：false
  // 长度
  System.out.println(set.size()); // 输出：2
  // 遍历元素。使用迭代器
  Iterator<String> iterator = set.iterator();
  while (iterator.hasNext()) {
  System.out.println(iterator.next());
  }
  // 使用增强for循环
  // 清空集合元素
  set.clear();
  System.out.println(set.size()); // 输出：0
  }
  }
```
    
###  1.2List
  List代表了有序可重复集合，可直接根据元素的索引来访问
  （1）ArrayList：底层数据结构是数组，查询快，增删慢，线程不安全，效率高，可以存储重复元素
  （2）LinkedList 底层数据结构是链表，查询慢，增删快，线程不安全，效率高，可以存储重复元素
  （3）Vector:底层数据结构是数组，查询快，增删慢，线程安全，效率低，可以存储重复元素
#### ArrayList相关的方法
  ArrayList是Java中的一种基于数组实现的动态数组类，它可以在数组的基础上实现增加、删除、访问等操作。ArrayList中的元素可以是任意类型的对象，它提供了以下方法：
- add(element): 在列表的末尾添加一个元素。
- add(index, element): 在指定位置插入一个元素。
- get(index): 返回指定位置的元素。
- set(index, element): 替换指定位置的元素。
- remove(index): 移除指定位置的元素。
- remove(element): 移除指定的元素。
- size(): 返回列表的大小。
- clear(): 清空列表中的所有元素。
  时间复杂度如下：
- 添加元素：O(n)
- 删除元素：O(n)
- 访问元素：O(1)
  扩容机制
#### ArrayList扩容机制
  打开idea中ArrayList类的源码，ArrayList中有两个属性，size：表示ArrayList的长度，elementData数组：用来存储数据的数组。
  在Arraylist扩容时会首先判断得到最小扩容量，如果你构造的ArrayList是用无参构造，即你创建ArrayList时没有确定它的长度，最小扩容量就为10和size+1当中的最大值，
  然后再判断是否需要扩容，如果最小扩容量大于elementData.length，就需要扩容，然后调用grow（）方法，其中旧容量为elementData.length，新容量为elementData.length的1.5倍（new=old+old>>1），
  若新容量大于size+1,最小需要容量就为新容量，若新容量小于size+1,最小需要容量就为size+1,之后再将原来的数组用Arrays.copyOf方法复制到新数组，使新数组的长度为最小需要容量。
```java
package collectionDemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
* @Author 70ash
* @Date 2023/11/23 19:41
* @Description:
  */
  public class ArrayListDemo {
  public static void main(String[] args) {
  List arrayList = new ArrayList<>();
  // 添加元素 add();
  arrayList.add(20);
  arrayList.add("A");
  arrayList.add("B");
  // 替换元素 set()。传入一个int值作为索引和要添加的值，替换索引处元素。如果索引超过了集合的最大索引，会报错。
  arrayList.set(1,"C");
  // 得到元素 get()
  Object o = arrayList.get(1);
  System.out.println(o);
  // 删除元素 remove()
  arrayList.remove("B");
  // 得到某一元素的索引,如果没有该元素就返回-1
  int b = arrayList.indexOf("B");
  System.out.println("B的索引为" + b);
  // 长度 size()
  System.out.println("集合的长度为" + arrayList.size());
  // 清空列表 clear()
  arrayList.clear();
  System.out.println("集合的长度为" + arrayList.size());

  }
  }
```

####  LinkedList相关的方法
  LinkedList是Java中的一个双向链表实现的集合类，它可以在常数时间内插入和删除元素，但是访问元素的时间复杂度较高。它提供了以下方法：
- add(element): 在链表的末尾添加一个元素。
- addFirst(element): 在链表的头部添加一个元素。
- addLast(element): 在链表的尾部添加一个元素。 - get(index): 返回指定位置的元素。
- set(index, element): 替换指定位置的元素。
- remove(index): 移除指定位置的元素。
- size(): 返回链表的大小。
- clear(): 清空链表中的所有元素
  时间复杂度如下：
- 添加元素：O(1)
- 删除元素：O(1)
- 访问元素：O(n)
####  Vector
  Vector是Java中的一个基于数组实现的动态数组类，它可以在数组的基础上实现增加、删除、访问等操作。
  Vector与ArrayList唯一的区别就是Vector是线程安全的。

**List和Set的区别**

![图片](https://pic.imgdb.cn/item/6562b64bc458853aef76f653.jpg)
### 1.3Map
HashMap是Java中的一个Map接口的实现类，它使用哈希表来存储键值对。HashMap中的键和值可以是任意对象，而且它支持自动扩容，以提高查询效率。  HashMap的特点如下：
1. 通过键来获取值，可以通过键来设置、删除值。
2. 支持空键和空值。
3. 支持快速查找，时间复杂度通常为O(1)。
4. 不保证元素的顺序。  
   HashMap的常用方法如下：
1. get(key)：根据键获取值。
2. put(key, value)：将键值对存入HashMap中。
3. remove(key)：根据键删除对应的键值对。
4. size()：返回HashMap中键值对的数量。
5. clear()：清空HashMap中的所有键值对。
6. isEmpty()：判断HashMap是否为空。
7. keySet()：返回一个Set集合，包含所有的键。
8. values()：返回一个Collection集合，包含所有的值。
```java
  package map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
* @Author 70ash
* @Date 2023/11/23 23:33
* @Description:
  */
  public class HashMapDemo {
  public static void main(String[] args) {
  // 创建一个HashMap对象
  Map<String, Integer> map = new HashMap<>();
  // 向map中添加键值对
  map.put("key", 1);
  // 从map中获取键为"key"的值，赋值给value变量
  int value = map.get("key");
  // 检查map中是否存在键为"key"的元素，如果存在返回true，否则返回false
  boolean exists = map.containsKey("key");
  // 获取map中所有的键，返回一个Set集合
  Set<String> keys = map.keySet();
  // 获取map中所有的值，返回一个Collection集合
  Collection<Integer> values = map.values();
  // 获取map中所有的键值对，返回一个Collection集合
  Collection<Map.Entry<String, Integer>> entries = map.entrySet();
  // 获取map中第一个键，返回一个String类型的字符串
  String key = map.keySet().toArray(new String[1])[0];
  // 从map中移除键为"key"的元素
  map.remove("key");
  // 清空map中的所有元素
  map.clear();
  // 获取map中元素的个数，返回一个int类型的整数
  int size = map.size();
  // 检查map是否为空，如果为空返回true，否则返回false
  boolean isEmpty = map.isEmpty();

  }
  }
```
  HashMap的底层结构

  ![图片](https://pic.imgdb.cn/item/6562b671c458853aef776572.jpg)

1. 哈希表
   HashMap主要依赖于哈希表（数组）来存储数据。哈希表中的每个元素被称为“bucket”。数组的每个位置（bucket）都可以存放一个元素（键值对），数组的索引是通过键的哈希码经过哈希函数计算得来的。这样我们就可以通过键快速定位到数组的某个位置，取出相应的值，这就是HashMap快速获取数据的原理。
2. 链表
   在理想的情况下，哈希函数将每个键均匀地散列到哈希表的各个位置。但在实际中，我们可能会遇到两个不同的键计算出相同的哈希值，这就是所谓的“哈希冲突”。‘’HashMap通过使用链表来解决这个问题。
   当哈希冲突发生时，HashMap会在冲突的bucket位置增加一个链表，新的元素会被添加到链表的末尾。每个链表中的元素都包含了相同哈希值的键值对。所以在查找元素时，如果遇到哈希冲突，HashMap需要进行一次线性查找。
3.  红黑树
   从Java 8开始，如果链表的长度超过一定的阈值（默认为8），那么链表会被转换为红黑树。红黑树是一种自平衡的二叉查找树，通过保持树的平衡，可以提高查找效率。
4. 扩容与重新哈希
   HashMap在初始化时，会有一个默认的初始容量（16），并且有一个加载因子（0.75）。当HashMap的大小（也就是已经存储的键值对数量）超过 容量*加载因子 的时候，HashMap会进行扩容，新的容量是原来的两倍，并且会进行重新哈希，将已经存在的元素重新放入新的bucket位置。
   总结
   HashMap的底层数据结构包括：哈希表（数组）、链表和红黑树。通过哈希表，我们可以快速定位元素的位置。通过链表和红黑树，我们可以解决哈希冲突的问题。通过扩容和重新哈希，我们可以保证HashMap的性能。
5. 
   关于HashMap的底层结构可以看看这篇文章:https://juejin.cn/post/7188057359754166331?searchId=20231124205835322C5596C5B424379DE0
##   2.泛型
   JDK 1.5时增加了泛型，在很大的程度上方便在集合上的使用。
   泛型是一种在编译期间进行集合中的元素进行限定的机制。使用了泛型，在运行期间可以安全的将元素强转成指定的元素。下面举个例子看一下有和没有泛型的区别
- 不使用泛型：
```java
public static void main(String[] args) {
  List list = new ArrayList();
  list.add(11);
  list.add("ssss");
  for (int i = 0; i < list.size(); i++) {
  System.out.println((String)list.get(i));
  }
  }
```
  

因为list类型是Object。所以int,String类型的数据都是可以放入的，也是都可以取出的。但是上述的代码，运行的时候就会抛出类型转化异常，这个相信大家都能明白。
- 使用泛型：
```java
 public static void main(String[] args) {
  List<String> list = new ArrayList();
  list.add("hahah");
  list.add("ssss");
  for (int i = 0; i < list.size(); i++) {
  System.out.println((String)list.get(i));
  }
  }
```
 

在上述的实例中，我们只能添加String类型的数据，否则编译器会报错。
---
泛型的三种使用方式：泛型类，泛型方法，泛型接口
### 2.1 泛型类
- 泛型类概述：把泛型定义在类上
- 定义格式：
```java
public class 类名 <泛型类型1,...> {}
```
- 注意事项：泛型类型必须是引用类型（非基本数据类型）
 ### 2.2 泛型方法
- 泛型方法概述：把泛型定义在方法上
- 定义格式：
```java
public <泛型类型> 返回类型 方法名（泛型类型 变量名） {}
```
- 注意要点：
    - 方法声明中定义的形参只能在该方法里使用，而接口、类声明中定义的类型形参则可以在整个接口、类中使用。当调用fun()方法时，根据传入的实际对象，编译器就会判断出类型形参T所代表的实际类型。
```java

      class Demo{  
      public <T> T fun(T t){   // 可以接收任意类型的数据  
      return t ;     // 直接把参数返回  
      }  
      };  
      public class GenericsDemo26{  
      public static void main(String args[]){  
      Demo d = new Demo() ; // 实例化Demo对象  
      String str = d.fun("汤姆") ; // 传递字符串  
      int i = d.fun(30) ;  // 传递数字，自动装箱  
      System.out.println(str) ; // 输出内容  
      System.out.println(i) ;  // 输出内容  
      }  
      };

```
### 2.3 泛型接口
- 泛型接口概述：把泛型定义在接口
- 定义格式：
```java
public interface 接口名<泛型类型> {}
```
- 实例：

```java
  /**
 * 泛型接口的定义格式:修饰符  interface 接口名<数据类型> {}
 */  
public interface Inter<T> {
  public abstract void show(T t) ;
  }

```

/**
* 子类是泛型类
  */
```java
  public class InterImpl<E> implements Inter<E> {
  @Override
  public void show(E t) {
  System.out.println(t);
  }
  }


Inter<String> inter = new InterImpl<String>() ;
inter.show("hello") ;
```


### 2.4 源码中泛型的使用，下面是List接口和ArrayList类的代码片段。
//定义接口时指定了一个类型形参，该形参名为E
```java
public interface List<E> extends Collection<E> {
//在该接口里，E可以作为类型使用
public E get(int index) {}
public void add(E e) {}
}
//定义类时指定了一个类型形参，该形参名为E

public class ArrayList<E> extends AbstractList<E> implements List<E> {
    //在该类里，E可以作为类型使用
    public void set(E e) {
.......................
    }
}
```
###  2.5 泛型构造器
- 构造器也是一种方法，所以也就产生了所谓的泛型构造器。
- 和使用普通方法一样没有区别，一种是显示指定泛型参数，另一种是隐式推断
```java
  public class Person {
  public <T> Person(T t) {
  System.out.println(t);
  }
  }
```


使用：
```java
public static void main(String[] args) {
new Person(22);// 隐式
new <String> Person("hello");//显示
}

```

- 特殊说明：
    - 如果构造器是泛型构造器，同时该类也是一个泛型类的情况下应该如何使用泛型构造器：因为泛型构造器可以显式指定自己的类型参数（需要用到菱形，放在构造器之前），而泛型类自己的类型实参也需要指定（菱形放在构造器之后），这就同时出现了两个菱形了，这就会有一些小问题，具体用法再这里总结一下。 以下面这个例子为代表
```java
     public class Person<E> {
      public <T> Person(T t) {
      System.out.println(t);
      }
      }
```
 

- 正确用法：
```java
 public static void main(String[] args) {
  Person<String> person = new Person("sss");
  }

```

- PS：编译器会提醒你怎么做的
###  2.6 通配符
####  2.6.1<? extends T> 上界通配符
- 上界通配符顾名思义，<? extends T>表示的是类型的上界【包含自身】，因此通配的参数化类型可能是T或T的子类。
```java
  //它表示集合中的所有元素都是Animal类型或者其子类
  List<? extends Animal>
```

  这就是所谓的上限通配符，使用关键字extends来实现，实例化时，指定类型实参只能是extends后类型的子类或其本身。
  例如：
  这样就确定集合中元素的类型，虽然不确定具体的类型，但最起码知道其父类。然后进行其他操作。
```java
  //Cat是其子类
  List<? extends Animal> list = new ArrayList<Cat>();
```

####  2.6.2 <? super T> 下界通配符
- 下界通配符<? super T>表示的是参数化类型是T的超类型（包含自身），层层至上，直至Object
```java
  它表示集合中的所有元素都是Cat类型或者其父类
  List <? super Cat>
```

- 这就是所谓的下限通配符，使用关键字super来实现，实例化时，指定类型实参只能是extends后类型的子类或其本身
```java
      //Animal是其父类
      List<? super Cat> list = new ArrayList<Animal>();
```

## 3.基础总结
学到这里，大家Java基础的部分已经学习完成了，再往后的课程就是学习一些数据库的知识和一些框架的知识，学习了这些知识过后大家的开发能力会迅速提高，而后面的课程内容难度也会略微提高，所以这里给大家小小的总结一下前面学习的知识。
### 3.1语言基础
语言基础这部分给大家入了一下门
- 基础语法
- 注释
- 数据类型
- 访问修饰符
- 运算符
- 条件控制
- 数组
####  3.2面向对象基础
- 面向对象的概念
- 类与对象
- 封装
- 继承
- 多态
####  3.3面向对象进阶
- final、static关键字
- 抽象类
- 接口
- lambda表达式
- 内部类
 #### 3.4异常处理、IO、多线程、反射
- 异常
- IO流
- 线程、进程
- 线程池
- 反射
#### 3.5集合框架、泛型

##  作业：
  Level1:

  复习Java基础的内容，为后面学习打下基础。（无需提交）

  Level2:

  [二叉树的所有路径](https://lanshanteam.feishu.cn/docx/HTNNd8QejoyvI1xjdU4c0XbVnMd#part-Y8QJdb9YKoaANNxUglncVnRZnIe)
  [最大正方形](https://lanshanteam.feishu.cn/docx/HTNNd8QejoyvI1xjdU4c0XbVnMd#part-ShlLdn6TjoDJpVx8EbmcpMplnQh)
