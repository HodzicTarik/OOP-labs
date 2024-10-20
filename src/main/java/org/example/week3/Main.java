package org.example.week3;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DbConnect dbConnect = new DbConnect();

        // Fetch all tasks
        List<TaskItem> tasks = dbConnect.fetchAllTasks();
        System.out.println("All Tasks:");
        for (TaskItem task : tasks) {
            System.out.println(task);
        }

        // Fetch a specific task by ID
        TaskItem taskById = dbConnect.fetchTaskById(1);
        System.out.println("\nTask with ID 1:");
        System.out.println(taskById);

        // Create a new task
        TaskItem newTask = new TaskItem(5, "New Task", Status.TO_DO);
        dbConnect.createTask(newTask);
        System.out.println("\nNew task created.");

        // Update a task
        dbConnect.updateTaskName(1, "Updated Task Description");
        System.out.println("\nTask with ID 1 updated.");
    }
}
