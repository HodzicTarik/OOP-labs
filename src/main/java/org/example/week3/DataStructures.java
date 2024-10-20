package org.example.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

enum Status {
    TO_DO,
    IN_PROGRESS,
    COMPLETED,
    CANCELLED
}

class TaskItem {
    private int taskId;
    private String taskDescription;
    private Status taskStatus;

    public TaskItem(int taskId, String taskDescription, Status taskStatus) {
        this.taskId = taskId;
        this.taskDescription = taskDescription;
        this.taskStatus = taskStatus;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public Status getTaskStatus() {
        return taskStatus;
    }
}

public class DataStructures {
    private List<TaskItem> tasks = new ArrayList<>();

    public DataStructures() {
        tasks = Arrays.asList(
                new TaskItem(1, "Push lab code to the GitHub", Status.TO_DO),
                new TaskItem(2, "Prepare for the quiz", Status.IN_PROGRESS),
                new TaskItem(3, "Go over tasks from lab 2", Status.COMPLETED),
                new TaskItem(4, "Submit final project", Status.TO_DO)
        );
    }

    public List<TaskItem> getAllTasks() {
        return tasks;
    }

    public List<TaskItem> getByStatus(Status status) {
        return tasks.stream()
                .filter(task -> task.getTaskStatus() == status)
                .collect(Collectors.toList());
    }

    public List<TaskItem> getTasksWithIdGreaterOrEqualTo(int id) {
        return tasks.stream()
                .filter(task -> task.getTaskId() >= id)
                .collect(Collectors.toList());
    }

    public void printAllTaskDescriptions() {
        tasks.forEach(task -> System.out.println(task.getTaskDescription()));
    }

    public static void main(String[] args) {
        DataStructures data = new DataStructures();

        List<TaskItem> allTasks = data.getAllTasks();
        for (TaskItem task : allTasks) {
            System.out.println("Task ID: " + task.getTaskId());
            System.out.println("Description: " + task.getTaskDescription());
            System.out.println("Status: " + task.getTaskStatus());
            System.out.println();
        }

        System.out.println("Tasks with status TO_DO:");
        List<TaskItem> toDoTasks = data.getByStatus(Status.TO_DO);
        toDoTasks.forEach(task -> System.out.println(task.getTaskDescription()));

        System.out.println("\nTasks with ID greater than or equal to 2:");
        List<TaskItem> tasksWithIdGreaterOrEqualTo = data.getTasksWithIdGreaterOrEqualTo(2);
        tasksWithIdGreaterOrEqualTo.forEach(task -> System.out.println(task.getTaskDescription()));

        System.out.println("\nAll task descriptions:");
        data.printAllTaskDescriptions();
    }
}
