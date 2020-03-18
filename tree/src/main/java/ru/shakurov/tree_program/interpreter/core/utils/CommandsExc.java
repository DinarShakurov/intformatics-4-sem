package ru.shakurov.tree_program.interpreter.core.utils;

public class CommandsExc {
    public static void requireCount(String[] args, int i) {
        if (args.length != i)
            throw new IllegalArgumentException("Not enough arguments: expected " + i + ", found: " + args.length);
    }
}
