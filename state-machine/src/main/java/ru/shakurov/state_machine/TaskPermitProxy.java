package ru.shakurov.state_machine;


import ru.shakurov.state_machine.proxy.permission.UserType;

public interface TaskPermitProxy extends TaskProxy {

    void associateWith(UserType userType);

    void unAssociate();

}
