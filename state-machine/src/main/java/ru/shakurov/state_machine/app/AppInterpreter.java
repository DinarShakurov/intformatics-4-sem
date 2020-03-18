package ru.shakurov.state_machine.app;

import ru.shakurov.state_machine.TaskRepository;
import ru.shakurov.state_machine.interpreter.Context;
import ru.shakurov.state_machine.interpreter.Interpreter;
import ru.shakurov.state_machine.interpreter.components.TaskOperations;

import java.util.Scanner;

public class AppInterpreter {

    public static void main(String[] args) {
        TaskRepository taskRepository = new TaskRepository(); // just for IDs

        Context context = new Context();
        context.addAttribute("taskRepository", taskRepository);

        Interpreter interpreter = new Interpreter(context, new TaskOperations());
        Scanner scanner = new Scanner(System.in);
        String input;
        while (!(input = scanner.nextLine()).equals("exit")) {
            interpreter.execute(input);
        }
    }

}
