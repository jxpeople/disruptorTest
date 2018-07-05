组件说明  
================

#####  从生产者-消费者的整体：
       RingBuffer：环形队列，是Disruptor最为重要的组件，其作用是存储和更新Disruptor中流通的数据。
       Sequence：递增序号（AtomicLong），Disruptor使用Sequence标识一个特殊组件处理的序号。每个重要的组件基本都有一个Sequence。
       Producer：生产者，泛指通过Disruptor发布事件的用户代码（实际业务代码，而并发框架代码）生成Event数据。
       Event：事件，从生产者到消费者过程中的数据单元。由用户定义代码。
       EventHandler：消费者，代表Disruptor框架中的一个消费者接口，由用户实现代码，负责处理Event数据，进度通过Sequence控制。
       （打个比方：餐饮店买奶茶
       你去餐饮店买奶茶，先要去柜台找服务员点一杯红豆抹茶，服务员会给你一个55号的排队号，等到服务员大喊：‘55号，55号’，于是你就屁颠屁颠的去拿红豆抹茶；
       “你去买红豆抹茶” 就是 Producer
       “红豆抹茶” 就是 Event
       “柜台” 就是 RingBuffer
       “55号” 就是 Sequence
       “你去拿红豆抹茶” 就是 EventHandler）
