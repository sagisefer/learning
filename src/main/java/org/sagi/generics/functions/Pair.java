package org.sagi.generics.functions;

/**
 * Created by ssefer at 2/24/2019
 */
public class Pair<K,V> {
    private final K left;
    private final V right;

    public Pair(K left, V right){
        this.left = left;
        this.right = right;
    }

    public K getLeft() {
        return left;
    }

    public V getRight() {
        return right;
    }
}
