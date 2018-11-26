package collectionHierarchy;

import collectionHierarchy.collections.AddCollectionFunc;

import java.util.ArrayDeque;
import java.util.Deque;

public class AddCollection implements AddCollectionFunc {

   private Deque<String> queue = new ArrayDeque<>();

    @Override
    public int add(String element) {
        queue.addLast(element);
        return queue.size() - 1;
    }
}
