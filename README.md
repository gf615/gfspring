### spring
 * spring是什么（可以反过来想，没有spring会怎样）
    1. 一个工具，提供了一些特性如，IOC，aop，事务管理和第三方组件集成，解决软件开发过程的复杂性、效率、使用成本。使开发人员专注于业务开发
 * 思考spring为什么大行其道，深层次原因是什么（从软件发展过程阐述更容易让人理解）
    1. 推动事物发展的三个内在因素：可用性、复杂性、效率。一个工具被广泛使用，都是解决了现在存在的问题，主要体现在可用性、复杂性和效率。
    2. spring解决了开发过程中的哪些痛点：
        1. 解耦，接口和实现解耦；代理对象和真实对象解耦；配置和使用解耦
        2. 集成各种插件，可以管理项目整个生命周期，项目架构、开发、配置、测试、打包、部署等
 * 利弊
    1. 优点
        简单、快速
    2. 弊端
        傻瓜式使用
#### spring版本及版本特性
 1. spring 1.0，所有的功能集中在一个项目中；支持第三方框架。hibernate、ibatis、模板引擎等。
 2. spring 2.x，增加对注解的支持，支持基于注解的配置
 3. spring 3.x，支持基于java类的配置
 4. spring 4.x，全面支持java8，支持Lambda表达式的使用，提供了对@Scheduled和@PropertySource重复注解的支持，提供了空指针终结者Optional，对核心容器进行增加：支持泛型的依赖注入、Map的依赖注入、Lazy延迟依赖的注入、List注入、Condition条件注解注入、对CGLib动态代理类进行了增强。还支持了基于Groovy DSL的配置，提高Bean配置的灵活性。Spring MVC基于Servlet 3.0 开发，并且为了方便Restful开发，引入了新的RestController注解器注解，同时还增加了一个AsyncRestTemplate支持Rest客户端的异步无阻塞请求。
 5. spring 5.x，jdk基线更新（1.8以上）；核心框架修订；核心容器更新；使用kotlin进行函数式编程；响应式编程模型；测试方面提示
  
#### spring生态
    spring
    spring mvc
    spring boot
    spring cloud
    spring XD
    spring data
    spring integration
    spring batch
    spring security
    。。。
        
#### spring原理
 * 核心概念IOC和代理。像其他AOP概念，注解概念，参数注入概念都是基于这两个概念
 * IOC重点关注对象之间的关系；代理对象重点关注单个对象，并对对象进行增强
 * 代理对象实现技术，动态代理和代码增强（cglib，asm）
 * 除了框架核心逻辑，平等对待自己实现和扩展实现（第三方组件，主要体现bean声明方面）
 
#### spring扩展点
 * 重点关注bean定义和bean对象。扩展点都是基于这两个方面
 * beanDefinition
    1. 加载，从哪些地方加载，也就是搜索路径
    2. bean定义属性属性处理
    3. 存储
 * bean object
    1. 初始化时间，延迟初始化和非延迟初始化
    2. 创建代理对象
    3. 特定继承或实现处理
    4. 依赖处理
    5. 存储
 * 扩展点设计
    
#### 启动过程
 * 关注实现流程
 * 关注方面，bean定义加载过程和bean对象获取过程
 * 关注扩展点设计
#### 项目测试

#### 项目打包

#### 集成第三方组件