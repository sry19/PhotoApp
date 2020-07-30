1. RPC: <b>Remote Procedure Call</b> An RPC framework in general is a set of tools that enable the programmer to call a piece of code in a remote process, be it on a different machine or just another process on the same machine
--------------------------------------------------------------------------------------------------------------------------------------------
2. 序列化和反序列化: Serialization is a mechanism of converting the state of an object into a byte stream. Deserialization is the reverse process where the byte stream is used to recreate the actual Java object in memory.(1）永久性保存对象，保存对象的字节序列到本地文件或者数据库中To save/persist state of an object.；（2）通过序列化以字节流的形式使对象在网络中进行传递和接收To travel an object across a network.；（3）通过序列化在进程间传递对象；

Only the objects of those classes can be serialized which are <b>implementing java.io.Serializable interface</b>.

The Serialization runtime associates a version number with each Serializable class called a <b>SerialVersionUID<b>, which is used during Deserialization to verify that sender and reciever of a serialized object have loaded classes for that object which are <b>compatible<b> with respect to serialization. If the reciever has loaded a class for the object that has different UID than that of corresponding sender’s class, the Deserialization will result in an InvalidClassException. A Serializable class can declare its own UID explicitly by declaring a field name.

If a serializable class doesn’t explicitly declare a serialVersionUID, then the serialization runtime will calculate a default one for that class based on various aspects of class, as described in Java Object Serialization Specification. However it is strongly recommended that all serializable classes explicitly <b>declare serialVersionUID</b> value, since its computation is highly <b>sensitive to class details</b> that may vary depending on compiler implementations, any change in class or using different id may affect the serialized data.
------------------------------------------------------------------------------------------------------------------------------------
3. 控制反转（Inversion of Control） 就是依赖倒置原则的一种代码设计的思路。具体采用的方法就是所谓的依赖注入（Dependency Injection）不在上层类里new一个下层类
控制反转容器(IoC Container)呢？其实上面的例子中，对车类进行初始化的那段代码发生的地方，就是控制反转容器
https://www.zhihu.com/question/23277575
------------------------------------------------------------------------------------------------------------------------------------
4. Spring MVC: MVC要实现的目标是将软件用户界面和业务逻辑分离以使代码可扩展性、可复用性、可维护性、灵活性加强。
View层是界面，Model层是业务逻辑，Controller层用来调度View层和Model层，将用户界面和业务逻辑合理的组织在一起，起粘合剂的效果。所以Controller中的内容能少则少，这样才能提供最大的灵活性。
比方说，有一个View会提交数据给Model进行处理以实现具体的行为，View通常不会直接提交数据给Model，它会先把数据提交给Controller，然后Controller再将数据转发给Model。假如此时程序业务逻辑的处理方式有变化，那么只需要在Controller中将原来的Model换成新实现的Model就可以了，控制器的作用就是这么简单， 用来将不同的View和不同的Model组织在一起，顺便替双方传递消息，仅此而已。

<b>MVC 三者中，Model 是核心。</b> View 和 Controller 是外在的东西，只有 Model 是本质的东西

5. status code
200 OK                        //客户端请求成功
400 Bad Request               //客户端请求有语法错误，不能被服务器所理解
401 Unauthorized              //请求未经授权，这个状态代码必须和WWW-Authenticate报头域一起使用 
403 Forbidden                 //服务器收到请求，但是拒绝提供服务
404 Not Found                 //请求资源不存在，eg：输入了错误的URL
500 Internal Server Error     //服务器发生不可预期的错误
503 Server Unavailable        //服务器当前不能处理客户端的请求，一段时间后可能恢复正常

6. http(超文本传输协议HyperText Transfer Protocol): 客户端和服务端进行数据传输的一种规则
7.Java Bean: (1)、所有属性为private (2)、提供默认构造方法 (3)、提供getter和setter (4)、实现serializable接口
