package ru.shakurov.state_machine.states;


import ru.shakurov.state_machine.State;
import ru.shakurov.state_machine.Task;

public enum AssignState implements State {

    INSTANCE;

    @Override
    public void up(Task task, int id) {
        task.setCurrentState(InProgressState.INSTANCE);
    }

    @Override
    public void down(Task task, int id, String text) {
        task.setDeveloperId(-1);
        task.setCurrentState(OpenState.INSTANCE);
    }
}
