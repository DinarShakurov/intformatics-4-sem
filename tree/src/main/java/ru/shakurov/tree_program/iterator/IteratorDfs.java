package ru.shakurov.tree_program.iterator;

import ru.shakurov.tree_program.tree.Node;

import java.util.*;
import java.util.function.Supplier;

public class IteratorDfs implements Iterator<Node> {

    private Supplier<Queue<Node>> supplier = LinkedList::new;
    private Stack<Queue<Node>> stack = new Stack<>();

    public IteratorDfs(Node root) {
        Queue<Node> queue = supplier.get();
        queue.add(root);
        stack.add(queue);
        addChildrenDeeply(root);
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public Node next() {
        Queue<Node> queue = stack.peek();
        Node n = queue.remove();
        if (queue.isEmpty()) {
            stack.pop();
        } else {
            addChildrenDeeply(queue.element());
        }
        return n;
    }

    private void addChildrenDeeply(Node cur) {
        List<Node> children;
        while (!(children = cur.getChildren()).isEmpty()) {
            Queue<Node> q = supplier.get();
            q.addAll(children);
            stack.add(q);
            cur = q.peek();
        }
    }
}