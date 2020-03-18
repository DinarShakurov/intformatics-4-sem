package ru.shakurov.state_machine;

public interface State {

    void up(Task task, int id);

    void down(Task task, int id, String text);


}
