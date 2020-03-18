package ru.shakurov.state_machine.states;


import ru.shakurov.state_machine.State;
import ru.shakurov.state_machine.Task;

public enum ClosedState implements State {

    INSTANCE;

    @Override
    public void up(Task task, int id) {

    }

    @Override
    public void down(Task task, int id, String text) {

    }
}
