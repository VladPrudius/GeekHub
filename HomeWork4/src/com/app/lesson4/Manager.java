package com.app.lesson4;

import java.time.*;
import java.util.*;

public class Manager implements TaskManager {
    private Map<LocalDateTime, List<Task>> taskByTime = new HashMap<>();

    @Override
    public void add(LocalDateTime date, Task task) {
        List<Task> tasks = taskByTime.get(date);
        if (tasks == null) {
            tasks = new ArrayList<>();
            taskByTime.put(date, tasks);
        }
        tasks.add(task);
    }

    @Override
    public void remove(LocalDateTime date) {
        taskByTime.remove(date);
    }

    @Override
    public Set<LocalDateTime> getCategories() {
        Set<LocalDateTime> keyByLocalDateTime = taskByTime.keySet();
        return keyByLocalDateTime;
    }

    @Override
    public Map<String, List<Task>> getTasksByCategories(String... categories) {
        Map<String, List<Task>> getsTaskByCategories = new HashMap<>();
        List<Task> getTaskByCategory = new ArrayList<>();
        for (String category : categories.toString().split(",")) {
            getsTaskByCategories.put(category, getTaskByCategory);
        }
        return getsTaskByCategories;
    }

    @Override
    public List<Task> getTasksByCategory(String category) {
        List<Task> getTasks = taskByTime.get(category);
        return getTasks;
    }

    @Override
    public List<Task> getTasksForToday() {
        List<Task> taskForToday = new ArrayList<>();
        Set<LocalDateTime> localDate = taskByTime.keySet();
        for (LocalDateTime date : localDate) {
            if (date.toLocalDate().equals(LocalDate.now())) {
                taskForToday = taskByTime.get(date);
            }
        }
        return taskForToday;
    }
}
