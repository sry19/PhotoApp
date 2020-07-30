1. RPC: <b>Remote Procedure Call</b> An RPC framework in general is a set of tools that enable the programmer to call a piece of code in a remote process, be it on a different machine or just another process on the same machine
--------------------------------------------------------------------------------------------------------------------------------------------
2. 序列化和反序列化: Serialization is a mechanism of converting the state of an object into a byte stream. Deserialization is the reverse process where the byte stream is used to recreate the actual Java object in memory.(1）永久性保存对象，保存对象的字节序列到本地文件或者数据库中To save/persist state of an object.；（2）通过序列化以字节流的形式使对象在网络中进行传递和接收To travel an object across a network.；（3）通过序列化在进程间传递对象；

Only the objects of those classes can be serialized which are <b>implementing java.io.Serializable interface</b>.

If a serializable class doesn’t explicitly declare a serialVersionUID, then the serialization runtime will calculate a default one for that class based on various aspects of class, as described in Java Object Serialization Specification. However it is strongly recommended that all serializable classes explicitly <b>declare serialVersionUID</b> value, since its computation is highly <b>sensitive to class details</b> that may vary depending on compiler implementations, any change in class or using different id may affect the serialized data.
