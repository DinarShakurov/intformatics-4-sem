package ru.shakurov.tree_program;


import ru.shakurov.tree_program.facade.TreeFileConverter;
import ru.shakurov.tree_program.facade.TreeFileConverterImpl;
import ru.shakurov.tree_program.interpreter.Context;
import ru.shakurov.tree_program.interpreter.Interpreter;
import ru.shakurov.tree_program.interpreter.components.Commands;
import ru.shakurov.tree_program.iterator.IteratorDfs;
import ru.shakurov.tree_program.tree.Tree;

import java.util.Scanner;

public class App implements Runnable {

    public final static String INPUT_FILENAME = "src/main/resources/data.xml";
    public final static String OUTPUT_FILENAME = "src/main/resources/data33.xml";

    public static final String ATTR_NAME = "name";
    public static final String ATTR_PRIORITY = "priority";

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    public void run() {
        TreeFileConverter converter = TreeFileConverterImpl.getInstance();
        Tree tree = converter.readTree(INPUT_FILENAME);
        tree.setIteratorClass(IteratorDfs.class);

        Context context = new Context();
        context.addAttribute(Context.ATTR_TREE, tree);
        context.addAttribute(Context.ATTR_CONVERTER, converter);
        context.addAttribute(Context.ATTR_INPUT_FILENAME, INPUT_FILENAME);
        context.addAttribute(Context.ATTR_OUTPUT_FILENAME, OUTPUT_FILENAME);

        Interpreter interpreter = new Interpreter(context, new Commands());
        Scanner scanner = new Scanner(System.in);
        String input;
        while (!(input = scanner.nextLine()).equals("exit")) {
            interpreter.execute(input + " ");
        }
    }

}
