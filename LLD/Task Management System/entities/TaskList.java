package entities;

import java.util.*;

public class TaskList {
    private final String id;
    private final String name;
    private final List<Task> tasks;

    public TaskList(String id, String name) {
        this.id = id;
        this.name = name;
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public List<Task> getTasks() {
        return new ArrayList<>(tasks); 
    }

    public String getId() { return id; }
    
    public String getName() { return name; }

    public void display() {
        System.out.println("--- Task List: " + name + " ---");
        for (Task task : tasks) {
            task.display("");
        }
        System.out.println("-----------------------------------");
    }
}
