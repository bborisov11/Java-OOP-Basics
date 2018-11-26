package collectionHierarchy;

import collectionHierarchy.collections.MyListFunc;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyList implements MyListFunc {
    private Deque<String> queue = new ArrayDeque<>();

    @Override
    public int add(String element) {
        this.queue.addFirst(element);
        return 0;
    }

    @Override
    public String remove() {
        return this.queue.removeFirst();
    }

    @Override
    public int Used() {
        return this.queue.size();
    }
}
