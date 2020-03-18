package ru.shakurov.state_machine.states;


import ru.shakurov.state_machine.State;
import ru.shakurov.state_machine.Task;

public enum InTestingState implements State {

    INSTANCE;

    @Override
    public void up(Task task, int id) {
        task.setDeveloperId(-1);
        task.setTesterId(-1);
        task.setCurrentState(ClosedState.INSTANCE);
    }

    @Override
    public void down(Task task, int id, String text) {
        task.setError(text);
        task.setCurrentState(AssignState.INSTANCE);
    }

}
