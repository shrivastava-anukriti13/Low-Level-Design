package strategy;

import java.util.*;
import entities.Task;

public class SortByPriority implements TaskSortStrategy {
    @Override
    public void sort(List<Task> tasks) {
        Collections.sort(tasks, Comparator.comparing(Task::getPriority));
    }
    
}
