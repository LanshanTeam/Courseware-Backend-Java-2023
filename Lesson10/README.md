

# 第一节课：Web开发

# 一、JavaWeb

## 1、关于Web应用：

还记得你们得寒假考核吗，那个就是基本的web应用，也就是大家经常上网看到的网页：淘宝，bilbil，github，其实都属于web应用的范畴，那么什么是web应用呢：

### 1.1、web应用：

- Web 应用程序：可以提供浏览器访问的程序；（提供DOS命令访问的程序，B/S架构。）
- **在互联网上能够访问到的任何一个页面或者资源，都存在于世界的某一个角落的计算机上。**
- 基于HTTP传输协议（超文本传输协议，回忆HTML的名字：超文本标记语言）
- Web序序必须要运行在web容器上，如Tomcat /Jboss/WebLogic等

### 1.2、B/S架构和C/S架构：

1.  Web应用程序也是B/S结构的系统，B/S是Browser/Server的缩写，即浏览器和服务器结构。正如我们访问过的所有网站那样，在客户机上只需要启动一个浏览器即可，例如IE、Firefox，或移动终端UC等浏览器，网站服务器则由应用服务器和数据库服务器等组成。
2. C/S是Client/Server的缩写，即大家熟知的客户机和服务器结构，就像我们常用的QQ或LOL游戏等网络软件那样，需要下载并安装专用的客户端软件才能运行，并且服务器端也需要特定的软件支持，并采用大型数据库系统。
3. B/S架构的优势：
    1.  虽然B/S和C/S两种结构都可以进行同样的业务处理，但B/S结构软件随着Internet技术的兴起，是对CS结构的一种变化或者改进。它具有分布式特点，可以随时随地进行查询、浏览等业务处理;
    2. 业务扩展简单方便，通过增加网页即可增加服务器功能;维护简单方便，只需要改变网页，即可实现所有用户的同步更新;开发简单，共享性强。
    3. 建立B/S结构的网络应用，再通过Internet模式下载数据库应用，相对易于把握，成本也相对较为低廉。它是一次性到位的开发，能实现不同的人员，从不同的地点，以不同的连接方式访问和操作共同的数据库。它能够有效地保护数据平台和管理访问权限，并且服务器端的数据库也很安全。
    4. 用户的操作界面完全通过浏览器实现，一部分事务逻辑在前端实现，但是主要事务逻辑在服务器端实现。这样就大大简化了客户端计算机负荷，减轻了系统维护与升级的成本及工作量，降低了用户的总体成本。

### 1.3、静态web，和动态web

#### 1.3.1、静态web：

*.htm、*.html，这些都是网页的后缀，如果服务器上一直存在这些东西，我们就可以直接进行读取。网络：

![img](https://github.com/LanshanTeam/Courseware-Backend-Java-2023/blob/main/Lesson10/Resource/img/img.png)

- 静态web的缺点：

web页面无法动态更新，所有用户看到的都是同一个页面（轮播图，点击特效：伪动态，JavaScript）

它无法和数据库交互（数据无法持久化，无法交互）

#### 1.3.2、动态web

页面会动态展示：“web页面展示的效果因人而异“；

![img](https://github.com/LanshanTeam/Courseware-Backend-Java-2023/blob/main/Lesson10/Resource/img/img_1.png)

例如：b站中我们随时刷新会推送新的视频

- 动态web缺点：
    -  服务器的动态web资源出现了错误，我们需要重新编写我们的后台程序，重新部署发布（当然后期使用动态部署可以解决这些困难）；

​     停机维护

- 优点：

web页面可以动态更新，所有用户看到的都不是同一个页面

它可以和数据库交互（数据持久化：注册，个人信息）

开发人员更牛逼O.o?

### 1.4 JSP:

现在一般流行后端分离项目，基本不用了，有空看看吧（防止白雪QWQ）。

## 2、HTTP协议:

### 2.1、简介：

http（HyperText Transfer Protocol）超文本 传输 协议 ，是一个简单的请求-响应协议，它通常运行在TCP之上。

- 超文本：图片，音乐，视频，定位，地图…（文本：html，字符串，-…）
- 传输：客户端->服务器， 客户端->客户端(HTTP 协议是一个双向协议。)
- 协议：HTTP 是一个用在计算机世界里的协议，一种计算机能够理解的计算机与计算机之间的交流通信规范

TCP（Transmission Control Protocol，传输控制协议）是一种位于 OSI 模型（开放式系统互连参考模型）的传输层之上的协议。它提供了可靠的、面向连接的数据传输服务，主要用于在网络上的两个应用程序之间建立可靠的数据传输连接。简单来说就是：先建立tcp连接，再基于tcp连接再发送http请求来达到计算机与计算机之间的交互效果。

HTTP/1.1 相比 HTTP/1.0 性能上的改进：

- 使用长连接的方式改善了 HTTP/1.0 短连接造成的性能开销。
- 支持管道（pipeline）网络传输，只要第一个请求发出去了，不必等其回来，就可以发第二个请求出去，可以减少整体的响应时间。

（ps：http1.1，http2.0，http3.0，tcp协议包括三次握手四次挥手，https协议等，自己下去了解，很重要的）

### 2.2、HTTP 请求（Request）：

#### 2.1.1、http请求方式：

1. **GET**：
    1. 用途：用于从服务器获取数据，通常用于请求一个资源。
    2. 参数传递：通过 URL 的查询字符串传递参数，参数会附加在 URL 后面。
    3. 安全性：GET 请求的参数会显示在 URL 中，不适合传输敏感数据。
    4. 幂等性：GET 请求是幂等的，多次调用相同的 GET 请求不会产生副作用。
2. **POST**：
    1. 用途：用于向服务器提交数据，通常用于提交表单数据或上传文件。
    2. 参数传递：通过请求体中的数据传递参数，不会显示在 URL 中。
    3. 安全性：POST 请求的数据不会直接暴露在 URL 中，适合传输敏感数据。
    4. 幂等性：POST 请求不是幂等的，多次调用相同的 POST 请求可能会产生副作用。
3. **PUT**：
    1. 用途：用于向服务器更新资源，通常用于更新指定的资源。
    2. 参数传递：通常通过请求体中的数据传递参数。
    3. 安全性：PUT 请求可以用于修改资源，需要谨慎处理权限和验证。
    4. 幂等性：PUT 请求是幂等的，多次调用相同的 PUT 请求应该具有相同的效果。
4. **DELETE**：
    1. 用途：用于删除服务器上的资源。
    2. 参数传递：通常通过 URL 中指定要删除的资源路径传递参数。
    3. 安全性：DELETE 请求会直接删除资源，需要谨慎处理权限和验证。
    4. 幂等性：DELETE 请求是幂等的，多次调用相同的 DELETE 请求应该具有相同的效果。

四种为最常用的方式，除此之外还有OPTIONS、HEAD、PATCH等（作为了解就行）

#### 2.1.2、http请求报文

HTTP请求报文由3部分组成（请求行+请求头+请求体）：

![img](https://github.com/LanshanTeam/Courseware-Backend-Java-2023/blob/main/Lesson10/Resource/img/img_2.png)

下面是一个实际的请求报文：

![img](https://github.com/LanshanTeam/Courseware-Backend-Java-2023/blob/main/Lesson10/Resource/img/img_3.png)

看不懂？（那就是寒假考核做了没认真看 【狗头】）

#### 2.1.3、常见请求字段

- *Host* 字段：客户端发送请求时，用来指定服务器的域名。
- *Content-Length 字段：*服务器在返回数据时，会有 `Content-Length` 字段，表明本次回应的数据长度。
    -  作用： 重所周知HTTP 是基于 TCP 传输协议进行通信的，而使用了 TCP 传输协议，就会存在一个“粘包”的问题，HTTP 协议通过设置回车符、换行符作为 HTTP header 的边界，通过 Content-Length 字段作为 HTTP body 的边界，这两个方式都是为了解决“粘包”的问题。粘包是什么呢？问问jpt（Q_Q）

    - ![img](https://github.com/LanshanTeam/Courseware-Backend-Java-2023/blob/main/Lesson10/Resource/img/img_4.png)
    -  当然造成粘包的情况还有很多不仅可以来自发送方，其实也可以来自接收方，所以使用content-length字段是一个很不错的协助解决粘包的方法（并不能直接解决粘包），通常会选择固定一个消息的长度，此时content-length就可以作为该段消息的边界，与其他消息分开。。。其他的自己下去看吧
- *Connection 字段：*`Connection` 字段最常用于客户端要求服务器使用「HTTP 长连接」机制，以便其他请求复用。（HTTP 长连接的特点是，只要任意一端没有明确提出断开连接，则保持 TCP 连接状态。）

![img](https://github.com/LanshanTeam/Courseware-Backend-Java-2023/blob/main/Lesson10/Resource/img/img_5.png)

短连接和长连接是在网络通信中常用的两种连接方式，它们有以下特点：

1. **短连接**：
    1. 短连接是指每次通信都建立一次连接，数据传输完成后立即断开连接。
    2. 每次通信需要重新建立连接，包括三次握手和四次挥手等过程，会消耗一定的时间和资源。
    3. 适用于服务器资源有限、客户端请求不频繁的场景，可以及时释放资源。
2. **长连接**：（TCP三次握手建立连接，经典面试题）
    1. 长连接是指在一次连接上可以进行多次数据传输，数据传输完成后保持连接不断开。
    2. 在同一个连接上可以发送多个请求和响应，减少了重复建立连接的开销，提高了通信效率。
    3. 适用于需要频繁通信的场景，减少了每次连接的额外开销，提高了性能和效率。

在实际应用中，选择使用短连接还是长连接取决于具体的场景和需求：

- 对于 Web 服务等需要频繁通信的场景，通常会选择长连接以提高性能和效率。
- 对于一些临时性的小规模数据传输或者需要独立的连接状态的场景，可以选择短连接。
- 有些协议（如 HTTP/1.0）默认采用短连接方式，而一些协议（如 HTTP/1.1）支持长连接并通过 Keep-Alive 头部来控制连接的持久性。

- *Content-Type 字段：*`Content-Type` 字段用于服务器回应时，告诉客户端，本次数据是什么格式。

例：Content-Type: text/html; Charset=utf-8

- User-Agent字段：在 User-Agent 字段中，通常包含有关客户端的以下信息：
    - 客户端的应用程序类型（比如浏览器、爬虫等）
    - 客户端的操作系统信息（比如 Windows、MacOS、Android 等）
    - 客户端的浏览器引擎和版本号
    - 其他特定应用程序的信息
    -  服务器可以使用 User-Agent 字段来判断客户端的类型，从而提供相应的内容，比如针对不同浏览器的兼容性处理、针对移动设备的优化等。
- Cookie 字段：项目都写了还能不知道cookie？想想你怎么保持用户登录的（后面会讲）

还有一些比较通俗易懂的字段这里就省略了 （^ v ^)

2.1.4、发送请求

```Java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class HttpRequest {
 /**
  * 向指定URL发送GET方法的请求
  *
  * @param url
  *   发送请求的URL
  * @param param
  *   请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
  * @return URL 所代表远程资源的响应结果
  */
 public static String sendGet(String url, String param) {
  String result = "";
  BufferedReader in = null;
  try {
   String urlNameString = url + "?" + param;
   URL realUrl = new URL(urlNameString);
   // 打开和URL之间的连接
   URLConnection connection = realUrl.openConnection();
   // 设置通用的请求属性
   connection.setRequestProperty("accept", "*/*");
   connection.setRequestProperty("connection", "Keep-Alive");
   connection.setRequestProperty("user-agent",
     "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
   // 建立实际的连接
   connection.connect();
   // 获取所有响应头字段
   Map<String, List<String>> map = connection.getHeaderFields();
   // 遍历所有的响应头字段
   for (String key : map.keySet()) {
    System.out.println(key + "--->" + map.get(key));
   }
   // 定义 BufferedReader输入流来读取URL的响应
   in = new BufferedReader(new InputStreamReader(
     connection.getInputStream()));
   String line;
   while ((line = in.readLine()) != null) {
    result += line;
   }
  } catch (Exception e) {
   System.out.println("发送GET请求出现异常！" + e);
   e.printStackTrace();
  }finally {
   try {
    if (in != null) {
     in.close();
    }
   } catch (Exception e2) {
    e2.printStackTrace();
   }
  }
  return result;
 }
```

### 2.3、HTTP 响应（Response）：

#### 2.3.1、http响应报文：

HTTP的响应报文也由三部分组成（响应行+响应头+响应体）：

![img](https://github.com/LanshanTeam/Courseware-Backend-Java-2023/blob/main/Lesson10/Resource/img/img_6.png)

以下是一个实际的HTTP响应报文：

![img](https://github.com/LanshanTeam/Courseware-Backend-Java-2023/blob/main/Lesson10/Resource/img/img_7.png)

响应体也就是我们最终请求想要得到的结果。大家在使用apifox或postman测试项目的时候相信你深有体会

#### 2.3.2、常见响应字段：

响应报文中字段比较简单：

- server：响应所使用的服务器软件及其版本信息（我们常用的一般都是Apache的服务器版本号）
- Content-Type：content-type通常会告诉客户端返回的内容是什么类型的数据，以便客户端能够正确地处理和显示这些数据。常见的 "Content-Type" 类型包括：
    - **text/html**：指示返回的内容是 HTML 格式的文本。（常用）
    - **application/json**：指示返回的内容是 JSON 格式的数据。（常用）
    - **image/jpeg**：指示返回的内容是 JPEG 格式的图片。
    - **application/pdf**：指示返回的内容是 PDF 文件。(一般作为方法放在接口中）
    - **text/plain**：指示返回的内容是纯文本数据。
- Date：响应的时间
- Transfer-Encoding： 是一个用于指示传输编码方式的字段。这个字段通常用于说明在消息传输过程中对消息体进行了什么样的编码转换。常见的 "Transfer-Encoding" 值包括：
    - **chunked**：表示消息体被分割成一系列的数据块进行传输。
    - **gzip**：表示消息体使用 GZIP 压缩编码传输。
    - **deflate**：表示消息体使用 Deflate 压缩编码传输。
    - **identity**：表示消息体未经过任何编码，以原始形式传输。

等，了解常用的几个就行

#### 2.3.3、响应状态码：

200，404，500，想必大家在做项目的时候都很常见，而且某些在写bug时肯定经常出现QWQ，这些其实都属于http中的状态码.

- 1xx: 类状态码属于提示信息，是协议处理中的一种中间状态，实际用到的比较少。
- 2xx: 类状态码表示服务器成功处理了客户端的请求，也是我们最愿意看到的状态。
    - 「200 OK」是最常见的成功状态码，表示一切正常。如果是非 `HEAD` 请求，服务器返回的响应头都会有 body 数据。
    - 「204 No Content」也是常见的成功状态码，与 200 OK 基本相同，但响应头没有 body 数据。
    - 「206 Partial Content」是应用于 HTTP 分块下载或断点续传，表示响应返回的 body 数据并不是资源的全部，而是其中的一部分，也是服务器处理成功的状态。
- 3xx: 类状态码表示客户端请求的资源发生了变动，需要客户端用新的 URL 重新发送请求获取资源，也就是重定向。
    - 「301 Moved Permanently」表示永久重定向，说明请求的资源已经不存在了，需改用新的 URL 再次访问。
    - 「302 Found」表示临时重定向，说明请求的资源还在，但暂时需要用另一个 URL 来访问。
    -  301 和 302 都会在响应头里使用字段 `Location`，指明后续要跳转的 URL，浏览器会自动重定向新的 URL。

    - 「304 Not Modified」不具有跳转的含义，表示资源未修改，重定向已存在的缓冲文件，也称缓存重定向，也就是告诉客户端可以继续使用缓存资源，用于缓存控制。
- 4xx: 类状态码表示客户端发送的报文有误，服务器无法处理，也就是错误码的含义。
    - 「400 Bad Request」表示客户端请求的报文有错误，但只是个笼统的错误。
    - 「403 Forbidden」表示服务器禁止访问资源，并不是客户端的请求出错。
    - 「404 Not Found」表示请求的资源在服务器上不存在或未找到，所以无法提供给客户端。
- 5xx: 类状态码表示客户端请求报文正确，但是服务器处理时内部发生了错误，属于服务器端的错误码。
    - 「500 Internal Server Error」与 400 类型，是个笼统通用的错误码，服务器发生了什么错误，我们并不知道。
    - 「501 Not Implemented」表示客户端请求的功能还不支持，类似“即将开业，敬请期待”的意思。
    - 「502 Bad Gateway」通常是服务器作为网关或代理时返回的错误码，表示服务器自身工作正常，访问后端服务器发生了错误。
    - 「503 Service Unavailable」表示服务器当前很忙，暂时无法响应客户端，类似“网络服务正忙，请稍后重试”的意思。

http暂时就讲到这里，当然肯定不止这么点(!w!)

# 二、Servelet

## 1.1、什么是Servelet：

很多同学听到这里可能跟我们以前学的知识联系不起来，实际上我们平时使用的springmvc就是基于Servelet API 来构建的。Java Servlet 是运行在 Web 服务器或应用服务器上的程序，它是作为来自 Web 浏览器或其他 HTTP 客户端的请求和 HTTP 服务器上的数据库或应用程序之间的中间层。

- Servlet 是 Java Web 开发中的基本组件，用于处理客户端请求、生成响应并与服务器进行通信。
- Servlet 是一个 Java 类，通过继承 HttpServlet 类来实现特定的 HTTP 请求处理逻辑。
- Servlet 提供了服务端动态生成内容的能力，可以处理各种类型的请求（GET、POST 等）并生成响应。
- Servlet 在web程序中的位置

![img](https://github.com/LanshanTeam/Courseware-Backend-Java-2023/blob/main/Lesson10/Resource/img/img_8.png)

当然我们现在都直接用sb框架了，这一块我们稍作了解就好

## 1.2、Servlet入门：

话不多说直接上Hello world

创建一个maven项目：项目路径如下

![img](https://github.com/LanshanTeam/Courseware-Backend-Java-2023/blob/main/Lesson10/Resource/img/img_9.png)

web.xml

```XML
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">
</web-app>
```

index.jsp

```XML
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>
```

HelloServlet

```Java
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
```

然后自己在启动项里面配置装好的tomcat运行即可（ps：注意你的servlet版本jdk版本tomcat版本需要匹配才能正常运行）

![img](https://github.com/LanshanTeam/Courseware-Backend-Java-2023/blob/main/Lesson10/Resource/img/img_10.png)

[tomcat官网](https://tomcat.apache.org/)

## 1.3、http生命周期

![img](https://github.com/LanshanTeam/Courseware-Backend-Java-2023/blob/main/Lesson10/Resource/img/img_11.png)

图中很明显了不需要我讲了吧，其实我们使用的springmvc中处理请求的步骤也是这样，只不过是在这基础上改进了而已

注意的是调用service方法时，可以调用HttpServlet中的doGet（）或doPost（）来处理请求

## 1.4、httpServletRequest和httpServletResponse

HttpServletRequest 和 HttpServletResponse 是Servlet 中的两个重要接口，用于处理 HTTP 请求和响应。

1. **HttpServletRequest**:
    1. HttpServletRequest 接口表示客户端向服务器发送的 HTTP 请求。它包含了请求的信息，如参数、头信息、请求方法等。
    2. 通过 HttpServletRequest 对象，开发人员可以获取客户端提交的数据，如表单数据、URL 参数等。
    3. HttpServletRequest 提供了一系列方法，用于获取请求的信息，如getParameter()、getHeader()、getMethod() 等。
2. **HttpServletResponse**:
    1. HttpServletResponse 接口表示服务器向客户端返回的 HTTP 响应。开发人员使用 HttpServletResponse 来构建并发送响应到客户端。
    2. 通过 HttpServletResponse 对象，开发人员可以设置响应的状态码、响应头信息、内容类型等。
    3. HttpServletResponse 提供了一系列方法，用于设置响应信息，如setStatus()、setHeader()、setContentType()、getWriter() 等。

当然我们在spring boot中编写代码时想要获取request或者是设置response也主要采用这两种方法来直接获取：

```Java
//方法一：
@RequestMapping("/test")
@ResponseBody
public void saveTest(HttpServletRequest requset, HttpServletResponse response){
　　
}

//方法二：
public class TestRequest {
    public HttpServletRequest getRequest() {
        HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        HttpServletResponse response=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
        return request;
    }
}
```

# 三、socket 和 websocket

上面讲了servlet基于http协议的应用层技术，下面我们来正式了解一下我们的socket这种底层的网络编程技术

## 1、 网络架构模型

### 1.1、OSI（Open System Interconnect）

即开放式系统互联。一般都叫OSI参考模型

OSI定义了网络互连的七层框架（物理层、数据链路层、网络层、传输层、会话层、表示层、应用层）。

![img](https://github.com/LanshanTeam/Courseware-Backend-Java-2023/blob/main/Lesson10/Resource/img/img_12.png)

### 1.2、TCP/IP五层模型

TCP/IP五层协议（物理层、数据链路层、网络层、传输层、应用层）

![img](https://github.com/LanshanTeam/Courseware-Backend-Java-2023/blob/main/Lesson10/Resource/img/img_13.png)
其实也就是把上面的应用层，表示层，会话层统一归到了应用层中。

### 1.3、应用层，传输层，网络层

1. 应用层

​        应用层最靠近用户的一层，是为计算机用户提供应用接口，也为用户直接提供各种网络服务。我们常见应用层的网络服务协议有：HTTP，HTTPS，FTP，TELNET等。

1. 传输层

​        建立了主机端到端的链接，传输层的作用是为上层协议提供端到端的可靠和透明的数据传输服务，包括处理差错控制和流量控制等问题。该层向高层屏蔽了下层数据通信的细节，使高层用户看到的只是在两个传输实体间的一条主机到主机的、可由用户控制和设定的、可靠的数据通路。我们通常说的，TCP UDP就是在这一层。端口号既是这里的“端”。

1.  网络层

​        本层通过IP寻址来建立两个节点之间的连接，为源端的运输层送来的分组，选择合适的路由和交换节点，正确无误地按照地址传送给目的端的运输层。就是通常说的IP层。这一层就是我们经常说的IP协议层。IP协议是Internet的基础。

## 2、TCP协议与UDP协议

### 2.1、TCP

TCP是（Tranfer Control Protocol）的简称，是一种面向连接的保证可靠传输的协议。通过TCP协议传输，得到的是一个顺序的无差错的数据流。发送方和接收方的成对的两个socket之间必须建立连接，当一个socket（通常都是server socket）等待建立连接时，另一个socket可以要求进行连接，一旦这两个socket连接起来，它们就可以进行双向数据传输，双方都可以进行发送或接收操作。（通过三次握手建立连接，经典面试题一定要下去看看）

### 2.2、UDP

UDP是（User Datagram Protocol）的简称，是一种无连接的协议，每个数据报都是一个独立的信息，包括完整的源地址或目的地址，它在网络上以任何可能的路径传往目的地，因此能否到达目的地，到达目的地的时间以及内容的正确性都是不能被保证的。

### 2.3、TCP和UDP的区别

1. UDP：

​        1、每个数据报中都给出了完整的地址信息，因此无需要建立发送方和接收方的连接。

​        2、UDP传输数据时是有大小限制的，每个被传输的数据报必须限定在64KB之内。

​        3、UDP是一个不可靠的协议，发送方所发送的数据报并不一定以相同的次序到达接收方

1.  TCP：

​        1、面向连接的协议，在socket之间进行数据传输之前必然要建立连接，所以在TCP中需要连接时间。

​        2、TCP传输数据没有大小限制，一旦连接建立起来，双方的socket就可以按统一的格式传输大的数据。

​        3、TCP是一个可靠的协议，它确保接收方完全正确地获取发送方所发送的全部数据。

### 2.4、应用：

​        1、TCP在网络通信上有极强的生命力，例如远程连接（Telnet）和文件传输（FTP）都需要不定长度的数据被可靠地传输。但是可靠的传输是要付出代价的，对数据内容正确性的检验必然占用计算机的处理时间和网络的带宽，因此TCP传输的效率不如UDP高。

​        2、UDP操作简单，而且仅需要较少的监护，因此通常用于局域网高可靠性的分散系统中client/server应用程序。例如视频会议系统，并不要求音频视频数据绝对的正确，只要保证连贯性就可以了，这种情况下显然使用UDP会更合理一些。

## 3、socket网络编程

- Socket的英文原义是“孔”或“插座”。在网络编程中，网络上的两个程序通过一个双向的通信连接实现数据的交换，这个连接的一端称为一个socket。
- Socket套接字是通信的基石，是支持TCP/IP协议的网络通信的基本操作单元。它是网络通信过程中端点的抽象表示，包含进行网络通信必须的五种信息：连接使用的协议，本地主机的IP地址，本地进程的协议端口，远地主机的IP地址，远地进程的协议端口。
- Socket本质是编程接口(API)，对TCP/IP的封装，TCP/IP也要提供可供程序员做网络开发所用的接口，这就是Socket编程接口；HTTP是轿车，提供了封装或者显示数据的具体形式；Socket是发动机，提供了网络通信的能力。

### 3.1、Socket的原理

​        Socket实质上提供了进程通信的端点。进程通信之前，双方首先必须各自创建一个端点，否则是没有办法建立联系并相互通信的。正如打电话之前，双方必须各自拥有一台电话机一样。

​        套接字之间的连接过程可以分为三个步骤：服务器监听，客户端请求，连接确认。

​        1、服务器监听：是服务器端套接字并不定位具体的客户端套接字，而是处于等待连接的状态，实时监控网络状态。

​        2、客户端请求：是指由客户端的套接字提出连接请求，要连接的目标是服务器端的套接字。为此，客户端的套接字必须首先描述它要连接的服务器的套接字，指出服务器端套接字的地址和端口号，然后就向服务器端套接字提出连接请求。

​        3、连接确认：是指当服务器端套接字监听到或者说接收到客户端套接字的连接请求，它就响应客户端套接字的请求，建立一个新的线程，把服务器端套接字的描述发给客户端，一旦客户端确认了此描述，连接就建立好了。而服务器端套接字继续处于监听状态，继续接收其他客户端套接字的连接请求。

### 3.2、socket实现

#### 3.2.1、实现步骤

对于一个功能齐全的Socket，都要包含以下基本结构，其工作过程包含以下四个基本的步骤：

1、创建Socket；

2、打开连接到Socket的输入/出流；

3、按照一定的协议对Socket进行读/写操作；

4、关闭Socket

#### 3.2.2、基于tcp的socket实现

服务端：

```Java
import com.example.tcp.ServerThread;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 黄一峰
 * @date 2024/3/8 19:24
 * @description ${NAME}
 */
public class SocketServer {
    
    public static void main(String[] args) {
       try {
          // 创建服务端socket
          ServerSocket serverSocket = new ServerSocket(8088);
          
          // 创建客户端socket
          Socket socket = new Socket();
          
          //循环监听等待客户端的连接
            while(true){
                // 监听客户端
                socket = serverSocket.accept();
                
                ServerThread thread = new ServerThread(socket);
                thread.start();
                
                InetAddress address=socket.getInetAddress();
                System.out.println("当前客户端的IP："+address.getHostAddress());
            }
       } catch (Exception e) {
          // TODO: handle exception
          e.printStackTrace();
       }
    }
 
}
```

客户端：

```Java
import java.io.*;
import java.net.Socket;

/**
 * @author 黄一峰
 * @date 2024/3/8 19:24
 * @description ${NAME}
 */
public class SocketClient {

    public static void main(String[] args) throws InterruptedException {
        try {
            // 和服务器创建连接
            Socket socket = new Socket("localhost",8088);

            // 要发送给服务器的信息
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("客户端发送信息");
            pw.flush();//刷新缓冲区

            socket.shutdownOutput();

            // 从服务器接收的信息
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String info = null;
            while((info = br.readLine())!=null){
                System.out.println("我是客户端，服务器返回信息："+info);
            }

            //关闭资源
            br.close();
            is.close();
            os.close();
            pw.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
```

server线程

```Java
import java.io.*;
import java.net.Socket;

/**
 * @author 黄一峰
 * @date 2024/3/8 19:24
 * @description ${NAME}
 */
public class ServerThread extends Thread{
    
    private Socket socket = null;
    
    public ServerThread(Socket socket) {
       this.socket = socket;
    }
 
    @Override
    public void run() {
       InputStream is=null;
        InputStreamReader isr=null;
        BufferedReader br=null;
        OutputStream os=null;
        PrintWriter pw=null;
        try {
          is = socket.getInputStream();
          isr = new InputStreamReader(is);
          br = new BufferedReader(isr);
          
          String info = null;
              
          while((info=br.readLine())!=null){
             System.out.println("我是服务器，客户端说："+info);
          }
          socket.shutdownInput();
          
          os = socket.getOutputStream();
          pw = new PrintWriter(os);
          pw.write("服务器欢迎你");
          
          pw.flush();
        } catch (Exception e) {
          // TODO: handle exception
       } finally{
          //关闭资源
            try {
                if(pw!=null)
                    pw.close();
                if(os!=null)
                    os.close();
                if(br!=null)
                    br.close();
                if(isr!=null)
                    isr.close();
                if(is!=null)
                    is.close();
                if(socket!=null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
       }
    }
}
```

#### 3.2.3、基于udp的socket实现

服务端：

```Java
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SocketClient {

    public static void main(String[] args) {
        try {
            // 要发送的消息
            String sendMsg = "客户端发送的消息";

            // 获取服务器的地址
            InetAddress addr = InetAddress.getByName("localhost");

            // 创建packet包对象，封装要发送的包数据和服务器地址和端口号
            DatagramPacket packet = new DatagramPacket(sendMsg.getBytes(),
                    sendMsg.getBytes().length, addr, 8088);

            // 创建Socket对象
            DatagramSocket socket = new DatagramSocket();

            // 发送消息到服务器
            socket.send(packet);

            // 关闭socket
            socket.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
```

客户端：

```Java
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class SocketServer {
    
    public static void main(String[] args) {
       try {
           // 要接收的报文
          byte[] bytes = new byte[1024];
          DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
          
          // 创建socket并指定端口
          DatagramSocket socket = new DatagramSocket(8088);
          
          // 接收socket客户端发送的数据。如果未收到会一致阻塞
          socket.receive(packet);
          String receiveMsg = new String(packet.getData(),0,packet.getLength());
          System.out.println(packet.getLength());
          System.out.println(receiveMsg);
          
          // 关闭socket
          socket.close();
       } catch (Exception e) {
          // TODO: handle exception
          e.printStackTrace();
       }
    }
 
}
```

大家下来细细读一下代码，相信大家看懂这些还是无压力。

## 4、websocket

寒假考核java组好像没人写双人考核，但是不知道大家看到这个没有

![img](https://github.com/LanshanTeam/Courseware-Backend-Java-2023/blob/main/Lesson10/Resource/img/img_14.png)

那这里该如何实现我们的用户间的实时通信和对战呢，可能最开始我们回想到使用轮询的方法，这个方法就是定期向服务器发送http请求，服务器收到请求后返回数据，第二次请求的时候会检查数据是否发生改变，若改变则继续发送请求，若不改变则告诉客户端继续等待。

这种方法呢，能简单的实现我们的需求，但是同时也有很多缺点，频繁的http请求会加大服务器的负载，如果服务器崩溃甚至可能丢失未保存的数据，这对用户很不友好，同时因为不能频繁请求，所以需要设置时间间隔，又会导致数据更新不及时，而且无法满足高并发场景下，大量用户的请求。所以来了解下下面的websockt双向通讯协议。

### 4.1、websocket和socket的区别

1. 底层协议：
    1. Socket：基于传输层的 TCP 或 UDP 协议。Socket 提供了一个底层的编程接口，可以实现面向连接的、可靠的双向数据流传输。
    2. WebSocket：是一种在单个 TCP 连接上进行全双工通信的应用层协议。它建立在 HTTP 协议之上，通过握手升级过程将 HTTP 连接升级为 WebSocket 连接。
2. 连接方式：
    1. Socket：使用主动发起和被动接收的方式建立连接。主动方需要知道被动方的 IP 地址和端口号，并主动发起连接请求。
    2. WebSocket：使用客户端-服务器模型，客户端发起 WebSocket 握手请求，服务器进行响应，双方建立连接后可以进行双向通信。
3. 数据传输：
    1. Socket：提供了底层的数据传输机制，可以直接发送和接收字节流或字符流。
    2. WebSocket：基于消息的传输，支持双向的文本和二进制数据传输。通过发送和接收消息，而不是原始的字节流。
4. 支持性：
    1. Socket：广泛支持各种编程语言和操作系统平台。
    2. WebSocket：也广泛支持各种编程语言和操作系统平台，但需要服务器端和客户端都支持 WebSocket 协议。
5. 适用场景：
    1. Socket：适用于需要实时、高性能的网络通信场景，如游戏、实时聊天等。
    2. WebSocket：适用于需要长连接、双向通信的应用场景，如实时推送、在线聊天室、协同编辑等。

总之：Socket是一种用于实现网络通信的编程接口。 它可以在不同的计算机之间建立连接，允许它们通过网络进行数据交换。 Socket通常使用TCP或UDP协议进行通信。 WebSocket是一种基于HTTP协议的高级协议，用于在客户端和服务器之间实现实时、双向的通信。

### 4.2、websocket的机制

WebSocket 是 HTML5 一种新的协议。它实现了浏览器与服务器全双工通信，能更好的节省服务器资源和带宽并达到实时通讯，它建立在 TCP 之上，同 HTTP 一样通过 TCP 来传输数据，但是它和 HTTP 最大不同是：

- WebSocket 是一种双向通信协议，在建立连接后，WebSocket 服务器和 Browser/Client Agent 都能主动的向对方发送或接收数据，就像 Socket 一样；
- WebSocket 需要类似 TCP 的客户端和服务器端通过握手连接，连接成功后才能相互通信

相对于传统 HTTP 每次请求-应答都需要客户端与服务端建立连接的模式，WebSocket 是类似 Socket 的 TCP 长连接的通讯模式，一旦 WebSocket 连接建立后，后续数据都以帧序列的形式传输。在客户端断开 WebSocket 连接或 Server 端断掉连接前，不需要客户端和服务端重新发起连接请求。在海量并发及客户端与服务器交互负载流量大的情况下，极大的节省了网络带宽资源的消耗，有明显的性能优势，且客户端发送和接受消息是在同一个持久连接上发起，实时性优势明显。

- websocket请求内容：

![img](https://github.com/LanshanTeam/Courseware-Backend-Java-2023/blob/main/Lesson10/Resource/img/img_15.png)

我们可以看到其实是类似于我们的http请求报文的：“Upgrade：websocket”参数值表明这是 WebSocket 类型请求，“Sec-WebSocket-Key”是 WebSocket 客户端发送的一个 base64 编码的密文，要求服务端必须返回一个对应加密的“Sec-WebSocket-Accept”应答，否则客户端会抛出“Error during WebSocket handshake”错误，并关闭连接。

- Websocket响应内容

![img](https://github.com/LanshanTeam/Courseware-Backend-Java-2023/blob/main/Lesson10/Resource/img/img_16.png)

类似的，也是长得像http响应报文：对应的里面的相关信息也就看的懂了

4.3、websocket的简单实现

想不到吧，神通广大的spring boot也帮我们整合好了

直接创建一个新的springboot项目

导入依赖：

```Java
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-websocket</artifactId>
</dependency>
```

编写WebSocketHandler

```Java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

// 这里的Handler更像是ServerEndpoint
// 需要实现WebSocketHandler接口，或者扩展TextWebSocketHandler或BinaryWebSocketHandler
public class MyWebSocketHandler extends TextWebSocketHandler {
 
    private static final Logger log = LoggerFactory.getLogger(TextWebSocketHandler.class);
 
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        log.info("message: " + message.getPayload());
    }
 
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info("afterConnectionEstablished: " + session.getId());
    }
 
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        log.info("afterConnectionClosed: " + session.getId());
    }
}
```

编写WebSocket配置类：

```Java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket    // 使用注解开启WebSocket功能
// 实现WebSocketConfigurer接口并重写registerWebSocketHandlers方法
public class WebSocketConfig implements WebSocketConfigurer {
 
    @Bean
    public MyWebSocketHandler myWebSocketHandler() {
        return new MyWebSocketHandler();
    }
 
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry
                // 注册WebSocketHandler ，/websocket是通讯的路径，例如ws://127.0.0.1:8080/websocket
                .addHandler(myWebSocketHandler(), "/websocket")
                // 可以设置拦截器 它们会在 WebSocket握手请求的时候生效
                // .addInterceptors()
                // 跨域设置
                .setAllowedOriginPatterns("*");
 
    }
}
```

通过[在线websocket测试-在线工具-postjson (coolaf.com)](http://coolaf.com/zh/tool/chattest)进行测试

访问正确地址和端口就能ping通了

# 四、Tomcat

那么代码都写完了，我们还需要一个运行它的环，当然我们web服务肯定是要运行在web服务器上，它需要一个能处理http请求的环境，显然本地肯定是不行的。于是便有了我们的tomcat。

## 1、简介：

Tomcat是由著名的apache公司打造的一款开源中间件，它提供了一系列的服务和功能，用于支持应用程序的开发、部署和运行。同时也是一个开源的 Java Web 服务器和 Servlet 容器。

## 2、作用：

1. **托管 Java Web 应用程序**：Tomcat 可以托管和运行使用 Java 技术编写的 Web 应用程序，包括 Servlet、JSP 页面等。开发人员可以将他们开发的 Java Web 应用部署到 Tomcat 中，并通过 Tomcat 提供的 Servlet 容器来处理 HTTP 请求和响应。
2. **Servlet 支持**：Tomcat 实现了 Java Servlet 规范，可以加载、管理和执行 Servlet。Servlet 是用于动态生成 Web 内容的 Java 类，Tomcat 提供了 Servlet 容器来管理 Servlet 的生命周期，处理请求和响应。
3. **JSP 支持**：Tomcat 支持 JavaServer Pages（JSP），这是一种类似于 HTML 的标记语言，可以在其中嵌入 Java 代码，用于生成动态内容。Tomcat 可以编译 JSP 页面并将其转换为 Servlet 运行。
4. **静态内容服务**：除了动态内容，Tomcat 也可以用作静态内容的 Web 服务器，可以直接提供静态文件（如 HTML、图片、CSS 文件等）的访问。
5. **连接池和线程管理**：Tomcat 提供了连接池和线程管理功能，用于管理并发请求的资源，提高性能和响应速度。
6. **安全性和权限控制**：Tomcat 提供了安全认证、访问控制和加密传输等安全功能，可以帮助确保 Web 应用程序的安全性。
7. **部署和管理工具**：Tomcat 提供了一系列的部署和管理工具，方便开发人员部署、配置和监控他们的应用程序。

总的来说，Tomcat 在 Java Web 应用程序开发中扮演着重要的角色，提供了一个运行环境和工具，使开发人员能够轻松地构建、部署和运行他们的 Web 应用程序。

## 3、使用：

这里我们不做过多赘述，感兴趣的小伙伴可以下来自己去电脑上装一个tomcat试试就会了。

平时我们使用的springboot项目中

![img](https://github.com/LanshanTeam/Courseware-Backend-Java-2023/blob/main/Lesson10/Resource/img/img_17.png)

已经默认帮我们整合了tomcat服务器了，我们需要了解一下他的作用就可以了。

## 4、其他web服务器：

除了 Tomcat，还有许多其他类似的 Web 服务器可供选择，这些服务器也可以用于托管和运行 Web 应用程序。以下是一些常见的类似 Tomcat 的 Web 服务器：

1. **Jetty**：Jetty 是一个轻量级的、可嵌入的 Web 服务器，具有良好的性能和灵活性，适合用于开发和测试环境以及需要嵌入式服务器的应用程序。
2. **Undertow**：Undertow 是一个基于 NIO 的高性能 Web 服务器，它是 Red Hat 开发的，并作为 JBoss AS 8 的默认 Web 服务器。Undertow 提供了非常简洁的 API，使得构建高性能的 Web 应用程序变得更加容易。
3. **GlassFish**：GlassFish 是一个开源的 Java EE 应用服务器，它提供了全面的 Java EE 支持，并且包含了一个内置的 Web 服务器。GlassFish 是一个功能强大的服务器，适合用于大型企业级应用程序的部署。

我们在springboot中是默认内嵌的tomcat服务器，当然我们也可以更改他

```Java
<dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
        <!-- 移除 Tomcat -->
        <exclusions>
                <exclusion>
                        <groupId>org.springframework.boot</groupId>
                        <artifactId>spring-boot-starter-tomcat</artifactId>
                </exclusion>
        </exclusions>
</dependency>

<!-- 添加 jetty 容器 -->
<dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-jetty</artifactId>
</dependency>
```

像这样在pom文件中移除tomcat容器，再加入其他的就好了

# 五、作业：

## 1、课后巩固：

1.1、将上课的代码自己下去实现一遍：socket，websocket等，可以尝试使用这些方法设计一个聊天室。（websocket除了直接使用sb框架给我们封装的以外，还可以使用原生的注解实现，可以自己下去了解）

1.2、安装一个tomcat（推荐9.0版本及以上，注意自己常用的jdk版本去查使用什么版本更合适），然后将自己的寒假考核项目打包部署到tomcat服务器**上**跑跑看，试一试能不能在浏览器上通过url ping到自己的接口。

## 2、weekly算法

[字节前端一面算法题](https://leetcode.cn/problems/SLwz0R/description/)

[三数之和](https://leetcode.cn/problems/3sum/)