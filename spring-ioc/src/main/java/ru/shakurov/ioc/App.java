package ru.shakurov.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.shakurov.ioc.interpreter.Interpreter;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Configs.class);

        Interpreter interpreter = applicationContext.getBean(Interpreter.class);

        Scanner scanner = new Scanner(System.in);
        String input;
        while (!(input = scanner.nextLine()).equals("stop")){
            interpreter.handle(input);
        }
    }
}
