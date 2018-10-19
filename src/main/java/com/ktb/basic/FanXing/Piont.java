package com.ktb.basic.FanXing;

/**
 * Created by dell on 2018-10-19.
 */
public class Piont<K extends Object, V> {
    public K key;
    public V value;

    public Piont(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Piont{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }

    public static void main(String[] args) {
        Piont<String, Integer> piont = new Piont<>("xiaohu", 23);
        fun(piont);
    }

    public static void fun(Piont<?, ?> piont) {
        System.out.println(piont);
    }
}
