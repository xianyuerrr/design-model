# 接口鉴权系统

## 需求分析

### 初版
通过 appId 和 password 来进行验证。

### 优化版
明文传输不安全，无法防止重放攻击。

可以借助加密算法，但其仍旧不安全，无法防御重放攻击。

借助 OAuth 的验证思路：
- 调用方将请求接口的 URL 跟 AppID、password 拼接在一起，然后进行加密，生成一个 token。
调用方在进行接口请求的的时候，将这个 token 及 AppID，随 URL 一块传递给微服务端。
- 微服务端接收到这些数据之后，根据 AppID 从数据库中取出对应的密码，并通过同样的 token 生成算法，生成另外一个 token。用这个新
生成的 token 跟调用方传递过来的 token 对比。如果一致，则允许接口调用请求；否则，就拒绝接口调用请求。

### 再优化版

这样的设计仍旧存在重放攻击的风险，不够安全。生成的 token 是固定的。

我们可以进一步优化 token 生成算法，引入一个随机变量，让每次接口请求生成的 token 都不一样。
我们可以选择时间戳作为随机变量。原来的 token 是对 URL、AppID、password 三者进行加密生成的，
现在我们将 URL、AppID、password、时间戳四者进行加密来生成 token。
调用方在进行接口请求的时候，将 token、AppID、时间戳，随 URL 一并传递给微服务端。

服务端还可以根据时间戳来判断 token 是否过期，不过期再根据 appId 取得对应 password 生成 token 进行比较。


### 最终版

还有一个细节我们没有考虑到，那就是如何在微服务端存储每个授权调用方的 AppID 和 password。当然，这个问题并不难。
最容易想到的方案就是存储到数据库里，比如 MySQL。不过，开发像鉴权这样的非业务功能，最好不要与具体的第三方系统有过度的耦合。

针对 AppID 和密码的存储，我们最好能灵活地支持各种不同的存储方式，比如 ZooKeeper、本地配置文件、自研配置中心、MySQL、Redis 等。
我们不一定针对每种存储方式都去做代码实现，但起码要留有扩展点，保证系统有足够的灵活性和扩展性，能够在我们切换存储方式的时候，尽可能地减少代码的改动。

### 需求总结
1. 把 URL、AppID、密码、时间戳拼接为一个字符串；
2. 对字符串通过加密算法加密生成 token；
3. 将token、AppID、时间戳拼接到URL中，形成新的URL；
4. 解析URL，得到 token、AppID、时间戳等信息；
5. 从存储中取出 AppID 和对应的密码；
6. 根据时间戳判断 token 是否过期失效；
7. 验证两个token 是否匹配；

## 类定义

### AuthToken

AuthToken类相关的功能点有四个：
1. 把URL、AppID、密码、时间戳拼接为一个字符串；
2. 对字符串通过加密算法加密生成token；
3. 根据时间戳判断token是否过期失效；
4. 验证两个token是否匹配。

可以做如下实现：[AuthToken](src/main/java/com/xianyue/Authencator/AuthToken.java)

可以发现这样三个小细节。
1. 并不是所有出现的名词都被定义为类的属性，比如URL、AppID、密码、时间戳这几个名词，我们把它作为了方法的参数。
2. 我们还需要挖掘一些没有出现在功能点描述中属性，比如 create Time，expireTimelnterval，它们用在isExpired0函数中，用来判定 token是否过期。
3. 我们还给AuthToken类添加了一个功能点描述中没有提到的方法getToken0。

第一个细节告诉我们，从业务模型上来说，不应该属于这个类的属性和方法，不应该被放到这个类里。比如 URL、AppID 这些信息，从业务模型上来说，
不应该属于 AuthToken，所以我们不应该放到这个类中。

第二、三个细节告诉我们，在设计类具有哪些属性和方法的时候，不能单纯地依赖当下的需求，还要分析这个类从业务模型上来讲，
理应具有哪些属性和方法。这样可以一方面保证类定义的完整性，另一方面不仅为当下的需求还为未来的需求做些准备。


### Url

Url类相关的功能点有两个：
1. 将 token、ApplD、时间戳拼接到URL中，形成新的URL
2. 解析URL，得到token、ApplD、时间戳等信息。

虽然需求描述中，我们都是以 URL 来代指接口请求，但是，接口请求并不一定是以 URL 的形式来表达，还有可能是 dubbo RPC 等其他形式。
为了让这个类更加通用，命名更加贴切，我们接下来把它命名为 ApiRequest。

可以做如下实现：[ApiRequest](src/main/java/com/xianyue/Authencator/ApiRequest.java)

### CredentialStorage 

CredentialStorage 类相关的功能点有一个：从存储中取出AppID和对应的密码。

为了做到抽象封装具体的存储方式，我们将 CredentialStorage 设计成了接口，基于接口而非具体的实现编程。

可以做如下实现：[CredentialStorage](src/main/java/com/xianyue/Authencator/CredentialStorage.java), [MysqlCredentialStorage](src/main/java/com/xianyue/Authencator/MysqlCredentialStorage.java)


## 入口

类定义好了，类之间必要的交互关系也设计好了，接下来我们要将所有的类组装在一起，提供一个执行入口。这个入口可能是一个 main（）函数，
也可能是一组给外部用的 API 接口。通过这个入口，我们能触发整个代码跑起来。

接口鉴权并不是一个独立运行的系统，而是一个集成在系统上运行的组件，所以，我们封装所有的实现细节，
设计了一个最顶层的 ApiAuthencator 接口类，暴露一组给外部调用者使用的 API 接口，作为触发执行鉴权逻辑的入口。

可以做如下实现：[ApiAuthencator](src/main/java/com/xianyue/Authencator/ApiAuthencator.java), [DefaultApiAuthencatorImpl](src/main/java/com/xianyue/Authencator/DefaultApiAuthencatorImpl.java)

## 总结

1. 划分职责进而识别出有哪些类
2. 定义类及其属性和方法
3. 定义类与类之间的交互关系
4. 将类组装起来并提供执行入口