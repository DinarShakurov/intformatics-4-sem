package ru.shakurov.tree_program.interpreter.components;

import ru.shakurov.tree_program.tree.Node;

import java.util.Iterator;
import java.util.function.Predicate;

public class Components {

    public static Node find(Iterator<Node> iterator, Predicate<Node> predicate) {
        while (iterator.hasNext()) {
            Node cur = iterator.next();
            if (predicate.test(cur)) {
                return cur;
            }
        }
        return null;
    }

}
