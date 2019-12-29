# Java之ServiceLoader

## 背景

effective java iterm1: 用静态工厂方法替代构造器，具体可见书本相关内容。本wiki
讨论在此准则下，Java 6提供的ServiceLoader框架，来实现服务提供者设计。

## 服务提供者框架

例如jdbc都是服务提供者的经典应用案例  

主要有四部分：

1. 服务接口

2. 提供者注册API

3. 服务访问API

4. 服务提供者接口（可选）

例如JDBC, Connection为服务接口, 这是提供者需要实现的, DriverManager.registerDriver是提供者注册API, DriverManager.getConnection是服务访问API, Driver是服务提供者接口

## java.util.ServiceLoader

JDK的ServiceLoader提供了SPI框架，可以基于ServiceLoader比较容易地实现面向服务的注册与发现，完成服务提供与使用的解耦

### 使用

先看下javadoc中对ServiceLoader的描述:

一个简单的服务提供者加载工具

服务: 接口以及类(抽象)的集合。 一个服务提供者就是一个服务的具体实现. 一个提供者中的类往往实现(继承)了服务中的接口(抽象类)。
服务提供者可以扩展的形式加载到java平台中，例如放在任务扩展目录下的jar包。

- 服务接口定义

```java
package com.lijian.effectivejava.demo.serviceloader;

public interface Dance {
    String getName();
    void printDescription();
}
```

- 注册提供者

[![lushqK.md.png](https://s2.ax1x.com/2019/12/29/lushqK.md.png)](https://imgchr.com/i/lushqK)
[![luyKJJ.md.png](https://s2.ax1x.com/2019/12/29/luyKJJ.md.png)](https://imgchr.com/i/luyKJJ)

- 服务访问

```java
package com.lijian.effectivejava.demo.serviceloader;

import java.util.ServiceLoader;

public class ServiceLoad {

    private static final  ServiceLoader<Dance> DANCES
            = ServiceLoader.load(Dance.class);

    public static Dance getDance(String name) {
        for (Dance dance : DANCES) {
            System.out.println(dance.getName());
            if (name.equals(dance.getName())) {
                return dance;
            }
        }
        return null;
    }

    public static void main(String args[]) {
        ServiceLoad serviceLoad = new ServiceLoad();
        Dance dance = serviceLoad.getDance("HipHop");
        if (dance != null) {
            dance.printDescription();
        } else {
            System.out.println("no such dance");
        }
    }
}
```

- 提供者实现

```java
package com.lijian.effectivejava.demo.serviceloader;

public class Poppin implements Dance {

    @Override
    public String getName() {
        return "Poppin";
    }

    @Override
    public void printDescription() {
        System.out.println("Well, I am not only a robot :), Poppin is me");
    }
}
```

```java
package com.lijian.effectivejava.demo.serviceloader;

public class HipHop implements Dance{

    @Override
    public String getName() {
        return "HipHop";
    }

    @Override
    public void printDescription() {
        System.out.println("what's up man, this's HipHop");
    }
}

```

### 高阶使用

待更
