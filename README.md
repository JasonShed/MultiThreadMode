# MultiThreadMode



### Single Thread Execution模式

使用synchronized方法或代码块，只能保证某一段代码是只能由一个线程执行。

也可使用Semaphore类设置资源数量




### Immutable模式

Immutable类：通过final关键字设置类的属性，且类中不存在setter方法。

优点：不需使用synchronized保护类的属性，适用于类被多个线程共享，且有可能被频繁访问。

标准类中mutable类：StringBuffer
标准类中Immutable类：String、BigInteger、BigDecimal、Pattern、基本类型的包装类



java.util.ArrayList非线程安全的类，可用Collections.synchronizedList()进行包装

``````java
List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());
``````

CopyOnWriteArrayList线程安全的类，适用于读操作频繁的场景。



### Guarded Suspension模式

通过让线程等待来保证实例的安全性。

