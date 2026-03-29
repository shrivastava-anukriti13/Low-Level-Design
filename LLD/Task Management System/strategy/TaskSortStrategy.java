package strategy;

import java.util.List;

import entities.Task;

public interface TaskSortStrategy {
    void sort(List<Task> tasks);
}
