# GOF

## 面向对象、设计原则、设计模式、编程规范、重构，这五者有何关系


## [七大设计原则](./DesignPrinciples/七大设计原则.md)

## [23 种设计模式](./DesignPatterns/23种设计模式.md)

## 面向对象

**面向对象编程**是一种编程范式或编程风格。它以类或对象作为组织代码的基本单元，并 将封装、抽象、继承、多态四个特性，作为代码设计和实现的基石。

**面向对象编程语言**是支持类或对象的语法机制，并有现成的语法机制，能方便地实现面 向对象编程四大特性（封装、抽象、继承、多态）的编程语言。

**面向过程编程**也是一种编程范式或编程风格。它以过程（可以为理解方法、函数、操作）作为组织代码的基本单元，
以数据（可以理解为成员变量、属性）与方法相分离为最主要的特点。面向过程风格是一种流程化的编程风格，通过拼接一组顺序执行的方法来操作数据完成一项功能。

**面向过程编程语言**首先是一种编程语言。它最大的特点是不支持类和对象两个语法概念，不支持丰富的面向对象编程特性（比如继承、多态、封装），
仅支持面向过程编程。

OOP 的优势：
- OOP 更能应对大规模复杂程序的开发。
- OOP 风格代码更易复用、扩展、维护。
- OOP 语言更加人性化、只能、高级。

面向对象四大特性：
- 封装。封装也叫作信息隐藏或者数据访问保护。类通过暴露有限的访问接口，授权外部仅能通过类提供的方式来访问内部信息或者数据。 
  一方面是保护数据不被随意修改，提高代码的可维护性；另一方面是仅暴露有限的必要接口，提高类的易用性。
- 抽象。抽象就是讲如何隐藏方法的具体实现，让使用者只需要关心方法提供了哪些功能，不需要知道这些功能是如何实现的。
  一方面是提高代码的可扩展性、维护性，修改实现不需要改变定义，减少代码的改动范围；另一方面，它也是处理复杂系统的有效手段，能有效地过滤掉不必要关注的信息。
- 继承。表示类之间的 is-a 关系，分为两种模式：单继承和多继承。主要是用来解决代码复用的问题。
- 多态。指子类可以替换父类，在实际的代码运行过程中，调用子类的方法实现。可以提高代码的扩展性和复用性。

三种违反面向对象编程风格的典型代码设计：
- 滥用 getter、setter 方法。
   在设计实现类的时候，除非真的需要，否则尽量不要给属性定义 setter 方法。除此之外，尽管 getter 方法相对 setter 方法要安全些，
   但是如果返回的是集合容器，那也要防范集合内部数据被修改的风险。
- Constants 类、Utils 类的设计问题。尽量能做到职责单一，定义一些细化的小类，避免定义大而全的类。除此之
  外，如果能将这些类中的属性和方法，划分归并到其他业务类中，那是最好不过的了，能极大地提高类的内聚性和代码的可复用性。
-  基于贫血模型的开发模式。数据和操作是分开定义在 VO/BO/Entity 和 Controler/Service/Repository 中的。


### 接口

接口与抽象类
- 如果我们要表示一种 is-a 的关系，并且是为了解决代码复用的问题，我们就用抽象类；
- 如果我们要表示?一种 has-a 关系，并且是为了解决抽象而非代码复用的问题，那我们就可以使用接口。

基于接口而非实现编程:
- “基于抽象而非实现编程”，我们在做软件开发的时候，一定要有抽象意识、封装意识、接口意识。越抽象、越顶层、越脱离具体某一实现的设计，
越能提高代码的灵活性、扩展性、可维护性。
- 我们在定义接口的时候，一方面，命名要足够通用，不能包含跟具体实现相关的字眼；另一方面，与特定实现有关的方法不要定义在接口中。


### 继承与组合

- 继承是面向对象的四大特性之一，用来表示类之间的 is-a 关系，可以解决代码复用的问题。虽然继承有诸多作用，但继承层次过深、过复杂，
也会影响到代码的可维护性。在这种情况下，我们应该尽量少用，甚至不用继承。

- 继承主要有三个作用：表示 is-a 关系，支持多态特性，代码复用。而这三个作用都可以通过组合、接口、委托三个技术手段来达成。
除此之外，利用组合还能解决层次过深、过复杂的继承关系影响代码可维护性的问题。

- 尽管我们鼓励多用组合少用继承，但组合也并不是完美的，继承也并非一无是处。在实际的项目开发中，我们还是要根据具体的情况，来选择该用继承还是组合。
如果类之间的继承结构稳定，层次比较浅，关系不复杂，我们就可以大胆地使用继承。反之，我们就尽量使用组合来替代继承。
除此之外，还有一些设计模式、特殊的应用场景，会固定使用继承或者组合。


## 代码质量

### 重构
1. 为什么重构

对于项目来言，重构可以保持代码质量持续处于一个可控状态，不至于腐化到无可救药的地步。对于个人而言，重构非常锻炼一个人的代码能力，
并且是一件非常有成就感的事情。它是我们学习的经典设计思想、原则、模式、编程规范等理论知识的练兵场。

2. 重构什么

按照重构的规模，我们可以将重构大致分为大规模高层次的重构和小规模低层次的重构。大规模高层次重构包括对代码分层、模块化、解耦、梳理
类之间的交互关系、抽象复用组件等等。这部分工作利用的更多的是比较抽象、比较顶层的设计思想、原则、模式。
小规模低层次的重构包括规范命名、注释、修正函数参数过多、消除超大类、提取重复代码等等编程细节问题，主要是针对类、函数级别的重构。
小规模低层次的重构更多的是利用编码规范这一理论知识。

3. 什么时候重构

我反复强调，我们一定要建立持续重构意识，把重构作为开发必不可少的部分，融入到日常开发中，而不是等到代码出现很大问题的时候，再大刀阔斧地重构。

4. 如何重构

大规模高层次的重构难度比较大，需要组织、有计划地进行，分阶段地小步快跑，时刻让代码处于一个可运行的状态。而小规模低层次的重构，
因为影响范围小，改动耗时短，所以，只要你愿意并且有时间，随时随地都可以去做。

### 单元测试
单元测试是代码层面的测试，由研发自己来编写，用于测试“自己”编写的代码的逻辑的正确性。单元测试顾名思义是测试一个“单元"，有别于集成测试，
这个“单元“一般是类或函数，而不是模块或者系统。

写单元测试的过程本身就是代码Code Review和重构的过程，能有效地发现代码中的bug和代码设计上的问题。
除此之外，单元测试还是对集成测试的有力补充，还能帮助我们快速熟悉代码，是TDD可落地执行的改进方案。

写单元测试就是针对代码设计各种测试用例，以覆盖各种输入、异常、边界情况，并将其翻译成代码。我们可以利用一些测试框架来简化单元测试的编写。
除此之外，对于单元测试，我们需要建立以下正确的认知：
- 编写单元测试尽管繁琐，但并不是太耗时；
- 我们可以稍微放低对单元测试代码质量的要求；
- 覆盖率作为衡量单元测试质量的唯一标准是不合理的；
- 单元测试不要依赖被测代码的具体实现逻辑；
- 单元测试框架无法测试，多半是因为代码的可测试性不好。

一方面，写单元测试本身比较繁琐，技术挑战不大，很多程序员不愿意去写；另一方面，国内研发比较偏向“快、糙、猛"，容易因为开发进度紧，
导致单元测试的执行虎头蛇尾。最后，关键问题还是团队没有建立对单元测试正确的认识，觉得可有可无，单靠督促很难执行得很好。

### 可测试性
1. 定义

粗略地讲，所谓代码的可测试性，就是针对代码编写单元测试的难易程度。对于一段代码，如果很难为其编写单元测试，或者单元测试写起来很费劲，
需要依靠单元测试框架中很高级的特性，那往往就意味着代码设计得不够合理，代码的可测试性不好。

2. 编写可测试性代码的最有效手段

依赖注入是编写可测试性代码的最有效手段。通过依赖注入，我们在编写单元测试的时候，可以通过mock的方法解依赖外部服务，
这也是我们在编写单元测试的过程中最有技术挑战的地方。

3. 常见的Anti-Patterns
- 代码中包含未决行为逻辑
- 滥用可变全局变量
- 滥用静态方法
- 使用复杂的继承关系
- 高度耦合的代码

### 如何发现代码问题
#### 常规checklist
1. 目录设置是否合理、模块划分是否清晰、代码结构是否满足“**高内聚、松耦合**”？ 
2. 是否遵循经典的**设计原则和设计思想**（SOLID、DRY、KISS、YAGNI、LOD 等）？ 
3. 设计模式是否应用得当？是否有**过度设计**？ 
4. 代码是否容易**扩展**？如果要添加新功能，是否容易实现？ 
5. 代码是否可以**复用**？是否可以复用已有的项目代码或类库？是否有重复造轮子？ 
6. 代码是否容易**测试**？单元测试是否全面覆盖了各种正常和异常的情况？ 
7. 代码是否**易读**？是否符合编码规范（比如命名和注释是否恰当、代码风格是否一致
等）？

#### 业务需求checklist
8. 代码是否实现了预期的业务**需求**？
9. **逻辑**是否正确？是否处理了各种异常情况？ 
10. **日志**打印是否得当？是否方便 debug 排查问题？ 
11. 接口是否**易用**？是否支持幂等、事务等？ 
12. 代码是否存在**并发**问题？是否线程安全？ 
13. **性能**是否有优化空间，比如，SQL、算法是否可以优化？ 
14. 是否有**安全**漏洞？比如输入输出校验是否全面？


## 代码规范
### 命名
- 命名的关键是能准确达意。对于不同作用域的命名，我们可以适当地选择不同的长度。作用域小的变量（比如临时变量），
可以适当地选择短一些的命名方式。除此之外，命名中也可以使用一些耳熟能详的缩写。
- 我们可以借助类的信息来简化属性、函数的命名，利用函数的信息来简化函数参数的命名。
- 命名要可读、可搜索。不要使用生僻的、不好读的英文单词来命名。除此之外，命名要符合项目的统一规范，不要用些反直觉的命名。
- 接口有两种命名方式：一种是在接口中带前缀“I”；另一种是在接口的实现类中带后缀“Impl"。
- 对于抽象类的命名，也有两种方式，一种是带上前缀“Abstract”，一种是不带前缀。这两种命名方式都可以，关键是要在项目中统一。

### 注释
- 注释的目的就是让代码更容易看懂。只要符合这个要求的内容，你就可以将它写到注释里。
- 注释的内容主要包含这样三个方面：做什么、为什么、怎么做。 对于一些复杂的类和接口，我们可能还需要写明“如何用"。
- 注释本身有一定的维护成本，所以并非越多越好。
- 类和函数一定要写注释，而且要写得尽可能全面、详细。
- 而函数内部的注释要相对少一些，一般都是靠好的命名、提炼函数、解释性变量、总结性注释来提高代码可读性。

### 风格
- 函数的代码行数不要超过一屏幕的大小，比如50行。类的大小限制比较难确定。
- 一行代码最好不要超过IDE显示的宽度。当然，限制也不能太小，太小会导致很多稍微长点的语句被折成两行，不利于阅读。
- 对于比较长的函数，为了让逻辑更加清晰，可以使用空行来分割各个代码块。在类内部，成员变量与函数之间、静态成员变量与普通成员变量之间、
函数之间，甚至成员变量之间，都可以通过添加空行的方式，让不同模块的代码之间的界限更加明确。
- 两格缩进可以节省空间，特别是在代码嵌套层次比较深的情况下。值得强调的是，不管是用两格缩进还是四格缩进，一定不要用tab键缩进。
- 我个人还是比较推荐将大括号放到跟上一条语句同一行的风格，这样可以节省代码行数。但是，将大括号另起一行，也有它的优势，
那就是，左右括号可以垂直对齐，哪些代码属于哪一个代码块，更加一目了然。
- 在Google Java编程规范中，依赖类按照字母序从小到大排列。类中先写成员变量后写函数。
成员变量之间或函数之间，先写静态成员变量或函数，后写普通变量或函数，并且按照作用域大小依次排列。

