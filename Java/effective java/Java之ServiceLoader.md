# Java之ServiceLoader

## 背景

effective java iterm1: 用静态工厂方法替代构造器皿，具体可见书本相关内容。本wiki
讨论在此准则下，Java 6提供的ServiceLoader框架，来实现服务提供者设计。

## 服务提供者框架

例如jdbc都是服务提供者的经典应用案例  

主要有四部分：
1. 服务提供
