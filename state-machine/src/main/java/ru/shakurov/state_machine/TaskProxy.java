package ru.shakurov.state_machine;

public interface TaskProxy extends Task {

    Task getProxied();

}
