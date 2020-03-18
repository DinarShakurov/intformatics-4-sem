package ru.shakurov.state_machine.states;


import ru.shakurov.state_machine.State;
import ru.shakurov.state_machine.Task;

public enum  InProgressState implements State {

    INSTANCE;

    @Override
    public void up(Task task, int id) {
        task.setCurrentState(ResolvedState.INSTANCE);
    }

    @Override
    public void down(Task task, int id, String text) {
        task.setCurrentState(AssignState.INSTANCE);
    }

}
