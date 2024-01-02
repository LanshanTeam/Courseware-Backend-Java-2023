# 蓝山工作室第八节课：springboot下

（上节课已经带大家基本的了解了spring的一些基础，现在让我们正式进入springboot的学习，这节课全是干货！话不多说我们直接开始）

![img](Lesson8/Resource/1.jpg)
# 1.MVC模式（三层架构）

## 1.1 三层架构是什么：

把各个功能模块划分为表述层，业务逻辑层，和数据访问层三层架构，各层之间采用接口相互访问，并通过对象模型的实体类（model）作为数据传递的载体，不同的对象模型实体类一般对应数据库的不同表。

上层对下层的调用是通过接口实现的；下层对上层的真正服务提供者，是下层接口的实现类。

## 1.2 分层方式

- **表示层**（视图层View）

在表示层调用业务层的方法，前台设计，相关控件，数据缓存都属于表示层。

就是实现用户界面，将用户的需求传达和反馈。

- **业务层**（服务层Service）

数据访问的逻辑放在业务层。对具体问题进行逻辑判断与执行操作；

接收到表现层 的用户指令后，会连接数据访问层，作为表示层和数据层的桥梁，实现三层之间的数据连接和指令传达，对 ***接收数据*** 进行逻辑处理，实现数据的修改，获取，删除等功能，并将处理结果反馈到表示层，实现软件功能。

- **数据层**（持久层Dao）

包含所建的数据库和一些存储过程（实现数据访问，分页，搜索算法等），被业务层调用是数据库的主要操作系统，实现 ***数据库*** 的增删改查等操作，并将操作结果反馈到业务逻辑层在实际运行的过程中，数据访问层没有逻辑判断能力，为了实现代码编写的严谨性，提高代码阅读程度，一般软件开发人员会在该层中编写DataAccessCommon，保证数据访问层 数据处理功能。

- **实体类库**

实体类库是数据库表的映射对象，在开发过程中，要建立对象实例，将关系数据库表采用对象实体化的方式表现出来，利用 GET 与 SET 把数据库表中的所有字段映射为系统对象，建立实体类库，进而实现各个结构层的参数传输，服务于其他三层。

## 1.3 什么是MVC

- View

视图，为用户提供界面，与用户直接进行交互，处理数据可视化的部分。

- Model

模型，用于处理应用程序数据逻辑的部分，实现增删改查功能，通常负责在数据库中存取数据，代表一个存取数据的对象或JAVA POJO

- Controller

控制器，处理用户交互的部分。通常负责从视图读取数据，控制用户输入，并向model发送数据，在数据变化时更新视图。

1）接受请求，并将该请求跳转（转发，重定向）到模型进行处理

2）模型处理完毕后，再通过控制器，返回给视图中的请求。

当单机web页面中超链接和发送表单时，控制器本身不输出任何东西和做任何处理，仅对请求进行解析。他只是接受请求并决定调用哪个模型构建去处理请求，在确定用哪个视图来显示返回的数据。

![img](https://lanshanteam.feishu.cn/space/api/box/stream/download/asynccode/?code=ZDJhMzBhMTZjZTI3YzFiYWJiNTZiOWE2MTM3NTUzZDFfeEFWWEd2WnNFZkdHdThKTUw2R0RYcjJRekxFclVneW5fVG9rZW46RWE5VmJCZjcybzZFT1d4dW1oWGNkdFFybkVmXzE3MDQxNzE1NDA6MTcwNDE3NTE0MF9WNA)

## 1.4 举例：

1. 模型层（Model）：
    1. Book（图书）类：表示图书的数据结构，包含属性如书名、作者、出版日期等，并提供对这些属性的访问方法。
    2. BookRepository（图书仓库）类：负责与数据库或其他数据源进行交互，实现对图书信息的持久化操作，例如添加、删除、更新、查询等。
2. 视图层（View）：
    1. BookView（图书视图）类：负责展示图书管理系统的用户界面，例如在控制台或网页上显示图书列表、接收用户输入等。
3. 控制器层（Controller）：
    1. BookController（图书控制器）类：接收用户的请求并根据请求调用相应的模型和视图进行处理。它作为中间层协调模型和视图之间的交互。
    2. 例如，当用户请求添加一本新书时，控制器将调用 BookRepository 添加新书的方法，并根据结果选择适当的视图进行响应。

这样，整个图书管理系统应用程序就按照 MVC 架构进行了分层和组织。模型层负责处理数据和业务逻辑，视图层负责展示用户界面，控制器层负责协调模型和视图之间的交互。这种架构可以使代码更易于理解、维护和扩展。

# 讲到这里我们来直接上手试试：

现在我们有一个数据库studb中有一个students表，长这样

![img](https://lanshanteam.feishu.cn/space/api/box/stream/download/asynccode/?code=MWYyMTBhNjM1MWMzNGY4ZDMwMDMyOTdiZjVmNTU1ZDZfZHRsWW84QjBhaXRxWHc1aEVxeVd0R3o5T0dSbEJqRFNfVG9rZW46WXdQRWJYb0F2b2dIR1h4cHhxTGNJbWRRbnVjXzE3MDQxNzE1NDA6MTcwNDE3NTE0MF9WNA)

我们该怎么实现使用java代码的方式去查询这个表里的所有信息呢？

# 2.Spring实现（了解）

## 2.1 数据库准备

```SQL
 create database studb;

use studb;

CREATE TABLE students (
  id INT PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  gender VARCHAR(10) NOT NULL,
  age INT,
  class VARCHAR(50)
);

INSERT INTO students (id, name, gender, age, class)
VALUES
  (1, '张三', '男', 20, '高中一班'),
  (2, '李四', '男', 19, '高中二班'),
  (3, '王五', '女', 18, '高中一班'),
  (4, '赵六', '女', 20, '高中三班'),
  (5, '刘七', '男', 19, '高中二班'),
  (6, '陈八', '女', 18, '高中一班'),
  (7, '杨九', '男', 20, '高中三班'),
  (8, '吴十', '男', 19, '高中二班');
```

## 2.2 创建项目

略（上节课讲的maven项目创建方法）

## 2.3 依赖引入

```XML
<dependencies>
      <!--spring context依赖-->
      <!--当你引入SpringContext依赖之后，表示将Spring的基础依赖引入了-->
      <dependency>
          <groupId>org.springframework</groupId>
          <artifactId>spring-context</artifactId>
          <version>6.0.6</version>
      </dependency>

      <!-- 数据库驱动和连接池-->
      <dependency>
          <groupId>mysql</groupId>
          <artifactId>mysql-connector-java</artifactId>
          <version>8.0.25</version>
      </dependency>

      <dependency>
          <groupId>com.alibaba</groupId>
          <artifactId>druid</artifactId>
          <version>1.2.8</version>
      </dependency>

      <!-- spring-jdbc -->
      <dependency>
          <groupId>org.springframework</groupId>
          <artifactId>spring-jdbc</artifactId>
          <version>6.0.6</version>
      </dependency>

</dependencies> 
```

## 2.4 实体类准备

```Java
public class Student {

    private Integer id;
    private String name;
    private String gender;
    private Integer age;
    private String classes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", classes='" + classes + '\'' +
                '}';
    }
}
```

也可以使用lombok中的**@Data**注解（上节课也讲了）省略get，set方法

## 2.5 JDBC技术

### 2.5.1 简单讲讲jdbc：

JDBC（Java Database Connectivity）是一种用于在Java应用程序和数据库之间进行连接和交互的Java API。它提供了一组类和接口，使得Java应用程序能够与各种关系型数据库（如MySQL、Oracle、Microsoft SQL Server等）进行通信。

JDBC 允许开发人员使用标准的SQL语句来执行数据库操作，例如查询、插入、更新和删除数据。它还提供了事务管理、批处理处理、预编译语句和存储过程等功能。

使用 JDBC，我们可以通过以下步骤与数据库进行交互：

1. 加载数据库驱动程序：开发人员需要加载适当的数据库驱动程序，以便在应用程序中使用该数据库。
2. 建立数据库连接：使用驱动程序提供的连接字符串、用户名和密码等信息，建立与数据库的连接。
3. 创建 Statement 或 PreparedStatement 对象：通过连接对象创建一个 Statement 或者 PreparedStatement 对象，用于执行 SQL 语句。
4. 执行 SQL 语句：使用 Statement 或 PreparedStatement 对象执行 SQL 查询或更新语句。
5. 处理结果：根据具体情况，可以从 ResultSet 对象中检索查询结果，或者获取更新操作的影响行数。
6. 关闭连接和释放资源：在完成数据库操作后，关闭连接、释放相关资源，以确保正确释放数据库连接池和避免资源泄漏。

JDBC 提供了一种标准的方式来访问和操作各种关系型数据库，使得 Java 应用程序能够与数据库进行有效的交互。

> 为了在特定领域帮助我们简化代码，Spring 封装了很多 『Template』形式的模板类。例如：RedisTemplate、RestTemplate 等等，包括我们今天要学习的 JdbcTemplate。

### 2.5.2 如何在项目中构建

#### A. jdbc.properties

```Properties
dalaoshi.url=jdbc:mysql://localhost:3306/studb
dalaoshi.driver=com.mysql.cj.jdbc.Driver
dalaoshi.username=root
dalaoshi.password=132123
```

#### B. springioc配置文件（jdbc.xml)

```XML
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">


    <!-- 导入外部属性文件 -->
    <context:property-placeholder location="classpath:jdbc.properties" />

    <!-- 配置数据源 -->
    <bean id="druidDataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <property name="url" value="${dalaoshi.url}"/>
        <property name="driverClassName" value="${dalaoshi.driver}"/>
        <property name="username" value="${dalaoshi.username}"/>
        <property name="password" value="${dalaoshi.password}"/>
    </bean>

    <!-- 配置 JdbcTemplate -->
    <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
        <!-- 装配数据源 -->
        <property name="dataSource" ref="druidDataSource"/>
    </bean>

</beans>
```

#### C. 基于jdbcTemplate的CRUD使用

```Java
public class JdbcTemplateTest {

    /**
     * 使用jdbcTemplate进行DML动作
     */
    @Test
    public void testDML(){

        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("jdbc.xml");

        JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);

        //TODO 执行插入一条学员数据
        String sql = "insert into students (id,name,gender,age,class) values (?,?,?,?,?);";
    /*
        参数1: sql语句
        参数2: 可变参数,占位符的值
     */
        int rows = jdbcTemplate.update(sql, 9,"大老师", "男", 18, "大二一班");

        System.out.println("rows = " + rows);

    }

    /**
     * 查询单条实体对象
     *   public class Student {
     *     private Integer id;
     *     private String name;
     *     private String gender;
     *     private Integer age;
     *     private String classes;
     */
    @Test
    public void testDQLForPojo(){

        String sql = "select id , name , age , gender , class as classes from students where id = ? ;";

        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("jdbc.xml");

        JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);

        int id = 6;//根据id查询
        //根据id查询
        Student student = jdbcTemplate.queryForObject(sql,  (rs, rowNum) -> {
            //自己处理结果映射
            Student stu = new Student();
            stu.setId(rs.getInt("id"));
            stu.setName(rs.getString("name"));
            stu.setAge(rs.getInt("age"));
            stu.setGender(rs.getString("gender"));
            stu.setClasses(rs.getString("classes"));
            return stu;
        }, id);

        System.out.println("student = " + student);
    }

    /**
     * 查询实体类集合
     */
    @Test
    public void testDQLForListPojo(){

        String sql = "select id , name , age , gender , class as classes from students  ;";

        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("jdbc.xml");

        JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);
    /*
        query可以返回集合!
        BeanPropertyRowMapper就是封装好RowMapper的实现,要求属性名和列名相同即可
     */
        List<Student> studentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));

        System.out.println("studentList = " + studentList);
    }

}
```

补充：jdbc的数据库操作方法中除select方法获得的返回值为查询的类型以外，其余操作返回值均为被更改影响到的行数

## 2.6 三层架构实现

文件格式如图

![img](https://lanshanteam.feishu.cn/space/api/box/stream/download/asynccode/?code=OTE1OTQzZGM3YmU2Y2VhMGVlMmQ1OGI3MTAyZDQxMDlfcVQ0RjFPSjkwN1ZRY2dPTzJ5WnBHdWRrNEdRSHVwOG9fVG9rZW46Sk1QaGJNdU5kb0ZIME14Vk41amNvS251bkpjXzE3MDQxNzE1NDA6MTcwNDE3NTE0MF9WNA)

ps：1.pojo为普通java类

2.使用 impl（implementation）文件的一种常见做法是将接口和实现类分离，以提高代码的可维护性和可扩展性。

### 2.6.1 持久层（Dao层）

```Java
//接口
public interface StudentDao {

    /**
     * 查询全部学生数据
     * @return
     */
    List<Student> queryAll();
}

//实现类
public class StudentDaoImpl implements StudentDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 查询全部学生数据
     * @return
     */
    @Override
    public List<Student> queryAll() {

        String sql = "select id , name , age , gender , class as classes from students ;";

        /*
          query可以返回集合!
          BeanPropertyRowMapper就是封装好RowMapper的实现,要求属性名和列名相同即可
         */
        List<Student> studentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));

        return studentList;
   }
}
```

### 2.6.2 业务层（service层）

```Java
//接口
public interface StudentService {

    /**
     * 查询全部学员业务
     * @return
     */
    List<Student> findAll();

}

//实现类
public class StudentServiceImpl  implements StudentService {
    
    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    /**
     * 查询全部学员业务
     * @return
     */
    @Override
    public List<Student> findAll() {
        
        List<Student> studentList =  studentDao.queryAll();
        
        return studentList;
    }
}
```

### 2.6.3 表述层（controller层）

```Java
public class StudentController {
    
    private StudentService studentService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
    
    public void  findAll(){
       List<Student> studentList =  studentService.findAll();
        System.out.println("studentList = " + studentList);
    }
}
```

## 2.7 三层架构ioc配置(spring_test.xml)

```Java
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">


    <!-- 导入外部属性文件 -->
    <context:property-placeholder location="classpath:jdbc.properties" />

    <!-- 配置数据源 -->
    <bean id="druidDataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <property name="url" value="${dalaoshi.url}"/>
        <property name="driverClassName" value="${dalaoshi.driver}"/>
        <property name="username" value="${dalaoshi.username}"/>
        <property name="password" value="${dalaoshi.password}"/>
    </bean>
    <!-- 配置 JdbcTemplate -->
    <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
        <!-- 装配数据源 -->
        <property name="dataSource" ref="druidDataSource"/>
    </bean>


    <bean id="studentDao" class="org.dalaoshi.dao.daoimpl.StudentDaoImpl">
        <property name="jdbcTemplate" ref="jdbcTemplate" />
    </bean>

    <bean id="studentService" class="org.dalaoshi.service.impl.StudentServiceImpl">
        <property name="studentDao" ref="studentDao" />
    </bean>

    <bean id="studentController" class="org.dalaoshi.controller.StudentController">
        <property name="studentService" ref="studentService" />
    </bean>

</beans>
```

## 2.8 运行测试

```Java
public class ControllerTest {

    @Test
    public  void testRun(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring_test.xml");
        StudentController studentController = applicationContext.getBean(StudentController.class);
        studentController.findAll();
    }
}
```

## 2.9 使用spring方式总结：（XMLIoC方式问题总结）

1. 注入的属性必须添加setter方法、代码结构乱！
2. 配置文件和Java代码分离、编写不是很方便！
3. XML配置文件解析效率低

# 3.SpringBoot实现

直接上代码！！！🤬🤬🤬

## 3.1 数据库准备：

用上面那个 😀

## 3.2创建项目：

不讲了，还是创建一个maven项目，idea自带有的一个快速创建springboot项目，比较简单快捷

![img](https://lanshanteam.feishu.cn/space/api/box/stream/download/asynccode/?code=ZjQwZTY4OTFhZjQ1ZmZiOTU5NzdjODhkZWM4OWFlZWJfREVOd3k1TW1NaHM3Z3RyNkN4TG83MDN6S3VGWVRscjdfVG9rZW46T1pZRWJXNDV1b2hSNkh4Z2NaemNzOVFVbjdYXzE3MDQxNzE1NDA6MTcwNDE3NTE0MF9WNA)

自己去研究😊

## 3.3 依赖引入

ps：pringboot中<parent>这里是java17开的项目所以用sb3的版本，如果你是java8就用sb2

```Java
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>3.2.0</version>
    <relativePath/> <!-- lookup parent from repository -->
</parent>

<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-jdbc</artifactId>
    </dependency>

    <dependency>
        <groupId>org.mybatis.spring.boot</groupId>
        <artifactId>mybatis-spring-boot-starter</artifactId>
        <version>3.0.3</version>
    </dependency>

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <scope>runtime</scope>
    </dependency>

    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>

    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>

<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
    </plugins>
</build>
```

maven上节课都给大家讲了，但是这里还是补充一个知识点：

`<build>` 标签用于配置项目的构建相关设置。它允许你自定义构建过程，并指定构建所需的插件、目标、资源等。

以下是 `<build>` 标签的一些常见配置项和作用：

1. `<sourceDirectory>` 和 `<testSourceDirectory>`：用于指定源代码和测试代码的目录路径，默认分别为 `src/main/java` 和 `src/test/java`。
2. `<resources>` 和 `<testResources>`：可以在这里配置要包含在构建输出中的资源文件的目录路径。例如，配置 `<resources>` 可以将应用程序所需的配置文件复制到构建输出的特定位置。
3. `<plugins>`：该标签包含了构建过程中要使用的插件的配置。插件可以用于执行各种任务，如编译代码、运行测试、打包应用程序等。你可以在这里配置 Maven 插件的参数、目标，以及插件在构建周期中执行的阶段。
4. `<finalName>`：用于指定最终构建输出的文件名或目录名。默认情况下，构建输出的文件名由 Maven 根据项目信息和构建类型自动生成。

通过配置 `<build>` 标签，你可以对构建过程进行灵活的定制和扩展。你可以添加自定义的构建插件、配置构建过程中的资源文件，以及指定构建输出的文件名等。

总之，`<build>` 标签是pom.xml 文件中用于配置项目构建相关设置的部分，它允许你自定义构建过程并指定构建所需的插件、目标、资源等。

## 3.4 实体类准备

```Java
@Data //上面有讲，不赘述了
public class Student {

    private Integer id;
    private String name;
    private String gender;
    private Integer age;
    private String classname;
}
```

## 3.5 三层架构实现

文件格式如图：

![img](https://lanshanteam.feishu.cn/space/api/box/stream/download/asynccode/?code=ZTRlMGM1NmU5YTE4YWU5ZDdiNjE1NWIyNzMxOTI1NGFfbzNaNWlsdFl5RUxKZ2dSVlBnNkt1ZFJXS3JZQUdITXFfVG9rZW46VnpGd2JoVVpZb1JsNVV4WHFTR2MzU3RLbjBiXzE3MDQxNzE1NDA6MTcwNDE3NTE0MF9WNA)

### 3.5.1 持久层（Mapper层）

使用Mybatis框架实现

那么首先：mybatis是什么？

> MyBatis 是一款流行的 Java 持久层框架，它提供了一种优雅的方式来将数据库操作和 SQL 语句与 Java 代码分离。MyBatis 的核心思想是通过 XML 或注解方式将 SQL 语句映射到 Java 方法上，从而实现了数据的持久化。

MyBatis 的主要特点包括：

1. 灵活的 SQL 映射：通过 XML 或注解方式将 SQL 语句映射到 Java 方法上，可以更加灵活地控制 SQL 语句和 Java 代码之间的关系。
2. 易于学习和使用：MyBatis 的 API 简单易用，开发人员无需深入了解底层的 SQL 语句和数据库操作细节。
3. 高性能和可扩展性：MyBatis 的底层采用了 JDBC 访问数据库，具有良好的性能和可扩展性。
4. 多种数据源支持：MyBatis 支持多种数据源，包括 MySQL、Oracle、SQL Server 等。
5. 插件机制：MyBatis 提供了插件机制，使得开发人员可以在不修改 MyBatis 核心代码的情况下扩展其功能。

我们先简单做个了解，后面会详细讲解他的作用

接口：

![img](https://lanshanteam.feishu.cn/space/api/box/stream/download/asynccode/?code=OGRiZGZjMmNhOGFjYjVjNzQyMzBmYTBkNjg0MDQ0OWRfMGRUUlpneDROSDRKa0xwQXBZVmhFM3JFQjdoY2YwRVBfVG9rZW46SXBVZ2JpSmptb3dmT1l4dXJkV2M0NVRabmhoXzE3MDQxNzE1NDA6MTcwNDE3NTE0MF9WNA)

```Java
@Mapper
public interface StudentMapper {
    List<Student> queryAll();
}
```

resource文件中：

![img](https://lanshanteam.feishu.cn/space/api/box/stream/download/asynccode/?code=MTdkZDUyMjI5ZmIzM2Q4MmJiZjg5YmQ5YWRlMTQ0NzFfdVlqeHlaOUtRdk1xOHZ2cWlNMkNjcXhTemFWY3ZadFVfVG9rZW46TGpISWJXV1h1b1phMXJ4b3RHWGM0QU9ZbmNnXzE3MDQxNzE1NDA6MTcwNDE3NTE0MF9WNA)

```Java
<?xml version="1.0" encoding="UTF-8" ?>

<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!-- namespace = 接口的全限定符 -->
<mapper namespace="com.example.springboot_test2.mapper.StudentMapper">

    <select id="queryAll" resultType="com.example.springboot_test2.pojo.Student">
        SELECT id,name,gender,age,class AS classname FROM students;
    </select>

</mapper>
```

### 3.5.2 业务层 （service层）

```Java
//接口
public interface StudentService {
    List<Student> findList();
}
//实现
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public List<Student> findList(){
        return studentMapper.queryAll();
    }
}
```

### 2.5.3 表述层（controller层）

```Java
@Controller
@ResponseBody
@RequestMapping("/user")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @GetMapping("/list")
    @ResponseBody
    public List<Student> getUser(){
        List<Student> students = studentService.findList();
        return students;
    }
    
}
```

## 3.6 配置文件application.yml

![img](https://lanshanteam.feishu.cn/space/api/box/stream/download/asynccode/?code=ZmVjMDJjNTI1OTIzNWFiMGE1MjFlM2JiOWZjMTJmZGRfRVY4RkVPYkFRbXY1M2FVRWFydDFDM29qM1lIbVZnR3ZfVG9rZW46UFE3OGJsT2VCb2V4SXR4ODhjcmNSNGU5bmNjXzE3MDQxNzE1NDA6MTcwNDE3NTE0MF9WNA)

想必大家也看到了上面的spring实现中也有配置文件properties，这里也可以用properties，但是我们更推荐学习使用yml文件格式

property和yml的区别：

> YAML（YAML Ain't Markup Language）是一种用于配置文件的数据序列化格式，而 Properties 文件是 Java 常用的配置文件格式之一。它们在以下几个方面存在区别：

1. 语法结构：YAML 使用缩进和冒号来表示层级关系，通过空格进行分隔，具有更加简洁和易读的语法。而 Properties 文件使用键值对的形式，通过等号或冒号进行分隔。
2. 数据类型支持：YAML 支持更多的数据类型，包括字符串、数字、布尔值、日期时间、数组、对象等。同时，YAML 还支持注释、多行字符串、引用等特性。Properties 文件中的值仅支持字符串类型，没有直接支持其他数据类型的方式。
3. 结构表达：YAML 具有更灵活的结构表达能力，可以通过缩进和层级关系来表示复杂的数据结构。而 Properties 文件则是扁平的键值对结构，不支持层级关系。
4. 扩展性：YAML 支持自定义标签和类型的扩展，可以通过自定义类和标签解析器来处理非标准的数据结构。Properties 文件没有直接的扩展机制，只能通过键值对的方式进行配置。
5. 文件后缀：YAML 文件的常用后缀为 `.yaml` 或 `.yml`，而 Properties 文件的常用后缀为 `.properties`。

![img](https://lanshanteam.feishu.cn/space/api/box/stream/download/asynccode/?code=MmZiZGVkN2ZhYzE2Y2Q1MGQxYmMyN2E2Njc2NDhkYTlfeXc2ZjY0ejVER2VqOUJSUEtzUEFqTmVJZkFZcjZhdThfVG9rZW46UElQQ2JWbG41b2NERFB4bENNOGNkbGY0blBjXzE3MDQxNzE1NDA6MTcwNDE3NTE0MF9WNA)

![img](https://lanshanteam.feishu.cn/space/api/box/stream/download/asynccode/?code=ZjJjYTgwMDZkODI1OTVkYTA4OGJkYzQyNjBmNzhkNDBfNFFQQ3dsNkpucmFRbnc1Tkd5NGlaSHNGY014a09PbjJfVG9rZW46VlJkbWJZTklIb2hEdWZ4dW1mZGNPdVIwbmVkXzE3MDQxNzE1NDA6MTcwNDE3NTE0MF9WNA)

(显然yml格式更加直观易懂）

```YAML
server:
  port: 8080
  servlet:
    context-path: /
spring:
  #数据库连接
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver #开启连接池
    url: jdbc:mysql://localhost:3306/studb #数据库地址
    username: root #账号
    password: 132123 #密码
mybatis:
  configuration:  # setting
    auto-mapping-behavior: full #全自动映射
    map-underscore-to-camel-case: true #开启驼峰映射
    log-impl: org.apache.ibatis.logging.slf4j.Slf4jImpl #日志打印方式
  type-aliases-package: org.dalaoshi.pojo #用于设置类型别名包扫描路径的属性
  mapper-locations: classpath:mapper/*.xml # 再resource文件下寻找mapper.xml文件
```

里面包含了很多配置，看不懂？用多了就会了😀

## 3.7 启动类

```Java
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
```

## 3.8 运行结果

访问http://localhost:80`80/user/list

或使用apifox等接口测试软件来访问该网址（推荐）

![img](https://lanshanteam.feishu.cn/space/api/box/stream/download/asynccode/?code=M2Q2ZTdmNTJiY2YyMjkzMjkxMGYyODk5YTRmMzE4M2ZfWHlLcDl1ZzBJZEFDUFpaeE5HbEhPcm9kb25Kc3M2VlpfVG9rZW46QXFmQmJjejBLb0twc0h4MkxOQmNEQzNjbmFjXzE3MDQxNzE1NDA6MTcwNDE3NTE0MF9WNA)

这里是使用网页访问的展示图

补充：JOSN格式：

JSON（JavaScript Object Notation）是一种轻量级数据交换格式，它采用键值对的形式表示数据（类似于map，一个key对应一个value）。JSON 格式通常用于 Web 应用程序之间的数据交换，并且可以与多种编程语言进行互操作。（总之就是通过他在前后端传递数据）

JSON 格式基于两种结构：

1. 键值对：键和值之间用冒号分隔，每个键值对之间用逗号分隔。例如：

```JSON
Copy Code
{
    "name": "John",
    "age": 30,
    "city": "New York"
 }
```

1. 数组：数组是一个有序的值列表，每个值之间用逗号分隔，用方括号括起来。例如：

```JSON
Copy Code
[
    "apple",
    "banana",
    "orange"
]
```

JSON 支持以下几种数据类型：

- 字符串：用双引号括起来的文本。
- 数字：整数或浮点数。
- 布尔值：true 或 false。
- 空值：null。
- 对象：由一组键值对组成，用花括号括起来。
- 数组：由一组有序的值组成，用方括号括起来。

## 3.9 springboot实现方式总结

1.引入技术栈更方便快捷

2.没有xml等配置文件的编写

3.开发方便快捷

但是里面是不是很多东西看不懂：

@Service，@Controler，@Mapper是什么？mapper.xml是什么？mybatis如何使用？

不急，我们来一一解答

# 4.SpringBoot深入学习

## 4.1 springmvc：

### 4.1.1 springmvc是什么：

Spring MVC 基于前端控制器模式，其中一个中央控制器（DispatcherServlet）负责拦截所有的请求，并将它们分发给相应的处理器（Controller）。控制器处理请求后，将模型数据传递给视图进行渲染，最终生成响应返回给客户端。总之就是拿来处理请求，覆盖表述层，实现表述层的简化。

![img](https://lanshanteam.feishu.cn/space/api/box/stream/download/asynccode/?code=NzQ3NzRkNWQ4OGJkMjg1MjcwZDNlMjI5MDRlY2U2YzhfTnR2c1FMbUZNaHM3bjJidjg3NWJBZ29zS1gwSUlaV2hfVG9rZW46STZqS2JuN2xRb3d3Z1V4eVNaemNXaUpYbllkXzE3MDQxNzE1NDA6MTcwNDE3NTE0MF9WNA)

### 4.1.2 SpringMVC处理请求流程：

![img](https://lanshanteam.feishu.cn/space/api/box/stream/download/asynccode/?code=YjVlOTQzNDg0NDg5ZDVmZDMxYWYwNjE4NzRkYWQ1MzlfVjk2aU9ZU0dnbmFZamdPbndJOGEwaTZrQ0NRRGJHdG1fVG9rZW46WXdGZGJzZGFBbzhTOHV4RzVFQmMzcnhtbmJnXzE3MDQxNzE1NDA6MTcwNDE3NTE0MF9WNA)

**SpringMVC涉及组件理解：**

1. DispatcherServlet :  SpringMVC提供，我们需要使用web.xml配置使其生效，它是整个流程处理的核心，所有请求都经过它的处理和分发！[ CEO ]
2. HandlerMapping :  SpringMVC提供，我们需要进行IoC配置使其加入IoC容器方可生效，它内部缓存handler(controller方法)和handler访问路径数据，被DispatcherServlet调用，用于查找路径对应的handler！[秘书]
3. HandlerAdapter : SpringMVC提供，我们需要进行IoC配置使其加入IoC容器方可生效，它可以处理请求参数和处理响应数据数据，每次DispatcherServlet都是通过handlerAdapter间接调用handler，他是handler和DispatcherServlet之间的适配器！[经理]
4. Handler : handler又称处理器，他是Controller类内部的方法简称，是由我们自己定义，用来接收参数，向后调用业务，最终返回响应结果！[打工人]
5. ViewResovler : SpringMVC提供，我们需要进行IoC配置使其加入IoC容器方可生效！视图解析器主要作用简化模版视图页面查找的，但是需要注意，前后端分离项目，后端只返回JSON数据，不返回页面，那就不需要视图解析器！所以，视图解析器，相对其他的组件不是必须的！[财务]

### 4.1.3 @RequestMapping():

用于将 HTTP 请求映射到控制器方法上。它可以用于类级别和方法级别，以定义请求的 URL 和处理请求的方法。在类级别上，@RequestMapping 注解定义了控制器类可以处理的所有请求的基本 URL 映射。(简单来说他对我们的表述层中的类和方法做一个标记，让handlerAdapter通过标记去找到需要处理的请求的对应的方法。)

@RequestMapping中的属性：

@RequestMapping(value = "", method = )

1. value: 必须设置值的属性，通过value中的地址来匹配请求（若属性里只有value参数，则value可省略）
2. method：请求方式：(前端传来的http请求中有多种请求方式）
    1. GET：用于获取指定资源的信息。GET 请求是幂等的，即多次执行同一个 GET 请求应该返回相同的结果，不会对资源产生影响。
    2. POST：用于向服务器提交数据，创建新的资源。POST 请求对资源进行修改、更新或添加，并且可能导致状态变化或副作用。
    3. PUT：用于向服务器更新指定资源的信息。PUT 请求是幂等的，即多次执行同一个 PUT 请求应该具有相同的结果。
    4. DELETE：用于删除指定的资源。
    5. PATCH：用于对资源进行局部更新。PATCH 请求只更新指定的字段或属性，而不是整个资源。
    6. HEAD：类似于 GET 请求，但只返回响应头信息，不返回实际的响应体，用于获取资源的元数据。
    7. OPTIONS：用于获取目标 URL 支持的请求方法列表，服务器可以通过 OPTIONS 请求告知客户端支持的方法。
    8. TRACE：用于追踪路径，服务器会将请求原样返回给客户端，用于诊断和调试。
    9. CONNECT：用于将客户端连接转换为透明的 TCP/IP 通道，通常用于 HTTPS 请求。

> 这些请求方式定义了不同的操作语义，开发人员可以根据需要选择适当的请求方式来与服务器进行交互。常见的使用场景是使用 GET 请求获取资源，使用 POST 请求提交表单数据，使用 DELETE 请求删除资源等。

例

```JSON
@RequestMapping(value = "user", method = RequestMethod.GET)
//该注解表示处理地址为user，请求方式为get的请求
```

ps：1.@RequestMapping(value = "user", method = RequestMethod.GET)可直接使用@GetMapping("user")代替，其他请求方式同理

2.@RequestMapping()加载类上表示整个类所拥有的属性，加在方法上表示方法所具有的属性

### 4.1.4 @ResponseBody

用于将方法的返回值直接作为 HTTP 响应的内容（JSON格式)发送给客户端，而不是通过视图解析器进行渲染。

也就是我们上面例子中访问网页所看到的结果，也可以用此方式将数据传送给前端让他们对数据进行美化加工

## 4.2 mybatis

### 4.2.1 mybaits是什么

MyBatis 是一款流行的 Java 持久层框架，它提供了一种优雅的方式来将数据库操作和 SQL 语句与 Java 代码分离。MyBatis 的核心思想是通过 XML 或注解方式将 SQL 语句映射到 Java 方法上，从而实现了数据的持久化。

特点上面也讲过了，这里就不再过多赘述

### 4.2.2 mybatis使用方法

1. 在我们项目中

![img](https://lanshanteam.feishu.cn/space/api/box/stream/download/asynccode/?code=NjgxZjgwMWUwYTA5Y2JmZDQ0YzViYmFkMDBiOTEwNDNfQ0lsVnBKSnBTbWtNUDZCZHBaNmxNZlk3VG45eG1sOGhfVG9rZW46Q2RYUmIyMzZVb3J4RUN4czk0UGNhUU5pbk9kXzE3MDQxNzE1NDA6MTcwNDE3NTE0MF9WNA)

需要写入mapper接口来规定mapper有些什么方法

1. 在resource文件中

![img](https://lanshanteam.feishu.cn/space/api/box/stream/download/asynccode/?code=OTI0ZTFhMjQ2Njg1NWEyMmY2MTNlODYyNGQ0MmY3MWRfZFpaamdCMkt3dEJUQWhZN294eW9FS1pLYkVNMjBaU0JfVG9rZW46QWkzR2I3VFVNb1B3bG54TFlCbWNkTURVbjNiXzE3MDQxNzE1NDA6MTcwNDE3NTE0MF9WNA)

创建mapper文件，这里面对应实现了上面mapper接口中的方法

下面是mapper.xml文件的详细介绍

```XML
<!-- 前面两排为默认格式，可自己添加进快捷创建文件中-->
<?xml version="1.0" encoding="UTF-8" ?>

<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!-- namespace = mapper接口的在项目中的路径,里面对应了该mapper.xml实现了哪个mapper接口方法-->
<mapper namespace="com.example.springboot_test2.mapper.StudentMapper">
    <!-- sql语句 是什么语句就对应什么标签 
    id表示实现的mapper中的接口名称，一定要对应！！
    resultType表示返回值类型所在项目中的位置，也可为基本数据类型
    -->
    <select id="queryAll" resultType="com.example.springboot_test2.pojo.Student">
        SELECT id,name,gender,age,class AS classname FROM students;
    </select>

</mapper>
```

1. 配置文件

```XML
spring:
  #数据库连接
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver #开启连接池
    url: jdbc:mysql://localhost:3306/studb #数据库地址
    username: root #账号
    password: 132123 #密码
mybatis:
  configuration:  # setting
    auto-mapping-behavior: full #全自动映射
    map-underscore-to-camel-case: true #开启驼峰映射
    log-impl: org.apache.ibatis.logging.slf4j.Slf4jImpl #日志打印方式
  type-aliases-package: org.dalaoshi.pojo #用于设置类型别名包扫描路径的属性
  mapper-locations: classpath:mapper/*.xml # 在resource文件下寻找mapper.xml文件
```

spring配置文件对比

```XML
 <!-- 配置数据源 -->
    <bean id="druidDataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <property name="url" value="${dalaoshi.url}"/>
        <property name="driverClassName" value="${dalaoshi.driver}"/>
        <property name="username" value="${dalaoshi.username}"/>
        <property name="password" value="${dalaoshi.password}"/>
    </bean>
    <!-- 配置 JdbcTemplate -->
    <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
        <!-- 装配数据源 -->
        <property name="dataSource" ref="druidDataSource"/>
    </bean>
```

现在是不是能看懂一部分了呢，springboot中直接使用配置文件的方式进行数据库连接，同时mybatis的配置也写在配置文件中。

ps: 1.mapper-locations: classpath:mapper/*.xml *# 在resource文件下寻找mapper.xml文件*

这里给大家做个简单解释：这是配置mybatis在classpath 也就是资源文件（resource）下去找，mapper文件目录下，/*表示该文件下的全部以.xml格式结尾的文件。

2.返回值为List或set等类型时，均使用里面数据的类型作为*resultType*

### 4.2.3 如何拥有小蓝鸟

下个插件就行了：mybatisx

![img](https://lanshanteam.feishu.cn/space/api/box/stream/download/asynccode/?code=M2Q1MzBmNjZkZTY2NzYyZjk0Mzc4OTU2MzIzYzhmMmFfRkNZUkV0aEZIS2tOSHJaNkdBSjV0U0Jac05QZ1VVZjBfVG9rZW46VkxCZ2JSOVZWb3ZPY1h4UEVFY2NrcTQybkxmXzE3MDQxNzE1NDA6MTcwNDE3NTE0MF9WNA)

## 4.3 SpringBoot如何自动装配注入ioc容器(DI)

还记得三层架构每层上的注解吗：

表述层：@Controller

业务层：@Service

持久层：@Mapper

还记得spring如何注入ioc容器的吗

```XML
    <bean id="studentDao" class="org.dalaoshi.dao.daoimpl.StudentDaoImpl">
        <property name="jdbcTemplate" ref="jdbcTemplate" />
    </bean>

    <bean id="studentService" class="org.dalaoshi.service.impl.StudentServiceImpl">
        <property name="studentDao" ref="studentDao" />
    </bean>

    <bean id="studentController" class="org.dalaoshi.controller.StudentController">
        <property name="studentService" ref="studentService" />
    </bean>
```

是的他们的作用一模一样。@Component，@Controller，@Service，@Mapper他们四个都是这个作用，那有什区别呢，区别就在于后面三个顺便把该类是那一层标识出来了，更清晰可见（@Mapper也可以使用@MapperScan（"你的mapper文件所在的位置“）加在启动类上替代，这样的话在项目启动时也会先扫描一遍mapper文件）

ps：注入ioc容器的bean id默认为该方法首字母小写，若想要自己设置id名直接@Component(value = "名称")

## 4.4 SpringBoot如何引用自动装配

我们看看service层

```XML
@Service
public class StudentServiceImpl {

    @Autowired
    private StudentMapper studentMapper;

    public List<Student> findList(){
        return studentMapper.queryAll();
    }
}
```

1. @Autowired工作流程

- 首先根据所需要的组件类型到 IOC 容器中查找
    - 能够找到唯一的 bean：直接执行装配
    - 如果完全找不到匹配这个类型的 bean：装配失败
    - 和所需类型匹配的 bean 不止一个
        - 加入@Qualifier(value = "bean的名称")后
        - 没有 @Qualifier 注解：根据 @Autowired 标记位置成员变量的变量名作为 bean 的 id 进行匹配
            - 能够找到：执行装配
            - 找不到：装配失败
        - 使用 @Qualifier 注解：根据 @Qualifier 注解中指定的名称作为 bean 的id进行匹配
            - 能够找到：执行装配
            - 找不到：装配失败

可以看到，我们在声明类的上面加上@Autowired，他就会自动使用我们类的类型去ioc容器寻找对应的bean，若找到，则装配成功，我们便可以直接使用该类中的所有方法，同样ctroller层中也这样装备service方法

1. 也可以使用@Resource

@Resource注解属于JDK扩展包，所以不在JDK当中，需要额外引入以下依赖：【高于JDK11或低于JDK8需要引入以下依赖】

```XML
<dependency>
    <groupId>jakarta.annotation</groupId>
    <artifactId>jakarta.annotation-api</artifactId>
    <version>2.1.1</version>
</dependency>
```

1. 比较：@Resource注解默认根据Bean名称装配，未指定name时，使用属性名作为name。通过name找不到的话会自动启动通过类型装配。

@Autowired注解默认根据类型装配，如果想根据名称装配，需要配合@Qualifier注解一起用。

## 4.5 如何获取前端传来的数据呢

1. 使用 `@RequestParam` 注解：
    1. 如果前端传递的参数是作为 URL 的查询参数（query parameter）传递的，你可以使用 `@RequestParam` 注解来获取参数的值。例如：
    2. ```Java
      @GetMapping("/example")
      public String exampleMethod(@RequestParam("paramName") String paramValue) {
          // 处理参数值return "response";
      }
      ```

    3. 在上述例子中，`paramName` 是前端传递的参数名，`paramValue` 是对应的参数值。
    4. 如果前端传递的参数是作为表单参数（form parameter）传递的，你可以直接在方法参数中声明一个对象，Spring Boot 会自动将参数映射到对象的属性上。例如：
    5. ```Java
      @PostMapping("/example")
      public String exampleMethod(ExampleDto exampleDto) {
          // 处理参数值return "response";
      }
      ```

    6. 在上述例子中，`ExampleDto` 是一个自定义的数据传输对象（DTO），它的属性名与前端传递的参数名保持一致。
2. 使用 `@PathVariable` 注解：
    1. 如果前端传递的参数是通过 URL 路径中的占位符（path variable）传递的，你可以使用 `@PathVariable` 注解来获取参数的值。例如：
    2. ```Java
      javaCopy Code
      @GetMapping("/example/{paramName}")
      public String exampleMethod(@PathVariable("paramName") String paramValue) {
          // 处理参数值return "response";
      }
      ```

    3. 在上述例子中，`paramName` 是 URL 路径中的占位符，`paramValue` 是对应的参数值。

> 上面这两个都是基于注解用于获取请求 URL 中的查询参数（query parameter）或表单参数（form parameter），它会将参数映射到方法参数上，可以直接使用基本数据类型或者包装类、字符串等类型的参数。
>
> 但是一下这种方式是用于获取请求体中的参数，它将请求体中的 JSON 或者 XML 等格式的数据转换为 Java 对象，需要使用对应的实体类来接收。

1. `@RequestBody` 注解用于获取请求体中的参数，它将请求体中的 JSON 或者 XML 等格式的数据转换为 Java 对象，需要使用对应的实体类来接收。因此，使用 `@RequestBody` 注解时，需要加上 `@RequestBody` 注解和实体类参数。

例如：

```Java
@PostMapping(path = "/example")
public String exampleMethod(@RequestBody ExampleDto exampleDto) {// ...
}
```

在上述例子中，`ExampleDto` 是一个实体类，用于接收请求体中的 JSON 数据。

## 4.6 下面我们来举个例子：

我们想在刚刚的springboot项目中加上一个根据id查询学生数据的方法该怎么实现呢？

### 4.6.1 持久层

StudentMapper

```Java
@Mapper
public interface StudentMapper {
    List<Student> queryAll();

    Student queryById(int id);
}
```

StudentMapper.xml

```Java
<?xml version="1.0" encoding="UTF-8" ?>

<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!-- namespace = 接口的全限定符 -->
<mapper namespace="com.example.springboot_test2.mapper.StudentMapper">

    <select id="queryAll" resultType="com.example.springboot_test2.pojo.Student">
        SELECT id,name,gender,age,class AS classname FROM students;
    </select>
    
    <select id="queryById" resultType="com.example.springboot_test2.pojo.Student">
        SELECT id,name,gender,age,class AS classname FROM students WHERE id = #{id};
    </select>

</mapper>
```

其中#{id}用于接收该方法中传进来的参数id

注意#{} 中的参数名称要与方法中的参数名称保持一致，这样 MyBatis 才能正确地将参数值替换到 SQL 语句中。

补充

在 MyBatis 中，如果需要传入多个参数，可以使用 `@Param` 注解来指定每个参数的名称，并在 SQL 语句中使用 `#{}` 来接收这些参数。

示例代码如下所示：

```Java
public interface UserMapper {
    List<User> getUsersByNameAndAge(@Param("name") String name, @Param("age") int age);
}
```

在上述示例中，使用 `@Param` 注解为每个参数指定了名称，即 `name` 和 `age`。然后，在 SQL 语句中可以使用 `#{name}` 和 `#{age}` 来接收这两个参数。

```XML
<select id="getUsersByNameAndAge" parameterType="java.util.Map" resultType="User">
    SELECT * FROM users WHERE name = #{name} AND age = #{age}
</select>
```

在 XML 配置文件中，通过 `parameterType` 属性指定了参数类型为 `java.util.Map`，这样 MyBatis 就能够将参数按照指定的名称进行匹配。

如果不使用 `@Param` 注解，或者直接传入一个对象作为参数，也可以在 SQL 语句中使用 `#{属性名}` 的方式来接收参数值，其中属性名与对象的属性名一致。

示例代码如下所示：

```Java
public class User {private String name;private int age;// getter and setter methods
}

public interface UserMapper {
    List<User> getUsers(User user);
}
<select id="getUsers" parameterType="User" resultType="User">
    SELECT * FROM users WHERE name = #{name} AND age = #{age}
</select>
```

在上述示例中，直接传入一个 `User` 对象作为参数，然后在 SQL 语句中可以使用 `#{name}` 和 `#{age}` 来接收对象的属性值。

总之，在 MyBatis 中，可以通过使用 `@Param` 注解为每个参数指定名称，或者直接传入一个对象来实现多参数的传递，并使用 `#{}` 来接收这些参数。

### 4.6.2 业务层

```XML
public interface StudentService {
    List<Student> findList();

    Student queryStudentById(int id);
}

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public List<Student> findList(){
        return studentMapper.queryAll();
    }

    @Override
    public Student queryStudentById(int id) {
        return studentMapper.queryById(id);
    }
}
```

### 4.6.3 表述层

```XML
@RestController
@RequestMapping("/user")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @GetMapping("/list")
    public List<Student> getUser(){
        List<Student> students = studentService.findList();
        return students;
    }

    @GetMapping("/query")
    public Student getStudentById(@RequestParam int id){
        return studentService.queryStudentById(id);
    }
}
```

这里采用@RequestParam的方式获取id值

### 4.6.4 测试

我们使用apifox来模拟前端传值看看返回结果

![img](https://lanshanteam.feishu.cn/space/api/box/stream/download/asynccode/?code=N2VjYmI4NGMwNmEzMjM0ODVhNzc0YzBkMzI0ZmFhMzJfc1V2aGVVUVFNS3RmdklXTzJJS081MmZqQlB0VXNwRXZfVG9rZW46QWgyWGJ3Yjllb1FmeE54Nkp6TGNEYjNJbm1TXzE3MDQxNzE1NDA6MTcwNDE3NTE0MF9WNA)

这样我们就算成功根据id查到了student的值

# 5.总结

到这里我们springboot的学习就告一段落了，相信你对springboot有了更深的理解，下来可以多自己实操两便如果学有余力的同学可以看看[ssm](https://www.wolai.com/v5Kuct5ZtPeVBk4NBUGBWF)，看完这个你一定能对于springboot有一个更深刻的理解，这两节课的内容请大家务必要掌握，作为一只合格的javaer，以后的日子大多数是个springboot打交道了，所以对于我们对springboot的掌握程度一定要有一个更高的要求。能看到这里，感谢大家的坚持。😭😭😭

# 作业

### level1

每周算法

[在排序数组中查找元素的第一个和最后一个位置](https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/)

[螺旋矩阵 II](https://leetcode.cn/problems/spiral-matrix-ii/)

# level2  （重要）

本次课程中并没有很详细的给大家讲解MyBatis中的动态sql编写，这个其实很重要，希望大家上网找资料自学

# level3 (很重要）

大家学完上面的内容看试着能不能在上面的项目中实现更多的方法，这是最基础的项目模型，可以去多深入看看能不能实现更多的方法