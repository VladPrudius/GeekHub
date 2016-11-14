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
    public Set<String> getCategories() {
        Set<String> categories = new HashSet<>();
        for (Map.Entry<LocalDateTime, List<Task>> entry : taskByTime.entrySet()) {
            List<Task> getCategoryByList = entry.getValue();
            for (Task task : getCategoryByList) {
                categories.add(task.getCategory());
            }
        }
        return categories;
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
        List<Task> getTasks = new ArrayList<>();
        for (Map.Entry<LocalDateTime, List<Task>> entry : taskByTime.entrySet()) {
            List<Task> getCategoryByList = entry.getValue();
            for (Task task : getCategoryByList) {
                if (category.equals(task.getCategory())) {
                    getTasks.add(task);
                }
            }
        }
        return getTasks;
    }

    @Override
    public List<Task> getTasksForToday() {
        List<Task> taskForToday = new ArrayList<>();
        for (Map.Entry<LocalDateTime, List<Task>> entry : taskByTime.entrySet()) {
            List<Task> taskForTodays = entry.getValue();
            for (Task task : taskForTodays) {
                if (entry.getKey().equals(LocalDateTime.now())) {
                    taskForToday.add(task);
                }
            }
        }
        return taskForToday;
    }
}