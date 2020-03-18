package ru.shakurov.tree_program.interpreter.components;

import ru.shakurov.tree_program.facade.TreeFileConverter;
import ru.shakurov.tree_program.interpreter.Context;
import ru.shakurov.tree_program.interpreter.core.annotation.CmdMapping;
import ru.shakurov.tree_program.interpreter.core.utils.CommandsExc;
import ru.shakurov.tree_program.tree.Node;
import ru.shakurov.tree_program.tree.NodeType;
import ru.shakurov.tree_program.tree.Tree;

import java.util.Objects;

public class Commands {
    // add <адрес родителя> <название ноды> <тип ноды> <приоритет>
    @CmdMapping("add")
    private void add(Context context, String[] args) {
        CommandsExc.requireCount(args, 4);

        String parentPath = args[0];
        String newName = args[1];
        String newType = args[2];
        String newPriority = args[3];

        Node newNode = new Node.Builder()
                .name(newName)
                .type(NodeType.valueOf((newType.toUpperCase())))
                .priority(Integer.parseInt(newPriority))
                .build();

        Tree tree = context.getAttribute(Context.ATTR_TREE, Tree.class);
        Node foundParent = Components.find(tree.iterator(), node -> node.getPath().endsWith(parentPath));
        Objects.requireNonNull(foundParent, "Suitable parent is not found");
        foundParent.addChild(newNode);
    }

    // save
    @CmdMapping("save")
    private void save(Context context, String[] args) {
        TreeFileConverter converter = context.getAttribute(Context.ATTR_CONVERTER, TreeFileConverter.class);
        String outputFilename = context.getAttribute(Context.ATTR_OUTPUT_FILENAME, String.class);
        Tree tree = context.getAttribute(Context.ATTR_TREE, Tree.class);
        converter.writeTree(outputFilename, tree);
    }

    // delete <адрес ноды>
    @CmdMapping("delete")
    private void delete(Context context, String[] args) {
        CommandsExc.requireCount(args, 1);

        String path = args[0];
        Tree tree = context.getAttribute(Context.ATTR_TREE, Tree.class);

        Node required = Components.find(tree.iterator(), node -> node.getPath().endsWith(path));
        Objects.requireNonNull(required, "Suitable node is not found");
        Node parent = required.getParent();
        parent.removeChildren(required);
    }

    // return children <тип> <название>
    @CmdMapping("return children")
    private void returnChildren(Context context, String[] args) {
        CommandsExc.requireCount(args, 2);

        String rawType = args[0];
        String name = args[1];

        NodeType type;
        try {
            type = NodeType.valueOf(rawType.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Wrong type: " + rawType + " found");
        }

        Tree tree = context.getAttribute(Context.ATTR_TREE, Tree.class);

        Node foundParent = Components.find(tree.iterator(),
                node -> node.getName().endsWith(name) && node.getType().equals(type));

        Objects.requireNonNull(foundParent, "Suitable parent is not found");
        for (Node child : foundParent.getChildren()) {
            System.out.println(child.getName());
        }
    }
}
