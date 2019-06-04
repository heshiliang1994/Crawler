<https://blog.csdn.net/sky_100/article/details/77541968>

1.通过访问的域名找出其IP地址 
2.TCP/TP三次握手 
3.进入tomcat后如何处理的 
4.TCP/IP四次挥手（如果需要的话） 
一、第一步： 
客户端先检查本地是否有对应的IP地址，若找到则返回响应的IP地址。若没找到则请求上级DNS服务器，直至找到或到根节点。（浏览器缓存→系统缓存→路由器缓存→ISP DNS缓存→从根域名服务器递归搜索） 
二、第二步： 
发送端先发送一个带有SYN（synchronize）标志的数据包给接收端，在一定的延迟时间内等待接收的回复。接收端收到数据包后，传回一个带有SYN/ACK标志的数据包以示传达确认信息。接收方收到后再发送一个带有ACK标志的数据包给接收端以示握手成功。在这个过程中，如果发送端在规定延迟时间内没有收到回复则默认接收方没有收到请求，而再次发送，直到收到回复为止。 

![è¿éåå¾çæè¿°](D:\Program Files\github\Crawler\learning\assets\20170824203039838.png)

建立连接成功后，浏览器给web服务器发送一个HTTP请求。 
第三步： 
这里我先说一下自己理解tomcat的内部处理过程： 
在HttpllProcessor的process方法里，会先从socket里读取http请求数据，并解析请求头，构造Request对象和Response对象，然后调用Adapter.service()方法。Adapter.service()完成请求行以及请求体的解析，并把解析出来的信息封装到Request和Response对象中，Adapter（确切说是org.apache.catalina.connector.CoyoteAdapter）是connector和container的桥梁，经过这一步，请求就从connector传递到container里了，Adapter.service()方法之后便将封装了Request以及Response对象的Socket传给Container容器了。到了Container，Container容器是子容器的父接口，所有的子容器都必须实现这个接口。在Tomcat中Container容器的设计是典型的责任链设计模式，其有四个子容器：Engine、Host、Context和Wrapper。这四个容器之间是父子关系，Engine容器包含Host，Host包含Context，Context包含Wrapper。Engine容器处理请求调用了StandardEngineValve的invoke方法。在StandardEngineValve的invoke方法中，选择可用的Host容器处理当前的请求，选择Host容器后，就调用其invoke方法，所以具体的处理就转移到了Host容器。在Host容器的invoke中，为特定的请求URL选择一个Context容器。Context容器是一个Web项目的代表，主要管理Servlet实例，在Tomcat中Servlet实例是以Wrapper出现的。在StandardContextValve的invoke()方法中，做了这几件事： 
1.禁止直接访问WEB-INF或者META-INF目录下的资源 
2.选择具体的Wrapper处理请求 
3.返回一个确认响应 
4.调用Wrapper容器的invoke方法，把处理请求交给StandardWrapperValve处理。 
Wrapper容器负责管理一个Servlet，包括Servlet的装载、初始化、资源回收。Wrapper是最底层的容器，其不能在添加子容器了。Wrapper是一个接口，其标准实现类是StandardWrapper。调用loadServlet的allocate方法的时候调用了StandardWrapperValve的invoke方法，在Wrapper容器获得请求后，通过allocate方法从实例池栈中弹出一个servlet实例来处理这个请求，servlet实例被封装成filterChain对象，紧接着通过一系列的过滤器过滤到达servlet.service()方法。之后发生的过程就是我们熟悉的request获取参数并用response进行响应的过程了。这里主要是本人的一些理解过程，方便自己以后回顾的，读者看不懂也没关系，如果能读懂的话，下面的过程便是十分简单的。下面给出正常的思路： 
假设来自客户的请求为： 
http://localhost:8080/wsota/wsota_index.jsp 
1) 请求被发送到本机端口8080，被在那里侦听的Coyote HTTP/1.1 Connector获得 
2) Connector把该请求交给它所在的Service的Engine来处理，并等待来自Engine的回应 
3) Engine获得请求localhost/wsota/wsota_index.jsp，匹配它所拥有的所有虚拟主机Host 
4) Engine匹配到名为localhost的Host（即使匹配不到也把请求交给该Host处理，因为该Host被定义为该Engine的默认主机） 
5) localhost Host获得请求/wsota/wsota_index.jsp，匹配它所拥有的所有Context 
6) Host匹配到路径为/wsota的Context（如果匹配不到就把该请求交给路径名为””的Context去处理） 
7) path=”/wsota”的Context获得请求/wsota_index.jsp，在它的mapping table中寻找对应的servlet 
8) Context匹配到URL PATTERN为*.jsp的servlet，对应于JspServlet类 
9) 构造HttpServletRequest对象和HttpServletResponse对象，作为参数调用JspServlet的doGet或doPost方法 
10)Context把执行完了之后的HttpServletResponse对象返回给Host 
11)Host把HttpServletResponse对象返回给Engine 
12)Engine把HttpServletResponse对象返回给Connector 
13)Connector把HttpServletResponse对象返回给客户browser 

![è¿éåå¾çæè¿°](D:\Program Files\github\Crawler\learning\assets\20170824203115225.png)

所谓四次挥手就是终止TCP连接，断开一个TCP连接需要客户端和服务端发送四次数据包以确定断开连接。 
1.Client发送一个数据包，用来关闭Client到server的数据传输，Client进入最后的等待状态。 
2.server接到数据包经过判断后，发送确认信息给Client，自己进入等待关闭状态。 
3.server发送一个数据包给Client，用来关闭server到Client的数据传输 
4.Client接收到数据经过判断后，自己进入Time_wait状态，server接收数据经过判断无误后，server进入关闭状态，Client等待2MLS(Maxmum segment lifetime),它是任何报文在网络丢弃前在网络内的最长时间，过了这个时间，Client就自动关闭了。 
最后解释一下图中字母缩写的含义： 
SYN：同步信号（Synchronize） 
ACK：确认字符（Acknowledge Character） 
RST：重连位（Reset） 
FIN：对方终止发送数据（Finally）（对方没有数据再发送给你啦）

## 一、连接池

<https://www.jianshu.com/p/c852cbcf3d68>

关键的地方有以下几点:

 1.httpclient实例必须是单例,且该实例必须使用HttpClients.custom().setConnectionManager()来绑定一个PollingHttpClientConnectionManager,这样该client每次发送请求都会通过manager来获取连接,如果连接池中没有可用连接的话,则该会阻塞线程,直到有可用的连接

2.httpclients4.5.x版本直接调用ClosableHttpResponse.close()就能直接把连接放回连接池,而不是关闭连接,以前的版本貌似要调用其他方法才能把连接放回连接池

3.由于服务器一般不会允许无限期的长连接,所以需要开启监控线程,每隔一段时间就检测一下连接池中连接的情况,及时关闭异常连接和长时间空闲的连接,避免占用服务器资源

#### 1.StrictPool

PoolingHttpClientConnectionManager中连接池默认使用的是StrictConnPool。

```java
// 从连接池中获取连接
public Future<PoolEntry<T, C>> lease(
        final T route, final Object state,
        final Timeout requestTimeout,
        final FutureCallback<PoolEntry<T, C>> callback) {
    Args.notNull(route, "Route");
    Args.notNull(requestTimeout, "Request timeout");
    Asserts.check(!this.isShutDown.get(), "Connection pool shut down");
    final BasicFuture<PoolEntry<T, C>> future = new BasicFuture<>(callback);
    // 加锁
    this.lock.lock();
    try {
        final LeaseRequest<T, C> request = new LeaseRequest<>(route, state, requestTimeout, future);
        // 
        final boolean completed = processPendingRequest(request);
        if (!request.isDone() && !completed) {
            this.leasingRequests.add(request);
        }
        if (request.isDone()) {
            this.completedRequests.add(request);
        }
    } finally {
        this.lock.unlock();
    }
    fireCallbacks();
    return future;
}
```

