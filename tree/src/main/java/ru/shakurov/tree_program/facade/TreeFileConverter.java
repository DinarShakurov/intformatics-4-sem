package ru.shakurov.tree_program.facade;

import ru.shakurov.tree_program.tree.Tree;

public interface TreeFileConverter {

    Tree readTree(String filename);

    void writeTree(String filename, Tree tree);



}
