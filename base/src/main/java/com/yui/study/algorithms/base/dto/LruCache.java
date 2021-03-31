package com.yui.study.algorithms.base.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;

/**
 * @author XuZhuohao
 * @date 2021/3/30
 */
public class LruCache<K, V> {
    private Entry<V> head, tail;
    int capacity;
    int size;
    private Map<K, Entry<V>> cache;

    @Data
    @Accessors(chain = true)
    public static class Entry<T> {
        private Entry<T> preNode;
        private Entry<T> nextNode;
        private T value;
    }

    public LruCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new Entry<>();
        this.tail = new Entry<>();
        this.head.nextNode = this.tail;
        this.tail.preNode = head;
        cache = new HashMap<>(capacity);
    }

    /**
     * 放入元素
     * @param key
     * @param value
     */
    public void put(K key, V value){
        Entry<V> newNode = this.cache.get(key);
        if (newNode != null){
            moveToHead(newNode);
            newNode.value = value;
            return;
        }
        if (size == capacity){
            removeTail(key);
        }
        newNode = new Entry<>();
        newNode.value = value;
        addNode(newNode);
        this.cache.put(key, newNode);
        size++;
    }
    public V get(K key){
        Entry<V> node = this.cache.get(key);
        if (node == null){
            return null;
        }
        moveToHead(node);
        return node.value;
    }

    public void moveToHead(Entry<V> node){
        deleteNode(node);
        addNode(node);
    }

    public void removeTail(K key){
        deleteNode(this.tail.preNode);
        this.cache.remove(key);
        size--;
    }


    public void addNode(Entry<V> node){
        this.head.nextNode.preNode = node;
        node.preNode = this.head;
        node.nextNode = this.head.nextNode;
        this.head.nextNode = node;
    }

    public void deleteNode(Entry<V> node){
        node.preNode.nextNode = node.nextNode;
        node.nextNode.preNode = node.preNode;
    }


    public void display() {
        Entry<V> currentNode = this.head.nextNode;
        if(currentNode == null) {
            return;
        }
        while (currentNode.nextNode != null) {
            System.out.print(currentNode.value + "\t");
            currentNode = currentNode.nextNode;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        LruCache<String, String> cache = new LruCache<>(5);
        cache.put("test1", "1");
        cache.put("test2", "2");
        cache.put("test3", "3");
        cache.put("test4", "4");
        cache.put("test5", "5");
        cache.display();
        System.out.println(cache.get("test3"));
        cache.display();
        System.out.println(cache.get("test5"));
        cache.display();
        cache.put("test6", "6");
        cache.display();
    }
}
