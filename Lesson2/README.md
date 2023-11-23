# :heart_eyes:  2023蓝山工作室Java方向第二课: 面向对象基础

## 面向对象的概念

面向对象编程（Object-Oriented Programming，OOP）是一种程序设计范式，它将程序中的数据和操作数据的方法封装成对象，以实现更清晰、模块化和可维护的代码。

## Java面向对象的关键概念

- **类（Class）**：类是Java中面向对象编程的基本构建块。它是一个模板或蓝图，描述了对象的属性（字段）和行为（方法）。类定义了对象的结构。

- **对象（Object）**：对象是类的实例。它是类的具体实体，可以通过类创建多个对象。每个对象都有自己的状态（由字段表示）和行为（由方法表示）。

- **封装（Encapsulation）**：封装是面向对象编程的核心原则之一。它指的是将数据和操作数据的方法封装在一个类中，通过访问修饰符（如private、public、protected）控制对类内部数据的访问，确保数据的安全性和一致性。

- **继承（Inheritance）**：继承允许一个类（子类或派生类）继承另一个类（父类或基类）的属性和方法。这促进了代码重用和层次化的设计。

- **多态（Polymorphism）**：多态允许不同的对象对同一个消息作出不同的响应。它可以通过方法重载（overloading）和方法重写（overriding）来实现。

- **抽象（Abstraction）**：抽象是一种简化复杂系统的方法，通过隐藏不必要的细节，只展示必要的部分。在Java中，抽象类和接口是实现抽象的机制。

- **接口（Interface）**：接口定义了一组方法的规范，但不提供方法的实现细节。类可以实现一个或多个接口， 以便具备接口规定的行为。

- **构造函数（Constructor）**：构造函数是一种特殊的方法，用于创建对象时初始化对象的状态。每个类可以有一个或多个构造函数。

- **方法（Method）**：方法是类中定义的操作，它们用于执行特定的任务或操作对象的数据。方法定义了对象的行为。

- **包（Package）**：包是Java中用于组织和管理类的一种方式。它可以将相关的类放在一个命名空间下，以避免命名冲突。

  本节课因为是基础咱就不讲太多,简单讲讲其中的几个概念就行,有兴趣的同学可以提前去了解哦。

## 类与对象

### 类的创建

- **类**: 类是一个模板,它描述了一类对象的行为和状态。例如，狗就是一个类，它的属性有：颜色、名字、品种；行为有：摇尾巴、叫、吃等。

- **对象**: 对象就是一个类的实例(instance),有行为和属性。比如旺财。

  > 所以说，类就是抽象概念的狗，而对象，就是具体的某一条狗。

  在Java编程中，我们会先抽象出一个类，然后再进一步的创建出这个类的实例，这样的编程方式也就是面向对象编程。


### 类与对象的创建

### 类的创建

#### 属性

我们右键对应目录创建一个名为Dog的类，然后再为其添加一些**属性**

```java
public class Dog {
    //名字
    String name;
    //年龄
    int age;
    //颜色
    String color;
}
```

#### 行为

然后是狗的一些行为

```java
public class Dog {
    //名字
    String name;
    //年龄
    int age;
    //颜色
    String color;
    
    //吃
    void eat() {
    }

    //跑
    void run() {
    }

    //睡
    void sleep(){
    }
    
}
```

在这我们可以看见，类的属性以**成员变量**的方式定义在类中，然后用**方法**来为这个类增加行为

##### 方法

这里插播一条小知识

###### 方法的定义

```
修饰符 返回值类型 方法名(参数类型 参数名){
    ...
    方法体
    ...
    return 返回值;
}
```

- **修饰符：**修饰符，`这是可选的`，告诉编译器如何调用该方法。定义了该方法的访问类型。
- **返回值类型 ：**方法可能会有返回值。returnValueType 是方法返回值的数据类型。有些方法执行所需的操作，不需要返回值。在这种情况下，returnValueType 是关键字**void**。
- **方法名：**是方法的实际名称。方法名和参数表共同构成方法签名。
- **参数类型：**参数像是一个占位符。当方法被调用时，传递值给参数。这个值被称为实参或变量。参数列表是指方法的参数类型、顺序和参数的个数。参数是可选的，方法可以不包含任何参数。
- **方法体：**方法体包含具体的语句，定义该方法的功能。

`TIPS:方法名称同样可以随便起，但是规则跟变量的命名差不多，也是尽量使用小写字母开头的单词，如果是多个单词，一般使用驼峰命名法最规范。`

###### return

关于`return`关键字，我们还需要进行进一步的介绍。

 `return` 关键字具有以下两种用途:

- 返回值：
  当一个方法声明了返回类型时，必须使用 `return` 关键字返回一个与该类型兼容的值。返回值可以是基本类型、对象或者 `null`。

  ```java
  public int add(int a, int b) {
      return a + b; // 返回两个数的和作为方法的返回值
  }
  ```

- 方法终止：
  `return` 关键字会终止方法的执行，即在方法中的某个位置直接返回,则方法会直接终止。利用这个特性也可以提前结束方法的执行，跳出方法体。

  ```java
  public void printNumbers() {
      for (int i = 0; i < 10; i++) {
          if (i == 5) {
              return; // 当 i 等于 5 时，直接返回，跳出方法体
          }
          System.out.println(i);
      }
      return;
  }
  ```
  
  `需要注意的是，return 关键字只能在方法内部使用，不能在类的构造函数或静态代码块中使用。同时，如果方法声明了返回类型，那么在方法的所有执行路径上都必须包含返回语句，以保证方法总是返回一个值。`
  
  以下是一些关于 `return` 关键字的注意事项：
  
  > - 在一个方法中，可以有多个 `return` 语句。但是，只有其中一个 `return` 语句会被执行，其余的 `return` 语句都将被忽略。
  >
  > - 如果一个方法声明了返回类型，但没有在所有执行路径上包含返回语句，编译器会报错。
  >
  >   `实际上如果方法过于复杂编译器在编译时可能会无法确认该执行路径是否有return,但是在运行过程中执行改路径会抛出一个编译器无法捕获的异常,所以规范代码是非常有必要的`
  >
  > - `return` 关键字也可以在条件语句中使用，例如在 `if` 或 `switch` 语句中根据条件返回不同的值。
  >
  > - 当方法返回类型为 `void` 时，表示方法不返回任何值，但可以使用 `return` 关键字来提前结束方法的执行。
  > - 在一条执行路径中return后面是"不可达到的地方"，所以说在这之后不能编写的任何代码。

#### 构造方法

然后我们再为这个类添加**构造方法**

```java
public class Dog {
    //名字
    String name;
    //年龄
    int age;
    //颜色
    String color;
    
    //吃
     void eat() {
    }

    //跑
    void run() {
    }

    //睡
    void sleep(){
    }
    
    //无参构造方法
   	public Dog() {}  

    //全参构造方法
    public Dog(String name, int age, String color) {   
        this.name = name;
        this.age = age;
        this.color = color;
    }
    
}
```

那么这个构造方法是干什么的呢??

###### 构造方法

此处我们介绍一个概念:**构造方法**。每个类都有构造方法。如果没有显式地为类定义构造方法，Java 编译器将会为该类提供一个默认构造方法。在**创建一个对象**的时候，至少要调用一个构造方法。构造方法的名称必须与类同名，一个类可以有多个构造方法。

我们创建一个显式声明无参构造函数的类，以及一个没有显式声明构造函数的类。

```java
class Cat{
    public Cat(){}
}
class CatAuto{}
```

然后我们编译一下，得到它们的字节码：

![resource/pic/20200307223834219.png](https://image-9h8.pages.dev/file/343ffd6b4daeb84ea918a.png)

我们可以看到，在没有写构造函数时，编译器会自动调用一个无参构造函数。

###### this

眼见的同学可能发现了，在全参构造方法中有一个this.×××。

大部分时候，普通方法访问其他方法、成员变量时无须使用 this 前缀，但如果方法里有个局部变量和成员变量同名，但程序又需要在该方法里访问这个被覆盖的成员变量，则必须使用 this 前缀。

就那这个构造方法来举例:

```java
this.color = color;
```

很明显这里是用调用函数是传入的color为这个类的color变量赋值，但是对于编译器来说，如果直接写成color = color，就有可能分不清哪个是color，哪个是color。

这个时候this就可以分别开这两个同名变量。

`ps:了解C++的同学可能能更好的理解这个this`

<span id="jump">跳转到的地方</span>

### 对象的创建与使用

#### 对象的创建方法

对象是根据类创建的。在Java中，使用关键字 new 来创建一个新的对象。创建对象需要以下三步：

- **声明**：声明一个对象，包括对象名称和对象类型。
- **实例化**：使用关键字 new 来创建一个对象。
- **初始化**：使用 new 创建对象时，会调用构造方法初始化对象。

那么介绍完构造方法后我们就可以正式开始创造自己的小狗狗🐕啦

```java
class Application{
    public static void main(String[] args) {

        //调用无参构造方法
        Dog myFirstDog = new Dog();

        //调用全参构造方法
        Dog mySecondDog = new Dog("旺财", 3, "哈士奇", "黑白相间");
    }
    
}
```

只不过这里仅仅是创建出了这样的一个对象，我们目前没有办法去操作这个对象，比如想要修改或是获取这个人的名字等等。既然现在我们知道如何创建对象，那么我们怎么去访问这个对象呢，比如我现在想要去查看或是修改它的名字。

```java
    //所有属性的getter和setter方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
```

这样我们就可以自由的获得和修改你创建的小狗狗的值了，就像这样：

```java
myFirstDog.setAge(2);
System.out.println(myFirstDog.getAge());
```

##  封装、继承和多态 

封装（Encapsulation）、继承（Inheritance）和多态（Polymorphism）是面向对象编程的三大特性。

- 封装，把对象的属性和方法结合成一个独立的整体，隐藏实现细节，并提供对外访问的接口。

- 继承，从已知的一个类中派生出一个新的类，叫子类。子类实现了父类所有非私有化的属性和方法，并根据实际需求扩展出新的行为。

- 多态，多个不同的对象对同一消息作出响应，同一消息根据不同的对象而采用各种不同的方法。

正是这三大特性，让我们的Java程序更加生动形象。

### 类的封装 

封装是将数据和操作数据的方法捆绑在一起的机制。通过封装，对象的内部状态和行为被隐藏起来，只对外部提供必要的访问接口。也就是说，封装思想其实就是把实现细节给隐藏了，外部只需知道这个方法是什么作用，而无需关心实现，要用什么由类自己来做，不需要外面来操作类内部的东西去完成。这样可以保证数据的安全性和一致性，并提高代码的可维护性和可复用性。封装就是通过访问权限控制来实现的。在Java中，使用访问修饰符（如`private`、`protected`、`public`）来控制对类的成员的访问权限，同时提供公共的方法（getter和setter）来对数据进行操作。

![resource\pic\20180702151647232.png](https://image-9h8.pages.dev/file/600978f3d00b841adb776.png)

`其实常用到的也就private和public`

这个时候我们就可以改进之前我们写的Dog类了:

```java
public class Dog {
    //名字
    private String name;
    //年龄
    private int age;
    //颜色
    private String color;
    
    //...
}
```

我们甚至还可以将构造方法改成私有的，需要通过我们的内部的方式来构造对象，通过这种方式，我们可以实现单例模式。不过单例模式就不是我们今天的重点，感兴趣的小伙伴可以自己下去了解哦。

### 类的继承

继承是一种通过创建新类来扩展现有类的机制。**子类**（派生类）继承**父类**（基类）的属性和方法，并可以添加新的属性和方法。通过继承，可以实现代码的重用和层次化的组织。子类可以继承父类的**非私有**成员，并可以通过方法的覆盖（重写）来改变父类的行为。Java中使用关键字 `extends` 来实现继承关系。

比如说我们一开始创建的狗类，根据种类，我们可以将这个大类进一步地细分出来，例如：柯基类，柴犬类。实际上这些划分出来的类，本质上还是狗类，也就是说狗类具有的属性，这些划分出来的类同样具有，但是，这些划分出来的类同时也会拥有他们自己独特的属性和技能。

让我们先抽象出一个狗类:

```java
public class Dog {
    //狗的名字
    private String name;
    //狗的颜色
    private String colour;
    //狗的年龄
    private int age;

    void eat() {
        System.out.println("狗吃");
    }

    void run() {
        System.out.println("狗跑");
    }

    void sleep(){
        System.out.println("狗睡");
    }
```

然后再创建一个哈士奇类继承狗类，这个时候便要用到关键字`extends`了:

```java
public class Husky extends Dog{
    
}
```

**类的继承可以不断向下，但是同时只能继承一个类，同时，标记为final的类不允许被继承**

当一个类继承另一个类时，属性会被继承，可以直接访问父类中定义的属性，除非父类中将属性的访问权限修改为`private`，那么子类将无法访问（但是依然是继承了这个属性的）。

同样的，在父类中定义的方法同样会被子类继承。子类直接获得了此方法，当我们创建一个子类对象时就可以直接使用这个方法。

是不是感觉非常人性化，子类继承了父类的全部能力，同时还可以[扩展自己的独特能力，就像一句话说的： 龙生龙凤生凤，老鼠儿子会打洞。

我们来尝试使用一些哈士奇类

```java
Husky husky = new Husky();
husky.eat();
```

![resource/pic/112201.png](https://image-9h8.pages.dev/file/b8f3f30656274c8c9ede4.png)

#### 方法重写

这个时候我们也可以重写eat()方法

```java
public class Husky extends Dog{
    public void eat(){
        System.out.println("Husky is eating");
    }
}
```

这个时候控制台打印的便是

![resource/pic/112806.png](https://image-9h8.pages.dev/file/d483c427fe4e24dc08ded.png)

- 我们如果不希望子类重写某个方法，我们可以在方法前添加`final`关键字，表示这个方法已经是最终形态

- 如果父类中方法的可见性为`private`，那么子类同样无法访问，也就不能重写，但是可以定义同名方法

- 我们在重写父类方法时，如果希望调用父类原本的方法实现，那么同样可以使用`super`关键字

- 然后就是访问权限的问题，子类在重写父类方法时，不能降低父类方法中的可见性

  > 因为子类实际上可以当做父类使用，如果子类的访问权限比父类还低，那么在被当做父类使用时，就可能出现无视访问权限调用的情况，这样肯定是不行的，但是相反的，我们可以在子类中提升权限

##### final

`final` 在 Java 中是一个保留的关键字，可以声明成员变量、方法、类以及本地变量。一旦你将引用声明作 final，你将不能改变这个引用了，编译器会检查代码，如果试图将变量再次初始化的话，编译器会报编译错误。

`final` 的使用可以带来以下好处：

- 安全性：通过将变量声明为 `final`，可以防止其被修改，确保其值的不变性。
- 可读性：在代码中使用 `final` 可以提供更清晰的意图，说明某个变量、方法或类的用途和设计意图。
- 优化：`final` 可以帮助编译器进行优化，例如内联常量，避免方法的动态绑定等。

#### 抽象

##### 抽象类

在刚刚写父类的时候实际上已经提到了`抽象`这个词，在了解继承的过程中，我们就可以发现，越是子类的行为和属性就也具体，相反，越是处于顶层定义的类，实际上可以进一步地进行抽象，比如狗类上还有动物类。

在面向对象的概念中，所有的对象都是通过类来描绘的，但是反过来，并不是所有的类都是用来描绘对象的，如果一个类中没有包含足够的信息来描绘一个具体的对象，这样的类就是抽象类。

`实际上我觉得这句话都很抽象`

说直白一点就是抽象的类不能被**实例化**成一个对象。

由于抽象类不能实例化对象，所以抽象类必须被继承，才能被使用。也是因为这个原因，通常在设计阶段决定要不要设计抽象类。

父类包含了子类集合的常见的方法，但是由于父类本身是抽象的，所以不能使用这些方法。

在 Java 语言中使用 `abstract` 关键字来定义抽象类。比如我们把刚刚的Dog类改为抽象类:

```java
public abstract class Dog {
    //狗的名字
    private String name;
    //狗的颜色
    private String colour;
    //狗的年龄
    private int age;

    void eat() {
        System.out.println("狗吃");
    }

    void run() {
        System.out.println("狗跑");
    }

    void sleep(){
        System.out.println("狗睡");
    }
```

这个时候我们再去看我们main方法中对Dog的实例化过程发现语句会报错。

```
'Dog' 为 abstract；无法实例化
```

但是Dog的子类Husky的实例化过程还是正常的。

##### 抽象方法

如果你想设计这样一个类，该类包含一个特别的成员方法，该方法的具体实现由它的子类确定，那么你可以在父类中声明该方法为抽象方法。

`abstract` 关键字同样可以用来声明`抽象方法`，抽象方法只包含一个方法名，而没有方法体。

**TIPS:抽象方法的访问权限不能为private**

> 因为抽象方法一定要由子类实现，如果子类都访问不了，那么还有什么意义呢？所以说不能为私有。

###### 抽象类总结规定

>- 抽象类不能被实例化(初学者很容易犯的错)，如果被实例化，就会报错，编译无法通过。只有抽象类的非抽象子类可以创建对象。
>- 抽象类中不一定包含抽象方法，但是有抽象方法的类必定是抽象类。
>- 抽象类中的抽象方法只是声明，不包含方法体，就是不给出方法的具体实现也就是方法的具体功能。
>- 构造方法，类方法（用 static 修饰的方法）不能声明为抽象方法。
>- 抽象类的子类必须给出抽象类中的抽象方法的具体实现，除非该子类也是抽象类。

##### 方法重载

`方法重载`（Method Overloading）是指在一个类中定义多个方法，它们具有相同的名称但不同的参数列表。方法重载允许在同一个类中使用相同的方法名来执行不同的操作，根据传递给方法的参数的类型、个数和顺序来确定要调用的具体的方法。

方法重载的特点如下：

- 方法名称相同：重载的方法必须具有相同的名称。

- 参数列表不同：重载的方法的参数列表必须不同，可以是参数的类型、个数或顺序的不同。

- 返回类型可以不同：重载的方法的返回类型可以相同也可以不同，但仅根据返回类型不能区分重载方法。

  `这里需要注意的是:仅返回类型不同，是不允许的！`

  ```java
  public class Calculator {
      public int add(int a, int b) {
          return a + b;
      }
  
      public double add(double a, double b) {
          return a + b;
      }
  
      public int add(int a, int b, int c) {
          return a + b + c;
      }
  }
  ```

  让我们在主函数里面尝试使用一下

  ```java
          int a = 1;
          int b = 2;
          double c = 1.1;
          double d = 2.2;
          int e = 3;
          Calculator calculator = new Calculator();
          System.out.println(calculator.add(a, b));
          System.out.println(calculator.add(c, d));
          System.out.println(calculator.add(a, b, e));
  ```

  输出的内容为:

  ```
  3
  3.3000000000000003
  6
  ```

  `返回两个浮点数的和，即 `1.1 + 2.2 = 3.3000000000000003`。这里的结果可能出现精度误差，是由于浮点数的内部表示方式导致的。有兴趣的同学可以自己去了解一些，这里就不做过多解释了`

### 多态

`多态`（Polymorphism）是面向对象最重要的特性。你将了解到**多态的实现条件**、**什么是向上转型**以及**什么是向下转型**，并学会使用`instanceof`运算符来检查对象引用是否是类型的实例。

#### 概念和特点

多态是指对象在不同情境下表现出不同的行为。在Java中，多态性允许使用基类类型的引用变量来引用派生类的对象。这样可以在运行时根据**实际对象的类型**选择执行对应的方法。多态性通过**方法的重写**和**方法的重载**来实现。方法的重写是子类对父类方法的重新定义，而方法的重载是在同一个类中根据不同的参数列表来定义多个方法。

例如，火车类和飞机类都继承自交通工具类，这些类下都有各自的`start()`方法，交通工具的`start()`方法输出交通工具可以运输，而火车的`start()`方法输出火车会跑，飞机的`start()`方法则输出飞机会飞，火车和飞机都继承父类的`start()`方法，但是对于不同的对象，拥有不同的操作。

#### 多态的实现

在 Java 中，多态性主要通过以下两种机制实现：

- 方法重写（Method Overriding）：子类可以覆盖（重写）父类的方法，以提供自己的实现。子类中重写的方法具有相同的方法签名（方法名称、参数列表和返回类型），通过 `@Override` 注解来标识。在程序中，通过父类引用指向子类对象时，可以根据实际对象的类型来调用相应的方法。这种多态性称为动态绑定或运行时多态。例如：

  `注解相关知识暂时可以不了解,在后续课程中我们会讲到,在这里提一下让大家眼熟眼熟`

```java
class Animal {
    public void makeSound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {
    //注解相关知识暂时可以不了解,在后续课程中我们会讲到,这里的注解删除也不会影响程序的运行
    @Override  
    public void makeSound() {
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog(); // 父类引用指向子类对象
        animal.makeSound(); // 调用的是 Dog 类中重写的方法
    }
}
```

输出结果为:

```
Dog barks
```

在这里我们便可以看出，多态的实现有以下三种必要的条件

>1. 满足继承关系
>2. 要有重写
>3. 父类引用指向子类对象

- 接口回调（Interface Callback）：接口回调的实现基于接口的多态性。一个类可以实现一个接口，并将自身的实例作为接口类型的参数传递给其他对象，使得其他对象能够调用该类所实现的接口方法。这样，通过接口回调，可以在运行时动态地确定实际执行的代码。

  例如:

  ```java
  // 定义一个接口
  interface Callback {
      void onCallback();
  }
  
  // 实现接口的类
  class MyClass implements Callback {
      @Override
      public void onCallback() {
          System.out.println("Callback called in MyClass");
      }
  }
  
  // 使用接口回调的类
  class AnotherClass {
      void performCallback(Callback callback) {
          callback.onCallback();
      }
  }
  
  public class Main {
      public static void main(String[] args) {
          MyClass myObject = new MyClass();
          AnotherClass anotherObject = new AnotherClass();
  
          // 将 MyObject 的实例作为 Callback 类型的参数传递给 AnotherClass
          anotherObject.performCallback(myObject);
      }
  }
  ```

  `由于接口并不是本节课讲的内容,所以暂时只给出事例就不做过多讲述了,我们将在面对对象进阶课程中正式接触到接口（Interface）,这里看看就行,等后面我们在细索`

#### 向上转型

`向上转型`又称为自动转型、隐式转型。向上转型就是父类引用指向子类实例，也就是子类的对象可以赋值给父类对象。例如：

```java
class Animal {
    public void makeSound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog(); // 向上转型，将子类对象赋值给父类类型的引用变量
        animal.makeSound(); // 调用的是 Dog 类中重写的方法
    }
}
```

这个是因为`Dog`类继承自`Animal`类，它拥有父类`Animal`的全部功能，所以如果`Animal`类型的变量指向了其子类`Dog`的实例，是不会出现问题的。

向上转型实际上是把一个子类型安全地变成了更加**抽象**的父类型，由于所有类的根类都是`Object`，所以我们也把子类类型转换为`Object`类型：

```java
Cat cat = new Cat();
Object o = cat;
```

#### 向下转型

向下转型必须满足以下的两个条件：

>- 原始对象必须是向上转型所得到的父类对象。
>
>- 转型操作必须是安全的，即原始对象的实际类型必须是转型后的类型。

例如:

```java
class Animal {
    public void makeSound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
    
    public void fetch() {
        System.out.println("Dog fetches");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog(); // 向上转型，将子类对象赋值给父类类型的引用变量
        animal.makeSound(); // 调用的是 Dog 类中重写的方法
        
        if (animal instanceof Dog) {
            Dog dog = (Dog) animal; // 向下转型，将父类引用变量转换为子类类型的引用变量
            dog.fetch(); // 调用子类特有的方法
        }
    }
}
```

输出结果:

```
Dog barks
Dog fetches
```

向下转型可以访问子类特有的成员和方法，但需要注意以下几点：

- 如果尝试将一个父类对象转型为与之无关的子类类型，会在运行时抛出 `ClassCastException` 异常。

- 在进行向下转型之前，应该使用 `instanceof` 运算符进行类型检查，以确保转型的安全性。

- 向下转型是一种显式操作，需要开发人员明确指定。

如果在进行向下转型之前没有进行类型检查，而直接进行转型，如果原始对象的实际类型与转型后的类型不兼容，将会在运行时抛出 `ClassCastException` 异常。

#### instanceof 运算符

`instanceof` 是一个运算符，用于检查一个对象是否是某个类的实例或者实现了某个接口。它的语法形式如下：

```
对象 instanceof 类/接口
```

其中，`对象` 是待检查的对象，`类/接口` 是要检查的类或接口的类型。

`instanceof` 运算符返回一个布尔值，如果对象是指定类的实例或者实现了指定接口，返回 `true`；否则，返回 `false`。

`instanceof` 运算符通常用于以下场景：

- 类型检查：判断一个对象是否是某个具体类的实例。

 ```java
  Animal animal = new Dog();
  if (animal instanceof Dog) {
      // 对象是 Dog 类的实例
  }
 ```

  

- 向下转型前的类型检查：在进行向下转型之前，使用 `instanceof` 运算符检查对象的类型，以确保转型的安全性。

 ```java
  Animal animal = new Animal();
  if (animal instanceof Dog) {
      Dog dog = (Dog) animal; // 向下转型
      // 执行基于 Dog 类型的操作
  }
 ```

  

- 接口的实现检查：判断一个对象是否实现了某个接口。

 ```java
  class MyClass implements MyInterface {
      // 类的实现代码
  }
  
  MyClass obj = new MyClass();
  if (obj instanceof MyInterface) {
      // 对象实现了 MyInterface 接口
  }
 ```

  

使用 `instanceof` 运算符可以在运行时根据对象的实际类型进行条件判断。它可以避免类型转换的错误和异常，并增加程序的安全性和灵活性。

需要注意的是，`instanceof` 运算符也可以用于判断对象是否是其父类或祖先类的实例。例如，如果一个对象是某个类的实例，那么它一定也是该类的父类或祖先类的实例。

# 课后学习指南[doge]

## Level 1

> 写一个自己的动物园吧！运用以上讲解的和自己课后自学的关于面向对象的知识点来写一个自己的动物园吧！多用，多学，才能多会嘛。

`TIPS：可以不按照我的提示创建自己的动物园哦`

**提示**

- 声明一个抽象类`Pet`，封装属性`name`和`sex`，声明一个带有两个参数的构造函数，声明抽象方法`void talk()`和`void eat()`；
- 声明一个`Dog`类继承自`Pet`，封装属性`color`，声明带有三个参数的构造函数，复写`talk()`和`eat()`方法；
- 声明一个`Cat`类继承自`Pet`，封装属性`weight`，声明带有三个参数的构造函数，复写`talk()`和`eat()`方法；
- 编写测试类，通过有参构造函数实例化`Dog`类对象，调用`talk()`方法和`eat()`方法；通过有参构造函数实例化`Cat`类对象 ，调用`talk()`方法和`eat()`方法；
- 在各自的动物子类定义定义一个自己特有的方法



## Level 2

> 做一个属于自己的英雄联盟吧（如果有同学没玩过的话，就做个自己熟悉的游戏也行）
>
> 要求：
>
> - 简单的类的创建
> - 类的属性可以包括但并不下限于：血量，蓝条，装备，攻击力，防御力，敏捷
> - 将英雄之间的战斗做成回合制游戏，(可以while循环实现)
> - 任何你所想的到的功能，尽可能的花哨
