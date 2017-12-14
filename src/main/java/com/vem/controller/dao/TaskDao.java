package com.vem.controller.dao;

import com.vem.controller.model.Task;

import java.util.List;

/**
 * Created by alex on 12/14/17.
 */
public interface TaskDao {
    public void add(Task task);
    public void edit(Task task);
    public void delete(Task task);
    public Task getTask(int taskId);
    public List<Task> getAllTasks();
}
