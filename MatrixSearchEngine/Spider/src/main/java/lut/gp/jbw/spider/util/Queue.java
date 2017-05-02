package lut.gp.jbw.spider.util;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * 队列，保存将要访问的URL
 *
 * @author vincent Apr 2, 2017 2:13:56 PM
 */
//使用链表实现队列
public class Queue implements Serializable {

    private LinkedList queue;

    public Queue() {
        queue = new LinkedList();
    }

    public Queue(LinkedList queue) {
        this.queue = queue;
    }

    //入队列
    public void enQueue(Object t) {
        queue.addLast(t);
    }

    //出队列
    public Object deQueue() {
        return queue.removeFirst();
    }

    //判断队列是否为空
    public boolean isQueueEmpty() {
        return queue.isEmpty();
    }

    //判断队列是否包含t
    public boolean contians(Object t) {
        return queue.contains(t);
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public void show() {
        queue.forEach(System.out::println);
    }

    public int size() {
        return queue.size();
    }
}
