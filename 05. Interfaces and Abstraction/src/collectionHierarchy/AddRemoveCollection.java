package collectionHierarchy;

import collectionHierarchy.collections.AddRemoveCollectionFunc;

import java.util.ArrayDeque;
import java.util.Deque;

public class AddRemoveCollection implements AddRemoveCollectionFunc{

    private Deque<String> queue = new ArrayDeque<>();

    @Override
    public int add(String element) {
        this.queue.addFirst(element);
        return 0;
    }

    @Override
    public String remove() {
        return this.queue.removeLast();
    }


}
