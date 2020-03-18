package ru.shakurov.state_machine.states;


import ru.shakurov.state_machine.State;
import ru.shakurov.state_machine.Task;

public enum OpenState implements State {

    INSTANCE;

    @Override
    public void up(Task task, int id) {
        task.setDeveloperId(id);
        task.setCurrentState(AssignState.INSTANCE);
    }

    @Override
    public void down(Task task, int id, String text) {
        task.setCurrentState(BackLogState.INSTANCE);
    }

}
