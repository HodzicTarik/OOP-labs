package org.example.week3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbConnect {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/lab3";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Ca0zdrav0*";

    private Connection connection;

    public DbConnect() {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<TaskItem> fetchAllTasks() {
        List<TaskItem> tasks = new ArrayList<>();
        String query = "SELECT * FROM tasks";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String description = rs.getString("task_description");
                String status = rs.getString("task_status");

                TaskItem task = new TaskItem(id, description, Status.valueOf(status));
                tasks.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public TaskItem fetchTaskById(int id) {
        String query = "SELECT * FROM tasks WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String description = rs.getString("task_description");
                String status = rs.getString("task_status");
                return new TaskItem(id, description, Status.valueOf(status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void createTask(TaskItem task) {
        String query = "INSERT INTO tasks (id, task_description, task_status) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, task.getTaskId());
            pstmt.setString(2, task.getTaskDescription());
            pstmt.setString(3, task.getTaskStatus().name());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTaskName(int id, String newDescription) {
        String query = "UPDATE tasks SET task_description = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, newDescription);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
