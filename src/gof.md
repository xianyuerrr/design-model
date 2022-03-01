# GOF

## 面向对象、设计原则、设计模式、编程规范、重构，这五者有何关系

### 七大设计原则

| 设计原则   | 一句话归纳              | 目的            |
|:-------|--------------------|---------------|
| 开闭原则   | 对扩展开放，对修改关闭        | 降低维护带来的新风险    |
| 依赖倒置原则 | 高层不该依赖低层           | 利于代码结构的升级扩展   |
| 单一职责原则 | 一个类、方法只干一件事        | 便于理解，提高代码可读性  |
| 接口隔离原则 | 一个接口只干一件事          | 功能解耦，高内聚、低耦合  |
| 迪米特法则  | 只知道必须知道的           | 只和朋友交流，减少代码臃肿 |
| 里氏替换原则 | 子类重写方法，不应影响父类方法的含义 | 防止继承犯泛滥       |
| 合成复用原则 | 减少继承的使用            | 降低代码耦合        |

### 23 种设计模式

1. 创建型
   - 常用的有：单例模式、工厂模式（工厂方法和抽象工厂）、建造者模式。
   - 不常用的有：原型模式。
2. 结构型
   - 常用的有：代理模式、桥接模式、装饰者模式、适配器模式。
   - 不常用的有：门面模式、组合模式、享元模式。
3. 行为型
   - 常用的有：观察者模式、模板模式、策略模式、职责链模式、迭代器模式、状态模式。
   - 不常用的有：访问者模式、备忘录模式、命令模式、解释器模式、中介模式。

### 面向对象

**面向对象编程**是一种编程范式或编程风格。它以类或对象作为组织代码的基本单元，并 将封装、抽象、继承、多态四个特性，作为代码设计和实现的基石。

**面向对象编程语言**是支持类或对象的语法机制，并有现成的语法机制，能方便地实现面 向对象编程四大特性（封装、抽象、继承、多态）的编程语言。



### Factory

工厂模式 : 提供创建对象的接口，就相当于 new，但可以给系统带来更大的可扩展性 和 尽量少的修改量。

如果创建实例时的初始工作比较 ==复杂==，可能是很长一段代码，如果将 很多工作 都写入构造函数，那么代码就会显得很难看，违背了单一职责原则。

工厂方法(Factory Method) 抽象工厂(Abstract Factory)。区别在于需要创建的对象的复杂程度上。
