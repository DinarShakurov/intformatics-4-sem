package ru.shakurov.state_machine;

public interface TaskLoggerProxy extends TaskProxy {

    void flush();

    void close();

}
