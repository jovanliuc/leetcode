package leetcode.question0239;

import java.util.LinkedList;

public class MonotonicQueue<E extends Comparable<E>> {

    private LinkedList<E> maxValQueue = new LinkedList<>();
    private LinkedList<E> minValQueue = new LinkedList<>();
    private LinkedList<E> countQueue = new LinkedList<>();

    public void push(E e) {
        countQueue.addLast(e);
        while (!maxValQueue.isEmpty() && e.compareTo((E) maxValQueue.getLast()) > 0) {
            maxValQueue.removeLast();
        }
        maxValQueue.addLast(e);
        while (!minValQueue.isEmpty() && e.compareTo((E) minValQueue.getLast()) < 0) {
            minValQueue.removeLast();
        }
        minValQueue.addLast(e);
    }

    public E pop() {
        E willRemovedVal = countQueue.removeFirst();
        assert willRemovedVal != null;
        if (willRemovedVal.compareTo(maxValQueue.getFirst()) == 0) {
            maxValQueue.removeFirst();
        }
        if (willRemovedVal.compareTo(minValQueue.getFirst()) == 0) {
            minValQueue.removeFirst();
        }
        return willRemovedVal;
    }

    public E max() {
        return maxValQueue.getFirst();
    }

    public E min() {
        return minValQueue.getLast();
    }

    public int size() {
        return countQueue.size();
    }
}
