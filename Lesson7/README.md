# 蓝山工作室第七节课：SpringBoot（上）

> #### **为什么要学习springboot？他是什么？他是拿来干嘛的？跟spring？有什么关系？（这节课偏理论知识多一点，主要带大家了解）接下来我会为大家一一介绍：**

![img](https://github.com/LanshanTeam/Courseware-Backend-Java-2023/blob/dalaoshi/Lesson7/Resource/img/OIP%20(1).jpg)

## **一、前置知识**

> ### 学习springboot之前，我们还得先了解了解两样东西：**maven**和spring

#### 1.maven：

##### **1.1 大家在创建项目时一定有看到过这个：（不知道大家有没有对这个产生过疑惑或者是去搜一搜这是个什么东西）**

![img](https://github.com/LanshanTeam/Courseware-Backend-Java-2023/blob/dalaoshi/Lesson7/Resource/img/o4zvi5f9nl.png)

**idea中自带****maven****构建工具不需要我们再下载导入**

##### **1.2 那么他是来干嘛的呢：**

Maven是一个[项目管理工具](https://cloud.tencent.com/product/coding-pm?from_column=20065&from=20065)，它包含了一个对象模型。一组标准集合，一个依赖管理系统。和用来运行定义在生命周期阶段中插件目标和逻辑。

**核心功能**： Maven的核心功能是合理叙述项目间的依赖关系，通俗点 就是通过pom.xml文件的配置获 取jar包不用手动的去添加jar包，，这个pom.xml包我        后面会叙述，不过已经学习过maven的 人应该对这个很熟悉。其本质就是通过配置pom.xml来获取jar包，当然这是在该项目必须是maven项目的前提下。

（那么什么是maven项目？上节课我们是不是学过mysql，那我们要如何把他运用到我们的项目中来呢？就是通过maven的整合，接着往下看吧)

##### **1.3 先举个栗子给大家看看：**

通过上个步骤建立好maven的项目之后呢我们打开它，会发现我们左边的文件栏中多了一个：

![img](https://github.com/LanshanTeam/Courseware-Backend-Java-2023/blob/dalaoshi/Lesson7/Resource/img/s5sxszzx2h.png)

这样的文件，这个文件pom.xml就是整个maven项目中最核心的文件了：POM全程*Project Object Model*，又称**项目对象模型**。他是Maven工程的基本工作单元，是一个XML（可扩展标记语言）文件，包含了项目的基本信息，用于描述项目如何构建，声明项目依赖等等。执行任务或目标时，Maven会在当前目录 中查找 POM并读取从而获取所需的配置信息执行目标，属于项目级别的配置文件。

总之pom最厉害的是提供一站式支持，可用于管理：源代码、配置文件、缺陷跟踪系统（defect tracking system）、组织和许可证（licenses）、项目所在的URL地址、开发者的信息和角色、项目依赖以及其他所有的和代码生命周期相关的方面。而在Maven中就只需要一个pom.xml文件，可以说pom.xml就是Maven的核心！

文件里的具体内容：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!--project是pom.xml根元素，它包含了pom.xml的一些约束信息，声明了一些POM相关的命名空间以及xsd元素-->
<!-- xmlns  命名空间，类似包名-->
<!-- xmlns:xsi        xml遵循的标签规范-->
<!--xsi:schemaLocation        定义xmlschema的地址，xml书写时需要遵循的语法-->
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <!-- 指定了当前pom.xml版本，目前固定为4.0.0版本。-->
    <modelVersion>4.0.0</modelVersion>
    <!--  坐标  -->
    <!--  属于哪个组，一般是项目所在组织或公司域名的倒序  -->
    <groupId>org.dalaoshi</groupId>
    <!--  定义当前项目在组中的唯一ID，一个groupId下面可能多个项目，就是靠artifactId来区分的 -->
    <artifactId>maven_test</artifactId>
    <!--  定义项目当前的版本  -->
    <version>1.0-SNAPSHOT</version>
    <!--  打包类型，可取值：pom , jar , maven-plugin , ejb , war , ear , rar , par等等  -->
    <packaging>jar</packaging>
    
    <!--  项目的名称（可省略） 默认artifactId，可修改为用户友好的名称 -->
    <name>test</name>
    <!--  仓库的地址（可省略）  -->
    <url>http://maven.apache.org</url>
 
 
    <!--  定义的属性变量，在其他地方进行使用  -->
    <properties>
        <!--java版本 -->
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
        <!--字符集-->
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>
   <!--定义的依赖清单，有所依赖包都需要写在这个标签里面-->
   <dependencies>
        <dependency>
            
        </dependency>
    </dependencies>
</project>
```

这些是idea会给我们自动生成出来的东西，大家需要了解是些什么，而需要我们主要编写的如下：

```xml
 <!--定义的依赖清单，有所依赖包都需要写在这个标签里面-->
    <dependencies>
        <!--具体的依赖 -->
        <dependency>
           <!--项目依赖的组织名 -->
           <groupId>org.projectlombok</groupId>
           <!--项目名-->
           <artifactId>lombok</artifactId>
           <!--项目版本号-->
           <version>1.18.30</version>
        </dependency>
        
        <!--整合mysql -->
        <dependency>
           <groupId>mysql</groupId>
           <artifactId>mysql-connector-java</artifactId>
           <version>8.0.27</version>
        </dependency>
        
    </dependencies>
```

##### 1.4  dependencies的作用：**Maven**的依赖管理

![img](https://github.com/LanshanTeam/Courseware-Backend-Java-2023/blob/dalaoshi/Lesson7/Resource/img/tnvtn2je4g.png)

相当于帮我们做了导入jar包的工作，在我们创建项目并想要使用一些技术栈时（例如mysql）需要对应的jar包才能使用里面的方法，而有了maven过后，我们不必再去官网下载对相应的jar包整合到我们的代码中，而是maven通过<dependencies></dependencies>这样的工具帮助我们完成了这样一项繁琐的工作，降低了我们开发的时间成本，可以说是java宇宙中一项伟大的发明，也为后面spring奠定了基础（扯多了）。

##### 1.5 项目的声明周期

![img](https://github.com/LanshanTeam/Courseware-Backend-Java-2023/blob/dalaoshi/Lesson7/Resource/img/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202023-12-04%20092918.png)

maven 通过执行一些简单命令即可实现上边生命周期的各各过程，比如执行 mvn compile 执行编译、

执行 mvn clean 执行清理等等。

导入maven后右边菜单栏也可以看到这些快捷操作的按键，不需要去cmd写命令行

![img](https://github.com/LanshanTeam/Courseware-Backend-Java-2023/blob/dalaoshi/Lesson7/Resource/img/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202023-12-04%20093628.png)
例如写完项目打包这些，直接在上面点点点操作就完了 O.o ;

##### 1.6 maven功能：

>  **1构建工程，** **2管理jar，** **3.编译代码，** **4.自动运行单元测试，** **5.打包** **6.生成报表，** **7.部署项目，生成web站点。**

##### 1.7 maven总结：

到这里关于maven我们就讲完了，关于maven其实东西还是有很多的，但是讲到这儿基本就够用了，更多深入的东西下面用到会讲，有些没讲到的东西大家下来可以自己去了解一下（这里丢一个官网给大家，没事的话可以上去看看：[maven官网](https://maven.apache.org/)）。

**maven**项目是啥？

我们这样来理解maven项目，就是在java项目和web项目上裹了一层maven，本质上java项目还是java项目，web项目还是web项目，但是包裹了maven之后，就可以使用maven提供的一些功能，即通过pom.xml添加jar包 就像在蜜汁鸡外面裹了一层面粉油炸一下变成了炸鸡，但是他还是一只鸡

![img](https://github.com/LanshanTeam/Courseware-Backend-Java-2023/blob/dalaoshi/Lesson7/Resource/img/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202023-12-04%20103008.png)

#### 2.spring框架：

> 这里就到了这节课的重头了，当然不仅仅是这节课的重头，也是整个java学习的重中之重

###### 2.1 什么是spring框架：

关于这个概念估计都有得讲，在这里鉴于时间篇幅原因还是简单介绍一下吧：

Spring 是一个开源的 Java 应用框架，是为了解决企业级应用开发的复杂性而创建的。它提供了大量的基础设施，以便开发者可以专注于应用程序的业务逻辑而不必担心底层的框架代码。Spring 框架包括了依赖注入、面向切面编程、事务管理、数据访问、消息传递等模块（看不懂没关系，了解，后面会提到，不做重点掌握），为企业级应用开发提供了全方位的支持。Spring 框架也广泛应用于 JavaEE 开发中，成为了当今最受欢迎的 Java 框架之一。

2.1.1 老规矩：

先贴个官网出来：[spring官网](https://spring.io/)

2.1.2 为啥要叫spring（春天）：

这个很好理解，有了这玩意java就迎来了他的春天，明白重要性了么😨😨😨

###### 2.2 spring能做什么：

看看官网

![img](https://github.com/LanshanTeam/Courseware-Backend-Java-2023/blob/dalaoshi/Lesson7/Resource/img/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202023-12-04%20110814.png)

###### 2.3 spring的优点：

看看官网

![img](https://github.com/LanshanTeam/Courseware-Backend-Java-2023/blob/dalaoshi/Lesson7/Resource/img/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202023-12-04%20110903.png)

（看不懂？反正就是吹spring很🐂，看不懂上官网看翻译，养成自己去康官方文档的习惯）

###### 2.4 spring的框架：

![img](https://github.com/LanshanTeam/Courseware-Backend-Java-2023/blob/dalaoshi/Lesson7/Resource/img/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202023-12-04%20111425.png)

###### 2.5 我们要学的：

看了这么多想必都很懵逼，这么多东西？没错，spring生态就是这么庞大，构成了java开发最主要的部分，但是不用担心，这么多东西我们肯定不用学这么多的（你肯定希望我这么说/(ㄒoㄒ)/~~），当然不是，这些技术肯定是学的越多越好，想要掌握全部是很难很难的事情（学长也不行捏/(ㄒoㄒ)/~~），所以今天先带着大家入门从springboot开始。

###### 2.6 spring Framework与springboot：

2.6.1 ：spring Framework：

我们口中常说的spring其实就是上图中的Spring Framework，这是什么呢？

**广义的 Spring：Spring 技术栈**（全家桶）

广义上的 Spring 泛指以 Spring Framework 为基础的 Spring 技术栈。

经过十多年的发展，Spring 已经不再是一个单纯的应用框架，而是逐渐发展成为一个由多个不同子项目（模块）组成的成熟技术，例如 Spring Framework、Spring MVC、SpringBoot、Spring Cloud、Spring Data、Spring Security 等，其中 Spring Framework 是其他子项目的基础。

这些子项目涵盖了从企业级应用开发到云计算等各方面的内容，能够帮助开发人员解决软件发展过程中不断产生的各种实际问题，给开发人员带来了更好的开发体验。

**狭义的 Spring：**Spring Framework（基础框架）

狭义的 Spring 特指 Spring Framework，通常我们将它称为 Spring 框架。

Spring Framework（Spring框架）是一个开源的应用程序框架，由SpringSource公司开发，最初是为了解决企业级开发中各种常见问题而创建的。它提供了很多功能，例如：依赖注入（Dependency Injection）、面向切面编程（AOP）、声明式事务管理（TX）等。其主要目标是使企业级应用程序的开发变得更加简单和快速，并且Spring框架被广泛应用于Java企业开发领域。

Spring全家桶的其他框架都是以SpringFramework框架为基础！

**对比理解：**

​      QQ 和 腾讯

腾讯 = Spring

QQ = SpringFramework

2.6.2：springboot：

springboot可以从字面上来理解，他是spring的增强，也就是说springboot并不是一个新的框架，而是在spring的基础上简化了开发，做了更大的提升。**它消除了设置 Spring应用程序中最麻烦的 XML配置（后面会讲，现在作为了解总之写这个特别麻烦）为更快，更高效的开发生态系统铺平了道路。这就是springboot！**

SpringBoot的主要目标是：

- 为所有 Spring 开发提供更快速、可广泛访问的入门体验。
- 开箱即用，设置合理的默认值，但是也可以根据需求进行适当的调整。
- 提供一系列大型项目通用的非功能性程序（如嵌入式服务器、安全性、指标、运行检查等）。
- 约定大于配置，基本不需要主动编写配置类、也不需要 XML 配置文件。

**总结：简化开发，简化配置，简化整合，简化部署，简化监控，简化运维！！！。**


######  2.7 spring框架总结：

Spring 框架是一个开源的、轻量级的、模块化的 Java 应用框架，它提供了丰富的功能和强大的支持，使得企业级应用开发更加简单、高效和可靠。以下是对 Spring 框架的总结：

1. 轻量级：Spring 框架以其轻量级的特性而闻名。它不依赖于庞大的第三方库，只需要很少的配置即可启动。这使得应用程序更加灵活、快速，并且可以更好地适应各种环境。
2. 依赖注入（DI）：Spring 的核心原则之一是依赖注入。通过 DI，对象之间的依赖关系由容器来管理，而不是由开发者手动创建和管理。这样可以降低组件之间的耦合性，提高代码的可维护性和可测试性。
3. 面向切面编程（AOP）：Spring 框架支持面向切面编程，可以将与核心业务逻辑无关的横切关注点（如日志记录、事务管理等）从业务逻辑中分离出来，提高了代码的可重用性，并且使得系统的架构更加清晰。
4. 声明式事务管理：Spring 提供了强大的事务管理支持，可以通过声明式的方式来管理事务。开发者只需使用注解或 XML 配置即可定义事务的边界和行为，而无需编写冗长的事务管理代码。
5. 数据访问抽象：Spring 提供了对各种数据访问技术（如 JDBC、ORM 框架）的抽象层，使得开发者可以更加方便地进行数据库操作。它还支持对象-关系映射（ORM）工具，如 Hibernate，Mybatis，Mybatis-plus以简化与数据库的交互。
6. 模块化和可扩展性：Spring 框架采用模块化的设计，拥有许多可选的模块，开发者可以根据自己的需求选择和组合这些模块。这种灵活性使得 Spring 可以应对各种不同的场景和需求，并且具有良好的可扩展性。

总之，Spring 框架提供了一套强大的工具和功能，可以大大简化企业级应用开发的复杂性，提高开发效率和代码质量。它已经成为 Java 开发领域最流行和广泛使用的框架之一。

####  3.spring深入了解

#####  3.1 什么是框架

框架( Framework )是一个集成了基本结构、规范、设计模式、编程语言和程序库等基础组件的软件系统，它可以用来构建更高级别的应用程序。框架的设计和实现旨在解决特定领域中的常见问题，帮助开发人员更高效、更稳定地实现软件开发目标。

######  3.1.1框架的优点包括以下几点：

1. 提高开发效率：框架提供了许多预先设计好了的组件和工具，能够帮助开发人员快速进行开发。相较于传统手写代码，在框架提供的规范化环境中，开发者可以更快地实现项目的各种要求。
2. 降低开发成本：框架的提供标准化的编程语言、数据操作等代码片段，避免了重复开发的问题，降低了开发成本，提供深度优化的系统，降低了维护成本，增强了系统的可靠性。
3. 提高应用程序的稳定性：框架通常经过了很长时间的开发和测试，其中的许多组件、代码片段和设计模式都得到了验证。重复利用这些组件有助于减少bug的出现，从而提高了应用程序的稳定性。
4. 提供标准化的解决方案：框架通常是针对某个特定领域的，通过提供标准化的解决方案，可以为开发人员提供一种共同的语言和思想基础，有助于更好地沟通和协作。

######  3.1.2框架的缺点包括以下几个方面：

1. 学习成本高：框架通常具有特定的语言和编程范式。对于开发人员而言，需要花费时间学习其背后的架构、模式和逻辑，这对于新手而言可能会耗费较长时间。
2. 可能存在局限性：虽然框架提高了开发效率并可以帮助开发人员解决常见问题，但是在某些情况下，特定的应用需求可能超出框架的范围，从而导致应用程序无法满足要求。开发人员可能需要更多的控制权和自由度，同时需要在框架和应用程序之间进行权衡取舍。
3. 版本变更和兼容性问题：框架的版本发布和迭代通常会导致代码库的大规模变更，进而导致应用程序出现兼容性问题和漏洞。当框架变更时，需要考虑框架是否向下兼容，以及如何进行适当的测试、迁移和升级。
4. 架构风险：框架涉及到很多抽象和概念，如果开发者没有足够的理解和掌握其架构，可能会导致系统出现设计和架构缺陷，从而影响系统的健康性和安全性。

######  3.1.3 站在文件结构的角度理解框架，可以将框架总结：框架 = jar包+配置文件

![img](https://github.com/LanshanTeam/Courseware-Backend-Java-2023/blob/dalaoshi/Lesson7/Resource/img/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202023-12-04%20131200.png)

##### 3.2 spring主要功能模块

![img](https://github.com/LanshanTeam/Courseware-Backend-Java-2023/blob/dalaoshi/Lesson7/Resource/img/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202023-12-04%20131505.png)

![img](https://github.com/LanshanTeam/Courseware-Backend-Java-2023/blob/dalaoshi/Lesson7/Resource/img/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202023-12-04%20131514.png)

可将spring主要功能总结为：

(1) **ioc**：控制反转，把创建好的对象作为一个Bean交给spring的ioc容器统一管理

(2) **aop**：面向切面编程，不修改源码的情况下进行功能增加,事务处理等（springtx)

##### 3.3spring快速入门

上面的内容看不懂？正常，举个例子写写就会了😀😀😀

步骤一：我们先用刚刚学的maven建立一个spring工程,导入坐标依赖

```JavaScript
<dependencies>
    <!-- 启动spring创建spring工厂的方法 -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>5.0.2.RELEASE</version>
    </dependency>
    <dependency>
        <groupId>commons-logging</groupId>
        <artifactId>commons-logging</artifactId>
        <version>1.2</version>
    </dependency>
    <!--打印日志的方法 -->
    <dependency>
        <groupId>log4j</groupId>
        <artifactId>log4j</artifactId>
        <version>1.2.12</version>
    </dependency>
    <!-- 测试类的方法 -->
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.12</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

步骤二：编写实体类：

```Java
public class hello {
    public void hello() {
        System.out.println("hello world");
    }
}
```

步骤三：在resource文件下创建一个名为applicationContext.xml的xml文件

![img](https://github.com/LanshanTeam/Courseware-Backend-Java-2023/blob/dalaoshi/Lesson7/Resource/img/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202023-12-04%20140723.png)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="hello" class="org.example.pojo.hello" />
</beans>
```

步骤四：编写测试方法

```Java
import org.example.pojo.hello;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class UserServiceTest {
    //传统写法
    @Test
    public void run(){
        hello userService = new hello();
        userService.Hello();
    }
    //spring写法
    @Test
    public void run1(){
            //创建spring工厂，加载配置文件
            ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
            //获取bean对象
            hello us = (hello) ac.getBean("hello");
            //调用方法
            us.Hello();
    }
 
}
```

去运行看看这两个测试方法有什么不同吧

##### 3.4 spring总结：

首先通过maven创建工程导入我们需要用到的依赖并卸载pom文件中，然后将我们需要使用的类通过写入xml中的<bean>标签完成DI（依赖注入）统一交由ioc容器管理，这样我们在使用时只用读取bean不需要再去new一个新对象，ioc容器里会帮我们自动生成出来，我们再进行调用即可。

通过IOC，对象的创建和依赖关系的注入不再由程序员手动管理，而是由Spring容器来完成。具体来说，IOC容器会负责创建、组装和管理应用中的对象。程序员只需要配置对象之间的依赖关系，而无需关心对象的具体创建过程。Spring IOC的作用主要体现在以下几个方面：

1. 降低耦合度：通过IOC容器管理对象的依赖关系，将对象的创建和使用解耦，降低了组件之间的耦合度。这使得代码更加灵活、可维护和可扩展。
2. 简化配置：通过IOC容器，可以通过配置文件或注解来定义对象的依赖关系，而不是通过硬编码在代码中创建对象和设置依赖关系。这样可以使配置更加灵活，便于修改和管理。
3. 提高可测试性：由于IOC容器管理对象的依赖关系，可以方便地进行单元测试。可以通过替换依赖的对象来进行测试，而无需修改代码。
4. 实现AOP（Aspect-Oriented Programming，面向切面编程）：IOC容器为实现AOP（这里就不多讲了，感兴趣的自己下去了解）提供了基础。通过配置切面和通知，可以在对象的方法执行前后添加额外的逻辑，如日志记录、事务管理等。

## 二、正式课程：

（看了这么多正式课程终于开始了）

### 1.直接开始：

第一步：还是用maven构建项目

第二步：添加父工程

SpringBoot可以帮我们方便的管理项目依赖 , 在Spring Boot提供了一个名为spring-boot-starter-parent的工程，里面已经对各种常用依赖的版本进行了管理，我们的项目需要以这个项目为父工程，这样我们就不用操心依赖的版本问题了，需要什么依赖，直接引入坐标(不需要添加版本)即可！

```xml
<!--所有springboot项目都必须继承自 spring-boot-starter-parent-->
<!--注意添加在<dependencies>外面,是一个单独的标签 -->
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>3.0.5</version>
</parent>
```

第三步：添加web启动器

为了让Spring Boot帮我们完成各种自动配置，我们必须引入Spring Boot提供的自动配置依赖，我们称为启动器。因为我们是web项目，这里我们引入web启动器，在 pom.xml 文件中加入如下依赖：

```XML
<dependencies>
<!--web开发的场景启动器-->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
</dependencies>
```

第四步：创建启动类

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication是一个特殊的注解，用于标识一个Spring Boot应用程序的入口类。它的主要作用是将三个常用注解组合在一起，简化了配置的过程。
 *
 * 具体而言，@SpringBootApplication注解包含以下三个注解的功能：
 *     @Configuration：将该类标识为应用程序的配置类。它允许使用Java代码定义和配置Bean。
 *     @EnableAutoConfiguration：启用Spring Boot的自动配置机制。它根据项目的依赖项自动配置Spring应用程序的行为。自动配置根据类路径、注解和配置属性等条件来决定要使用的功能和配置。
 *     @ComponentScan：自动扫描并加载应用程序中的组件，如控制器、服务、存储库等。它默认扫描@SpringBootApplication注解所在类的包及其子包中的组件。
 *
 * 使用@SpringBootApplication注解，可以将上述三个注解的功能集中在一个注解上，简化了配置文件的编写和组件的加载和扫描过程。它是Spring Boot应用程序的入口点，标识了应用程序的主类，
 * 并告诉Spring Boot在启动时应如何配置和加载应用程序。
 */
@SpringBootApplication
public class Main {

    //SpringApplication.run() 方法是启动 Spring Boot 应用程序的关键步骤。它创建应用程序上下文、
    // 自动配置应用程序、启动应用程序，并处理命令行参数，使应用程序能够运行和提供所需的功能
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}
```

第五步：编写处理器

```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello,Spring Boot!";
    }

}
```

第六步：启动测试

启动项目后去访问 http://localhost:8080/test/hello试试

### 2.入门总结

#### 2.1为什么maven中的依赖不需要写版本：

- 每个boot项目都有一个父项目`spring-boot-starter-parent`
- parent的父项目是`spring-boot-dependencies`
- 父项目 **版本仲裁中心**，把所有常见的jar的依赖版本都声明好了。
- 比如：`mysql-connector-j`

![img](https://github.com/LanshanTeam/Courseware-Backend-Java-2023/blob/dalaoshi/Lesson7/Resource/img/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202023-12-04%20145528.png)

#### 2.2 启动器是什么

Spring Boot提供了一种叫做Starter的概念，它是一组预定义的依赖项集合，旨在简化Spring应用程序的配置和构建过程。Starter包含了一组相关的依赖项，以便在启动应用程序时自动引入所需的库、配置和功能。

主要作用如下：

1. 简化依赖管理：Spring Boot Starter通过捆绑和管理一组相关的依赖项，减少了手动解析和配置依赖项的工作。只需引入一个相关的Starter依赖，即可获取应用程序所需的全部依赖。
2. 自动配置：Spring Boot Starter在应用程序启动时自动配置所需的组件和功能。通过根据类路径和其他设置的自动检测，Starter可以自动配置Spring Bean、数据源、消息传递等常见组件，从而使应用程序的配置变得简单和维护成本降低。
3. 提供约定优于配置：Spring Boot Starter遵循“约定优于配置”的原则，通过提供一组默认设置和约定，减少了手动配置的需要。它定义了标准的配置文件命名约定、默认属性值、日志配置等，使得开发者可以更专注于业务逻辑而不是繁琐的配置细节。
4. 快速启动和开发应用程序：Spring Boot Starter使得从零开始构建一个完整的Spring Boot应用程序变得容易。它提供了主要领域（如Web开发、数据访问、安全性、消息传递等）的Starter，帮助开发者快速搭建一个具备特定功能的应用程序原型。
5. 模块化和可扩展性：Spring Boot Starter的组织结构使得应用程序的不同模块可以进行分离和解耦。每个模块可以有自己的Starter和依赖项，使得应用程序的不同部分可以按需进行开发和扩展。

![img](https://github.com/LanshanTeam/Courseware-Backend-Java-2023/blob/dalaoshi/Lesson7/Resource/img/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202023-12-04%20145930.png)

Spring Boot提供了许多预定义的Starter，例如spring-boot-starter-web用于构建Web应用程序，spring-boot-starter-data-jpa用于使用JPA进行数据库访问，spring-boot-starter-security用于安全认证和授权等等。

使用Starter非常简单，只需要在项目的构建文件（例如Maven的pom.xml）中添加所需的Starter依赖，Spring Boot会自动处理依赖管理和配置。

通过使用Starter，开发人员可以方便地引入和配置应用程序所需的功能，避免了手动添加大量的依赖项和编写冗长的配置文件的繁琐过程。同时，Starter也提供了一致的依赖项版本管理，确保依赖项之间的兼容性和稳定性。

[spring boot提供的全部启动器地址](https://docs.spring.io/spring-boot/docs/current/reference/html/using.html#using.build-systems.starters)

命名规范：

- 官方提供的场景：命名为：`spring-boot-starter-*`
- 第三方提供场景：命名为：`*-spring-boot-starter`

#### 2.3 @SpringBootApplication注解

@SpringBootApplication添加到启动类上，是一个组合注解，他的功效有具体的子注解实现

```java
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan
public @interface SpringBootApplication {}
```

@SpringBootApplication注解是Spring Boot框架中的核心注解，它的主要作用是简化和加速Spring Boot应用程序的配置和启动过程。

具体而言，@SpringBootApplication注解起到以下几个主要作用：

1. 自动配置：@SpringBootApplication注解包含了@EnableAutoConfiguration注解，用于启用Spring Boot的自动配置机制。自动配置会根据应用程序的依赖项和类路径，自动配置各种常见的Spring配置和功能，减少开发者的手动配置工作。它通过智能地分析类路径、加载配置和条件判断，为应用程序提供适当的默认配置。
2. 组件扫描：@SpringBootApplication注解包含了@ComponentScan注解，用于自动扫描并加载应用程序中的组件，例如控制器（Controllers）、服务（Services）、存储库（Repositories）等。它默认会扫描@SpringBootApplication注解所在类的包及其子包中的组件，并将它们纳入Spring Boot应用程序的上下文中，使它们可被自动注入和使用。
3. 声明配置类：@SpringBootApplication注解本身就是一个组合注解，它包含了@Configuration注解，将被标注的类声明为配置类。配置类可以包含Spring框架相关的配置、Bean定义，以及其他的自定义配置。通过@SpringBootApplication注解，开发者可以将配置类与启动类合并在一起，使得配置和启动可以同时发生。

总的来说，@SpringBootApplication注解的主要作用是简化Spring Boot应用程序的配置和启动过程。它自动配置应用程序、扫描并加载组件，并将配置和启动类合二为一，简化了开发者的工作量，提高了开发效率。

当然上面的代码中还有其他很多的注解，看不懂也没关系，下节课会为大家着重讲解这些用法

## 三、作业

Level1：算法

[三数之和](https://leetcode.cn/problems/3sum/)

[四数之和](https://leetcode.cn/problems/4sum/)

Level2：可能大家上完这节课是一脸懵逼，但是不用担心，这节课只做一个了解，下节课才会教大家如何去使用springboot，如有不懂的地方大可上网查找提前了解。这节课大家下去梳理一下spring框架的前置知识，掌握maven这个项目构建工具和spring项目的创建流程即可。
