# 蓝山工作室第九节课

> 虽然咱不是干运维的，但是咱也得了解一点相关的知识。开发人员也需要了解一丢丢运维的内容以便更好地开发和协作嘛。

## 什么是linux？

[参考文献](https://blog.csdn.net/ComputerGeekHack/article/details/88926287?spm=1001.2101.3001.6650.6&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7ERate-6-88926287-blog-109865281.pc_relevant_multi_platform_whitelistv3&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7ERate-6-88926287-blog-109865281.pc_relevant_multi_platform_whitelistv3&utm_relevant_index=11)

linux是一个操作系统，最初的版本是由芬兰的编程大佬linus研发，后来公布到开源社区之后，引起很多的黑客注意并参与到linux的设计之中。最初的代码不过几千行，但是现在已经超过2700万行，由于它的稳定和高效，已经成为企业开发首选的操作系统。

起初的linux公布到开源社区之后，就逐渐产生了分支，比如说centOs,Ubuntu，国内也有麒麟等系统

Linux的发行版本可以大体分为两类，一类是商业公司维护的发行版本，一类是社区组织维护的发行版本前者以著名的Redhat（RHEL）为代表，后者以Debian为代表。

![](https://image-9h8.pages.dev/file/20424755b8fc8b254b4db.png)

**linux的核心：**

一切皆文件

## linux镜像下载地址

[阿里云](https://developer.aliyun.com/mirror/?spm=a2c6h.25603864.0.0.23583decSAS38g)

[Linux镜像下载网站指南](https://blog.csdn.net/weixin_47853811/article/details/111054464)

对应系统的官网

## 使用VMware创建虚拟机

### 使用VMware创建linux的分区设置

Linux来说无论有几个分区，分给哪一目录使用，它归根结底就只有一个根目录，一个独立且唯一的文件结构，Linux中每个分区都是用来组成整个文件系统的一部分。
Linux采用了一种叫“载入"的处理方法，它的整个文件系统中包含了一整套的文件和目录，且将一个分区和一个目录联系起来。这时要载入的一个分区将使它的存储空间在一个目录下获得。

简单来说 Linux是将分区挂载在目录里面的，当你进入到了一个相应的目录之后，即进入了相应的分区 **使用命令`lsblk`可以查看Linux的内存分配情况**

#### `/boot`，引导分区

- **用途：** `/boot` 分区是用于存储引导加载程序和内核镜像的地方。引导加载程序负责启动操作系统，而内核是操作系统的核心部分。
- **特点：** 这个分区通常比较小，一般在几百兆到1 GB 之间。

#### `/`，根分区

- **用途：** `/` 分区是整个文件系统的根目录，包含了操作系统的所有文件和目录。在生产环境中，大部分应用和系统文件都存储在这个分区下。
- **特点：** 根分区的大小通常取决于安装的软件和数据量。它包含操作系统的核心组件和用户安装的应用程序。

#### `/swap`，交换分区

- **用途：** `/swap` 分区是交换分区，用于临时存储内存中暂时不需要的数据。当系统的物理内存（RAM）用尽时，部分数据会被移到交换分区中，以释放物理内存供其他程序使用。
- **特点：** 交换分区的大小通常是物理内存的两倍，但这取决于系统管理员的设置和需求。在某些情况下，系统可能没有交换分区，而是使用交换文件。

### 三种网络连接模式

#### 主机模式

仅主机模式表示的是物理主机与物理主机之间用同一局域网连接，虚拟机则是采用的虚拟网络连接，它与物理网络是隔开的，所以此模式下虚拟机与别的物理主机无法实现通信。一般在安装VM之后，软件会自动添加VMnet1和VMnet8两块虚拟网卡。也就是说，**仅主机模式下，只能实现虚拟机和创建虚拟机的物理主机之间的通讯**

#### NAT模式

NAT模式对应的虚拟网络为VMnet8，这是一个独立的网络。此模式下物理主机就像是一台支持NAT功能的代理服务器，虚拟机就像是NAT的客户端一样。虚拟机可以使用物理主机的IP地址访问互联网，但由于NAT技术的特点，外部网络中的主机无法主动与NAT模式下的虚拟机进行通讯。也就是说，**只能是由虚拟机到外部网络计算机的单向通信**。**物理主机与NAT模式下的虚拟机是可以互通的，前提是要虚拟机的IP与VMnet8的网卡IP在同一网段内。**

#### 桥接模式

在此模式下，[虚拟机](https://so.csdn.net/so/search?q=虚拟机&spm=1001.2101.3001.7020&login=from_csdn)就像是独立的主机，和真实的物理主机是一样的地位，可以通过虚拟机所在的物理主机访问外网，外网中的其他主机也可以访问此虚拟机

### 虚拟机克隆

用的是vmware直接复制粘贴虚拟机文件

或者说用vmware自带的克隆

### 虚机移除或者删除

虚拟机的本质就是一堆的文件，删除文件或者移动文件就可以删除虚拟机或者移动虚拟机

### vmware虚拟机快照

相当于备份，使用vmware进行快照管理，会在当前进度的条件下，创建一个备份

## linux的目录结构

在Linux的世界里，一切皆文件

| 目录        | 说明                                                         |
| :---------- | ------------------------------------------------------------ |
| /           | 根目录                                                       |
| /boot       | 包含启动 Linux 操作系统所需的文件，例如内核和引导加载程序。  |
| /root       | 是 root 用户的家目录，一般不用于存放普通用户的文件。         |
| /home       | 每个具体用户的目录， 包含每个用户的个人文件和配置文件的目录。 |
| /bin        | 存放系统启动和修复时需要的基本命令，是二进制文件的缩写。常用的指令就放在bin目录,/usr/bin,/usr/local/bin ....... |
| /etc        | 包含系统的配置文件，各种软件的配置文件也会存放在这个目录下。 |
| /dev        | 存放硬件的目录，包含设备文件，Linux 把设备映射为文件，例如硬盘、USB 设备等。 |
| /lost+found | 系统非法关机后，存放一些文件片段和修复工具生成的文件。       |
| /usr        | 存放用户安装的软件和程序，这是一个非常重要的目录，用户的很多应用程序和文件都放在这个目录下，类似与windows下的program files目录。比如说你安装的各种应用，都默认在这个文件里面。 |
| /proc       | 虚拟文件系统，提供有关系统内核和进程的信息，它是系统内存的映射，通过访问这些文件可以获取系统信息。 |
| /srv        | service 该目录存放的是一些服务启动后需要提供的数据，例如网站的数据文件。 |
| /sys        | 包含系统管理和配置的文件，提供对内核参数的访问。             |
| /tmp        | 用于存放临时文件，重启系统时可能会清空该目录。               |
| /media      | 会把插入的U盘光驱等外部设备映射到这个目录，用于挂载可移动媒体设备，例如U盘、光驱等。 |
| /mnt        | 用来做文件挂载的，可用于手动挂载其他文件系统的目录。         |
| /opt        | 一般把安装的文件装入到这个文件，用于存放额外的软件包和程序。 |
| /usr/local  | 文件安装好之后存放的目录                                     |
| /var        | 存放经常变化的文件，如日志文件、缓存文件等。                 |

## Vim和Vi

| 指令，命令模式     |                         |
| :----------------- | ----------------------- |
| vim 文件名         | 使用vim编辑             |
| :q                 | 退出，不保存            |
| :q!                | 强制退出，不保存        |
| /                  | 开始搜索，输入n进行查找 |
| :set nu/nonu       | 显示行号                |
| 行号 +shift+g      | 跳到指定的行数          |
| dd,前面可以跟数字  | 表示删除，往下删除      |
| yy，前面可以跟数字 | 表示粘贴                |
| G/gg               | 回到末尾，行首          |
| u                  | 撤回                    |
| .......            | .......                 |

## 权限

root权限最高级

linux除开root，还可以有一些其他用户，但是权限都不如root多

使用 `logout`命令可以退出当前用户

### 用户管理

`useradd+用户名` 就可以创建对应的文件夹在/home，加入参数`-d`可以创建指定目录 每次当这个用户登进去，就会去到创建的目录。

`userdel` 可以删除用户，`userdel -r`可以删除用户及其家目录

高权限到低权限不需要输入密码

#### 用户组

把具有相同权限的用户放在一起

| 指令                   | 说明                                                         |
| ---------------------- | ------------------------------------------------------------ |
| groupadd               | 创建用户组                                                   |
| useradd -g 组名 用户名 | 创建用户并为他加入组                                         |
| useradd 用户名         | 创建一个用户，他所在的组和它名字一样，加入参数-m生成在home 目录下 |
| userdel  -r用户        | 删除用户                                                     |
| usermod                | 修改用户账户                                                 |
| gpasswd                | 为组添加用户：例：把 user1加入users组<br/>gpasswd –a user1 users<br/>例：把 user1退出users组<br/>gpasswd –d user1 users |

创建组的信息都在`/etc`文件夹下面

| 目录          | 说明                                                         |
| ------------- | ------------------------------------------------------------ |
| /etc/shadow   | 口令的配置文件：每行的含义：登录名：加密口令：最后一次修改时间：最小时间间隔：最大时间间隔：警告时间：不活动时间：失效时间：标志 |
| /etc/group    | 组(group)的配置文件，记录Linux包含的组的信息<br/>每行含义：组名：口令：组标识号：组内用户列表 |
| /etc/password | 用户(user)的配置文件，记录用户的各种信息：每行的含义：用户名：口令：用户标识号：组标识号：注释性描述：主目录：登录Shell |

## linux的运行级别：

使用 `runlevel`就可以查看当前运行级别

使用 `init+级别`就可以实现改变运行级别

传统的七个运行级别：

- 运行级别0（Halt）： 关机。
- 运行级别1（Single user mode）： 单用户模式，只有基本的系统服务被启动，用于系统维护和修复。
- 运行级别2（Multi-user mode without networking）： 多用户模式，不包括网络支持。
- 运行级别3（Full multi-user mode）： 多用户模式，具有网络支持。
- 运行级别4： 未分配，可以由用户定义。
- 运行级别5（Graphical multi-user mode）： 图形多用户模式，通常是默认的图形用户界面（GUI）模式。
- 运行级别6（Reboot）： 重启系统。

在现代Linux发行版中，有些系统可能仅使用少量的运行级别，或者甚至只使用一个默认的运行级别，因为系统的管理方式和引导过程可能发生了变化。一些系统可能采用目标单元（target units）或其他方式来管理系统的状态。

## linux一些指令

### 不同的一些linux系统对应的软件包安装指令

#### Debian 和 Ubuntu（以及基于它们的发行版）

##### 安装软件包

```terminal
sudo apt-get update  # 更新软件包列表
sudo apt-get install 软件包名  # 安装软件包
```

##### 删除软件包

```
sudo apt-get remove 软件包名  # 仅删除软件包
sudo apt-get purge 软件包名   # 删除软件包及其配置文件
```

#### Red Hat、CentOS 和 Fedora

##### 安装软件包

```terminal
sudo yum install 软件包名  # 安装软件包
```

##### 删除软件包

```terminal
sudo yum remove 软件包名  # 仅删除软件包
```

#### Arch Linux

##### 安装软件包

```terminal
sudo pacman -S 软件包名  # 安装软件包
```

##### 删除软件包

```terminal
sudo pacman -R 软件包名  # 仅删除软件包
sudo pacman -Rs 软件包名 # 删除软件包及其依赖
```

#### openSUSE

##### 安装软件包

```terminal
sudo zypper install 软件包名  # 安装软件包
```

##### 删除软件包

```terminal
sudo zypper remove 软件包名  # 仅删除软件包
```

### 其他的一些指令

| 指令        | 含义                                                         | 示例                                                         |
| ----------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| help        | 获得帮助信息, 提供了简要的内置命令帮助                       | `help ls`                                                    |
| man         | 获得帮助信息, 提供详细的命令手册                             | `man ls`                                                     |
| ls/dir      | 查看当前目录下的文件                                         | `ls` <br/>`dir`                                              |
| cd   ~/:/.. | 切换目录                                                     | `cd /`<br/>`cd ..`                                           |
| mkdir       | 创建目录，加入参数-p可以创建多级目录                         | `mkdir mydir`<br/>`mkdir -p path/to/mydir`                   |
| mv          | 移动文件 移动到相同文件夹是重命名                            | `mv file1.txt /path/to/directory/` <br/>`mv oldname.txt newname.txt` |
| touch       | 创建一个空文件                                               | `touch myfile.txt`                                           |
| cp          | 赋值文件 加入-r 参数表示递归复制                             | `cp file1.txt /path/to/directory/`<br/>`cp -r source_directory/ destination_directory/` |
| rm          | 删除文件，加入-r，表示递归删除整个文件夹。 加入-f表示强制删除，如使用 rm -rf混合使用 | `rm file.txt`<br/>`rm -r mydir/`<br/>`rm -rf directory_to_delete/` |
| cat         | 加一个-n可以先显示行号，猫一眼某一个文件，不能修改           | `cat myfile.txt`<br/>`cat -n myfile.txt`                     |
| \|          | 管道，将上一个指令的结果交给管道处理                         | `cat myfile.txt | grep "pattern"`                            |
| chomd       | 给文件添加权限 后面可以用数字代表权限                        | `chmod +x myscript.sh `<br/>`chmod 644 myfile.txt`           |
| netstat -ap | 查看所有的服务端口（LISTEN，ESTABLISHED）,可以添加管道符进行过滤 | `netstat -ap`                                                |
| ......      | ......                                                       | ......                                                       |

## 使用SSH工具连接服务器

大家可能都在网上看到过一些机房的图片,里面的服务器是和我们安装的虚拟机是不一样的,它们没有显示器,那么我们应该怎么去操作这些服务器呢?

Secure Shell(SSH) 是由 IETF(The Internet Engineering Task Force) 制定的建立在应用层基础上的安全网络协议。它是专为远程登录会话(甚至可以用Windows远程登录Linux服务器进行文件互传)和其他网络服务提供安全性的协议，可有效弥补网络中的漏洞。通过SSH，可以把所有传输的数据进行加密，也能够防止DNS欺骗和IP欺骗。还有一个额外的好处就是传输的数据是经过压缩的，所以可以加快传输的速度。目前已经成为Linux系统的标准配置。

以下都是一些常用的ssh工具

> - xshell
>
> - finalshell
>
> - windTerm
>
> - terminus
>
>   ......

首先在服务器端装上相关的openSSH软件包,并启用相关服务

参考资料: [linux启用ssh服务](https://blog.csdn.net/crayon0/article/details/122272001)

然后打开我们的ssh工具,输入服务器的ip地址,登录用户和密码,这样好啦

## docker

IT界有句俗话说，所有问题都可以通过增加一层来解决。大家写过原始的javaweb就知道，复杂繁琐的webservlet促使了SpringMVC的设计模式产生，通过dispatcherServlet的适配和处理，我们的开发变得更加简单。docker也是这样：

docker是一个用来装应用的容器,就像杯子可以装水,笔筒可以放笔,书包可以放书,可以把hello word放在docker中,可以把网站放入docker中,可以把任何想得到的程序放在docker中。使用docker可以节省我们的资源，减少我们的配置。

### docker安装

[docker安装](https://www.runoob.com/docker/ubuntu-docker-install.html)

### 容器和虚拟机

**docker运行 常用命令**

```terminal
：--name:指定容器的名字
-d：后台运行容器并返回容器id，也即启动守护式容器（后台运行）
-it：为容器重新分配一个伪输入终端，通常与-i使用
-P（大写）随机的端口映射，
-p(小写)：指定端口映射
docker exec -it:进入容器内部，打开终端命令,退出不会杀死容器
docker atach -it同上，退出会杀死容器
docker inspect  可以观看容器实例信息
docker run -it -privileged=true -v /mydocker/u:/tmp/u:ro --name u2 ubuntu     ro:read only,容器只可读，不可写
docker run it -privileged=true --volumes-from 实例名称 --name 名字 ubuntu      --volumes-from表示继承某一个容器的配   
docker images: 查看镜像
docker rm: 删除容器实例
docker rmi：删除镜像
```

### 示例：使用docker部署安装mysql

```terminal
docker run -p 3306:3306 --name mysql \
-v /mydata/mysql/log:/var/log/mysql \
-v /mydata/mysql/data:/var/lib/mysql \
-v /mydata/mysql/conf.d:/etc/mysql/conf.d \
-e MYSQL_ROOT_PASSWORD=2825097536 \
-d mysql:5.7
```



**Docker镜像加载原理(浅了解)：**
docker的镜像实际上由一层一层的文件系统组成，这种层级的文件系统UnionFS。bootfs(boot file system)主要包含bootloader和kernel,.bootloader主要是引导加载kernel,Linux刚启动时会加载bootfs文件系统，在Docker镜像的最底层是引导文件系统bootfs。这一层与我们典型的Linux/Unix系统是一样的，包含boot加载器和内核。当boot加载成之后整个内核就都在内存中了，此时内存的使用权已由bootfs转交给内核，此时系统也会卸载bootfs。rootfs(root file system),在bootfs.之上.包含的就是典型Linux系统中的/dev,proc,bin,Ietc等标准目录和文件。rootfs就是各不不同的操作系统发行版，比如ubuntu,Cehtos等等**。**

读不懂吗？反正我也读不懂。。。能用就行了

**docker 发布到镜像仓库**

阿里云或者docker官网创建好仓库，想GitHub一样提交代码就好了

```terminal
docker操作阿里云常用命令
$ docker login --username=feiwoscun registry.cn-hangzhou.aliyuncs.com
$ docker tag [ImageId] registry.cn-hangzhou.aliyuncs.com/atluobin/luobin:[镜像版本号]
$ docker push registry.cn-hangzhou.aliyuncs.com/atluobin/luobin:[镜像版本号]

```

注意/atluobin/luobin，这个实例里面的镜像版本不可以重复，重复会把原始的镜像覆盖掉

### docker容器数据卷

Docker挂载主机目录访问如果出现cannot open directory:Permission denied
解决办法：在挂载目录后多加一个-privileged=true参数即可
如果是CentOS7安全模块会比之前系统版本加强，不安全的会先禁止，所以目录挂载的情况被默认为不安全的行为，在SELinux里面挂载目录被禁止掉了，如果要开启，我们一般使用-privileged=true命令，扩大容器的权限解决挂载目录没有权限的问题，也即使用该参数，container内的root拥有真正的root权限，否则，container内的root只是外部的一个普通用户权限  。

```terminal
docker run -d -p5000:5000 -v /mydata/config:/data/config
```

-v:就是容器数据卷，可以做到多个实例都享用同一份文件

将运用与运行的环境打包镜像，run后形成容器实例运行，但是我们对数据的要求希望是持久化的
Docker容器产生的数据，如果不备份，那么当容器实例别除后，容器内的数据自然也就没有了。
为了能保存数据在docker中我们使用卷。
特点：
1：数据卷可在容器之间共享或重用数腿
2：卷中的更改可以直接实时生效，爽，
3:数据卷中的更改不会包含在镜像的更新中
4:数据卷的生命周期一直持续到没有容器使用它为止

### docker network网络

| 网络模式 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| host     | 容器将不会虚拟出自己的网卡，配置自己的iP等，而是便用宿主机的P和端口。 |
| none     | 容器有独立的Network namespace,但并没有对其进行任何网络设置，如分配veth pair和网桥连接，IP等。 |
| containe | 新创建的容器不会创建自己的网卡和配置自己的iP,而是和一个指定的容器共享P、端口范围等。 |
| bridge   | 为每一个容器分配，设置ip等，并将容器连接到一个docker0，**虚拟网桥，默认该模式** |

### idea安装docker插件

在插件市场找到docker后进行下载

在设置里，点击docker进行连接，选择tcp进行连接，然后输入你的ip地址加端口号2375,如 tcp://111.111.1.1:2375 等一会儿他就会显示链接成功

可以参考一些文章: [IntelliJ IDEA中配置和使用Docker](https://blog.csdn.net/axibazz/article/details/118364899)

如果连接不上，可以尝试:

```terminal
#使用root登录终端：
#修改Docker服务文件，需要先切换到root用户
vim /lib/systemd/system/docker.service
#注释掉"ExecStart"这一行，并添加下面这一行信息
ExecStart=/usr/bin/dockerd -H fd:// --containerd=/run/containerd/containerd.sock -H tcp://0.0.0.0:2375
```



## 使用docker进行部署

### 编写dockerfile文件

Dockerfile 是用于构建 Docker 镜像的文本文件，其中包含了一系列指令，每个指令对应一个镜像层的操作。通过编写 Dockerfile，可以定义应用程序的环境、依赖关系和运行时配置。

简单的 Dockerfile 的例子：

```dockerfile
# 使用官方的基础镜像，这里以Alpine Linux为例
FROM alpine:latest

# 设置镜像的作者信息
LABEL maintainer="your-name <your-email@example.com>"

# 在容器内创建一个新目录
WORKDIR /app

# 将当前目录下的所有文件复制到容器的 /app 目录中
COPY . .

# 安装应用所需的依赖
RUN apk --no-cache add python3

# 设置环境变量
ENV APP_PORT=8080

# 声明容器将要监听的端口
EXPOSE $APP_PORT

# 定义容器启动时执行的命令
CMD ["python3", "app.py"]

```

- `FROM`：指定基础镜像，即构建新镜像所基于的镜像。在本例中，使用了最新版本(latest)的 Alpine Linux。
- `LABEL`：设置镜像的元数据，如作者信息、版本等。
- `WORKDIR`：设置工作目录，即后续指令的执行目录。
- `COPY`：将本地文件复制到容器内。在这里，将当前目录下的所有文件复制到容器的 `/app` 目录中。
- `RUN`：在镜像构建过程中执行命令。在这里，使用 `apk` 包管理器安装了 Python3。
- `ENV`：设置环境变量。
- `EXPOSE`：声明容器将要监听的端口。这并不会自动映射端口，只是用于标记容器中应用程序可能使用的端口。
- `CMD`：定义容器启动时执行的默认命令。

#### Dockerfile 中常用的一些指令

| 指令       | 用途                                                         | 示例                                                    |
| ---------- | ------------------------------------------------------------ | ------------------------------------------------------- |
| FROM       | 指定基础镜像，构建新镜像的起点                               | `FROM ubuntu:20.04`                                     |
| LABEL      | 设置镜像的元数据，如作者、版本、描述等                       | `LABEL maintainer="your-name <your-email@example.com>"` |
| RUN        | 在构建过程中执行命令，用于安装软件、更新系统等操作           | `RUN apt-get update && apt-get install -y python3`      |
| WORKDIR    | 设置工作目录，即后续指令的执行目录                           | `WORKDIR /app`                                          |
| USER       | 指定容器中运行的用户                                         | `USER nobody`                                           |
| ENV        | 设置环境变量，在构建过程中配置容器的环境                     | `ENV MY_PATH /usr/mytest`                               |
| VOLUME     | 声明容器内的挂载点，用于持久化数据                           | `VOLUME ["/data"]`                                      |
| ADD        | 将宿主机目录下的文件拷贝进镜像，同时会自动处理 URL 和解压 tar 压缩包 | `ADD ./files /app`                                      |
| COPY       | 类似于 ADD，将宿主机目录下的文件拷贝进镜像，但不会自动处理 URL 和解压 tar | `COPY ./files /app`                                     |
| EXPOSE     | 声明容器将要监听的端口，供其他容器或主机连接                 | `EXPOSE 80`                                             |
| CMD        | 定义容器启动时执行的默认命令，可被覆盖                       | `CMD ["nginx", "-g", "daemon off;"]`                    |
| ENTRYPOINT | 类似于 CMD，但不会被覆盖。定义容器的主要运行命令，CMD 提供默认参数 | `ENTRYPOINT ["nginx", "-g", "daemon off;"]`             |

### 使用docker-compose部署编排

只使用dockerfile进行创建镜像会有很多的问题，比如当项目部署的时候有redis，mysql这样的镜像启动顺序，或者说容器间的ip地址发生了变化，映射出错，要么生产ip写死，要么通过服务调用。

使用docker-compose可以做到集中管理，一套带走

### 安装docker-compose

```terminal
//下载
sudo curl -L "https://github.com/docker/compose/releases/download/v2.14.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose

 //授权   
sudo chmod +x usr/local/bin/docker-compose
    
```

**[docker-compose安装](https://www.runoob.com/docker/docker-compose.html)**

### 编写docker-compose.yml文件

#### 什么是docker-compose.yml文件？

Docker Compose 是一个用于定义和运行多容器 Docker 应用程序的工具。它通过一个单独的 `docker-compose.yml` 文件来配置应用的服务、网络和卷。下面是一个简单的 `docker-compose.yml` 文件的例子，以说明其基本结构和一些常见配置项：

```yml
version: '3'  # Docker Compose 文件版本

services:  # 定义应用的服务
  web:  # 服务名称
    image: nginx:latest  # 使用的镜像
    ports:  # 定义端口映射
      - "8080:80"  # 将容器的 80 端口映射到主机的 8080 端口
    volumes:  # 定义卷挂载
      - ./web-content:/usr/share/nginx/html  # 将主机上的 ./web-content 目录挂载到容器的 /usr/share/nginx/html 目录
    networks:  # 定义网络
      - frontend
    environment:  # 设置环境变量
      - NGINX_VERSION=latest

  db:
    image: mysql:5.7
    environment:
      - MYSQL_ROOT_PASSWORD=root_password
      - MYSQL_DATABASE=my_database
      - MYSQL_USER=user
      - MYSQL_PASSWORD=password
    volumes:
      - db-data:/var/lib/mysql
    networks:
      - frontend
      - backend

networks:  # 定义网络
  frontend:
  backend:

volumes:  # 定义卷
  db-data:
  web-content:
```

- `version`：指定 Docker Compose 文件的版本。目前常用的版本是3。
- `services`：定义应用的各个服务，每个服务包含一个或多个容器。
- `image`：指定服务所使用的镜像。
- `ports`：定义端口映射，将容器内的端口映射到主机上的端口。
- `volumes`：定义卷挂载，将主机上的目录或卷挂载到容器内。
- `networks`：定义服务使用的网络，以及服务之间的连接关系。
- `environment`：设置容器的环境变量。
- `volumes`：定义卷，用于持久化数据。

#### docker-compose常用命令

| 指令       | 说明                             |
| ---------- | -------------------------------- |
| -h         | 查看帮助                         |
| up         | 启动所有的docker-compose服务     |
| up -d      | 启动所有的服务并后台运行         |
| down       | 停止并删除容器，网络，卷，镜像   |
| exec       | 进入容器的实例内部               |
| ps         | 展示当前编排过的运行的所有的容器 |
| top        | 展示当前编排过的容器进程         |
| logs       | 查看容器输出日志                 |
| config     | 检查配置                         |
| config  -q | 检查配置，输出问题               |
| restart    | 重启服务                         |
| start      | 启动服务                         |
| stop       | 停止服务                         |

一个docker-compose模板

   ```yml
version: 'xxx' # 版本号
    
services: # 固定写死，代表有几个服务实例
  microService: # 自定义服务名
    image: zzyy_docker:1.6 #镜像名字:版本号
    container_name: ms01
    volumes: # 容器数据卷
    	- /app/microService:/data
    network: # docker网络配置
    	- atguigu_net
    depends_on: # 依赖
    	- redis
    	- mysql

# docker run -p 6379:6379 --name redis608 --privileged=true -v /app/redis/redis.conf:/etc/redis/redis.conf -v /app/redis/data:/data -d redis:6.0.8 redis-server /etc/redis/redis.conf
  redis:
  	images: redis:6.0.8
  	ports: # 端口映射
  		- "6379:6379"
  	volumes:
  		- /app/redis/redis.conf:/etc/redis/redis.conf
  		- /app/redis/data:/data
  	networks:
  		- atguigu_net
  	command: redis-server /etc/redis/redis.conf # 命令

# docker run -p 3306:3306 --name mysql5.7 --privileged=true -v /app/mysql/db:/var/lib/mysql -v /app/mysql/mysql_config:/etc/mysql -v /app/mysql/init:/docker-entrypoint-initdb.d -e MYSQL_ROOT_PASSWORD=123456 -d mysql:5.7
  mysql:
    image: mysql:5.7
    environment: # 环境配置
      - MYSQL_ROOT_PASSWORD: "123456"
      - MYSQL_DATABASE: "db"
      - MYSQL_USER: "zzyy"
      - MYSQL_PASSWORD: "zzyy123"
    ports:
      - "3306:3306"
    volumes:
      - /app/mysql/db:/var/lib/mysql
      - /app/mysql/mysql_config:/etc/mysql
      - /app/mysql/init:/docker-entrypoint-initdb.d
    network:
      - auguigu_net
    command: --default-authentication-plugin=mysql_native_password # 解决外部无法访问

# docker network create atguigu_net
network:
	atguigu_net

   ```

编写好之后，使用`docker-compose up -d` 可以一次性的把需要的容器给创建好，就省去了很多麻烦。

### 实战: docker-compose部署springboot项目

我们就来尝试一下使用docker-compose部署一个简单的springboot项目

> 为了方便我把相关文件放在了/static下

#### Dockerfile

```dockerfile
#依赖jdk17环境
FROM khipu/openjdk17-alpine

#对外暴露8081
EXPOSE 8081
#复制server-1.0-SNAPSHOT到docker容器中并命名为app.jar
ADD springboot_test-1.0-SNAPSHOT.jar app.jar
#执行命令
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

#### docker-compose.yml

```yml
version: '3'
services:
  springboot:
    image: springboot:latest
    build: .
    ports:
      - 8081:8081
    volumes:
      - /usr/photo:/usr/photo # 实际上在本次示例中部署的项目上并没有什么用,可写可不写
    depends_on:
      - mysql
  mysql:
    image: mysql:8.0.20
    container_name: mysql
    restart: always
    ports:
      - 3306:3306
    volumes:
      - dbdata:/var/lib/mysql
      - ./init.sql:/docker-entrypoint-initdb.d/init.sql  # 将你的 SQL 文件挂载到容器内的初始化目录
    environment:
      MYSQL_DATABASE: webserver
      MYSQL_ROOT_USER: root
      MYSQL_ROOT_PASSWORD: 123456
      MYSQL_ROOT_HOST: '%'
      TZ: Asia/Shanghai
    command: ["--init-file", "/docker-entrypoint-initdb.d/init.sql"]  # 执行初始化 SQL 文件
volumes:
  dbdata:
  imagedata:
```

然后我们直接`docker-compose up`就行啦!

