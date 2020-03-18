package ru.shakurov.pages;

import ru.shakurov.pages.browser.HistorySavedBrowser;
import ru.shakurov.pages.browser.HistorySavedBrowserPageStorageBased;
import ru.shakurov.pages.interpretator.Context;
import ru.shakurov.pages.interpretator.Interpreter;
import ru.shakurov.pages.interpretator.components.BrowserOperations;
import ru.shakurov.pages.storage.JsonPageStorage;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        JsonPageStorage storage = new JsonPageStorage();

        storage.load(App.class.getClassLoader().getResource("pages.json"));

        HistorySavedBrowser browser = new HistorySavedBrowserPageStorageBased(storage);

        Context context = new Context();
        context.addAttribute("browser", browser);

        Interpreter interpreter = new Interpreter(context, new BrowserOperations());

        Scanner scanner = new Scanner(System.in);
        String input;
        while (!(input = scanner.nextLine()).equals("exit")) {
            interpreter.execute(input);
            String name = browser.getCurrentPage().getName();
            System.out.println("current page is " + name);
        }

    }

}
