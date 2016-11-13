package com.app.lesson4;

public class Task {

    private String name;
    private String category;

    Task(String category, String name) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }
}
