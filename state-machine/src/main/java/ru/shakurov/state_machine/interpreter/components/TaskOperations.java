package ru.shakurov.state_machine.interpreter.components;


import ru.shakurov.state_machine.Task;
import ru.shakurov.state_machine.TaskBuilder;
import ru.shakurov.state_machine.TaskRepository;
import ru.shakurov.state_machine.interpreter.Context;
import ru.shakurov.state_machine.interpreter.core.anotation.CmdMapping;
import ru.shakurov.state_machine.interpreter.core.util.Commands;
import ru.shakurov.state_machine.states.DraftState;

public class TaskOperations {

    // new task <текст задания>
    @CmdMapping("new task")
    private void add(Context context, String[] args) {
        Commands.requireCount(args, 1);

        String text = args[0];
        TaskRepository taskRepository;

        taskRepository = context.getAttribute("taskRepository", TaskRepository.class);
        Task newTask = new TaskBuilder()
                .text(text)
                .currentState(DraftState.INSTANCE)
                .build();
        taskRepository.save(newTask);
        System.out.println(newTask.getId());
    }

    // up <id таски>  [аргументы]
    @CmdMapping("up")
    private void up(Context context, String[] args) {
        Commands.requireCountOrGreater(args, 1);

        TaskRepository taskRepository = context.getAttribute("taskRepository", TaskRepository.class);
        int id = Integer.parseInt(args[0]);
        Task currentTask = taskRepository.findById(id);

        if (args.length == 2) {
            currentTask.up(Integer.parseInt(args[1]));
        } else {
            currentTask.up(-1);
        }
        System.out.println(currentTask.getCurrentState().getClass().getSimpleName());
    }

    // down <id таски>  [аргументы]
    @CmdMapping("down")
    private void down(Context context, String[] args) {
        Commands.requireCountOrGreater(args, 1);

        TaskRepository taskRepository = context.getAttribute("taskRepository", TaskRepository.class);
        int id = Integer.parseInt(args[0]);
        Task currentTask = taskRepository.findById(id);

        if (args.length == 3) {
            currentTask.down(Integer.parseInt(args[1]), args[2]);
        } else {
            currentTask.down(-1, null);
        }
        System.out.println(currentTask.getCurrentState().getClass().getSimpleName());

    }

    // copy <taskId>
    @CmdMapping("copy")
    private void copy(Context context, String[] args) {
        Commands.requireCount(args, 1);
        TaskRepository taskRepository = context.getAttribute("taskRepository", TaskRepository.class);
        Task task = taskRepository.findById(Integer.parseInt(args[0]));
        Task taskCopy = task.copy();
        taskRepository.save(taskCopy);
        System.out.println(taskCopy.getId());
    }



}
